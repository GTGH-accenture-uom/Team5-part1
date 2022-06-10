import model.Insured;
import model.Timeslot;
import model.VaccinationCenter;
import services.DoctorService;
import services.InsuredService;
import services.VaccinationCenterService;
import utilities.RecordWriter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    private static final VaccinationCenterService vaccinationCenterService = new VaccinationCenterService();
    private static final DoctorService doctorService = new DoctorService();
    private static final InsuredService insuredService = new InsuredService();

    public static void main(String[] args) {

        Insured insured1 = new Insured("111111127", "22222223333", "makis", LocalDate.of(1950, 8, 23), "papadopoulos", "mail@mail.gr");
        Insured insured2 = new Insured("111611137", "22202223333", "takis", LocalDate.of(1930, 6, 20), "papas", "mail2@mail.gr");
        Insured insured3 = new Insured("111111119", "22222223309", "sakis", LocalDate.of(1990, 8, 23), "euaggelou", "mail3@mail.gr");
        Insured insured4 = new Insured("113111170", "22202223330", "lakis", LocalDate.of(2001, 6, 27), "nikou", "mail4@mail.gr");
        Insured insured5 = new Insured("213111177", "32222223333", "giotis", LocalDate.of(2001, 8, 23), "papadopoulos", "mai99l@mail.gr");
        Insured insured6 = new Insured("211811157", "32205223333", "nikos", LocalDate.of(1991, 6, 20), "papafotiou", "mail22@mail.gr");
        Insured insured7 = new Insured("211121179", "32223223309", "alexis", LocalDate.of(1980, 8, 23), "euaggelou", "mail23@mail.gr");
        Insured insured8 = new Insured("211111700", "32202223330", "maria", LocalDate.of(1945, 6, 27), "nikou", "mail24@mail.gr");
        Insured insured9 = new Insured("111121770", "22224223333", "makis", LocalDate.of(1950, 8, 23), "nikolaou", "mail8@mail.gr");
        Insured insured10 = new Insured("333333333", "22202623333", "mairi", LocalDate.of(1999, 6, 20), "papas", "mail28@mail.gr");
        Insured insured11 = new Insured("111211179", "22222223309", "gianna", LocalDate.of(2015, 8, 23), "euaggelou", "mail38@mail.gr");
        Insured insured12 = new Insured("111111170", "22208223330", "lakis", LocalDate.of(2013, 6, 27), "nikou", "mail48@mail.gr");
        Insured insured13 = new Insured("211129177", "32228223333", "giotis", LocalDate.of(2010, 8, 23), "andreou", "mail88@mail.gr");
        Insured insured14 = new Insured("221111177", "32202723333", "xrisa", LocalDate.of(2017, 6, 20), "papas", "mail228@mail.gr");
        Insured insured15 = new Insured("211131179", "32228223309", "alexis", LocalDate.of(1930, 8, 23), "nakis", "mail238@mail.gr");

        List<Insured> insuredList = Arrays.asList(insured1, insured2, insured3, insured4, insured5, insured6, insured7, insured8, insured9, insured10, insured11, insured12, insured13, insured14, insured15);

        //Creation of Vaccination centers
        VaccinationCenter vaccCenter1 = vaccinationCenterService.createVaccinationCenter("5012", "Thessaloniki", "Egnatias 10");
        VaccinationCenter vaccCenter2 = vaccinationCenterService.createVaccinationCenter("4356", "Thessaloniki", "Egnatias 54");

        //Creation of Doctors
        doctorService.createDoctor("12345678912", "nikolaos", "vasileiou");
        doctorService.createDoctor("12345678919", "vasilis", "dimitriou");
        doctorService.createDoctor("12345678914", "maria", "dimitriou");
        doctorService.createDoctor("12345678915", "xristina", "deli");

        //timeslots for vaccination center1
        Timeslot timeslot1center1 = new Timeslot(LocalDateTime.of(2022, 6, 23, 18, 30), 20);
        doctorService.addTimeslotToDoctor("12345678912", timeslot1center1);

        Timeslot timeslot2center1 = new Timeslot(timeslot1center1.getEndDateTime(), 15);
        doctorService.addTimeslotToDoctor("12345678912", timeslot2center1);

        Timeslot timeslot3center1 = new Timeslot(timeslot2center1.getEndDateTime(), 25);
        doctorService.addTimeslotToDoctor("12345678912", timeslot3center1);

        Timeslot timeslot4center1 = new Timeslot(timeslot3center1.getEndDateTime(), 15);
        doctorService.addTimeslotToDoctor("12345678912", timeslot4center1);

        Timeslot timeslot5center1 = new Timeslot(timeslot4center1.getEndDateTime(), 15);
        doctorService.addTimeslotToDoctor("12345678912", timeslot5center1);

        Timeslot timeslot6center1 = new Timeslot(timeslot5center1.getEndDateTime(), 10);
        doctorService.addTimeslotToDoctor("12345678919", timeslot6center1);

        Timeslot timeslot7center1 = new Timeslot(timeslot6center1.getEndDateTime(), 15);
        doctorService.addTimeslotToDoctor("12345678919", timeslot7center1);

        Timeslot timeslot8center1 = new Timeslot(timeslot7center1.getEndDateTime(), 25);
        doctorService.addTimeslotToDoctor("12345678919", timeslot8center1);

        Timeslot timeslot9center1 = new Timeslot(timeslot8center1.getEndDateTime(), 15);
        doctorService.addTimeslotToDoctor("12345678919", timeslot9center1);

        Timeslot timeslot10center1 = new Timeslot(timeslot9center1.getEndDateTime(), 15);
        doctorService.addTimeslotToDoctor("12345678919", timeslot10center1);

        List<Timeslot> timeslotListCenter1 = Arrays.asList(timeslot1center1, timeslot2center1, timeslot3center1, timeslot4center1, timeslot5center1, timeslot6center1, timeslot7center1, timeslot8center1, timeslot9center1, timeslot10center1);
        vaccinationCenterService.addTimeslotsToVaccinationCenter(timeslotListCenter1, vaccCenter1);


        //timeslots for vaccination center2
        Timeslot timeslot1center2 = new Timeslot(LocalDateTime.of(2022, 6, 23, 18, 30), 20);
        doctorService.addTimeslotToDoctor("12345678914", timeslot1center2);

        Timeslot timeslot2center2 = new Timeslot(timeslot1center2.getEndDateTime(), 15);
        doctorService.addTimeslotToDoctor("12345678914", timeslot2center2);

        Timeslot timeslot3center2 = new Timeslot(timeslot2center2.getEndDateTime(), 25);
        doctorService.addTimeslotToDoctor("12345678914", timeslot3center2);

        Timeslot timeslot4center2 = new Timeslot(timeslot3center2.getEndDateTime(), 15);
        doctorService.addTimeslotToDoctor("12345678914", timeslot4center2);

        Timeslot timeslot5center2 = new Timeslot(timeslot4center2.getEndDateTime(), 15);
        doctorService.addTimeslotToDoctor("12345678914", timeslot5center2);

        Timeslot timeslot6center2 = new Timeslot(timeslot5center2.getEndDateTime(), 10);
        doctorService.addTimeslotToDoctor("12345678915", timeslot6center2);

        Timeslot timeslot7center2 = new Timeslot(timeslot6center2.getEndDateTime(), 15);
        doctorService.addTimeslotToDoctor("12345678915", timeslot7center2);

        Timeslot timeslot8center2 = new Timeslot(timeslot7center2.getEndDateTime(), 25);
        doctorService.addTimeslotToDoctor("12345678915", timeslot8center2);

        Timeslot timeslot9center2 = new Timeslot(timeslot8center2.getEndDateTime(), 15);
        doctorService.addTimeslotToDoctor("12345678915", timeslot9center2);

        Timeslot timeslot10center2 = new Timeslot(timeslot9center2.getEndDateTime(), 15);
        doctorService.addTimeslotToDoctor("12345678915", timeslot10center2);

        List<Timeslot> timeslotListCenter2 = Arrays.asList(timeslot1center2, timeslot2center2, timeslot3center2, timeslot4center2, timeslot5center2, timeslot6center2, timeslot7center2, timeslot8center2, timeslot9center2, timeslot10center2);
        vaccinationCenterService.addTimeslotsToVaccinationCenter(timeslotListCenter2, vaccCenter2);

        //Reservations for Center1
        vaccinationCenterService.createReservation(insured1, timeslot1center1, vaccCenter1);
        vaccinationCenterService.createReservation(insured2, timeslot2center1, vaccCenter1);
        vaccinationCenterService.createReservation(insured3, timeslot3center1, vaccCenter1);
        vaccinationCenterService.createReservation(insured4, timeslot4center1, vaccCenter1);

        //Reservations for Center2
        vaccinationCenterService.createReservation(insured5, timeslot1center2, vaccCenter2);
        vaccinationCenterService.createReservation(insured6, timeslot2center2, vaccCenter2);
        vaccinationCenterService.createReservation(insured7, timeslot3center2, vaccCenter2);
        vaccinationCenterService.createReservation(insured8, timeslot4center2, vaccCenter2);

        //vaccinations
        vaccinationCenterService.createVaccination("Pfizer", 2, insured1, vaccCenter1);
        vaccinationCenterService.createVaccination("Moderna", 3, insured2, vaccCenter1);
        vaccinationCenterService.createVaccination("Pfizer", 2, insured3, vaccCenter1);
        vaccinationCenterService.createVaccination("Pfizer", 2, insured4, vaccCenter1);
        vaccinationCenterService.createVaccination("Pfizer", 2, insured5, vaccCenter2);
        vaccinationCenterService.createVaccination("Pfizer", 2, insured6, vaccCenter2);

        //requirements
        String totalRecords = "";
        //1st requirement
        totalRecords += vaccinationCenterService.getAllReservationsPerCenter();
        vaccinationCenterService.displayAllReservationsPerCenter();

        //2nd requirement
        totalRecords += vaccinationCenterService.getFreeTimeslotsByVaccinationCenter();
        vaccinationCenterService.displayFreeTimeslotsByVaccinationCenter();

        //3rd requirement
        totalRecords += doctorService.getVaccinationsOfAllDoctors();
        doctorService.displayVaccinationsOfAllDoctorsPerCenter();

        //4th requirement
        List<VaccinationCenter> vaccinationCenters = vaccinationCenterService.getAllVaccinationCenters();
        insuredService.displayInsuredAbove60WhoDidntReserve(insuredList,vaccinationCenters);
        totalRecords += "\n---------INSURED >60YO WITHOUT RESERVATION---------\n" +
                insuredService.getInsuredAbove60WhoDidntReserve(insuredList, vaccinationCenters).stream()
                        .map(t -> t.getName()+ " " + t.getSurname() + " with afm :" + t.getAfm()).collect(Collectors.joining("\n"));
        RecordWriter.writeFile(totalRecords);


    }
}
