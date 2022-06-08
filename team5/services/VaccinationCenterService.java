package team5.services;

import team5.model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class VaccinationCenterService {

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

    public Reservation makeReservation(Insured insured, Timeslot timeSlot, VaccinationCenter vaccinationCenter) {
        Reservation reservation =  new Reservation(insured, timeSlot);
        vaccinationCenter.addReservation(reservation);
        return reservation;
    }

    private Timeslot findTimeSlotByVaccinationCenter(Timeslot timeSlot, VaccinationCenter vaccinationCenter) {
        Timeslot foundTimeSlot = null;
        Optional<Timeslot> optionalTimeSlot = vaccinationCenter.getFreeTimeSlots()
                .stream()
                .filter(freeTimeSlot -> freeTimeSlot.equals(timeSlot)).findFirst();
        if (optionalTimeSlot.isPresent()) {
            foundTimeSlot = optionalTimeSlot.get();
        }
        return foundTimeSlot;
    }

    public Vaccination vaccinate(String brand, int yearsToExpire, Reservation reservation, VaccinationCenter vaccinationCenter) {
        Insured insured = reservation.getInsured();
        Doctor doctor = reservation.getTimeslot().getDoctor();
        LocalDateTime startDateTime = reservation.getTimeslot().getStartDateTime();
        LocalDateTime expirationDate = startDateTime.plusYears(yearsToExpire);
        Vaccination vaccination = new Vaccination(brand, insured, doctor, startDateTime, expirationDate);
        //Add record of vaccination to vaccination center
        vaccinationCenter.addVaccination(vaccination);
        //Add vaccination in doctor's vaccinations list
        doctor.addVaccination(vaccination);
        return vaccination;
    }






}
