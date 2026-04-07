package model;

/**
 * Patient.java
 * Represents a patient and their current health vitals.
 * This object is passed between all layers (DAO → Service → UI).
 */
public class Patient {

    private int patientId;
    private String name;
    private int age;
    private String ward;
    private int heartRate;          // beats per minute
    private double temperature;     // in Celsius
    private int systolicBP;         // upper blood pressure value (mmHg)
    private int diastolicBP;        // lower blood pressure value (mmHg)
    private String status;          // "NORMAL" or "WARNING"

    // ---------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------

    public Patient() {}

    public Patient(int patientId, String name, int age, String ward,
                   int heartRate, double temperature,
                   int systolicBP, int diastolicBP) {
        this.patientId   = patientId;
        this.name        = name;
        this.age         = age;
        this.ward        = ward;
        this.heartRate   = heartRate;
        this.temperature = temperature;
        this.systolicBP  = systolicBP;
        this.diastolicBP = diastolicBP;
        this.status      = "NORMAL";
    }

    // ---------------------------------------------------------------
    // Getters and Setters
    // ---------------------------------------------------------------

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getWard() { return ward; }
    public void setWard(String ward) { this.ward = ward; }

    public int getHeartRate() { return heartRate; }
    public void setHeartRate(int heartRate) { this.heartRate = heartRate; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public int getSystolicBP() { return systolicBP; }
    public void setSystolicBP(int systolicBP) { this.systolicBP = systolicBP; }

    public int getDiastolicBP() { return diastolicBP; }
    public void setDiastolicBP(int diastolicBP) { this.diastolicBP = diastolicBP; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // ---------------------------------------------------------------
    // Helper: returns blood pressure as readable string e.g. "120/80"
    // ---------------------------------------------------------------
    public String getBloodPressure() {
        return systolicBP + "/" + diastolicBP;
    }

    // ---------------------------------------------------------------
    // toString - useful for debugging
    // ---------------------------------------------------------------
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + patientId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ward='" + ward + '\'' +
                ", heartRate=" + heartRate +
                ", temperature=" + temperature +
                ", BP=" + getBloodPressure() +
                ", status='" + status + '\'' +
                '}';
    }
}
