package unittest.ex5;


import org.junit.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

// 만약 픽스쳐를 설치하거나 해체하는 작업이 시간이 오래 걸린다.
//  => Slow Test 문제
//   : 테스트가 너무 느려서, 개발자들이 SUT가 변경되어도 테스트를 수행하지 않는다.
//     테스트를 수행하는 개발자의 생산성을 떨어뜨린다.

//  해결 방법
//  => Suite Fixture Setup / Teardown

// Test Runner
// TestCase.setupTestCase();              - connect
// TestCase testcase = new TestCase();
// testcase.setup();
// testcase.testA();
// testcase.tearDown();

// TestCase testcase = new TestCase();
// testcase.setup();
// testcase.testB();
// testcase.tearDown();
// TestCase.tearDownTestCase();           - disconnect


/*
public class TerminalTest {
    private Terminal terminal;

    public TerminalTest() {
        System.out.println("TestCase()");
    }

    // Suite Fixture Setup - static method
    @BeforeClass
    public static void setupTestCase() throws Exception {
        System.out.println("setupTestCase()");
    }

    // Suite Fixture Teardown - static method
    @AfterClass
    public static void tearDownTestCase() throws Exception {
        System.out.println("tearDownTestCase()");
    }


    @Before
    public void setUp() throws Exception {
        System.out.println("setup()");
        terminal = new Terminal();
        terminal.connect();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown()");
        terminal.disconnect();
    }

    @Test
    public void loginTest() throws Exception {
        System.out.println("\tloginTest()");
        terminal.login("guest", "guest_password");

        assertTrue(terminal.isLogin());
    }

    @Test
    public void logoutTest() throws Exception {
        System.out.println("\tlogoutTest()");
        terminal.login("guest", "guest_password");
        terminal.logout();

        assertFalse(terminal.isLogin());
    }

}
*/

// Suite Fixture Setup / Teardown => 문제점이 있다.
//  => 더 이상 각각의 테스트 메소드는 독립적이지 않다.
//  => 공유 픽스쳐 전략
//  => 공유되는 픽스쳐의 상태에 따라서 성공해야 하는 테스트가 실패하거나
//     실패해야 하는 테스트가 성공하는 문제가 발생할 수 있다.
//    : 신뢰성 => 변덕스러운 테스트

//  => Tip!
//     : Test Suite - 20개 테스트 (공유 픽스쳐)
//       -> Test Suite A - 5개
//               ..    D - 5개

public class TerminalTest {
    private static Terminal terminal;  // !

    public TerminalTest() {
        System.out.println("TestCase()");
    }

    // Suite Fixture Setup - static method
    @BeforeClass
    public static void setupTestCase() throws Exception {
        System.out.println("setupTestCase()");
        terminal = new Terminal();
        terminal.connect();
    }

    // Suite Fixture Teardown - static method
    @AfterClass
    public static void tearDownTestCase() throws Exception {
        System.out.println("tearDownTestCase()");
        terminal.disconnect();
    }


    @Before
    public void setUp() throws Exception {
        System.out.println("setup()");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown()");

    }

    @Test
    public void loginTest() throws Exception {
        System.out.println("\tloginTest()");
        terminal.login("guest", "guest_password");

        assertTrue(terminal.isLogin());
    }

    @Test
    public void logoutTest() throws Exception {
        System.out.println("\tlogoutTest()");
        terminal.login("guest", "guest_password");
        terminal.logout();

        assertFalse(terminal.isLogin());
    }

    @Test
    public void foo1() {}
    @Test
    public void foo2() {}
    @Test
    public void foo3() {}

}

// SUT
// 가정: Terminal에 접속하거나 접속 해제하는 것이 느리다.
class Terminal {
    public void connect() throws Exception {
        TimeUnit.SECONDS.sleep(2);
    }

    public void disconnect() throws Exception {
        TimeUnit.SECONDS.sleep(1);
    }

    public void login(String id, String password) {
    }

    public void logout() {
    }

    public boolean isLogin() {
        return true;
    }
}