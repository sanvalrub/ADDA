package Practica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio1 {
	
public static record EnteroCadena(Integer a, String s) {	
		
		public static EnteroCadena nx(Integer a, String s) {
			a = a+2;
			if (a%3==0) {
				s = s+a.toString();
			}else {
				s = s.substring(a%s.length());
			}
			return new EnteroCadena(a,s);
		}	
	}

	public static Map<Integer, List<String>> ejercicioA (Integer varA, String varB,
			Integer varC, String varD, Integer varE){
		
		Map<Integer, List<String>> ac = new HashMap<Integer, List<String>>(); // inicializamos map
		EnteroCadena elem = new EnteroCadena(varA,varB);
		while(varA<varC) { // mientras se cumpla la condición varA<varC
			String nom = elem.s()+varD;
			if (nom.length()<varE) {
				Integer clave = nom.length();
				if (!ac.containsKey(clave)) {
					List<String> l = new ArrayList<>();
					l.add(nom);
					ac.put(clave, l);
				}else {
					List<String> aux = ac.get(clave);
					aux.add(nom);
					ac.put(clave, aux);
				}
				
			}
			
			 EnteroCadena.nx(varA, varB); 
		}
		
		return ac;
		
	}
}
