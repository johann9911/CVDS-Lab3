package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void DeberiaTenerUnNombreValido() {
        Person person = new Person("pepito Perez",1000032927,20,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
        Person person2 = new Person("Esteban Gomez",100003227,20,Gender.MALE,true);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.VALID, result2);
    }
    
    @Test
    public void DeberiaValidarUnNombreInValido() {
    	Person person = new Person("pepito Perez30",1000032927,20,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID, result);
        Person person2 = new Person("102930",100002927,20,Gender.MALE,true);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.INVALID, result2);
    }
    
    @Test
    public void DeberiaValidarMenorEdad() {

        Person person = new Person("pepito Perez",1000032927,17,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
        Person person2 = new Person("102930",100002927,16,Gender.MALE,true);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.INVALID, result2);
    }
    
    @Test
    public void DeberiaValidarMayoriaEdad() {
    	Person person = new Person("pepito Perez",1000032927,18,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
        Person person2 = new Person("Juan Lopezs",100002927,19,Gender.MALE,true);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.VALID, result2);
    }
    
    @Test
    public void DeberiaValidarNumerosUnicos() {
        Person person = new Person("pepito Perez",1000032927,20,Gender.MALE,true);
        Person person2 = new Person("Andrea Perez",1000032927,24,Gender.FEMALE,true);
        RegisterResult result = registry.registerVoter(person);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.VALID, result);
        Assert.assertEquals(RegisterResult.DUPLICATED, result2);
    }
    
    @Test
    public void DeberiaInvalidarUnaEdadErronea() {
    	Person person = new Person("pepito Perez",1000032927,-12,Gender.MALE,true);
    	RegisterResult result = registry.registerVoter(person);
    	Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    
    @Test
    public void DeberiaValidarPersonaViva() {
    	Person person = new Person("Juan Perez",1000032927,25,Gender.MALE,false);
    	Person person2 = new Person("Juanita Perez",1000032977,25,Gender.MALE,true);
    	RegisterResult result = registry.registerVoter(person);
    	RegisterResult result2 = registry.registerVoter(person2);
    	Assert.assertEquals(RegisterResult.DEAD, result);
    	Assert.assertEquals(RegisterResult.VALID, result2);
    }
    
    @Test
    public void DeberiaValidarNumeroDigitosTD() {
    	Person person;
    	RegisterResult result;
    	//Identificacion de 7 digitos
    	person = new Person("Juanita Perez",1000032,25,Gender.MALE,true);
    	result = registry.registerVoter(person);
    	Assert.assertEquals(RegisterResult.INVALID, result);
    	//Identificacion de 8 digitos
    	person = new Person("Juanita Perez",10000320,25,Gender.MALE,true);
    	result = registry.registerVoter(person);
    	Assert.assertEquals(RegisterResult.VALID, result);
    	//Identificacion de 11 digitos
    	person = new Person("Juanita Perez",1000032758,25,Gender.MALE,true);
    	result = registry.registerVoter(person);
    	Assert.assertEquals(RegisterResult.VALID, result);
    	//Identificacion de 12 digitos
    	person = new Person("Juanita Perez",100007888,25,Gender.MALE,true);
    	result = registry.registerVoter(person);
    	Assert.assertEquals(RegisterResult.VALID, result);
    }
    
    
    
    
    public void validateRegistryResult() {

        Person person = new Person();

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }

    // TODO Complete with more test cases

}