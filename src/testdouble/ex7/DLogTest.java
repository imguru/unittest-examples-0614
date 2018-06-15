package testdouble.ex7;

import java.util.logging.Level;

public class DLogTest {
}

// SUT
interface Target {
    void write(Level level, String message);
}

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