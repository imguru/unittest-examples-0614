package testdouble.ex8;

// 1. 메소드 호출 여부
// 2. 메소드 호출 횟수
// 3. 메소드 호출 순서
// 4. 메소드 인자(그룹)

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class SUT {
    public void foo(List<String> s) {
        s.add("one");
        s.add("two");
    }

    public void goo(List<String> s) {
        s.add("once");
        s.add("twice");
        s.add("twice");
    }
}

public class MockitoExamples {
    // 1. 호출 여부 판단
    @Test
    public void fooTest() {
        SUT sut = new SUT();
        List<String> mockedList = mock(List.class);

        sut.foo(mockedList);

        verify(mockedList).add("one");
        verify(mockedList).add("two");
    }

    // 2. 호출 횟수 판단


}




















