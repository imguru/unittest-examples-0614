package testdouble.ex4;

import org.junit.Test;

import java.io.IOException;

// Test Stub Pattern
//  의도: 다른 컴포넌트로부터의 간접 입력에 의존하는 로직을 독립적으로 검증하고 싶다.
//   => 실제 의존하는 객체를 테스트 용 객체로 교체해서, SUT가 테스트하는 필요한 결과를
//      보내도록 한다.

//  외부 의존물을 제어하는 것이 가능하다.
//  '외부 의존물': 제어할 수 없는 협력 객체
//     => 네트워크, 파일 시스템, 시간

// Test Double
//  용도 1. 특수한 상황을 시뮬레이션 할 수 있다.

class StubConnection implements Connection {

    @Override
    public void move(int x, int y) throws IOException {
        throw new IOException();
    }

    @Override
    public void attack() throws IOException {
        throw new IOException();
    }
}


public class UserTest {
    // 네트워크 연결이 끊겼을 때, User move의 동작이 BadConnection이 제대로
    // 발생하는지 여부를 검증하고 싶다.

    // 문제점: 아래의 테스트는 실제로 네트워크 연결이 끊겨야만, 성공하는 테스트이다.
    //       단위테스트는 수동 조정이 필요하면 안된다.

    @Test(expected = BadConnection.class)
    public void badConnectionTest() throws Exception {
        StubConnection stub = new StubConnection();
        User user = new User(stub);

        user.move(10, 32);
    }
}

// SUT
interface Connection {
    void move(int x, int y) throws IOException;

    void attack() throws IOException;
}

class TCPConnection implements Connection {

    @Override
    public void move(int x, int y) {
        // TCP Pakcet을 만들어서 서버에 전송한다.
    }

    @Override
    public void attack() {
        // TCP Pakcet을 만들어서 서버에 전송한다.
    }
}

class BadConnection extends IOException {

}

class User {
    private Connection connection;

    public User(Connection connection) {
        this.connection = connection;
    }

    public User() {
        this.connection = new TCPConnection();
    }

    public void move(int x, int y) throws BadConnection {
        try {
            connection.move(x, y);
        } catch (IOException e) {
            throw new BadConnection();
        }
    }

    public void attack() throws BadConnection {
        try {
            connection.attack();
        } catch (IOException e) {
            throw new BadConnection();
        }
    }

}
