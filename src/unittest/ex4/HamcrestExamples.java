package unittest.ex4;

// Hamcrest Matcher
//  => 비교 표현의 확장 라이브러리 입니다.
//  => 테스트 단언문을 작성할 때 문맥적으로 자연스럽고 우아한 문자을 만들 수 있게 해준다.
//  => jMock 라이브러리에서 시작해서 지금 현재 junit 4.4 부터 기본적으로 포함되었습니다.
//  => junit5 에서는 Hamcrest 라이브러리가 제외되었습니다.

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class HamcrestExamples {
    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    // 테스트 메소드 안에서 여러 개의 단언문이 존재할 경우,
    // 첫번째 단언문이 실패한다면 이후의 단언문은 절대 수행되지 않는다.
    // => Google Test, Junit 5
    // => 여러개의 단언문을 하나의 테스트 메소드 놓을 경우,
    //    테스트가 실패해도 전체를 실행할 수 있는 기능이 있습니다.
    @Test
    public void getBalanceTest() {
        // assertEquals(1000, bank.getBalance());

        // Hamcrest Matcher - assertThat
        assertThat(bank.getBalance(), is(equalTo(1000)));
        // Assert that bank getBalance is equal to 1000
    }

    @Test
    public void newBankTest() {
        // assertNotNull(bank.newBank());
        assertThat(bank.newBank(), is(notNullValue()));
        // Assert that bank newBank is not null
    }

    @Test
    public void getAccountNameTest() {
        // assertTrue(bank.getAccountName().contains("Guest"));

        assertThat(bank.getAccountName(), containsString("Guest"));
    }

}


// SUT
class Bank {
    public int getBalance() {
        return 0;
    }

    public Bank newBank() {
        return null;
        // return new Bank();
    }

    public String getAccountName() {
        return "TestAccount";
    }
}