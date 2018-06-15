package testdouble.ex4;

import java.io.IOException;

public class UserTest {
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
