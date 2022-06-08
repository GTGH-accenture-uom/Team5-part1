package team5.services;

import team5.model.Insured;
import team5.model.Reservation;
import team5.model.VaccinationCenter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class InsuredService {


    public void getNonVaccinatedInsuredAbove60(List<Insured> insuredList, List<VaccinationCenter> vaccinationCenters) {

        List<Insured> insuredWhoBooked = vaccinationCenters
                .stream()
                .flatMap(vaccinationCenter -> vaccinationCenter.getReservations().stream())
                .map(Reservation::getInsured)
                .filter(e -> LocalDate.now().getYear() - e.getBirthdate().getYear() > 60)
                .toList();

        List<Insured> insured = insuredList.stream()
                .filter(ins -> !insuredWhoBooked.contains(ins) && LocalDate.now().getYear() - ins.getBirthdate().getYear() > 60)
                .collect(Collectors.toList());


        System.out.println(insured);


    }

}
