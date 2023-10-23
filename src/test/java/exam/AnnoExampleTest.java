package exam;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class AnnoExampleTest {
    @Test
    void accountDto(){
        //given
        //when
        //then

        AnnoExample annoexample = new AnnoExample(
                "accountNumber",
                "summer",
                LocalDateTime.now()
        );
        //@AllArgs~ 가 있다면 한번에 선언 가능
        //설정안하시 밑의 설정 해야함
        //accountDto.setAccountNumber("accountNumber");
        //accountDto.setNickname("summer");

        System.out.println(annoexample.getAccountNumber());
        System.out.println(annoexample.toString());
    }
}