package testdouble.ex9;


import org.junit.Test;

import static org.junit.Assert.*;

public class MockitoLoggerTest {
    @Test
    public void isValidFilename_NameLoggerThan5Chars_ReturnsTrue() {

        String filename = "goodname.log";
        StubFileSystem stub = new StubFileSystem();
        stub.result = true;
        Logger logger = new Logger(stub);


        boolean actual = logger.isValidFilename(filename);


        assertTrue("파일명이 다섯글자 이상일 때", actual);
    }


    @Test
    public void isValidFilename_NameShorterThan5Chars_ReturnsFalse() {
        String filename = "bad.log";
        StubFileSystem stub = new StubFileSystem();
        stub.result = true;
        Logger logger = new Logger(stub);

        boolean actual = logger.isValidFilename(filename);

        assertFalse("파일명이 다섯글자 미만일 때", actual);
    }
}


// Stub: 협력 객체를 간단하게 대신하기 위해 쓰이는 '제어 가능한' 테스트 대역
class StubFileSystem implements IFileSystemManager {
    boolean result;

    @Override
    public boolean isValid(String filename) {
        return result;
    }
}



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










