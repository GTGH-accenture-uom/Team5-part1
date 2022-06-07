package team5;

import team5.model.Insured;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        //Timeslot timeslot = new Timeslot(LocalDateTime.now());
       // System.out.println(timeslot);
        //System.out.println(LocalDateTime.of(2018,8,23,18,30));

        Insured insured1 = new Insured("111111177", "22222223333", "makis", LocalDate.of(2018,8,23), "papadopoulos", "mail@mail.gr");
        Insured insured2 = new Insured("111111177", "22202223333", "takis", LocalDate.of(2010,6,20), "papas", "mail2@mail.gr");
        Insured insured3 = new Insured("111111179", "22222223309", "sakis", LocalDate.of(2018,8,23), "euaggelou", "mail3@mail.gr");
        Insured insured4 = new Insured("111111170", "22202223330", "lakis", LocalDate.of(2019,6,27), "nikou", "mail4@mail.gr");
        Insured insured5 = new Insured("211111177", "32222223333", "giotis", LocalDate.of(2018,8,23), "papadopoulos", "mai99l@mail.gr");
        Insured insured6 = new Insured("211811177", "32205223333", "nikos", LocalDate.of(2017,6,20), "papafotiou", "mail22@mail.gr");
        Insured insured7 = new Insured("211111179", "32223223309", "alexis", LocalDate.of(2038,8,23), "euaggelou", "mail23@mail.gr");
        Insured insured8 = new Insured("211111700", "32202223330", "maria", LocalDate.of(2009,6,27), "nikou", "mail24@mail.gr");
        Insured insured9 = new Insured("111111770", "22224223333", "makis", LocalDate.of(2018,8,23), "nikolaou", "mail8@mail.gr");
        Insured insured10 = new Insured("333333333", "22202623333", "mairi", LocalDate.of(2010,6,20), "papas", "mail28@mail.gr");
        Insured insured11 = new Insured("111111179", "22222223309", "gianna", LocalDate.of(2018,8,23), "euaggelou", "mail38@mail.gr");
        Insured insured12 = new Insured("111111170", "22208223330", "lakis", LocalDate.of(2019,6,27), "nikou", "mail48@mail.gr");
        Insured insured13 = new Insured("211111177", "32228223333", "giotis", LocalDate.of(2018,8,23), "andreou", "mail88@mail.gr");
        Insured insured14 = new Insured("211111177", "32202723333", "xrisa", LocalDate.of(2017,6,20), "papas", "mail228@mail.gr");
        Insured insured15 = new Insured("211111179", "32228223309", "alexis", LocalDate.of(2038,8,23), "nakis", "mail238@mail.gr");
        System.out.println(insured1);
        System.out.println("dd");
    }
}
