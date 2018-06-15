package testdouble.ex8;

// 1. 메소드 호출 여부
// 2. 메소드 호출 횟수
// 3. 메소드 호출 순서
// 4. 메소드 인자(그룹)

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

//class User {
//
//}

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

    public void hoo(List<String> s) {
        s.add("second");
        s.add("first");
    }
}

/*
public class MockitoExamples {
    // 3. 인자 순서 - InOrder 객체를 이용해서 순서를 검증하는 것이 가능하다.
    @Test
    public void hooTest() {
        SUT sut = new SUT();
        List<String> mockedList = createMock();
        sut.hoo(mockedList);

        InOrder inOrder = inOrder(mockedList);
        inOrder.verify(mockedList).add("second");
        inOrder.verify(mockedList).add("first");
    }


    // 인자에 대한 체크
    //  anyString

    @Test
    public void gooTest2() {
        SUT sut = new SUT();
        List<String> mockedList = createMock();
        sut.goo(mockedList);

        // 사용자 정의 타입에 대해서 any를 사용하는 방법
        // User arg = any(User.class);

        verify(mockedList, times(3)).add(any());
        // verify(mockedList, times(3)).add(anyString());
    }


    // 2. 호출 횟수 판단
    //  => times, 적어도 N번 - atLeast(), atLeastOnce(),
    //            많아도 N번 - atMost()
    @Test
    public void gooTest() {
        SUT sut = new SUT();
        List<String> mockedList = createMock();
        sut.goo(mockedList);

        // verify(mockedList, times(1)).add("once");
        verify(mockedList).add("once");
        verify(mockedList, atMost(2)).add("twice");

        // verify(mockedList, atLeast(1)).add("twice");
        // verify(mockedList, times(2)).add("twice");
    }

    // Java Generic: 타입 소거 방식으로 동작합니다.
    //   List<String>  s1;     -> List s1;
    //   List<Integer> s2;     -> List s2;
    // C++  Template

    // 1. 호출 여부 판단
    @Test
    public void fooTest() {
        SUT sut = new SUT();

        // List<String> = mock(List.class): List<Object>
        List<String> mockedList = createMock();

        sut.foo(mockedList);

        verify(mockedList).add("one");
        verify(mockedList).add("two");
    }

    // Delegation Setup
    @SuppressWarnings("unchecked")
    private List<String> createMock() {
        return mock(List.class);
    }


//
//    void foo(List<String> s) {
//
//    }
//
//    void foo(List<Integer> a) {
//
//    }

}
*/

public class MockitoExamples {
    // 3. 인자 순서 - InOrder 객체를 이용해서 순서를 검증하는 것이 가능하다.
    @Test
    public void hooTest() {
        sut.hoo(mockedList);

        InOrder inOrder = inOrder(mockedList);
        inOrder.verify(mockedList).add("second");
        inOrder.verify(mockedList).add("first");
    }


    // 인자에 대한 체크
    //  anyString

    @Test
    public void gooTest2() {
        sut.goo(mockedList);

        // 사용자 정의 타입에 대해서 any를 사용하는 방법
        // User arg = any(User.class);

        verify(mockedList, times(3)).add(any());
        // verify(mockedList, times(3)).add(anyString());
    }


    // 2. 호출 횟수 판단
    //  => times, 적어도 N번 - atLeast(), atLeastOnce(),
    //            많아도 N번 - atMost()
    @Test
    public void gooTest() {
        sut.goo(mockedList);

        // verify(mockedList, times(1)).add("once");
        verify(mockedList).add("once");
        verify(mockedList, atMost(2)).add("twice");
    }

    // 1. 호출 여부 판단
    @Test
    public void fooTest() {
        sut.foo(mockedList);

        verify(mockedList).add("one");
        verify(mockedList).add("two");
    }

    private SUT sut;

    @Mock
    private List<String> mockedList;

    @Mock
    private List<String> mockedList2;

    @Before
    public void setUp() {
        // @Mock
        MockitoAnnotations.initMocks(this);

        sut = new SUT();
        // mockedList = ...
    }

    @After
    public void tearDown() {

    }
}

// Mockito Framework -> 격리 프레임워크
//                   => Stub, Spy


















