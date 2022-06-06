package team5.model;


import java.util.*;

public class Doctor {
    //Doctor (amka, name, surname, Timeslots)
    private String amka;
    private String name;
    private String surname;
    private List<Timeslot> timeslots = new ArrayList<>();


    public Doctor(String amka, String name, String surname) {
        this.amka = amka;
        this.name = name;
        this.surname = surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Timeslot> getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(List<Timeslot> timeslots) {
        this.timeslots = timeslots;
    }

    public void addTimeslot(Timeslot timeslot){
        timeslots.add(timeslot);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Doctor{");
        sb.append("amka='").append(amka).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", timeslots=").append(timeslots);
        sb.append('}');
        return sb.toString();
    }
}
