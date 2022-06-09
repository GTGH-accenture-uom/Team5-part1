package team5.services;

import team5.model.Insured;
import team5.model.Reservation;
import team5.model.VaccinationCenter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class InsuredService {



    public void getInsuredAbove60WhoDidntReserve(List<Insured> insuredList, List<VaccinationCenter> vaccinationCenters) {

        // Taking all the insured above 60 who made reservation from all vaccination centers
        List<Insured> insuredWhoReservedAbove60 = vaccinationCenters
                .stream()
                .flatMap(vaccinationCenter -> vaccinationCenter.getReservations().stream())
                .map(Reservation::getInsured)
                .filter(e -> LocalDate.now().getYear() - e.getBirthdate().getYear() > 60)
                .toList();

        //Exclude the insuredWhoReservedAbove60 from the general list of insured and keeping only them who are above 60 and didn't reserve
        List<Insured> insured = insuredList.stream()
                .filter(ins -> !insuredWhoReservedAbove60.contains(ins) && LocalDate.now().getYear() - ins.getBirthdate().getYear() > 60)
                .collect(Collectors.toList());


        System.out.println(insured);


    }

}
