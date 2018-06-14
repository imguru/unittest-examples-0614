package unittest.ex2;


import org.junit.Test; // junit4
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void test_add_10plus32_expected42() {
        Calculator calc = new Calculator();

        calc.add(10);
        calc.add(32);

        assertEquals("10 + 32", 42, calc.display());
    }

    @Test
    public void subTest() {
        Calculator calc = new Calculator();

        calc.sub(10);
        calc.sub(32);

        assertEquals("-10 - 32", -42, calc.display());
    }
}

class Calculator {
    private int value;

    public Calculator() {
        this.value = 0;
    }

    public void add(int a) {
        value += a;
    }

    public void sub(int a) {
        value -= a;
    }

    public int display() {
        return value;
    }
}


















