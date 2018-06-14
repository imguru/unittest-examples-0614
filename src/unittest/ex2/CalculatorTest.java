package unittest.ex2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/*
// Test Fixture를 구성하는 방법
//   1. Inline Fixture Setup
//   : 모든 픽스쳐 설치를 테스트 메소드 안에서 한다.

//  Pros: 테스트의 인과 관계를 쉽게 파악할 수 있다.
//  Cons: 모든 테스트 메소드 안에서 각각 설치해야 하므로 '테스트 코드 중복'이 발생한다.

//  테스트 코드 중복 - 테스트 냄새(Test Smells)
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
*/

/*
// 2. Delegate Setup(위임 설치)
//   : 테스트 인과 관계를 쉽게 파악할 수 있고, 픽스쳐 설치에 관한 복잡함을 캡슐화함으로써
//     SUT 설치에 대한 코드를 관리하기 편리하다.
public class CalculatorTest {
    // Test Utility Method
    //  : 테스트 내에 중복되는 코드를 별도의 메소드로 캡슐화하자.
    //  => Creation Method
    private Calculator createCalculator() {
        return new Calculator(0);
    }

    @Test
    public void test_add_10plus32_expected42() {
        Calculator calc = createCalculator();

        calc.add(10);
        calc.add(32);

        assertEquals("10 + 32", 42, calc.display());
    }

    @Test
    public void subTest() {
        Calculator calc = createCalculator();

        calc.sub(10);
        calc.sub(32);

        assertEquals("-10 - 32", -42, calc.display());
    }
}
*/

// 3. 암묵적(Implicit) 설치
//   : xUnit Test Framework가 지원하는 기능을 이용한다.
// Pros: 테스트 코드 중복을 제거하고, 불필요한 상호 작용을 감출 수 있다.
// Cons: 테스트 메소드를 이해하기 어려울 수 있다.

// * Test Runner가 테스트를 수행하는 흐름
//  CalculatorTest testcase = new CalculatorTest();
//  testcase.setUp()      ; 암묵적으로 호출되는 픽스쳐 설치 용도 메소드
//  testcase.addTest()

//  testcase.setUp()
//  testcase.subTest()


// TestCase(테스트 메소드 집합) / TestSuite('동일한 픽스쳐'를 가진 테스트 메소드 집합)
public class CalculatorTest {

    private Calculator calc;
    @Before
    public void setUp() {
        System.out.println("setUp");
        calc = new Calculator();
    }

    @Test
    public void addTest() {
        System.out.println("addTest");
        // Calculator calc = new Calculator();

        calc.add(10);
        calc.add(32);

        assertEquals("10 + 32", 42, calc.display());
    }

    @Test
    public void subTest() {
        System.out.println("subTest");
        // Calculator calc = new Calculator();

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


















