package testdouble.ex3;

import org.junit.Test;

import static org.junit.Assert.*;

// 단위 테스트 핵심
// 1. 가독성
// 2. 신뢰성
// 3. 유지보수성

// 단위 테스트를 구성하는 방법
//  1. 3A:  Arrange / Act / Assert
//  2. BDD: Given / When / Then
//  3. xUnit Test Pattern
//     : 4단계 테스트 패턴 - setup / act / assert / teardown
//  : 각 단계가 명확하게 구분될 수 있도록 만드는 것이 중요합니다.

// 테스트 대역 목적
//  => 작성하는 테스트 코드의 실패 지점을 최소화 한다.
//  => 결함 국소화: 테스트가 실패할 경우, 실패 지점을 바로 알아낼 수 있어야 한다.

public class LoggerTest {
    @Test
    public void isValidFilename_NameLoggerThan5Chars_ReturnsTrue() {
        // Arrange
        String filename = "goodname.log";
        Logger logger = new Logger();

        // Act
        boolean actual = logger.isValidFilename(filename);

        // Assert
        assertTrue("파일명이 다섯글자 이상일 때", actual);
    }


    @Test
    public void isValidFilename_NameShorterThan5Chars_ReturnsFalse() {
        String filename = "bad.log";
        Logger logger = new Logger();

        boolean actual = logger.isValidFilename(filename);

        assertFalse("파일명이 다섯글자 미만일 때", actual);
    }

    /*
    @Test
    public void isValidFilename_NameShorterThan5Chars_ReturnsFalse() {
        String filename = "bad.log";
        Logger logger = new Logger();

        assertFalse("파일명이 다섯글자 미만일 때",
                logger.isValidFilename(filename));
    }
    */

}


// 아래의 설계는 테스트 대역을 적용하기 어렵습니다. - 문제점!
//  => 테스트 대역을 적용하기 위해서는 반드시 '테스트 가능 설계'가 반영되어 있어야 합니다.

// 객체 지향 설계
//   OCP(Open Close Principle): 개방 폐쇄의 원칙
//      => 새로운 기능이 추가되어도 기존 코드는 수정되면 안된다.
//      => 느슨한 결합(약한 결합)

// 강한 결합: A라는 클래스가 B라는 클래스를 이용할 때 '구체적인 타입'을 이용하는 것
//   => 인터페이스 / 추상 클래스

// 주의 사항: A라는 클래스가 B라는 클래스를 이용할 때,
//         절대 직접 생성하는 것이 아니라, 외부에서 생성된 객체를 전달 받아야 한다.
//   => 의존성 주입(Dependency Injection) 설계

// 의존성 주입 방법 2가지
//  1) 생성자 주입: 필수적인 협력 객체인 경우 생성자를 통해 주입한다.
//     A() - B(), C(), D()
//    보일러플레이트
//      B b = new B();
//      C c = new C();
//      D d = new D();
//      A a = new A(b, c, d);

//  2) 메소드 주입: 필수적이지 않은 협력 객체인 경우 메소드를 통해 주입한다.

// => 의존성 주입은 보일러플레이트가 발생합니다.
//    보일러플레이트를 없애기 위해서는 '의존성 주입 프레임워크'를 이용하는 것이 좋다.
// => 사용자가 직접 의존성 주입을 구현하는 것을 '가난한 자의 의존성 주입'

// 틈새 만들기: 테스트 대역을 적용할 수 있는 형태로 리팩토링 하는 것
//   핵심: 기존 사용법과 다르면 안된다.

// Java: Spring Framework
// Frontend: Angular, React, Vue.js
// Android: Dagger2(Google)


interface IFileSystemManager {
    boolean isValid(String filename);
}

// 1. 인터페이스를 도입한다.
class FileSystemManager implements IFileSystemManager {
    @Override
    public boolean isValid(String filename) {
        return false;
    }
}

class Logger {
    private IFileSystemManager manager;
    public Logger(IFileSystemManager manager) {
        this.manager = manager;
    }

    // 기존의 기능과 동일한 동작을 수행할 수 있도록 해줍니다.
    public Logger() {
        this.manager = new FileSystemManager();
    }

    public boolean isValidFilename(String filename) {
        // 1. 확장자를 제외한 파일의 이름이 반드시 다섯글자 이상이어야 한다.
        //---------------------------- SUT start
        String name = filename.split("\\.")[0];
        if (name.length() < 5)
            return false;
        //---------------------------- SUT end

        // 2. 파일 시스템에서 체크한다.
        // IFileSystemManager manager = new FileSystemManager();
        return manager.isValid(filename);
    }
}

/*
// SUT
class FileSystemManager {
    public boolean isValid(String filename) {
        // OS - NTFS, ext2, ext3 ...
        // ...
        return false;
    }
}

// 핵심: SUT에 의해서 테스트의 성공 실패가 결정되어야 한다.
class Logger {
    // "file.log"
    public boolean isValidFilename(String filename) {
        // 1. 확장자를 제외한 파일의 이름이 반드시 다섯글자 이상이어야 한다.
        //---------------------------- SUT start
        String name = filename.split("\\.")[0];
        if (name.length() < 5)
            return false;
        //---------------------------- SUT end

        // 2. 파일 시스템에서 체크한다.
        FileSystemManager manager = new FileSystemManager();
        return manager.isValid(filename);
    }
}
*/












