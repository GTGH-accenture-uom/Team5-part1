package team5.model;

import java.time.LocalDate;
import java.util.Objects;

public class Insured {

    private String afm;
    private String amka;
    private String name;
    private LocalDate birthdate;
    private String surname;
    private String email;

    public Insured(String afm, String amka, String name, LocalDate birthdate, String surname, String email) {
        this.afm = afm;
        this.amka = amka;
        this.name = name;
        this.birthdate = birthdate;
        this.surname = surname;
        this.email = email;
    }
    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insured insured = (Insured) o;
        return afm.equals(insured.afm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(afm);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Insured{");
        sb.append("afm='").append(afm).append('\'');
        sb.append(", amka='").append(amka).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", birthdate=").append(birthdate);
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
