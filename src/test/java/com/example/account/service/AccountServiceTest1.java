package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountStatus;
import com.example.account.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//Mockito 테스트 방법
@ExtendWith(MockitoExtension.class)
//@SpringBootTest//스프링 부트 테스트
class AccountServiceTest1 {

    //스프링 부트 테스트
    //@Autowired
    //private AccountService accountService;
    //@BeforeEach
    //void init(){
    //    accountService.createAccount();
    //}

    @Mock//Mockito 테스트 방법
    private AccountRepository accountRepository;
    @InjectMocks//Mockito 테스트 방법
    private AccountService accountService;

    @Test//Mockito 테스트 방법
    @DisplayName("계좌 조회 성공")
    void testxxx(){
        //이 설정에 대한 테스트 진행
        //given
        given(accountRepository.findById(anyLong()))
                .willReturn(Optional.of(Account.builder()
                        .accountStatus(AccountStatus.UNREGISTERED)
                        .accountNumber("65789").build()));
        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        //when
        Account account = accountService.getAccount(4555L);
        //then
        verify(accountRepository,times(1)).findById(captor.capture());
        verify(accountRepository,times(0)).save(any());
        assertEquals(4555L,captor.getValue());
        assertNotEquals(45541L,captor.getValue());
        assertEquals("65789",account.getAccountNumber());
        assertEquals(AccountStatus.UNREGISTERED,account.getAccountStatus());
    }
    @Test//Mockito 테스트 방법
    @DisplayName("계좌 실패 성공 - 음수로 조회")
    void testFailedToSearchAccount(){
        //이 설정에 대한 테스트 진행
        //given
        //when
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> accountService.getAccount(-10L));
        //then
        assertEquals("Minus",exception.getMessage());
    }



    @Test
    void testGetAccount1(){
        //given
        //accountService.createAccount();
        given(accountRepository.findById(anyLong()))
                .willReturn(Optional.of(Account.builder()
                        .accountStatus(AccountStatus.UNREGISTERED)
                        .accountNumber("65789").build()));
        //when
        Account account = accountService.getAccount(4555L);
        //then
        verify(accountRepository,times(1)).findById(anyLong());
        assertEquals("65789",account.getAccountNumber());
        assertEquals(AccountStatus.UNREGISTERED,account.getAccountStatus());
    }
/*    @Test
    void testGetAccount(){
        //given
        //accountService.createAccount();
        Account account =accountService.getAccount(1L);
        //when
        //then
        assertEquals("40000",account.getAccountNumber());
        assertEquals(AccountStatus.IN_USE, account.getAccountStatus());
    }*/
    /*@Test
    void testGetAccount2(){
        //given
        //accountService.createAccount();
        Account account =accountService.getAccount(2L);
        //when
        //then
        assertEquals("40000",account.getAccountNumber());
        assertEquals(AccountStatus.IN_USE, account.getAccountStatus());
    }*/

    /*@Test
    void testSomething(){
        //given
        String something = "Hello " + "World";

        assertEquals("Hello World",something);
        //when
        //then
    }
    @Test
    void testSomething2(){
        //given
        String something = "Hello " + "World";

        assertEquals("Hello World",something);
        //when
        //then
    }*/

}