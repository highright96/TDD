package dev.highright96.tdd.chap05;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.sum;
import static org.assertj.core.api.Assertions.*;

public class AssertJTest {

    @Test
    void sumTest() {
        int value = sum(2, 2);
        Integer nv = null;
        String str = "abcdef";
        LocalDate localDate = LocalDate.now();
        List<Integer> list = Arrays.asList(1, 2, 3);

        /*
        assertThat(value).isEqualTo(4);

        assertThat(value).isNotEqualTo(5);

        assertThat(nv).isNull();

        assertThat(value).isIn(1, 2, 3, 4, 5);

        assertThat(value).isIn(1, 2, 3, 4);

        assertThat(value).isLessThan(10);

        assertThat(value).isLessThanOrEqualTo(4);

        assertThat(str).contains("abc");

        assertThat(str).containsOnlyOnce("abc");

        assertThat(str).doesNotContain("ab", "abc", "abcd");

        assertThat(str).startsWith("ab");

        assertThat(localDate).isBefore(LocalDate.of(2030, 1, 12));

        assertThat(list).hasSize(3);

        assertThat(list).contains(1);

        assertThat(list).containsOnly(1, 2, 3);

        assertThatThrownBy(() -> list.get(100)).isInstanceOf(ArrayIndexOutOfBoundsException.class);

        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(1).isBetween(0, 2);
        soft.assertThat(11).isBetween(10, 20);
        soft.assertAll();
        */

        assertThat(17).as("크기 비교 : %d", 15).isLessThan(15);
    }

}
