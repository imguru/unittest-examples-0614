package unittest.ex1;

// Test Case:  Test Method의 집합
// Test Suite: 동일한 Fixture를 가진 테스트의 집합


// 1. Test Case 를 만들어야 합니다.
// 2. Test Case 안에서 Test Method를 만들어야 합니다.

// junit3 / Google Test
//  - class CalculatorTest extends TestCase {}

// import junit.framework.TestCase;
// https://github.com/imguru/unittest-examples-0614.git

import org.junit.Test; // junit4

// import static org.junit.Assert.assertEquals;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

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

    // BDD(행위 주도 개발)
    //  1) 행위 기반 테스트
    //  2) 테스트를 구성할 때, 자연어와 가깝게 구성하는 것을 지향한다.

    // 테스트 프레임워크 - Javascript
    //   : mocha.js / jest.js
    //   it()

    // 테스트를 구성하는 방법 - 3A(TDD) / BDD
    // 1) Arrange(Given): 객체를 생성하고, 필요한 경우 적절하게 설정한다.
    // 2) Act(When): 객체에 작용을 가한다.
    // 3) Assert(Then): 기대하는 바를 단언한다.


    // 테스트의 이름은 어떤 시나리오로 동작하는 명확하게 드러나야 한다.
    //  => test_테스트대상메소드_시나리오_기대값()
    // @DisplayName("10과 32를 더했을 경우 42의 결과가 나오는지 검증한다.")
    @Test
    public void test_add_10plus32_expected42() {
    // public void test_add_10더하기32_결과는42() {
        // Arrange
        Calculator calc = new Calculator();
        int expected = 42;

        // Act
        calc.add(10);
        calc.add(32);

        // 테스트를 만들때 고려할 점
        //  * 테스트 코드 안에는 조건문이나 반복문 같은 제어구문이 나오면 안됩니다.
        // Assert
        //  1. assertEquals를 사용할 때는 반드시 첫번째 인자로 기대값을 이용해야 합니다.
        //  2. 실패의 원인이 무엇인지 '반드시' 메세지를 작성해야 한다.
        assertEquals("10 + 32", 42, calc.display());

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
        return 0;
    }
}


















