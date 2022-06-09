package model;

import java.util.ArrayList;
import java.util.List;

public class VaccinationCenter {
    private String code;
    private String city;
    private String address;
    private List<Timeslot> timeslots = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private List<Vaccination> vaccinations = new ArrayList<>();

    public VaccinationCenter(String code, String city, String address) {
        this.code = code;
        this.city = city;
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Timeslot> getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(List<Timeslot> timeslots) {
        this.timeslots = timeslots;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(List<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }

    public void addTimeSlot(Timeslot timeslot) {
        timeslots.add(timeslot);
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void addVaccination(Vaccination vaccination) {
        vaccinations.add(vaccination);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VaccinationCenter{");
        sb.append("code='").append(code).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", freeTimeSlots=").append(timeslots);
        sb.append(", reservations=").append(reservations);
        sb.append(", vaccinations=").append(vaccinations);
        sb.append('}');
        return sb.toString();
    }
}
