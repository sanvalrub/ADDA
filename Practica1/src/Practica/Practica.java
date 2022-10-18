package Practica;

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
	// RECURSIVA NO FINAL
	
	
	public static record Tupla(String s,Integer a, Integer b) {
		
		public static Tupla of(String s, Integer a, Integer b) {
			return new Tupla(s,a,b);
		}
		
		public static Tupla first() {
			
		}
		
	
	
	public static Integer SolucionRecursivaNoFinal(Integer a, Integer b, String s) {
		Integer res= null;
		if(a>0 & b>0) {
			if(s.length()==0) {
				res = a*a+b*b;
			}else if(a<2 || b < 2){
				res =s.length() + a + b;
			}else if(a%s.length()<b%s.length()){
				res = a + b + SolucionRecursivaNoFinal(a-1, b/2, s.substring(a%s.length(),b%s.length()));	
			}else {
				res = a*b + SolucionRecursivaNoFinal(a/2, b-1, s.substring(b%s.length(),a%s.length()));
			}
		}	
		return res;
	}

	
	
	
	
	// RECURSIVA FINAL
	public static Integer SolucionRecursivaFinal(Integer a, Integer b, String s) {
		return RecursivaFinal(a, b, s, 0);
	}
	
	public static Integer RecursivaFinal(Integer a, Integer b, String s, Integer ac) {
		if(a>0 & b>0) {
			if(s.length()==0) {
				ac = a*a+b*b;
			}else if(a<2 || b < 2){
				ac =s.length() + a + b;
			}else if(a%s.length()<b%s.length()){
				ac = RecursivaFinal(a-1, b/2, s.substring(a%s.length(),b%s.length()), a + b);
			}else {
				ac = RecursivaFinal(a/2, b-1, s.substring(b%s.length(),a%s.length()), a*b);
			}
		}
		return ac;
	}
	
	public static Integer Iterativa(Integer a, Integer b, String s, Integer ac) {
		while (s.length()!=0 || a<2 || b < 2 ) {
			if(a%s.length()<b%s.length()) {
				ac = a + b;
				a -=1;
				b /=2;
				s = s.substring(a%s.length(), b&s.length());
			}else {
				ac = a * b;
				a /=2;
				a -=1;
				s = s.substring(b%s.length(), b%s.length());
			}
		}
		if (s.length()==0) {
			ac = a*a+b*b;
		}else {
			ac = s.length()+a +b;
		}
		
		return ac;
	}
	
	public static Integer Funcional(Integer a, Integer b, String s) {
		
	}
		
	
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
		
		public static tupla of(Integer s, Integer a, Integer b) {
			return new tupla(s,a,b);
		}
		
		public static Tupla first() {
			
		}
	
		// Recursiva con memoria
	public static String RecursivaConMemoria(Integer a, Integer b, Integer c) {
		return RecursivaConMemoriaAux(a, b, c, new HashMap<Tupla, String>());
	}
	
	public static String RecursivaConMemoriaAux(Integer a, Integer b, Integer c, Map<Tupla, String> m) {
		String ac = "";
		if (m.containsKey(tupla.of(a, b, c))) {
			ac = m.get(tupla.of(a, b, c));
		}else if(a<2 & b<=2 || c <2) {
			ac = a.toString()+"+"+b.toString()+"+"+c.toString();
			m.put(tupla.of(a, b, c),ac);
		}else if (a<3 || b<3 & c<=3) {
			ac = c.toString()+"-"+b.toString()+"-"+a.toString();
			m.put(tupla.of(a, b, c),ac);
		}else if (b%a==0 & (a%2==0 || b%3==0)) {
			ac = "("+Recursiva(a-1, b/a, c-1)+"*"+Recursiva(a-2,b/2,c/2)+")";
			m.put(tupla.of(a, b, c),ac);
		}else {
			ac = "("+Recursiva(a/2, b-2, c/2)+"*"+Recursiva(a/3,b-1,c/3)+")";
			m.put(tupla.of(a, b, c),ac);
		}
		
		return ac;
	}
	
	// Iterativo
	public static String Iterativo(Integer a, Integer b, Integer c) {
	
	}
	
	// EJERCICIO 1
	public static record EnteroCadena(Integer a, String s) {
		
		public static EnteroCadena of(Integer a, String s) {
			a = a+2;
			if (a%3==0) {
				s = s+a.toString();
			}else {
				s = s.substring(a%s.length());
			}
			return new EnteroCadena(a,s);
		}	
		
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
		while(varA<varC) { // mientras se cumpla la condición varA<varC
			EnteroCadena elem = EnteroCadena.nx(varA, varB); // se invoca a EnteroCadena
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
		}
		
		return ac;
		
	}
	
	public static Map<Integer, List<String>> ejercicioARecFinalSolucion (Integer varA, String varB,
			Integer varC, String varD, Integer varE){
		// secuencia = varB y varD
		// estado inicial = 
		// estado final =
		
		// acumulador = Map<Integer, List<String>>
		
		return ejercicioARecFinal (varA,varB,varC,varD,varE, new HashMap<Integer, List<String>>());
		
	}
	
	public static Map<Integer, List<String>> ejercicioARecFinal (Integer varA, String varB,
			Integer varC, String varD, Integer varE, Map<Integer, List<String>> ac ){
		if(varA<varC) {
			EnteroCadena elem = EnteroCadena.nx(varA, varB); // se invoca a EnteroCadena
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
		}
		
	}
	
	
	
	// EJERCICIO 3
	
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
				Punto2D p1 = parsePunto(linea1);
				Punto2D p2= parsePunto(linea2);
				Predicate<Punto2D> p = x->x.getCuadrante()==Cuadrante.TERCER_CUADRANTE || x.getCuadrante()==Cuadrante.PRIMER_CUADRANTE;
				if (p) {
					
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
	
	public static List<Punto2D> resultado3(String fichero1, String fichero2){
		List<Punto2D> l1 = leerPunto(fichero1);
		List<Punto2D> l2 = leerPunto(fichero2);
		for 
	}
	


}
}}