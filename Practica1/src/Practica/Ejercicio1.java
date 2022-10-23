package Practica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio1 {
	
public static record EnteroCadena(Integer a, String s) {	
	
	}

     // EJERCICIO 1 SOLUCIÓN ITERATIVA

    /**
     * @param Integer varA, String varB, Integer varC, String varD, Integer varE.
     * @return Map cuyas claves son Integers que se corresponden a la longitud de la cadena conformada 
     *         por varB + varD. Los valores son dicha cadena.
     */
	public static Map<Integer, List<String>> solucionIterativa(Integer varA, String varB,
			Integer varC, String varD, Integer varE){
		
		Map<Integer, List<String>> res = new HashMap<Integer, List<String>>(); 
		
		EnteroCadena elem = new EnteroCadena(varA,varB);
		
		
		while(elem.a<varC) { 
			
			String nom = elem.s()+varD;
			
			if (nom.length()<varE) {
				Integer clave = nom.length();
				if (!res.containsKey(clave)) {
					List<String> l = new ArrayList<>();
					l.add(nom);
					res.put(clave, l);
				}else {
					res.get(clave).add(nom);
			}
			
		}
			
			Integer a = elem.a;
			String s = elem.s;
			if (a%3==0) {
				s = s+a.toString();
			}else {
				s = s.substring(a%s.length());
			}
			a +=2;
			
			elem = new EnteroCadena(a,s);
		
		
		}
		
		
			return res;
	}
	
	
	// EJERCICIO 1 SOLUCIÓN RECURSIVA FINAL
	
	/**
     * @param Integer varA, String varB, Integer varC, String varD, Integer varE.
     * @return Llamada a la función auxiliar que realiza el algoritmo recursivo. Esta, 
     *         a su vez, devuelve el Map<Integer, List<String>>.
     */
	public static Map<Integer, List<String>> solucionARecursivaFinal (Integer varA, String varB,
			Integer varC, String varD, Integer varE){
		
		return ejercicioARecursivaFinal(varA, varB, varC, varD, varE, new HashMap<Integer, List<String>>());
	}
	
	
	/**
     * @param Integer varA, String varB, Integer varC, String varD, Integer varE,
     * List<String>> ac (nuestro acumulador).
     * @return Map<Integer, List<String>> 
     *         
     */
	public static Map<Integer, List<String>> ejercicioARecursivaFinal(Integer varA, String varB,
			Integer varC, String varD, Integer varE, Map<Integer, List<String>> ac){
		
		EnteroCadena elem = new EnteroCadena(varA,varB);
		if (elem.a<varC) {
			String nom = elem.s()+varD;
			
			if (nom.length()<varE) {
				Integer clave = nom.length();
				if (!ac.containsKey(clave)) {
					List<String> l = new ArrayList<>();
					l.add(nom);
					ac.put(clave, l);
				}else {
					ac.get(clave).add(nom);
			}
			
		}
			
			Integer a = elem.a;
			String s = elem.s;
			if (a%3==0) {
				s = s+a.toString();
			}else {
				s = s.substring(a%s.length());
			}
			a +=2;
			elem = new EnteroCadena(a,s);
			
			ejercicioARecursivaFinal(elem.a, elem.s, varC, varD, varE, ac);
			
		}
		
		return ac;
		
		
	}
		
	}

