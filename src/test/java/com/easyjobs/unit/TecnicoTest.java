package com.easyjobs.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TecnicoTest {

    @Test
    @DisplayName("When Create a Tecnico with Valid Id Then Returns Repective Tecnico")
    public void whenCreateTecnicoWithValidIdGetATecnico(){
        Tecnico tecnico = new Tecnico();
        tecnico.setId(1L);

        Assertions.assertEquals(1L, tecnico.getId());
    }

    @Test
    @DisplayName("When Create a Tecnico with Valid Dni Then Returns Repective Tecnico")
    public void whenCreateTecnicoWithValidDniGetATecnico(){
        Tecnico tecnico = new Tecnico();
        tecnico.setDni(70707070L);

        Assertions.assertEquals(70707070L, tecnico.getDni());
    }

    @Test
    @DisplayName("When Create a Tecnico with Valid Nombre Then Returns Repective Tecnico")
    public void whenCreateTecnicoWithValidNombreGetATecnico(){
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre("Testito");

        Assertions.assertEquals("Testito", tecnico.getNombre());
    }

    @Test
    @DisplayName("When Create a Tecnico with Valid Apellido Then Returns Repective Tecnico")
    public void whenCreateTecnicoWithValidApellidoGetATecnico(){
        Tecnico tecnico = new Tecnico();
        tecnico.setApellido("Testón");

        Assertions.assertEquals("Testón", tecnico.getApellido());
    }

    @Test
    @DisplayName("When Create a Tecnico with Valid Ciudad Then Returns Repective Tecnico")
    public void whenCreateTecnicoWithValidCiudadGetATecnico(){
        Tecnico tecnico = new Tecnico();
        tecnico.setCiudad("Lima");

        Assertions.assertEquals("Lima", tecnico.getCiudad());
    }

    @Test
    @DisplayName("When Create a Tecnico with Valid CV Then Returns Repective Tecnico")
    public void whenCreateTecnicoWithValidCVGetATecnico(){
        Tecnico tecnico = new Tecnico();
        tecnico.setCV("Imagine this is a curriculum vitae");

        Assertions.assertEquals("Imagine this is a curriculum vitae", tecnico.getCV());
    }

    @Test
    @DisplayName("When Create a Tecnico with Valid Telefono Then Returns Repective Tecnico")
    public void whenCreateTecnicoWithValidTelefonoGetATecnico(){
        Tecnico tecnico = new Tecnico();
        tecnico.setTelefono("980808080");

        Assertions.assertEquals("980808080", tecnico.getTelefono());
    }

    @Test
    @DisplayName("When Create a Tecnico with Valid Cuenta Then Returns Repective Tecnico")
    public void whenCreateTecnicoWithValidCuentaGetATecnico(){
        Tecnico tecnico = new Tecnico();
        Cuenta cuenta = new Cuenta();
        tecnico.setCuenta(cuenta);

        Assertions.assertEquals(cuenta, tecnico.getCuenta());
    }
}
