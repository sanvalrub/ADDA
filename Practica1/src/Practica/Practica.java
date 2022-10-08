package Practica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;
import us.lsi.streams.Stream2;

public class Practica {
	// EJERCICIOS NO ENTREGABLES
	// 1
	public static Map<Punto2D.Cuadrante,Double> ejemplo1(List<Punto2D> l){
		return l.stream()
		.collect(Collectors.groupingBy(Punto2D::getCuadrante,
		Collectors.<Punto2D,Double>reducing(0.,x->x.x(),(x,y)->x+y)));
		}
	
	public static Map<Punto2D.Cuadrante,Double> solucionIterativa(List<Punto2D> l){
		// Secuencia = lista de puntos
		// estado inicial = 0
		// estado final = tamaño de la lista (l.size())
		
		// Acumulador = Map<Punto2D.Cuadrante,Double>
		// Estado incial del acumulador: map vacío
		
		Integer e = 0; // inicializamos iterador 
		Map<Punto2D.Cuadrante,Double> ac = new HashMap<>(); // map vacío
		while(e<l.size()) {
			Punto2D p = l.get(e);
			Cuadrante clave = p.getCuadrante();
			if (ac.containsKey(clave)) {
				Double valorAnterior = ac.get(clave);
				ac.put(clave, valorAnterior+p.x());
				
			}else {
				ac.put(clave, p.x());
			}
			e++;
		}
		return ac;
	}
	
	public static Map<Punto2D.Cuadrante,Double> solucionRecursivaFinal(List<Punto2D> l){
		// Hay que hacer dos métodos: 1 principal y 1 auxiliar
		
		// Primera llamada al método recursivo con estados inciales de secuencia y acumulador
		return recFinalAux(l, 0, new HashMap<>());
	}
	
	public static Map<Punto2D.Cuadrante,Double> recFinalAux(List<Punto2D> l, Integer e, Map<Punto2D.Cuadrante,Double> ac ){
		if (e<l.size()) {
			Punto2D p = l.get(e);
			Cuadrante clave = p.getCuadrante();
			if (ac.containsKey(clave)) {
				ac.put(clave, ac.get(clave)+p.x());
			}else {
				ac.put(clave, p.x());
			}
			ac = recFinalAux(l, e+1, ac);
		}
		
		return ac;
	}
	
	
	
	// ENTREGABLE
	
	// 2
	// Iterativa, Recursiva Final, Recursiva no Final, funcional
	// RECURSIVA NO FINAL
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
		// Secuencia = 
		// Acumulador = Integer ac
		// Estado Inicial = 0;
		while(a>0 & b>0) {
			if(s.length()==0) {
				ac = a*a+b*b;
		}else if(a<2 || b < 2){  
			ac =s.length() + a + b;
		}else if(a%s.length()<b%s.length()){
			
		}
	}
		
	
	// Ejercicio 3
	public static List<Punto2D> Ejercicio3(String fichero1, String fichero2){
		List<Punto2D> ls = Stream2.file(file).map(s-> parsePunto(s)).collect(Collectors.toList())

		
		
	}
	
	
	
}
}
