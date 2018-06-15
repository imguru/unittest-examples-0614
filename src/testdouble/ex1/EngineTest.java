package testdouble.ex1;


// 테스트 전용 하위 클래스 패턴
//   : SUT의 private 상태 또는 상태가 제공되지 않을 때 어떻게 하면 테스트 가능하게
//     할 수 있는가?
//   => Test Specific Subclass Pattern
//    방법: SUT를 상속받은 클래스에 테스트에 필요한 상태나 동작을 드러내는 기능을
//         추가한다.

import static org.junit.Assert.assertTrue;

class TestEngine extends Engine {
    // 테스트를 위해 상태를 확인해야 한다면, 적절한 기능이 추가되어야 한다.
    //---------------------------
    private boolean isStart = false;

    public boolean isStart() {
        return isStart;
    }
    //---------------------------

    @Override
    public void start() {
        super.start();    // Engine::start()

        //---------------------------
        isStart = true;
        //---------------------------
    }
}



// Car 객체에 대해서 go를 수행하였을 경우, Engine 객체의 start가
// 제대로 호출되는지 여부를 검증하고 싶다.
public class EngineTest {
    public void goTest2() {
        // Arrange
        TestEngine engine = new TestEngine();
        Car car = new Car(engine);

        // Act
        car.go();


        // Assert
        //  Engine 객체에 start가 호출되었는지 여부를
        //  확인할 수 있는 기능이 제공되지 않는다.
        assertTrue(engine.isStart());
    }




    public void goTest() {
        // Arrange
        Engine engine = new Engine();
        Car car = new Car(engine);

        // Act
        car.go();


        // Assert
        //  Engine 객체에 start가 호출되었는지 여부를
        //  확인할 수 있는 기능이 제공되지 않는다.
    }
}

// SUT
class Engine {
    public void start() {
        System.out.println("Engine start");
    }
}

class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void go() {
        engine.start();
    }
}