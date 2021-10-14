package com.easyjobs.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    @Test
    @DisplayName("When Create a Cliente with Valid Id Then Returns Repective Cliente")
    public void whenCreateClienteWithValidIdGetACliente(){
        Cliente cliente = new Cliente();
        cliente.setId(1L);

        Assertions.assertEquals(1L, cliente.getId());
    }

    @Test
    @DisplayName("When Create a Cliente with Valid Nombre Then Returns Repective Cliente")
    public void whenCreateClienteWithValidNombreGetACliente(){
        Cliente cliente = new Cliente();
        cliente.setNombre("Testito");

        Assertions.assertEquals("Testito", cliente.getNombre());
    }

    @Test
    @DisplayName("When Create a Cliente with Valid Apellido Then Returns Repective Cliente")
    public void whenCreateClienteWithValidApellidoGetACliente(){
        Cliente cliente = new Cliente();
        cliente.setApellido("Testón");

        Assertions.assertEquals("Testón", cliente.getApellido());
    }

    @Test
    @DisplayName("When Create a Cliente with Valid Distrito Then Returns Repective Cliente")
    public void whenCreateClienteWithValidCiudadGetACliente(){
        Cliente cliente = new Cliente();
        cliente.setDistrito("Monterrico");

        Assertions.assertEquals("Monterrico", cliente.getDistrito());
    }

    @Test
    @DisplayName("When Create a Cliente with Valid Telefono Then Returns Repective Cliente")
    public void whenCreateClienteWithValidTelefonoGetACliente(){
        Cliente cliente = new Cliente();
        cliente.setTelefono("980808080");

        Assertions.assertEquals("980808080", cliente.getTelefono());
    }

    @Test
    @DisplayName("When Create a Cliente with Valid Metodo de Pago Then Returns Repective Cliente")
    public void whenCreateClienteWithValidMetodoPagoGetACliente(){
        Cliente cliente = new Cliente();
        cliente.setMetodoPago("Tarjeta de Debito");

        Assertions.assertEquals("Tarjeta de Debito", cliente.getMetodoPago());
    }

    @Test
    @DisplayName("When Create a Cliente with Valid Cuenta Then Returns Repective Cliente")
    public void whenCreateClienteWithValidCuentaGetACliente(){
        Cliente cliente = new Cliente();
        Cuenta cuenta = new Cuenta();
        cliente.setCuenta(cuenta);

        Assertions.assertEquals(cuenta, cliente.getCuenta());
    }
}
