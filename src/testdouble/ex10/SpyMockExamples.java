package testdouble.ex10;

// Mockito
//   mock,  spy
//  @Mock, @Spy
// => 행위 기반 테스트를 목적으로 사용합니다.
// => xUnit Test Pattern의 Spy와는 조금 차이가 있다.


import org.junit.Test;

import static org.mockito.Mockito.*;

public class SpyMockExamples {
    @Test
    public void playMusicTestWithMock() {
        Person person = new Person();
        Mp3 mockedMp3 = mock(Mp3.class);

        person.playMusic(mockedMp3);

        verify(mockedMp3).play();
        verify(mockedMp3).stop();
    }

    @Test
    public void playMusicTestWithSpy() {
        Person person = new Person();
        Mp3 mockedMp3 = spy(Mp3.class);

        person.playMusic(mockedMp3);

        verify(mockedMp3).play();
        verify(mockedMp3).stop();
    }
}

interface Mp3 {
    void play();
    void stop();
}

class Person {
    public void playMusic(Mp3 mp3) {
        mp3.play();
        mp3.stop();
    }
}









