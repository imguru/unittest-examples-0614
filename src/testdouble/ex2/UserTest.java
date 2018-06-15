package testdouble.ex2;

import org.junit.Test;
import testdouble.ex1.User;

import java.lang.reflect.Field;

import static org.junit.Assert.assertTrue;

class TestUser extends User {
    public boolean isAvailable() {
        return isAvailable;  // protected!!
    }
}

// Java - 접근 지정자
//  1. private
//  2. package-default
//  3. protected: 자식 클래스, 같은 패키지
//  4. public

public class UserTest {
    @Test
    public void sampleTest() {
        TestUser user = new TestUser();

        assertTrue(user.isAvailable());
    }

    @Test
    public void privateTest() throws Exception {
        // Java의 Reflection을 통해서 강제적으로 읽어낼 수 있습니다.
        User user = new User();
        Class clazz = user.getClass();

        Field field = clazz.getDeclaredField("isSecret");
        field.setAccessible(true);

        Boolean value = (Boolean) field.get(user);

        System.out.println("value: " + value);
    }
}



































