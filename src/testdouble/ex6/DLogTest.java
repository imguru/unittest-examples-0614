package testdouble.ex6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static org.junit.Assert.assertTrue;

// https://github.com/imguru/unittest-examples-0614

// DLog 객체에 대해서 write를 수행하였을 때, 등록된 Target에 제대로
// 전달되는가?


// 테스트 대역 종류 4가지 - xUnit Test Pattern
//  1. Test Stub
//  2. Fake Object
//  3. Test Spy
//  4. Mock Object - 모의 객체


// 테스트 대역 용도 3.
//  : SUT의 메소드를 호출하였을 때, 발생하는 부수 효과를 관찰할 수 없어
//    테스트가 안된 요구사항을 테스트하고 싶다.

//  1) Test Spy Pattern
//  : 목격한 일을 기록해두었다가, 나중에 테스트에서 확인할 수 있도록 만들어진 테스트 대역

//  2) Mock Object
//  : 행위 기반 테스트

//   테스트를 작성하는 방법 2가지
//      1) 상태 검증
//       : 테스트에 검증해야 하는 상태(객체의 필드, 전역 변수)가 있는 경우 유용하다.
//         assert methods

//      2) 행위 검증
//       : SUT에 관찰할 수 있는 상태가 존재하지 않는 경우
//         => 올바른 로직 수행의 판단의 근거로 특정한 동작의 수행 여부를 검증
//        * 메소드 호출 여부
//        * 메소드 호출 횟수
//        * 메소드 호출 순서

//  행위 검증을 하기 위해서는 Mock Framework을 사용하면 됩니다.
//     C++: Google Test - Google Mock
//    Java: jMock, EasyMock, Mockito

class SpyTarget implements Target {
    // 1. 목격한 일을 기록한다.
    private List<String> history = new ArrayList<>();

    private String concat(Level level, String message) {
        return level.getName() + "@" + message;
    }

    // 2. 테스트에서 확인할 수 있는 기능을 제공한다.
    public boolean received(Level level, String message) {
        return history.contains(concat(level, message));
    }

    @Override
    public void write(Level level, String message) {
        history.add(concat(level, message));
    }
}

public class DLogTest {
    @Test
    public void writeTest() {
        SpyTarget spy1 = new SpyTarget();
        SpyTarget spy2 = new SpyTarget();
        DLog dlog = new DLog(spy1, spy2);
        Level level = Level.INFO;
        String message = "log testing message";

        dlog.write(level, message);

        assertTrue(spy1.received(level, message));
        assertTrue(spy2.received(level, message));
    }
}

// SUT
interface Target {
    void write(Level level, String message);
}

// FileTarget -> file.log
// HttpTarget -> POST message
class DLog {
    private Target[] targets;
    public DLog(Target... targets) {
        this.targets = targets;
    }

    public void write(Level level, String message) {
        // 자신에게 전달된 로그 메세지를 등록된 타겟에게 전파한다.
        for (Target e : targets) {
            e.write(level, message);
        }
    }
}








