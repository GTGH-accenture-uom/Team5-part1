package team5.services;

import team5.model.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class VaccinationCenterService {

    private final List<Timeslot> timeslots = new ArrayList<>();

    private final List<VaccinationCenter> totalVaccinationCenters = new ArrayList<>();


    public void createVaccinationCenter(String code, String city, String address) {
        VaccinationCenter vaccinationCenter = new VaccinationCenter(code, city, address);
        totalVaccinationCenters.add(vaccinationCenter);
    }

    public void addTimeslotsToVaccinationCenter(List<Timeslot> timeslots, VaccinationCenter vaccinationCenter) {
        for (Timeslot t : timeslots) {
            if (!vaccinationCenter.getTimeslots().contains(t)) {
                vaccinationCenter.addTimeSlot(t);
            }
        }
    }

    public void makeReservation(Insured insured, Timeslot timeSlot, VaccinationCenter vaccinationCenter) {
        Reservation reservation = new Reservation(insured, timeSlot);
        vaccinationCenter.addReservation(reservation);
    }

    public void vaccinate(String brand, int yearsToExpire, Insured insured, VaccinationCenter vaccinationCenter) {
        Reservation foundReservation = findReservationByInsuredAmka(insured, vaccinationCenter);
        if (foundReservation != null) {
            Insured insuredToVaccinate = foundReservation.getInsured();
            Doctor doctor = foundReservation.getTimeslot().getDoctor();
            LocalDateTime startDateTime = foundReservation.getTimeslot().getStartDateTime();
            LocalDateTime expirationDate = startDateTime.plusYears(yearsToExpire);
            Vaccination vaccination = new Vaccination(brand, insuredToVaccinate, doctor, startDateTime, expirationDate);
            System.out.println("Insured with afm " + insuredToVaccinate.getAfm() + " got vaccinated");
            //Add record of vaccination to vaccination center
            vaccinationCenter.addVaccination(vaccination);
            //Add vaccination in doctor's vaccinations list
            doctor.addVaccination(vaccination);
        } else {
            System.err.println("This Vaccination cannot be made because this reservation cannot be found");
        }

    }

    public void displayReservations(VaccinationCenter vaccinationCenter) {
        AtomicInteger runCount = new AtomicInteger(0);
        List<Reservation> reservations = vaccinationCenter.getReservations();
        if (!reservations.isEmpty()) {
            System.out.println("---------Reservations of VaccinationCenter " + vaccinationCenter.getCode() + "---------");
            reservations.forEach(reservation -> {
                System.out.println((runCount.incrementAndGet()) + "-" + reservation);
            });
        } else {
            System.err.println("No Reservations are made");
        }
    }
    public List<Timeslot> displayFreeTimeslotsByVaccinationCenter(VaccinationCenter vaccinationCenter){
        List<Timeslot> freeTimeslots = new ArrayList<>();
        for (Timeslot ts: vaccinationCenter.getTimeslots()){
            if(ts.isAvailable()) { freeTimeslots.add(ts); }
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

}
