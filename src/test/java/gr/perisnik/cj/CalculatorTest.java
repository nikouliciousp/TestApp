package gr.perisnik.cj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void addTowInts() {
        var calc = new Calculator();
        int a = 5, b = 10;

        int expected = 15;
        int actual = calc.add(a, b);

        assertEquals(expected, actual);
    }

    @Test
    void subTowInts() {
        var calc = new Calculator();
        int a = 5, b = 10;

        int expected = -5;
        int actual = calc.sub(a, b);

        assertEquals(expected, actual);
    }
}