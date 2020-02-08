package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.Assert;
import org.junit.Test;
import edu.eci.cvds.tdd.aerodescuentos.*;

public class TarifasTest {
    private CalculadorDescuentos descuentos = new CalculadorDescuentos();
    
    @Test
    public void deberiaMostrarTarifa() {
        Assert.assertEquals(8500.0, descuentos.calculoTarifa(10000,22,40),0.5);
		Assert.assertEquals(77000.0, descuentos.calculoTarifa(100000 ,22,80),0.5);
		Assert.assertEquals(80000.0, descuentos.calculoTarifa(100000 ,22,5),0.5);
    }
    
    @Test
    public void deberiaValidarDias() {
        Assert.assertEquals(100000.0, descuentos.calculoTarifa(100000 ,0,22),0.5);
		Assert.assertEquals(100000.0, descuentos.calculoTarifa(100000 ,15,22),0.5);
		Assert.assertEquals(100000.0, descuentos.calculoTarifa(100000 ,20,22),0.5);
		Assert.assertEquals(85000.0, descuentos.calculoTarifa(100000 ,21,22),0.5);
		Assert.assertEquals(85000.0, descuentos.calculoTarifa(100000 ,30,22),0.5);
    }
    
    @Test
    public void deberiaValidarEdad() {
        Assert.assertEquals(95000.0, descuentos.calculoTarifa(100000 ,10,5),0.5);
        Assert.assertEquals(95000.0, descuentos.calculoTarifa(100000 ,10,17),0.5);
        Assert.assertEquals(100000.0, descuentos.calculoTarifa(100000 ,10,18),0.5);
        Assert.assertEquals(100000.0, descuentos.calculoTarifa(100000 ,10,30),0.5);
        Assert.assertEquals(100000.0, descuentos.calculoTarifa(100000 ,10,65),0.5);
        Assert.assertEquals(92000.0, descuentos.calculoTarifa(100000 ,10,66),0.5);
    }

}