package unittest.ex6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

// 파라미터화 테스트(Parameterized Test Pattern)
//  : xUnit Test Framework이 제공하는 기능입니다.
// => 데이터를 아주 조금씩 바꿔가며, 수차례 반복 검사하는 데이터 중심 테스트가 있을 경우
//    코드의 중복을 없애준다.


// 파라미터화 테스트를 적용하는 방법
//   * 기존
//   TestCase tc = new TestCase();
//   tc.setUp()
//   tc.testBody();
//   tc.tearDown();

//   Object[][] data = [ {"tom"}, {"bob"}, {"alice"}]
//   * Parameterized Test Runner
//   TestCase tc = new TestCase({"tom"});
//   tc.setUp();
//   tc.testBody();
//   tc.tearDown();

//   TestCase tc = new TestCase({"bob"});
//   tc.setUp();
//   tc.testBody();
//   tc.tearDown();

//   TestCase tc = new TestCase({"alice"});
//   tc.setUp();
//   tc.testBody();
//   tc.tearDown();

// 1. 기존의 Test Runner와 동작 방식이 다릅니다,.
@RunWith(value = Parameterized.class)
public class UserNameTest {

}

/*
public class UserNameTest {

    // 단언문
    //  : 하나의 단언문이 실패하면, 이후의 단언문은 절대 실행되지 않는다.

    @Test
    public void isValidNameTest() {
        assertTrue(User.isValidName("tom"));
        assertTrue(User.isValidName("bob"));
        assertTrue(User.isValidName("alice"));
        assertTrue(User.isValidName("marry"));
    }
}
*/


// SUT
class User {
    public static boolean isValidName(String name) {
        // 사용자의 이름은 반드시 소문자로 이루어져 있어야 하고, 5글자 이상이어야 한다.
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (Character.isUpperCase(c))
                return false;
        }

        return name.length() >= 5;
    }
}