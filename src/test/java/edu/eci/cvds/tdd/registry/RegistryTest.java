package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void DeberiaTenerUnNombreValido() {

        Person person = new Person("pepito Perez2",1000032927,20,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID, result);
    }
    
    @Test
    public void DeberiaValidarMenorEdad() {

        Person person = new Person("pepito Perez",1000032927,2,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
    
    @Test
    public void DeberiaInvalidarUnaEdadErronea() {
    	Person person = new Person("pepito Perez",1000032927,-12,Gender.MALE,true);
    	RegisterResult result = registry.registerVoter(person);
    	Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    
    
    public void validateRegistryResult() {

        Person person = new Person();

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }

    // TODO Complete with more test cases

}