package Practica;

import java.util.HashMap;
import java.util.Map;


public class Ejercicio4 {
	
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
		
		public static record tupla(Integer s,Integer a, Integer b) {

			
		}
		
		

}
