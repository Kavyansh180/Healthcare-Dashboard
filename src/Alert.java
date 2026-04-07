package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Alert.java
 * Represents a health alert generated when a patient's vitals
 * cross a threshold defined in AlertConstants.
 */
public class Alert {

    private int alertId;
    private int patientId;
    private String patientName;
    private String alertType;       // e.g. "HIGH HEART RATE"
    private String message;         // human-readable description
    private LocalDateTime timestamp;
    private boolean acknowledged;   // true = medical staff has seen it

    // ---------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------

    public Alert() {
        this.timestamp    = LocalDateTime.now();
        this.acknowledged = false;
    }

    public Alert(int patientId, String patientName,
                 String alertType, String message) {
        this.patientId    = patientId;
        this.patientName  = patientName;
        this.alertType    = alertType;
        this.message      = message;
        this.timestamp    = LocalDateTime.now();
        this.acknowledged = false;
    }

    // ---------------------------------------------------------------
    // Getters and Setters
    // ---------------------------------------------------------------

    public int getAlertId() { return alertId; }
    public void setAlertId(int alertId) { this.alertId = alertId; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getAlertType() { return alertType; }
    public void setAlertType(String alertType) { this.alertType = alertType; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public boolean isAcknowledged() { return acknowledged; }
    public void setAcknowledged(boolean acknowledged) { this.acknowledged = acknowledged; }

    // ---------------------------------------------------------------
    // Helper: returns timestamp as readable string
    // ---------------------------------------------------------------
    public String getFormattedTime() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return timestamp.format(fmt);
    }

    // ---------------------------------------------------------------
    // toString - useful for debugging and logging
    // ---------------------------------------------------------------
    @Override
    public String toString() {
        return "Alert{" +
                "alertId=" + alertId +
                ", patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", alertType='" + alertType + '\'' +
                ", message='" + message + '\'' +
                ", time=" + getFormattedTime() +
                ", acknowledged=" + acknowledged +
                '}';
    }
}
