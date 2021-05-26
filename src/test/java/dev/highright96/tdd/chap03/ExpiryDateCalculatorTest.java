package dev.highright96.tdd.chap03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨() {
        LocalDate billingDate = LocalDate.of(2019, 3, 1);
        int payAmount = 100;

        ExpiryDateCalculator cal = new ExpiryDateCalculator();

        assertExpiryDate(billingDate, payAmount, cal.calculateExpiryDate(billingDate, payAmount));
    }

    void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);
        Assertions.assertThat(expiryDate).isEqualTo(expectedExpiryDate);
    }

}