package tech.reliab.cource.toropchnda.bank.utils;

import java.time.LocalDate;
import java.time.Period;

public class CreditCalculator {

    public static double calcMonthPayment(LocalDate creditBegin,
                                        LocalDate creditEnd,
                                        Long creditAmount,
                                        Double interestRate) {

        var monthBetween = Period.between(creditBegin, creditEnd).toTotalMonths();
        return (creditAmount * (1 + interestRate / 100)) / monthBetween;
    }
}
