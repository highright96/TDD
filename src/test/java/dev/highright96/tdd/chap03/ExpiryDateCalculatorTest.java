package dev.highright96.tdd.chap03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨() {
        assertExpiryDate(PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(10000)
                        .build(),
                LocalDate.of(2019, 4, 1));
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {
        assertExpiryDate(PayData.builder()
                        .billingDate(LocalDate.of(2019, 1, 31))
                        .payAmount(10000)
                        .build(),
                LocalDate.of(2019, 2, 28)
        );
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_만원_납부() {
        assertExpiryDate(PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 1, 30))
                        .billingDate(LocalDate.of(2019, 2, 28))
                        .payAmount(10000)
                        .build(),
                LocalDate.of(2019, 3, 30)
        );

        assertExpiryDate(PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 5, 31))
                        .billingDate(LocalDate.of(2019, 6, 30))
                        .payAmount(10000)
                        .build(),
                LocalDate.of(2019, 7, 31)
        );
    }

    @Test
    void 이만원_이상_납부하면_비례해서_만료일_계산(){
        assertExpiryDate(PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(20000)
                        .build(),
                LocalDate.of(2019, 5, 1)
        );

        assertExpiryDate(PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(30000)
                        .build(),
                LocalDate.of(2019, 6, 1)
        );
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_이만원_이상_납부(){
        assertExpiryDate(PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 1, 31))
                        .billingDate(LocalDate.of(2019, 2, 28))
                        .payAmount(40000)
                        .build(),
                LocalDate.of(2019, 6, 30)
        );

        assertExpiryDate(PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 3, 31))
                        .billingDate(LocalDate.of(2019, 4, 28))
                        .payAmount(50000)
                        .build(),
                LocalDate.of(2019, 9, 30)
        );
    }

    @Test
    void 십만원을_납부하면_1년_제공(){
        assertExpiryDate(PayData.builder()
                        .billingDate(LocalDate.of(2019, 1, 28))
                        .payAmount(100000)
                        .build(),
                LocalDate.of(2020, 1, 28)
        );
    }

    void assertExpiryDate(PayData payData, LocalDate expectExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(payData);
        Assertions.assertThat(expiryDate).isEqualTo(expectExpiryDate);
    }

}