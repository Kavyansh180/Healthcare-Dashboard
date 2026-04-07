package util;

/**
 * AlertConstants.java
 * Contains all threshold values for patient health monitoring.
 * Change values here to update alert conditions across the whole system.
 */
public class AlertConstants {

    // Heart Rate thresholds (beats per minute)
    public static final int MAX_HEART_RATE = 120;
    public static final int MIN_HEART_RATE = 60;

    // Temperature threshold (Celsius)
    public static final double MAX_TEMPERATURE = 38.0;

    // Blood Pressure thresholds (mmHg)
    public static final int MAX_SYSTOLIC_BP = 140;
    public static final int MIN_SYSTOLIC_BP = 90;

    // Alert type labels
    public static final String ALERT_HIGH_HR    = "HIGH HEART RATE";
    public static final String ALERT_LOW_HR     = "LOW HEART RATE";
    public static final String ALERT_HIGH_TEMP  = "HIGH TEMPERATURE";
    public static final String ALERT_HIGH_BP    = "HIGH BLOOD PRESSURE";
    public static final String ALERT_LOW_BP     = "LOW BLOOD PRESSURE";
    public static final String ALERT_NORMAL     = "NORMAL";

    // Private constructor - this class should never be instantiated
    private AlertConstants() {}
}
