package team5.services;


import team5.model.Doctor;
import team5.model.Timeslot;
import team5.model.Vaccination;
import team5.utilities.InputValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class DoctorService {


    private final List<Doctor> doctors = new ArrayList<>();


    public String getVaccinationsPerDoctor(Doctor doctor) {
        List<Vaccination> vaccinations = doctor.getVaccinations();
        String str = "---------Vaccinations of Doctor with amka " + doctor.getAmka() + "---------\n";
        if (vaccinations.isEmpty()) {
            str+="This Doctor has done no vaccinations yet.\n";
        }
       for (Vaccination vacc : vaccinations) {
            str+= "The vaccination date is:" + vacc.getVaccinationDate() + "\n" +
                    "The insured is:" + vacc.getInsured().getName() + " " + vacc.getInsured().getSurname() +"\n";
       }
       return str;
    }

    public void createDoctor(String amka, String firstName, String lastName) {

        if (findAmkaByDoctor(amka) == null) {
            if (InputValidator.checkAmka(amka)) {
                Doctor doctor = new Doctor(amka, firstName, lastName);
                doctors.add(doctor);
            } else {
                System.err.println("Please provide a right amka");
            }
        } else {
            System.err.println("This doctor with amka " + amka + " already exists");
        }
    }

    public String getVaccinationsOfAllDoctors() {
        System.out.println("*************");
        System.out.println(doctors);
        String str = "Vaccdoctor:\n";
        for (Doctor d : doctors) {
            str+= getVaccinationsPerDoctor(d);
        }
        return str;
    }

    public Doctor findAmkaByDoctor(String amka) {
        Doctor foundDoctor = null;
        Optional<Doctor> doctor = doctors.stream().filter(e -> e.equals(amka)).findFirst();
        if (doctor.isPresent()) {
            foundDoctor = doctor.get();
        }
        return foundDoctor;
    }

}
