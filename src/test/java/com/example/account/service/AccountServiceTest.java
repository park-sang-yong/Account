package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @BeforeEach
    void init(){
        accountService.createAccount();
    }
    @Test
    void testGetAccount(){
        //given
        //accountService.createAccount();
        Account account =accountService.getAccount(1L);
        //when
        //then
        assertEquals("40000",account.getAccountNumber());
        assertEquals(AccountStatus.IN_USE, account.getAccountStatus());
    }
    @Test
    void testGetAccount2(){
        //given
        //accountService.createAccount();
        Account account =accountService.getAccount(2L);
        //when
        //then
        assertEquals("40000",account.getAccountNumber());
        assertEquals(AccountStatus.IN_USE, account.getAccountStatus());
    }
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