package services;

import model.Insured;
import model.Reservation;
import model.VaccinationCenter;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InsuredService {

    public List<Insured> getInsuredAbove60WhoDidntReserve(List<Insured> insuredList, List<VaccinationCenter> vaccinationCenters) {

        // Taking all the insured above 60 who made reservation from all vaccination centers
        List<Insured> insuredWhoReservedAbove60 = vaccinationCenters
                .stream()
                .flatMap(vaccinationCenter -> vaccinationCenter.getReservations().stream())
                .map(Reservation::getInsured)
                .filter(this::isInsuredAbove60)
                .collect(Collectors.toList());

        /*
            Exclude the insuredWhoReservedAbove60 from the general list of insured
            and keep only them who are above 60 and didn't reserve
         */
        return insuredList.stream()
                .filter(ins -> !insuredWhoReservedAbove60.contains(ins) && isInsuredAbove60(ins))
                .collect(Collectors.toList());
    }

    private boolean isInsuredAbove60(Insured e) {
        return LocalDate.now().getYear() - e.getBirthdate().getYear() > 60;
    }

    public void displayInsuredAbove60WhoDidntReserve(List<Insured> insuredList, List<VaccinationCenter> vaccinationCenters) {
        AtomicInteger runCount = new AtomicInteger(0);
        List<Insured> insuredAbove60WhoDidntReserve =  getInsuredAbove60WhoDidntReserve(insuredList,vaccinationCenters);
        if (!insuredAbove60WhoDidntReserve.isEmpty()) {
            System.out.println("--------INSURED ABOVE 60 WHO DIDNT RESERVE-------");
            insuredAbove60WhoDidntReserve.forEach(insured -> {
                System.out.println((runCount.incrementAndGet()) + "-"
                         + insured.getName() + " " + insured.getSurname() + " with afm " +  insured.getAfm());
            });
        } else {
            System.out.println("--------NO INSURED ABOVE 60 WHO DIDNT RESERVE FOUND-------");
        }
    }


}
