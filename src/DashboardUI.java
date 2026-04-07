package src;

import model.Patient;
import model.Alert;
import service.AlertService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DashboardUI {

    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private AlertService alertService;
    private List<Patient> patients;

    // --- Professional Color Palette ---
    private final Color COLOR_BG = new Color(245, 246, 250);    // Clean Light Gray
    private final Color COLOR_HEADER = new Color(41, 128, 185); // Professional Blue
    private final Color COLOR_RED = new Color(231, 76, 60);     // Soft Red (Warning)
    private final Color COLOR_GREEN = new Color(46, 204, 113);   // Soft Green (Normal)
    private final Color COLOR_TEXT_DARK = new Color(44, 62, 80); // Dark Blue-Gray

    public DashboardUI() {
        alertService = new AlertService();
        patients = new ArrayList<>();

        // 1. Frame Setup
        frame = new JFrame("Healthcare Patient Monitoring Dashboard");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(COLOR_BG);
        frame.setLayout(new BorderLayout(0, 0));

        // 2. Modern Header Title Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(220, 221, 225)));

        JLabel title = new JLabel("PATIENT MONITORING DASHBOARD", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(COLOR_TEXT_DARK);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        headerPanel.add(title);
        frame.add(headerPanel, BorderLayout.NORTH);

        // 3. Table Setup
        String[] columns = {"ID", "Patient Name", "Heart Rate (bpm)", "Temp (°C)", "Blood Pressure", "Status"};
        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; } // Make table read-only
        };

        table = new JTable(model);
        table.setRowHeight(45); // Comfortable row height
        table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setSelectionBackground(new Color(52, 152, 219, 100)); // Semi-transparent selection

        // --- FIXED HEADER RENDERER (Ensures text is visible) ---
        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(100, 50));
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setBackground(COLOR_HEADER);
                label.setForeground(Color.WHITE);
                label.setFont(new Font("Segoe UI", Font.BOLD, 15));
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setOpaque(true);
                label.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.WHITE));
                return label;
            }
        });

        // --- ROW ALERT RENDERER ---
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {

                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);

                // Check status from column index 5
                String status = table.getModel().getValueAt(row, 5).toString();

                if ("WARNING".equals(status)) {
                    c.setBackground(COLOR_RED);
                    c.setForeground(Color.WHITE);
                } else {
                    c.setBackground(COLOR_GREEN);
                    c.setForeground(Color.WHITE);
                }

                if (isSelected) {
                    c.setBackground(c.getBackground().darker());
                }
                return c;
            }
        });

        // 4. ScrollPane with Padding
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(30, 40, 40, 40));
        scrollPane.getViewport().setBackground(COLOR_BG);
        frame.add(scrollPane, BorderLayout.CENTER);

        // --- Initial Data ---
        loadSampleData();
        refreshTable();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void loadSampleData() {
        patients.add(new Patient(1, "Ravi Kumar", 45, "ICU", 130, 39.2, 155, 95));
        patients.add(new Patient(2, "Priya Sharma", 30, "General", 75, 37.0, 120, 80));
    }

    public void refreshTable() {
        model.setRowCount(0);
        // AlertService updates the 'status' inside each patient object
        alertService.checkAllPatients(patients);

        for (Patient p : patients) {
            model.addRow(new Object[]{
                    p.getPatientId(),
                    p.getName(),
                    p.getHeartRate(),
                    p.getTemperature(),
                    p.getBloodPressure(),
                    p.getStatus()
            });
        }
    }

    public static void main(String[] args) {
        // Set System Look and Feel for modern borders/scrollbars
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(DashboardUI::new);
    }
}
