package testdouble.ex3;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoggerTest {
    @Test
    public void isValidFilename_NameLoggerThan5Chars_ReturnsTrue() {
        String filename = "goodname.log";
        Logger logger = new Logger();

        boolean actual = logger.isValidFilename(filename);

        assertTrue("파일명이 다섯글자 이상일 때", actual);
    }

    @Test
    public void isValidFilename_NameShorterThan5Chars_ReturnsFalse() {
        String filename = "bad.log";
        Logger logger = new Logger();

        assertFalse("파일명이 다섯글자 미만일 때",
                logger.isValidFilename(filename));
    }

}

// SUT
class FileSystemManager {
    public boolean isValid(String filename) {
        // OS - NTFS, ext2, ext3 ...
        return true;
    }
}

class Logger {
    // "file.log"
    public boolean isValidFilename(String filename) {
        // 1. 확장자를 제외한 파일의 이름이 반드시 다섯글자 이상이어야 한다.
        String name = filename.split("\\.")[0];
        if (name.length() < 5)
            return false;

        // 2. 파일 시스템에서 체크한다.
        FileSystemManager manager = new FileSystemManager();
        return manager.isValid(filename);
    }
}