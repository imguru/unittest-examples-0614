package testdouble.ex6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

// DLog 객체에 대해서 write를 수행하였을 때, 등록된 Target에 제대로
// 전달되는가?

// 테스트 대역 용도 3.
//  : SUT의 메소드를 호출하였을 때, 발생하는 부수 효과를 관찰할 수 없어
//    테스트가 안된 요구사항을 테스트하고 싶다.

//  => Test Spy Pattern
//  : 목격한 일을 기록해두었다가, 나중에 테스트에서 확인할 수 있도록 만들어진 테스트 대역

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








