package dev.highright96.tdd.chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {

        int addMonths = payData.getPayAmount() == 100000 ? 12 : payData.getPayAmount() / 10000;

        if (payData.getFirstBillingDate() != null) {
            return expiryDateUsingFirstBillingDate(payData, addMonths);
        } else {
            return payData.getBillingDate().plusMonths(addMonths);
        }
    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addMonths) {
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addMonths);
        if (isNotSameDayOfMonth(candidateExp, payData.getFirstBillingDate())) {
            final int dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth();
            int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
            if (dayLenOfCandiMon < dayOfFirstBilling) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(dayOfFirstBilling);
        } else {
            return candidateExp;
        }
    }

    private boolean isNotSameDayOfMonth(LocalDate candidateExp, LocalDate dayOfFirstBilling) {
        return dayOfFirstBilling != candidateExp;
    }
}
