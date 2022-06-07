package team5.services;

import team5.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VaccinationService {


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

    public void setExpirationDate(LocalDateTime startDate, int numOfYears) {
        startDate.plusYears(numOfYears);
    }


}
