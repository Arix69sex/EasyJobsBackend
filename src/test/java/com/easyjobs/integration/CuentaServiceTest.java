package com.easyjobs.integration;

import com.easyjobs.exception.ResourceNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CuentaServiceTest {

    @MockBean
    private CuentaRepository cuentaRepository;

    @Autowired
    private CuentaService cuentaService;

    @Test
    @DisplayName("When GetCuentaById with Valid Id Then Returns Repective Cuenta")
    public void whenGetCuentaByIdThenGetCuenta(){
        Cuenta cuenta = new Cuenta();
        cuenta.setId(1L);

        when(cuentaRepository.findById(1L)).thenReturn(Optional.of(cuenta));
    }

    @Test
    @DisplayName("When GetCuentaById with Invalid Id Then Returns Not Found Exception")
    public void whenGetCuentaByIdWithInvalidIdThenGetException(){
        //Arrange
        String template = "Resource %s not found for %s with value %s";
        when(cuentaRepository.findById(1L))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Cuenta", "Id", 1L);

        //Act
        Throwable exception = catchThrowable(()->{
            Cuenta foundCuenta = cuentaService.getCuentaById(1L);
        });

        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("When GetCuentaByEmail with Valid Email Then Returns Repective Cuenta")
    public void whenGetCuentaByEmailThenGetCuenta(){
        Cuenta cuenta = new Cuenta();
        cuenta.setEmail("test@gmail.com");

        when(cuentaRepository.findByEmail("test@gmail.com")).thenReturn(Optional.of(cuenta));
    }

    @Test
    @DisplayName("When GetCuentaByEmail with Invalid Email Then Returns Not Found Exception")
    public void whenGetCuentaByEmailWithInvalidEmailThenGetException(){
        //Arrange
        String template = "Resource %s not found for %s with value %s";
        when(cuentaRepository.findByEmail("test@gmail.com"))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Cuenta", "Email", "test@gmail.com");

        //Act
        Throwable exception = catchThrowable(()->{
            Cuenta foundCuenta = cuentaService.getCuentaByEmail("test@gmail.com");
        });

        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("When GetCuentaByUsername with Valid Username Then Returns Repective Cuenta")
    public void whenGetCuentaByUsernameThenGetCuenta(){
        Cuenta cuenta = new Cuenta();
        cuenta.setUsername("testUser");

        when(cuentaRepository.findByUsername("testUser")).thenReturn(Optional.of(cuenta));
    }

    @Test
    @DisplayName("When GetCuentaByUsername with Invalid Username Then Returns Not Found Exception")
    public void whenGetCuentaByUsernameWithInvalidUsernameThenGetException(){
        //Arrange
        String template = "Resource %s not found for %s with value %s";
        when(cuentaRepository.findByUsername("testUser"))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Cuenta", "Username", "testUser");

        //Act
        Throwable exception = catchThrowable(()->{
            Cuenta foundCuenta = cuentaService.getCuentaByUsername("testUser");
        });

        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
