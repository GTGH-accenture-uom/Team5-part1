package model;

import java.time.LocalDateTime;

public class Vaccination {

    private String vacc_brand;
    private Insured insured;
    private Doctor doctor;
    private LocalDateTime vaccinationDate;
    private LocalDateTime expirationDate;


    public Vaccination(String vacc_brand,Insured insured,Doctor doctor, LocalDateTime vaccinationDate,LocalDateTime expirationDate) {
        this.vacc_brand = vacc_brand;
        this.insured = insured;
        this.doctor = doctor;
        this.vaccinationDate = vaccinationDate;
        this.expirationDate = expirationDate;
    }

    public String getVacc_brand() {
        return vacc_brand;
    }

    public void setVacc_brand(String vacc_brand) {
        this.vacc_brand = vacc_brand;
    }

    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDateTime vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vaccination{");
        sb.append("vacc_brand='").append(vacc_brand).append('\'');
        sb.append(", insured=").append(insured);
        sb.append(", doctor=").append(doctor);
        sb.append(", vaccinationDate=").append(vaccinationDate);
        sb.append(", expirationDate=").append(expirationDate);
        sb.append('}');
        return sb.toString();
    }
}


