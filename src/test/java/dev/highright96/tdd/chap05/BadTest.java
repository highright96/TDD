package dev.highright96.tdd.chap05;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BadTest {

    private static List<Integer> nb = new ArrayList<>();

    @Test
    void fillTest() {
        nb.add(1);
        nb.add(2);
    }

    @Test
    void removeTest() {
        nb.add(1);
        nb.remove(0);
        assertThat(nb.size()).isEqualTo(0);
    }
}
