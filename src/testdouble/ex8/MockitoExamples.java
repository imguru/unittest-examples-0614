package testdouble.ex8;

// 1. 메소드 호출 여부
// 2. 메소드 호출 횟수
// 3. 메소드 호출 순서
// 4. 메소드 인자(그룹)

import java.util.List;

class SUT {
    public void foo(List<String> s) {
        s.add("one");
        s.add("two");
    }
}

public class MockitoExamples {

}
