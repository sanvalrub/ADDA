package Practica;

import java.util.stream.Stream;

public class Ejercicio2 {
	
	// EJERCICIO 2 SOLUCIÓN RECURSIVA NO FINAL
	
	/**
     * @param Integer a, Integer b, String s.
     * @return Integer que según ciertas condiciones realizará una operación u otra.
     *         
     */
	public static Integer SolucionRecursivaNoFinal(Integer a, Integer b, String s) {
		Integer res= null;
			if(s.length()==0) {
				res = a*a+b*b;
			}else if(a<2 || b < 2){
				res =s.length() + a + b;
			}else if(a%s.length()<b%s.length()){
				res = a + b + SolucionRecursivaNoFinal(a-1, b/2, s.substring(a%s.length(),b%s.length()));	
			}else {
				res = a*b + SolucionRecursivaNoFinal(a/2, b-1, s.substring(b%s.length(),a%s.length()));
			}	
		return res;
	}
	
	
	
	
	// EJERCICIO 2 SOLUCIÓN RECURSIVA FINAL
	
	/**
     * @param Integer a, Integer b, String s.
     * @return Llamada a la función auxiliar RecursivaFinal que retornará el Integer.
     *         
     */
	public static Integer SolucionRecursivaFinal(Integer a, Integer b, String s) {
		return RecursivaFinal(a, b, s, 0);
	}
	
	/**
     * @param Integer a, Integer b, String s, Integer ac que será nuestro acumulador.
     * @return Integer que según ciertas condiciones realizará una operación u otra.
     *         
     */
	public static Integer RecursivaFinal(Integer a, Integer b, String s, Integer ac) {
			if(s.length()==0) {
				ac = ac + a*a+b*b;
			}else if(a<2 || b < 2){
				ac =ac + s.length() + a + b;
			}else if(a%s.length()<b%s.length()){
				ac = RecursivaFinal(a-1, b/2, s.substring(a%s.length(),b%s.length()), a + b + ac);
			}else {
				ac = RecursivaFinal(a/2, b-1, s.substring(b%s.length(),a%s.length()), a*b + ac);
			}
		return ac;
	}
	
	
	
	// EJERCICIO 2 SOLUCIÓN ITERATIVA
	
	/**
     * @param Integer a, Integer b, String s.
     * @return Integer que según ciertas condiciones realizará una operación u otra.
     *         
     */
	public static Integer Iterativa(Integer a, Integer b, String s) {
		
		Integer ac = 0; // inicializamos el acumulador
		
		while ((s.length()!=0) && (a>=2 || b >= 2 )) {
			if(a%s.length()<b%s.length()) {
				ac =ac + a + b;
				s = s.substring(a%s.length(),b%s.length());
				a = a-1;
				b = b/2;
			}else {
				ac = a * b + ac;
				s = s.substring(b%s.length(),a%s.length());
				a=a/2;
				b = b-1;
			}
		}
		
		if (s.length()==0) {
			ac = ac + a*a+b*b;
		}else {
			ac = ac + s.length()+a +b;
		}
		
		return ac;
	}
	
	// EJERCICIO 2 FUNCIONAL 
	
	public static record Tupla(Integer a, Integer b, String s, Integer ac) { // tipo Tupla necesario para realizar el algoritmo funcional
		public static Tupla of(Integer a, Integer b, String s, Integer ac) {
			return new Tupla(a,b,s,ac);
		}
	}
	
	/**
     * @param elemento de tipo Tupla.
     * @return Tupla compuesta por los parámetros de entrada a,b y s, además del acumulador.
     *         
     */
	public static Tupla nx(Tupla t) {
		Integer a = t.a;
		Integer b = t.b;
		String s = t.s;
		Integer ac = t.ac;
		if(a%s.length()<b%s.length()) {
			ac =ac + a + b;
			s = s.substring(a%s.length(),b%s.length());
			a = a-1;
			b = b/2;
		}else {
			ac = a * b + ac;
			s = s.substring(b%s.length(),a%s.length());
			a=a/2;
			b = b-1;
		}
		
		return new Tupla(a,b,s,ac);
		
	}
	
	/**
     * @param Integer a, Integer b, String s.
     * @return Integer que según ciertas condiciones realizará una operación u otra.       
     */
	public static Integer resFunc(Integer a, Integer b, String s) {
		Tupla t = Stream.iterate(Tupla.of(a, b, s, 0), x->nx(x))
				.dropWhile(x->x.s.length()!=0 && (x.a>=2 || x.b>=2)).findFirst().get();
		return t.s().length()==0?t.ac+t.a*t.a+t.b*t.b:t.ac+t.b+t.s.length();
	}

 
	
		

}

