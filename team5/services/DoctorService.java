package team5.services;


import team5.model.Doctor;
import team5.model.Vaccination;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class DoctorService {


    private final List<Doctor> doctors = new ArrayList<>();


    public void displayVaccinationsPerDoctor(Doctor doctor) {
        List<Vaccination> vaccinations = doctor.getVaccinations();
        System.out.println("---------Vaccinations of Doctor with amka " + doctor.getAmka() + "---------");
        if (vaccinations.isEmpty()) {
            System.out.println("This Doctor has done no vaccinations yet");
        }
        for (Vaccination vacc : vaccinations) {
            System.out.println("The vaccination date is:" + vacc.getVaccinationDate());
            System.out.println("The insured is:" + vacc.getInsured().getName() + " " + vacc.getInsured().getSurname());

        }
    }

    public Doctor createDoctor(String amka, String firstName, String lastName) {
        Doctor doctor = null;
        if (findAmkaByDoctor(amka) == null) {
            doctor = new Doctor(amka, firstName, lastName);
            doctors.add(doctor);
        }
        return doctor;
    }

    public void displayVaccinationsOfAllDoctors(){
        for(Doctor d: doctors){
            displayVaccinationsPerDoctor(d);
        }
    }

    public Doctor findAmkaByDoctor(String amka) {
        Doctor foundDoctor = null;
        Optional<Doctor> doctor = doctors
                .stream().filter(e -> e.equals(amka)).findFirst();
        if (doctor.isPresent()) {
            foundDoctor = doctor.get();
        }
        return foundDoctor;
    }

}
