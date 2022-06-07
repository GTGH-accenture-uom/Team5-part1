package team5.services;

import team5.model.Reservation;
import team5.model.VaccinationCenter;

import java.util.List;
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


}
