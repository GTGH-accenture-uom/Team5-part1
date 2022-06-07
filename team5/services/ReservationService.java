package team5.services;

import team5.model.Insured;
import team5.model.Reservation;
import team5.model.Timeslot;
import team5.model.VaccinationCenter;

import java.util.Optional;

public class ReservationService {


    public Reservation makeReservation(Insured insured, Timeslot timeSlot,VaccinationCenter vaccinationCenter) {
        Reservation reservation =  new Reservation(insured, timeSlot);
        vaccinationCenter.addReservation(reservation);
        return reservation;
    }

    /*
    private void freeTimeslotSpace(Timeslot timeSlot, VaccinationCenter vaccinationCenter) {
        vaccinationCenter.getFreeTimeSlots().removeIf(freeTimeSlot -> freeTimeSlot.equals(timeSlot));
    }

     */


    private Timeslot findTimeSlotByVaccinationCenter(Timeslot timeSlot, VaccinationCenter vaccinationCenter) {
        Timeslot foundTimeSlot = null;
        Optional<Timeslot> optionalTimeSlot = vaccinationCenter.getFreeTimeSlots().stream().filter(freeTimeSlot -> freeTimeSlot.equals(timeSlot)).findFirst();
        if (optionalTimeSlot.isPresent()) {
            foundTimeSlot = optionalTimeSlot.get();
        }
        return foundTimeSlot;
    }


}
