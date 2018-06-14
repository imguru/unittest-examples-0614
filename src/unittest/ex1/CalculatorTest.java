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

// junit4 / junit5 => AOP(관점 지향 프로그래밍)
// => alt + enter
public class CalculatorTest {
    @Test
    public void testAdd() {
        // System.out.println("CalculatorTest - testAdd()");
        throw new IllegalStateException("TODO");
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

// SUT
class Calculator {}
