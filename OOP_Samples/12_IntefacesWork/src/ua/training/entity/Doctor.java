package ua.training.entity;

import java.time.LocalDate;

public class Doctor {
    private HumanDoctor doctor;
    private LicenceDoctor license;

    public Doctor(HumanDoctor doctor, LicenceDoctor license) {
        this.doctor = doctor;
        this.license = license;
    }

    public HumanDoctor getDoctor() {
        return doctor;
    }

    public void setDoctor(HumanDoctor doctor) {
        this.doctor = doctor;
    }

    public LicenceDoctor getLicense() {
        return license;
    }

    public void setLicense(LicenceDoctor license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor=" + doctor +
                ", license=" + license +
                '}';
    }
}
