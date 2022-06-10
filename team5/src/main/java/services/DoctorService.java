package services;

import model.Doctor;
import model.Timeslot;
import model.Vaccination;
import utilities.InputValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class DoctorService {


    private final List<Doctor> allDoctors = new ArrayList<>();


    public String getVaccinationsPerDoctor(Doctor doctor) {
        List<Vaccination> vaccinations = doctor.getVaccinations();
        String str = "---------Vaccinations of Doctor with amka " + doctor.getAmka() + "---------\n";
        if (vaccinations.isEmpty()) {
            str += "This Doctor has done no vaccinations yet.\n";
        }
        for (Vaccination vacc : vaccinations) {
            str += "The vaccination date is:" + vacc.getVaccinationDate() + "\n" +
                    "The insured is:" + vacc.getInsured().getName() + " " + vacc.getInsured().getSurname() + "\n";
        }
        return str;
    }

    public void createDoctor(String amka, String firstName, String lastName) {

        if (findDoctorByAmka(amka) == null) {
            if (InputValidator.checkAmka(amka)) {
                Doctor doctor = new Doctor(amka, firstName, lastName);
                allDoctors.add(doctor);
            } else {
                System.err.println("Please provide a right amka.");
            }
        } else {
            System.err.println("This doctor with amka " + amka + " already exists");
        }
    }

    public String getVaccinationsOfAllDoctors() {
        String str = "---------VACCINATIONS OF ALL DOCTORS---------\n";
        for (Doctor d : allDoctors) {
            str += getVaccinationsPerDoctor(d);
        }
        return str;
    }

    public Doctor findDoctorByAmka(String amka) {
        Doctor foundDoctor = null;
        Optional<Doctor> doctor = allDoctors.stream()
                .filter(e -> e.getAmka().equals(amka)).findFirst();
        if (doctor.isPresent()) {
            foundDoctor = doctor.get();
        }
        return foundDoctor;
    }

    public void addTimeslotToDoctor(String amka, Timeslot timeslot) {
        Doctor doctor = findDoctorByAmka(amka);
        if (doctor != null && timeslot != null && timeslot.isAvailable()
                && !doctor.getTimeslots().contains(timeslot)) {
            doctor.addTimeslot(timeslot);
            timeslot.setDoctor(doctor);
        } else {
            System.err.println("Timeslot can not be added");
        }
    }
    //3rd requirement
    public void displayVaccinationsOfAllDoctorsPerCenter(){
        System.out.println(getVaccinationsOfAllDoctors());

    }
}
