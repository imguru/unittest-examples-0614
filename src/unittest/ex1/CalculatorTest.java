package unittest.ex1;

// Test Case:  Test Method의 집합
// Test Suite: 동일한 Fixture를 가진 테스트의 집합


// 1. Test Case 를 만들어야 합니다.
// 2. Test Case 안에서 Test Method를 만들어야 합니다.

// junit3 / Google Test
//  - class CalculatorTest extends TestCase {}

// import junit.framework.TestCase;
// https://github.com/imguru/unittest-examples-0614.git

import org.junit.Test;

// import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

// junit4 / junit5 => AOP(관점 지향 프로그래밍)
// => alt + enter
public class CalculatorTest {
    /*
    @Test
    public void testAdd() {
        // System.out.println("CalculatorTest - testAdd()");
        throw new IllegalStateException("TODO");
    }
    */

    // 테스트를 구성하는 방법 - 3A
    // 1) Arrange: 객체를 생성하고, 필요한 경우 적절하게 설정한다.
    // 2) Act: 객체에 작용을 가한다.
    // 3) Assert: 기대하는 바를 단언한다.

    // 테스트를 만들때 고려할 점
    //  * 테스트 코드 안에는 조건문이나 반복문 같은 제어구문이 나오면 안됩니다.

    @Test
    public void addTest() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        calc.add(10);
        calc.add(32);

        // Assert
        assertEquals(42, calc.display());
        /*
        if (42 != calc.display()) {
            throw new IllegalStateException("10 + 32 != 42");
        }
        */
    }
}



/*
public class CalculatorTest extends TestCase {
    public void testAdd() {

    }

}
*/


// xUnit Test Framework 안에 숨겨져 있습니다.
// => main을 별도로 작성할 필요가 없습니다.
/*
public class Program {
    public static void main(String[] args) {
        System.out.println("Hello, Unittest");
    }
}
*/

// SUT: System Under Test
//  => CUT(Code Under Test, Class Under Test)
//  => 테스트 대상 시스템
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


















