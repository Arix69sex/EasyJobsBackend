package com.easyjobs.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CuentaTest {
    
    @Test
    @DisplayName("When Create a Cuenta with Valid Id Then Returns Repective Cuenta")
    public void whenCreateCuentaWithValidIdGetACuenta(){
        Cuenta cuenta = new Cuenta();
        cuenta.setId(1L);

        Assertions.assertEquals(1L, cuenta.getId());
    }

    @Test
    @DisplayName("When Create a Cuenta with Valid Username Then Returns Repective Cuenta")
    public void whenCreateCuentaWithValidUsernameGetACuenta(){
        Cuenta cuenta = new Cuenta();
        cuenta.setUsername("testUser");

        Assertions.assertEquals("testUser", cuenta.getUsername());
    }

    @Test
    @DisplayName("When Create a Cuenta with Valid Email Then Returns Repective Cuenta")
    public void whenCreateCuentaWithValidEmailGetACuenta(){
        Cuenta cuenta = new Cuenta();
        cuenta.setEmail("test@gmail.com");

        Assertions.assertEquals("test@gmail.com", cuenta.getEmail());
    }

    @Test
    @DisplayName("When Create a Cuenta with Valid Tipo Then Returns Repective Cuenta")
    public void whenCreateCuentaWithValidTipoGetACuenta(){
        Cuenta cuenta = new Cuenta();

        cuenta.setTipoCuenta("cliente");

        Assertions.assertEquals("cliente", cuenta.getTipoCuenta());
    }

    @Test
    @DisplayName("When Create a Cuenta with Valid Password Then Returns Repective Cuenta")
    public void whenCreateCuentaWithValidPasswordGetACuenta(){
        Cuenta cuenta = new Cuenta();
        cuenta.setPassword("12345");

        Assertions.assertEquals("12345", cuenta.getPassword());
    }
}
