package exam;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
//@NoArgsConstructor
//arg를 없애줌, AllArgsConstructor과 같이 사용 불가
@AllArgsConstructor
//한번에 arg를 설정할 때 사용 테스트(commend+shift+t)확인
@RequiredArgsConstructor
//
//@Data
//getter,setter,Tostring,RequiredArgsConstructor를 한번에 설정
//보안에 문제 있을 수 있어 가능하면 필요한것 하나씩 생성
@Slf4j
//log
//@UtilityClass
//생성자 자동 생성
public class AnnoExample {
    private String accountNumber;
    private String nickname;
    private LocalDateTime registeredAt;

    public void log(){
        log.error("error is occurred");
    }
}
