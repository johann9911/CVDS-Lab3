package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {
	private ArrayList<Integer> identificaciones = new ArrayList<Integer>();
    public RegisterResult registerVoter(Person p) {
    	RegisterResult registro = RegisterResult.VALID;
    	
        if(p.getAge()<18) {
        	if(p.getAge()>0) {
        		registro = RegisterResult.UNDERAGE;
        	}else {
        		registro = RegisterResult.INVALID_AGE;
        	}
        }
        //if(!(p.getGender().equals(Gender.FEMALE) || p.getGender().equals(Gender.MALE)|| p.getGender().equals(Gender.UNIDENTIFIED))); registro = RegisterResult.INVALID;
        if(!esSoloLetras(p.getName()))registro = RegisterResult.INVALID;
        if(!p.isAlive())registro = RegisterResult.DEAD;
        if(identificaciones.contains(p.getId())) registro= RegisterResult.DUPLICATED;
        identificaciones.add(p.getId());
        return registro;
    }
    
    static boolean esSoloLetras(String cadena)
	{
    	boolean resul = true;
		for (int i = 0; i < cadena.length(); i++)
		{
			char caracter = cadena.toUpperCase().charAt(i);
			int valorASCII = (int)caracter;
			if (valorASCII != 32 && valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
				resul = false;
		}
		return resul;
	}
}