package testdouble.ex10;

// Mockito
//   mock,  spy
//  @Mock, @Spy
// 1. 행위 기반 테스트를 목적으로 사용합니다.
// 2. xUnit Test Pattern의 Spy와는 조금 차이가 있다.
// 3. Spy와 Mock의 차이점을 확인하기 위해서는 interface에서는 확인이 안됩니다.
// 4. Spy는 실제 동작을 수행합니다.
//    Mock은 실제 동작을 수행하지 않고, 메소드 호출 여부만 검증합니다.
// 5. Mockito v1 - Interface type을 spy로 만들 경우 예외가 발생했습니다.

// Java 8
//   => 6, 7 언어적인 변화가 거의 존재하지 않았다.
//     ; 인터페이스의 한계
//   => 8:

import org.junit.Test;

import static org.mockito.Mockito.*;

public class SpyMockExamples {
    @Test
    public void playMusicTestWithMock() {
        Person person = new Person();
        Mp3 mockedMp3 = mock(Mp3.class);

        person.playMusic(mockedMp3);

        verify(mockedMp3).playOneMinute();

//        verify(mockedMp3).play();
//        verify(mockedMp3).stop();
    }

    @Test
    public void playMusicTestWithSpy() {
        Person person = new Person();
        Mp3 mockedMp3 = spy(Mp3.class);

        person.playMusic(mockedMp3);

        verify(mockedMp3).playOneMinute();

//        verify(mockedMp3).play();
//        verify(mockedMp3).stop();
    }
}

/*
abstract class Mp3 {
    void play() { System.out.println("Play mp3"); }
    void stop() { System.out.println("Stop mp3"); }
}
*/

// Java 8 에서는 인터페이스 기본 구현을 제공할 수 있습니다.
interface Mp3 {
    void play();
    void stop();

    // default method(defender method)
    default void playOneMinute() {
        System.out.println("playOneMinute");
        play();
        // ...
        stop();
    }
}

class SmartPhone implements Mp3 {
    @Override
    public void play() {

    }

    @Override
    public void stop() {

    }
}


class Person {
    public void playMusic(Mp3 mp3) {
        // mp3.play();
        // mp3.stop();
        mp3.playOneMinute();
    }
}

// Test Double Pattern
//  종류 4가지
// 1) Test Stub   -> Stub - *
// 2) Fake Object -> Fake
// 3) Test Spy    -> Spy
// 4) Mock Object -> Mock - *

//  목적
//   : 테스트 대상 코드를 격리한다.
//     SUT의 테스트 환경을 통제하는 목적으로 사용한다.

//  1) 비결정적 요소를 제어한다. - Stub
//     시간, 네트워크, 파일 시스템 등

//  2) 만들어지지 않은 협력 객체에 의존하는 모듈을 검증하는 목적 - Fake
//     사용하기 힘든 협력 객체에 의존하는 모듈을 검증하는 목적

//  3) 테스트하는데 필요한 정보가 없는 경우, 목격한 일을 기록해서 테스트 가능하도록
//     만들어주는 역활 - Spy

//  4) 행위 기반 테스트 - Mock

//  핵심: Test Double을 직접 만들어서 사용하는 것은, 테스트 코드의 유지보수를 나쁘게
//       한다.
//   => 이미 검증된 격리 프레임워크를 적절하게 활용하는 것이 좋다.
//    C++: Google Mock
//   Java: Mockito

//  2권
//  1) xUnit Test Pattern
//  2) Effective Unit Testing







































