package service;

import model.Alert;
import model.Patient;
import util.AlertConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * AlertService.java
 * Core business logic for checking patient vitals against thresholds.
 * This is the brain of the alert system.
 *
 * Usage:
 *   AlertService alertService = new AlertService();
 *   List<Alert> alerts = alertService.checkPatient(patient);
 */
public class AlertService {

    // ---------------------------------------------------------------
    // Check a SINGLE patient and return any alerts generated
    // ---------------------------------------------------------------
    public List<Alert> checkPatient(Patient patient) {

        List<Alert> alerts = new ArrayList<>();

        // --- Heart Rate Check ---
        if (patient.getHeartRate() > AlertConstants.MAX_HEART_RATE) {
            String msg = "WARNING: " + patient.getName() +
                         " has HIGH heart rate: " + patient.getHeartRate() + " bpm" +
                         " (Normal: " + AlertConstants.MIN_HEART_RATE +
                         " - " + AlertConstants.MAX_HEART_RATE + " bpm)";
            alerts.add(new Alert(
                patient.getPatientId(),
                patient.getName(),
                AlertConstants.ALERT_HIGH_HR,
                msg
            ));
            patient.setStatus("WARNING");
        }

        if (patient.getHeartRate() < AlertConstants.MIN_HEART_RATE) {
            String msg = "WARNING: " + patient.getName() +
                         " has LOW heart rate: " + patient.getHeartRate() + " bpm" +
                         " (Normal: " + AlertConstants.MIN_HEART_RATE +
                         " - " + AlertConstants.MAX_HEART_RATE + " bpm)";
            alerts.add(new Alert(
                patient.getPatientId(),
                patient.getName(),
                AlertConstants.ALERT_LOW_HR,
                msg
            ));
            patient.setStatus("WARNING");
        }

        // --- Temperature Check ---
        if (patient.getTemperature() > AlertConstants.MAX_TEMPERATURE) {
            String msg = "WARNING: " + patient.getName() +
                         " has HIGH temperature: " + patient.getTemperature() + "°C" +
                         " (Normal: below " + AlertConstants.MAX_TEMPERATURE + "°C)";
            alerts.add(new Alert(
                patient.getPatientId(),
                patient.getName(),
                AlertConstants.ALERT_HIGH_TEMP,
                msg
            ));
            patient.setStatus("WARNING");
        }

        // --- Blood Pressure Check ---
        if (patient.getSystolicBP() > AlertConstants.MAX_SYSTOLIC_BP) {
            String msg = "WARNING: " + patient.getName() +
                         " has HIGH blood pressure: " + patient.getBloodPressure() + " mmHg" +
                         " (Normal systolic: below " + AlertConstants.MAX_SYSTOLIC_BP + ")";
            alerts.add(new Alert(
                patient.getPatientId(),
                patient.getName(),
                AlertConstants.ALERT_HIGH_BP,
                msg
            ));
            patient.setStatus("WARNING");
        }

        if (patient.getSystolicBP() < AlertConstants.MIN_SYSTOLIC_BP) {
            String msg = "WARNING: " + patient.getName() +
                         " has LOW blood pressure: " + patient.getBloodPressure() + " mmHg" +
                         " (Normal systolic: above " + AlertConstants.MIN_SYSTOLIC_BP + ")";
            alerts.add(new Alert(
                patient.getPatientId(),
                patient.getName(),
                AlertConstants.ALERT_LOW_BP,
                msg
            ));
            patient.setStatus("WARNING");
        }

        // If no alerts, patient is normal
        if (alerts.isEmpty()) {
            patient.setStatus("NORMAL");
        }

        return alerts;
    }

    // ---------------------------------------------------------------
    // Check ALL patients at once - used by MonitorThread
    // Returns a combined list of all alerts from all patients
    // ---------------------------------------------------------------
    public List<Alert> checkAllPatients(List<Patient> patients) {
        List<Alert> allAlerts = new ArrayList<>();
        for (Patient patient : patients) {
            List<Alert> patientAlerts = checkPatient(patient);
            allAlerts.addAll(patientAlerts);
        }
        return allAlerts;
    }

    // ---------------------------------------------------------------
    // Print alerts to console - useful for testing
    // ---------------------------------------------------------------
    public void printAlerts(List<Alert> alerts) {
        if (alerts.isEmpty()) {
            System.out.println("All patients are NORMAL. No alerts.");
            return;
        }
        System.out.println("========== ALERTS ==========");
        for (Alert alert : alerts) {
            System.out.println("[" + alert.getFormattedTime() + "] "
                             + alert.getAlertType() + " → "
                             + alert.getMessage());
        }
        System.out.println("============================");
    }

    // ---------------------------------------------------------------
    // Quick test - run this main() to verify AlertService works
    // ---------------------------------------------------------------
    public static void main(String[] args) {
        AlertService service = new AlertService();

        // Test patient with abnormal vitals
        Patient p1 = new Patient(1, "Ravi Kumar", 45, "ICU",
                                 130, 39.2, 155, 95);
        // Test patient with normal vitals
        Patient p2 = new Patient(2, "Priya Sharma", 30, "General",
                                 75, 37.0, 120, 80);

        List<Patient> patients = new ArrayList<>();
        patients.add(p1);
        patients.add(p2);

        List<Alert> alerts = service.checkAllPatients(patients);
        service.printAlerts(alerts);

        System.out.println("\nPatient statuses:");
        for (Patient p : patients) {
            System.out.println(p.getName() + " → " + p.getStatus());
        }
    }
}
