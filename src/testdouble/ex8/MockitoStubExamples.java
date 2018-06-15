package testdouble.ex8;

import org.junit.Test;

import static org.mockito.Mockito.*;

// Stub: 특수한 상황을 시뮬레이션 한다.
interface Mouse {
    String showOff();

    void move(int x, int y);
}

public class MockitoStubExamples {
    @Test
    public void stubTest() {
        Mouse stub = mock(Mouse.class);
        // stub이 호출되었을 때 어떤 결과를 반환할지 결정한다.
        when(stub.showOff()).thenReturn("I'm Mouse");

        System.out.println(stub.showOff());
    }
}


