package team5;

import team5.model.Doctor;
import team5.model.Insured;
import team5.model.Timeslot;
import team5.model.VaccinationCenter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class App {

//    public static void createDoctorTimeslot(Doctor doctor1, int duration, LocalDateTime localDateTime){
//        localDateTime = LocalDateTime.of(2018,8,23,18,30);//timeslot1center1.getEndLocalDateTime()
//        Timeslot timeslot2center1 = new Timeslot(localDateTime, 15, doctor1);
//        doctor1.addTimeslot(timeslot2center1);
//    }

    public static void main(String[] args) {
//        Timeslot timeslot = new Timeslot(LocalDateTime.now());
//        System.out.println(timeslot);
        //System.out.println(LocalDateTime.of(2018,8,23,18,30));

        Insured insured1 = new Insured("111111177", "22222223333", "makis", LocalDate.of(2018,8,23), "papadopoulos", "mail@mail.gr");
        Insured insured2 = new Insured("111111177", "22202223333", "takis", LocalDate.of(2010,6,20), "papas", "mail2@mail.gr");
        Insured insured3 = new Insured("111111179", "22222223309", "sakis", LocalDate.of(2018,8,23), "euaggelou", "mail3@mail.gr");
        Insured insured4 = new Insured("111111170", "22202223330", "lakis", LocalDate.of(2019,6,27), "nikou", "mail4@mail.gr");
        Insured insured5 = new Insured("211111177", "32222223333", "giotis", LocalDate.of(2018,8,23), "papadopoulos", "mai99l@mail.gr");
        Insured insured6 = new Insured("211811177", "32205223333", "nikos", LocalDate.of(2017,6,20), "papafotiou", "mail22@mail.gr");
        Insured insured7 = new Insured("211111179", "32223223309", "alexis", LocalDate.of(2008,8,23), "euaggelou", "mail23@mail.gr");
        Insured insured8 = new Insured("211111700", "32202223330", "maria", LocalDate.of(2009,6,27), "nikou", "mail24@mail.gr");
        Insured insured9 = new Insured("111111770", "22224223333", "makis", LocalDate.of(2018,8,23), "nikolaou", "mail8@mail.gr");
        Insured insured10 = new Insured("333333333", "22202623333", "mairi", LocalDate.of(2010,6,20), "papas", "mail28@mail.gr");
        Insured insured11 = new Insured("111111179", "22222223309", "gianna", LocalDate.of(2018,8,23), "euaggelou", "mail38@mail.gr");
        Insured insured12 = new Insured("111111170", "22208223330", "lakis", LocalDate.of(2019,6,27), "nikou", "mail48@mail.gr");
        Insured insured13 = new Insured("211111177", "32228223333", "giotis", LocalDate.of(2018,8,23), "andreou", "mail88@mail.gr");
        Insured insured14 = new Insured("211111177", "32202723333", "xrisa", LocalDate.of(2017,6,20), "papas", "mail228@mail.gr");
        Insured insured15 = new Insured("211111179", "32228223309", "alexis", LocalDate.of(2038,8,23), "nakis", "mail238@mail.gr");

        List<Insured> insuredList = Arrays.asList(insured1, insured2, insured3, insured4, insured5,
                insured6, insured7, insured8, insured9, insured10,
                insured11, insured12, insured13, insured14, insured15);

        VaccinationCenter vaccCenter1 = new VaccinationCenter("5012", "Thessaloniki", "Egnatias 10");
        VaccinationCenter vaccCenter2 = new VaccinationCenter("4356", "Thessaloniki", "Egnatias 54");

        Doctor doctor1 = new Doctor("12345678912", "nikolaos", "vasileiou");
        Doctor doctor2 = new Doctor("12345678913", "georgios", "papas");
        Doctor doctor3 = new Doctor("12345678914", "maria", "dimitriou");
        Doctor doctor4 = new Doctor("12345678915", "xristina", "deli");

        //System.out.println(doctor1);

        //timeslots for vaccination center1
        Timeslot timeslot1center1 = new Timeslot(LocalDateTime.of(2022,6,23,18,30), 20, doctor1);
        doctor1.addTimeslot(timeslot1center1);
        Timeslot timeslot2center1 = new Timeslot(timeslot1center1.getEndLocalDateTime(), 15, doctor1);
        doctor1.addTimeslot(timeslot2center1);
        Timeslot timeslot3center1 = new Timeslot(timeslot2center1.getEndLocalDateTime(), 25, doctor1);
        doctor1.addTimeslot(timeslot3center1);
        Timeslot timeslot4center1 = new Timeslot(timeslot3center1.getEndLocalDateTime(), 15, doctor1);
        doctor1.addTimeslot(timeslot4center1);
        Timeslot timeslot5center1 = new Timeslot(timeslot4center1.getEndLocalDateTime(), 15, doctor1);
        doctor1.addTimeslot(timeslot5center1);
        Timeslot timeslot6center1 = new Timeslot(timeslot5center1.getEndLocalDateTime(), 10, doctor2);
        doctor1.addTimeslot(timeslot6center1);
        Timeslot timeslot7center1 = new Timeslot(timeslot6center1.getEndLocalDateTime(), 15, doctor2);
        doctor1.addTimeslot(timeslot7center1);
        Timeslot timeslot8center1 = new Timeslot(timeslot7center1.getEndLocalDateTime(), 25, doctor2);
        doctor1.addTimeslot(timeslot8center1);
        Timeslot timeslot9center1 = new Timeslot(timeslot8center1.getEndLocalDateTime(), 15, doctor2);
        doctor1.addTimeslot(timeslot9center1);
        Timeslot timeslot10center1 = new Timeslot(timeslot9center1.getEndLocalDateTime(), 15, doctor2);
        doctor1.addTimeslot(timeslot10center1);

        List<Timeslot> timeslotListCenter1 =
                Arrays.asList(timeslot1center1, timeslot2center1, timeslot3center1, timeslot4center1,
                timeslot5center1, timeslot6center1, timeslot7center1, timeslot8center1, timeslot9center1, timeslot10center1);
        vaccCenter1.setFreeTimeSlots(timeslotListCenter1);

        //timeslots for vaccination center2
        Timeslot timeslot1center2 = new Timeslot(LocalDateTime.of(2022,6,23,18,30), 20, doctor1);
        doctor1.addTimeslot(timeslot1center2);
        Timeslot timeslot2center2 = new Timeslot(timeslot1center2.getEndLocalDateTime(), 15, doctor1);
        doctor1.addTimeslot(timeslot2center2);
        Timeslot timeslot3center2 = new Timeslot(timeslot2center2.getEndLocalDateTime(), 25, doctor1);
        doctor1.addTimeslot(timeslot3center2);
        Timeslot timeslot4center2 = new Timeslot(timeslot3center2.getEndLocalDateTime(), 15, doctor1);
        doctor1.addTimeslot(timeslot4center2);
        Timeslot timeslot5center2 = new Timeslot(timeslot4center2.getEndLocalDateTime(), 15, doctor1);
        doctor1.addTimeslot(timeslot5center2);
        Timeslot timeslot6center2 = new Timeslot(timeslot5center2.getEndLocalDateTime(), 10, doctor2);
        doctor1.addTimeslot(timeslot6center2);
        Timeslot timeslot7center2 = new Timeslot(timeslot6center2.getEndLocalDateTime(), 15, doctor2);
        doctor1.addTimeslot(timeslot7center2);
        Timeslot timeslot8center2 = new Timeslot(timeslot7center2.getEndLocalDateTime(), 25, doctor2);
        doctor1.addTimeslot(timeslot8center2);
        Timeslot timeslot9center2 = new Timeslot(timeslot8center2.getEndLocalDateTime(), 15, doctor2);
        doctor1.addTimeslot(timeslot9center2);
        Timeslot timeslot10center2 = new Timeslot(timeslot9center2.getEndLocalDateTime(), 15, doctor2);
        doctor1.addTimeslot(timeslot10center2);

        List<Timeslot> timeslotListCenter2 = Arrays.asList(timeslot1center2, timeslot2center2, timeslot3center2, timeslot4center2,
                        timeslot5center2, timeslot6center2, timeslot7center2, timeslot8center2, timeslot9center2, timeslot10center2);
        System.out.println(timeslotListCenter1);
        vaccCenter2.setFreeTimeSlots(timeslotListCenter2);

        System.out.println(doctor1);


    }
}
