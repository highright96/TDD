package dev.highright96.tdd.chap02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {
    /*
    조건
    1) 길이가 8글자 이상
    2) 0부터 9사이의 숫자를 포함
    3) 대문자 포함
    */
    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    //모두 만족하는 경우
    @Test
    void meetsAllCriteria_Then_Strong() {
        assertStrength("ac12!@AC", PasswordStrength.STRONG);
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
    }

    // 8글자 미만인 경우만 충족하지 않는 경우
    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
    }

    //숫자 조건만 충족하지 않는 경우
    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        assertStrength("abcd!@Ab", PasswordStrength.NORMAL);
    }

    // 대문자 조건만 충족하지 않는 경우
    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
        assertStrength("abcd@24fd", PasswordStrength.NORMAL);
    }

    //8글자 이상인 조건만 충족
    @Test
    void meetsOnlyLengthCriteria_Then_Weak() {
        assertStrength("absdcwefew", PasswordStrength.WEAK);
    }

    //숫자를 포함한 조건만 만족한 경우
    @Test
    void meetsOnlyNumCriteria_Then_Weak() {
        assertStrength("1351", PasswordStrength.WEAK);
    }

    //대문자 포함 조건만 충족하는 경우
    @Test
    void meetOnlyUpCriteria_Then_Weak() {
        assertStrength("ADFS", PasswordStrength.WEAK);
    }

    //값이 없는 경우
    @Test
    void nullInput_Then_Invalid() {
        assertStrength(null, PasswordStrength.INVALID);
    }

    //빈값이 들어오는 경우
    @Test
    void emptyInput_Then_Invalid() {
        assertStrength("", PasswordStrength.INVALID);
    }

    //아무 조건도 충족하지 않은 경우
    @Test
    void meetsNoCriteria_Then_Weak(){
        assertStrength("abc", PasswordStrength.WEAK);
    }

}
