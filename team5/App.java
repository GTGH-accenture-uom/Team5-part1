package team5;

import team5.model.*;
import team5.services.DoctorService;
import team5.services.InsuredService;
import team5.services.VaccinationCenterService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class App {

    private static final VaccinationCenterService vaccinationCenterService = new VaccinationCenterService();
    private static final DoctorService doctorService = new DoctorService();

    private static final InsuredService insuredService = new InsuredService();

    public static void main(String[] args) {
        Insured insured1 = new Insured("111111177", "22222223333", "makis", LocalDate.of(1950, 8, 23), "papadopoulos", "mail@mail.gr");
        Insured insured2 = new Insured("111111177", "22202223333", "takis", LocalDate.of(1930, 6, 20), "papas", "mail2@mail.gr");
        Insured insured3 = new Insured("111111179", "22222223309", "sakis", LocalDate.of(1990, 8, 23), "euaggelou", "mail3@mail.gr");
        Insured insured4 = new Insured("111111170", "22202223330", "lakis", LocalDate.of(2001, 6, 27), "nikou", "mail4@mail.gr");
        Insured insured5 = new Insured("211111177", "32222223333", "giotis", LocalDate.of(2001, 8, 23), "papadopoulos", "mai99l@mail.gr");
        Insured insured6 = new Insured("211811177", "32205223333", "nikos", LocalDate.of(1991, 6, 20), "papafotiou", "mail22@mail.gr");
        Insured insured7 = new Insured("211111179", "32223223309", "alexis", LocalDate.of(1980, 8, 23), "euaggelou", "mail23@mail.gr");
        Insured insured8 = new Insured("211111700", "32202223330", "maria", LocalDate.of(1945, 6, 27), "nikou", "mail24@mail.gr");
        Insured insured9 = new Insured("111111770", "22224223333", "makis", LocalDate.of(1950, 8, 23), "nikolaou", "mail8@mail.gr");
        Insured insured10 = new Insured("333333333", "22202623333", "mairi", LocalDate.of(1999, 6, 20), "papas", "mail28@mail.gr");
        Insured insured11 = new Insured("111111179", "22222223309", "gianna", LocalDate.of(2015, 8, 23), "euaggelou", "mail38@mail.gr");
        Insured insured12 = new Insured("111111170", "22208223330", "lakis", LocalDate.of(2013, 6, 27), "nikou", "mail48@mail.gr");
        Insured insured13 = new Insured("211111177", "32228223333", "giotis", LocalDate.of(2010, 8, 23), "andreou", "mail88@mail.gr");
        Insured insured14 = new Insured("211111177", "32202723333", "xrisa", LocalDate.of(2017, 6, 20), "papas", "mail228@mail.gr");
        Insured insured15 = new Insured("211111179", "32228223309", "alexis", LocalDate.of(1930, 8, 23), "nakis", "mail238@mail.gr");

        List<Insured> insuredList = Arrays.asList(insured1, insured2, insured3, insured4, insured5,
                insured6, insured7, insured8, insured9, insured10,
                insured11, insured12, insured13, insured14, insured15);

//        VaccinationCenter vaccCenter1 = new VaccinationCenter("5012", "Thessaloniki", "Egnatias 10");
//        VaccinationCenter vaccCenter2 = new VaccinationCenter("4356", "Thessaloniki", "Egnatias 54");


        VaccinationCenter vaccCenter1 = vaccinationCenterService.createVaccinationCenter("5012", "Thessaloniki", "Egnatias 10");
        VaccinationCenter vaccCenter2 = vaccinationCenterService.createVaccinationCenter("4356", "Thessaloniki", "Egnatias 54");


        Doctor doctor1 = new Doctor("12345678912", "nikolaos", "vasileiou");
        Doctor doctor2 = new Doctor("12345678913", "georgios", "papas");
        Doctor doctor3 = new Doctor("12345678914", "maria", "dimitriou");
        Doctor doctor4 = new Doctor("12345678915", "xristina", "deli");

        doctorService.createDoctor("12345678912", "nikolaos", "vasileiou");
        doctorService.createDoctor("12345678919", "vasilis", "dimitriou");


        //timeslots for vaccination center1
        Timeslot timeslot1center1 = new Timeslot(LocalDateTime.of(2022, 6, 23, 18, 30), 20, doctor1);
        doctor1.addTimeslot(timeslot1center1);
        Timeslot timeslot2center1 = new Timeslot(timeslot1center1.getEndDateTime(), 15, doctor1);
        doctor1.addTimeslot(timeslot2center1);
        Timeslot timeslot3center1 = new Timeslot(timeslot2center1.getEndDateTime(), 25, doctor1);
        doctor1.addTimeslot(timeslot3center1);
        Timeslot timeslot4center1 = new Timeslot(timeslot3center1.getEndDateTime(), 15, doctor1);
        doctor1.addTimeslot(timeslot4center1);
        Timeslot timeslot5center1 = new Timeslot(timeslot4center1.getEndDateTime(), 15, doctor1);
        doctor1.addTimeslot(timeslot5center1);
        Timeslot timeslot6center1 = new Timeslot(timeslot5center1.getEndDateTime(), 10, doctor2);
        doctor1.addTimeslot(timeslot6center1);
        Timeslot timeslot7center1 = new Timeslot(timeslot6center1.getEndDateTime(), 15, doctor2);
        doctor1.addTimeslot(timeslot7center1);
        Timeslot timeslot8center1 = new Timeslot(timeslot7center1.getEndDateTime(), 25, doctor2);
        doctor1.addTimeslot(timeslot8center1);
        Timeslot timeslot9center1 = new Timeslot(timeslot8center1.getEndDateTime(), 15, doctor2);
        doctor1.addTimeslot(timeslot9center1);
        Timeslot timeslot10center1 = new Timeslot(timeslot9center1.getEndDateTime(), 15, doctor2);
        doctor1.addTimeslot(timeslot10center1);

        List<Timeslot> timeslotListCenter1 =
                Arrays.asList(timeslot1center1, timeslot2center1, timeslot3center1, timeslot4center1,
                        timeslot5center1, timeslot6center1, timeslot7center1, timeslot8center1, timeslot9center1, timeslot10center1);


        vaccinationCenterService.addTimeslotsToVaccinationCenter(timeslotListCenter1, vaccCenter1);


        //timeslots for vaccination center2
        Timeslot timeslot1center2 = new Timeslot(LocalDateTime.of(2022, 6, 23, 18, 30), 20, doctor3);
        doctor3.addTimeslot(timeslot1center2);
        Timeslot timeslot2center2 = new Timeslot(timeslot1center2.getEndDateTime(), 15, doctor3);
        doctor3.addTimeslot(timeslot2center2);
        Timeslot timeslot3center2 = new Timeslot(timeslot2center2.getEndDateTime(), 25, doctor3);
        doctor3.addTimeslot(timeslot3center2);
        Timeslot timeslot4center2 = new Timeslot(timeslot3center2.getEndDateTime(), 15, doctor3);
        doctor3.addTimeslot(timeslot4center2);
        Timeslot timeslot5center2 = new Timeslot(timeslot4center2.getEndDateTime(), 15, doctor3);
        doctor3.addTimeslot(timeslot5center2);
        Timeslot timeslot6center2 = new Timeslot(timeslot5center2.getEndDateTime(), 10, doctor4);
        doctor4.addTimeslot(timeslot6center2);
        Timeslot timeslot7center2 = new Timeslot(timeslot6center2.getEndDateTime(), 15, doctor4);
        doctor4.addTimeslot(timeslot7center2);
        Timeslot timeslot8center2 = new Timeslot(timeslot7center2.getEndDateTime(), 25, doctor4);
        doctor4.addTimeslot(timeslot8center2);
        Timeslot timeslot9center2 = new Timeslot(timeslot8center2.getEndDateTime(), 15, doctor4);
        doctor4.addTimeslot(timeslot9center2);
        Timeslot timeslot10center2 = new Timeslot(timeslot9center2.getEndDateTime(), 15, doctor4);
        doctor4.addTimeslot(timeslot10center2);


        List<Timeslot> timeslotListCenter2 = Arrays.asList(timeslot1center2, timeslot2center2, timeslot3center2, timeslot4center2,
                timeslot5center2, timeslot6center2, timeslot7center2, timeslot8center2, timeslot9center2, timeslot10center2);

        vaccinationCenterService.addTimeslotsToVaccinationCenter(timeslotListCenter2, vaccCenter2);


        //Reservations for Center1
        vaccinationCenterService.makeReservation(insured1, timeslot1center1, vaccCenter1);
        vaccinationCenterService.makeReservation(insured2, timeslot2center1, vaccCenter1);
        vaccinationCenterService.makeReservation(insured3, timeslot3center1, vaccCenter1);
        vaccinationCenterService.makeReservation(insured4, timeslot4center1, vaccCenter1);

        //Reservations for Center2
        vaccinationCenterService.makeReservation(insured5, timeslot1center2, vaccCenter2);
        vaccinationCenterService.makeReservation(insured6, timeslot2center2, vaccCenter2);
        vaccinationCenterService.makeReservation(insured7, timeslot3center2, vaccCenter2);
        vaccinationCenterService.makeReservation(insured8, timeslot4center2, vaccCenter2);


        vaccinationCenterService.vaccinate("Pfizer", 2, insured1, vaccCenter1);
        // vaccinationCenterService.vaccinate("Moderna", 3, reservation2, vaccCenter1);
        //  vaccinationCenterService.vaccinate("Pfizer", 2, reservation3, vaccCenter1);
        // vaccinationCenterService.vaccinate("Pfizer", 2, reservation4, vaccCenter1);
        //  vaccinationCenterService.vaccinate("Pfizer", 2, reservation5, vaccCenter2);
        //  vaccinationCenterService.vaccinate("Pfizer", 2, reservation6, vaccCenter2);


//        vaccinationCenterService.displayReservations(vaccCenter1);
//        vaccinationCenterService.displayReservations(vaccCenter2);
//
//        doctorService.displayVaccinationsPerDoctor(doctor3);
//
//        doctorService.displayVaccinationsOfAllDoctors();

        //requirements

        //1st requirement
        System.out.println(vaccinationCenterService.getAllReservationsPerCenter());

        //2nd requirement
        System.out.println(vaccinationCenterService.getFreeTimeslotsByVaccinationCenter());

        //3rd requirement
        System.out.println(doctorService.getVaccinationsOfAllDoctors());


        //4th requirement
        List<VaccinationCenter> vaccinationCenters = vaccinationCenterService.getTotalVaccinationCenters();
       insuredService.getNonVaccinatedInsuredAbove60(insuredList,vaccinationCenters);




    }
}
