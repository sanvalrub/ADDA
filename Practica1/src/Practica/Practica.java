package Practica;
/*
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import Practica.Ejemplo2.Tupla;
import TestPractica.Integer;
import TestPractica.String;
import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;
import us.lsi.streams.Stream2;

public class Practica {
	
	// ENTREGABLE
	
	// 2
	// Iterativa, Recursiva Final, Recursiva no Final, funcional
	
	
	
	

	
	
	// Ejercicio 3
	// Recursiva sin memoria
	public static String Recursiva(Integer a, Integer b, Integer c) {
		String ac = "";
		if (a<2 & b<=2 || c <2) {
			ac = a.toString()+"+"+b.toString()+"+"+c.toString();
		}else if (a<3 || b<3 & c<=3) {
			ac = c.toString()+"-"+b.toString()+"-"+a.toString();
		}else if (b%a==0 & (a%2==0 || b%3==0)) {
			ac = "("+Recursiva(a-1, b/a, c-1)+"*"+Recursiva(a-2,b/2,c/2)+")";
		}else {
			ac = "("+Recursiva(a/2, b-2, c/2)+"*"+Recursiva(a/3,b-1,c/3)+")";
		}
		
		return ac;
	}
public static record tupla(Integer s,Integer a, Integer b) {

		
}
	
		// Recursiva con memoria
	public static String RecursivaConMemoria(Integer a, Integer b, Integer c) {
		return RecursivaConMemoriaAux(a, b, c, new HashMap<tupla, String>());
	}
	
	public static String RecursivaConMemoriaAux(Integer a, Integer b, Integer c, Map<tupla, String> m) {
		String ac = "";
		if (m.containsKey(new tupla(a, b, c))) {
			tupla t = new tupla(a, b, c);
			m.put(t,ac);
		}else if(a<2 & b<=2 || c <2) {
			ac = a.toString()+"+"+b.toString()+"+"+c.toString();
			tupla t = new tupla(a, b, c);
			m.put(t,ac);
		}else if (a<3 || b<3 & c<=3) {
			ac = c.toString()+"-"+b.toString()+"-"+a.toString();
			tupla t = new tupla(a, b, c);
			m.put(t,ac);
		}else if (b%a==0 & (a%2==0 || b%3==0)) {
			ac = "("+Recursiva(a-1, b/a, c-1)+"*"+Recursiva(a-2,b/2,c/2)+")";
			tupla t = new tupla(a, b, c);
			m.put(t,ac);
		}else {
			ac = "("+Recursiva(a/2, b-2, c/2)+"*"+Recursiva(a/3,b-1,c/3)+")";
			tupla t = new tupla(a, b, c);
			m.put(t,ac);
		}
		
		return ac;
	}
	
	
	}
	
	// EJERCICIO 1
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
	
	
	// EJERCICIO 3
	/*
	
	public static List<Punto2D> leerPunto(String fichero1, String fichero2){
		List<Punto2D> ac = new ArrayList<Punto2D>();
		
		FileReader fr = null;
		BufferedReader bf = null;
		
		try {
			FileReader fr1 = new FileReader(fichero1);
			BufferedReader bf1 = new BufferedReader(fr1);
			
			FileReader fr2 = new FileReader(fichero2);
			BufferedReader bf2 = new BufferedReader(fr2);
			
			String linea1;
			String linea2;
			
			
			while((linea1 =bf1.readLine()) !=null && (linea2 =bf2.readLine()) !=null ) {
				Punto2D p1 = leerPunto(linea1);
				Punto2D p2 = leerPunto(linea2);
				
					
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=fr) {
					fr.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ac;
	}
	/*
	public static List<Punto2D> ejercicio3(Punto2D p1, Punto2D p2){
		Predicate<Punto2D> isInCuadrante = x -> x.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || x.getCuadrante() == Cuadrante.TERCER_CUADRANTE;
		List<Punto2D> l = new ArrayList<Punto2D>();
		Punto2D candidato1;
		Punto2D candidato2;
		if ()
				
				
		}
		*/
/*		
	}
	


}

*/
