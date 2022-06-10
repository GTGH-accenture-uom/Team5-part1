package services;

import model.*;

import java.time.LocalDateTime;
import java.util.*;

public class VaccinationCenterService {


    private final List<VaccinationCenter> allVaccinationCenters = new ArrayList<>();


    public VaccinationCenter createVaccinationCenter(String code, String city, String address) {
        VaccinationCenter vaccinationCenter = new VaccinationCenter(code, city, address);
        allVaccinationCenters.add(vaccinationCenter);
        return vaccinationCenter;
    }


    public void addTimeslotsToVaccinationCenter(List<Timeslot> timeslots, VaccinationCenter vaccinationCenter) {
        for (Timeslot t : timeslots) {
            if (!vaccinationCenter.getTimeslots().contains(t)) {
                vaccinationCenter.addTimeSlot(t);
            }
        }
    }

    public void createReservation(Insured insured, Timeslot timeSlot, VaccinationCenter vaccinationCenter) {
        if (insured!=null && timeSlot!=null && vaccinationCenter!=null
            && timeSlot.getDoctor()!=null){
            Reservation reservation = new Reservation(insured, timeSlot);
            vaccinationCenter.addReservation(reservation);
            timeSlot.setAvailable(false);
        }else{
            System.err.println("Cannot make this reservation with insured amka:" +insured.getAmka() + ", " +
                    "timeslot" + timeSlot + ", center with code " + vaccinationCenter.getCode());
        }
    }

    public void createVaccination(String brand, int yearsToExpire, Insured insured, VaccinationCenter vaccinationCenter) {
        Reservation foundReservation = findReservationByInsuredAmka(insured, vaccinationCenter);
        if (foundReservation != null) {
            Insured insuredToVaccinate = foundReservation.getInsured();
            Doctor doctor = foundReservation.getTimeslot().getDoctor();
            LocalDateTime startDateTime = foundReservation.getTimeslot().getStartDateTime();
            LocalDateTime expirationDate = startDateTime.plusYears(yearsToExpire);
            Vaccination vaccination = new Vaccination(brand, insuredToVaccinate, doctor, startDateTime, expirationDate);
            //Add record of vaccination to vaccination center
            vaccinationCenter.addVaccination(vaccination);
            //Add vaccination in doctor's vaccinations list
            doctor.addVaccination(vaccination);
        } else {
            System.err.println("This Vaccination cannot be made because this reservation cannot be found");
        }

    }

    public String getAllReservationsPerCenter() {
        String str = "---------All RERSERVATIONS PER CENTER---------\n";
        for (VaccinationCenter v : allVaccinationCenters) {
            str += getReservations(v);
        }
        return str;
    }

    public String getReservations(VaccinationCenter vaccinationCenter) {
        String str = "";
        List<Reservation> reservations = vaccinationCenter.getReservations();
        if (!reservations.isEmpty()) {
            str += "---------Reservations of VaccinationCenter " + vaccinationCenter.getCode() + "---------\n";
            int count = 1;
            for (Reservation r : reservations) {
                str += count + "-" + r + "\n";
                count++;
            }
        } else {
            str += "No Reservations are made\n";
        }
        return str;
    }

    public String getFreeTimeslotsByVaccinationCenter() {
        String str = "---------LIST OF FREE TIMESLOTS PER VACCINATION CENTER---------\n";
        for (VaccinationCenter vc : allVaccinationCenters) {
            str += "Vaccination center no." + vc.getCode() + " has free timeslots: " + getFreeTimeslotsByVaccinationCenter(vc) + "\n";
        }
        return str;
    }


    public List<Timeslot> getFreeTimeslotsByVaccinationCenter(VaccinationCenter vaccinationCenter) {
        List<Timeslot> freeTimeslots = new ArrayList<>();
        for (Timeslot ts : vaccinationCenter.getTimeslots()) {
            if (ts.isAvailable()) {
                freeTimeslots.add(ts);
            }
        }
        return freeTimeslots;
    }


    private Reservation findReservationByInsuredAmka(Insured insured, VaccinationCenter vaccinationCenter) {
        Reservation reservation = null;
        Optional<Reservation> optionalReservation = vaccinationCenter
                .getReservations()
                .stream().filter(reserv -> reserv
                        .getInsured()
                        .getAmka()
                        .equals(insured.getAmka())).findFirst();
        if (optionalReservation.isPresent()) {
            reservation = optionalReservation.get();
        }
        return reservation;
    }

    public List<VaccinationCenter> getAllVaccinationCenters() {
        return allVaccinationCenters;
    }

    //1st requirement
    public void displayAllReservationsPerCenter(){
        System.out.println(getAllReservationsPerCenter());
    }

    //2st requirement
    public void displayFreeTimeslotsByVaccinationCenter(){
        System.out.println(getFreeTimeslotsByVaccinationCenter());

    }
}