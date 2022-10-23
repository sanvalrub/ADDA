package Practica;

import java.util.HashMap;
import java.util.Map;


public class Ejercicio4 {
	
	// Recursiva sin memoria
		public static String Recursiva(Integer a, Integer b, Integer c) {
			String ac = "";
			if (a<2 & b<=2 || c <2) {
				ac = "("+ a.toString() + "+" + b.toString() + "+" +c.toString() + ")";
			}else if (a<3 || b<3 & c<=3) {
				ac = "(" + c.toString() + "-" + b.toString() + "-" + a.toString()+")";
			}else if (b%a==0 & (a%2==0 || b%3==0)) {
				ac = "(" + Recursiva(a-1, b/a, c-1) + "*" + Recursiva(a-2,b/2,c/2) + ")";
			}else {
				ac = "(" + Recursiva(a/2, b-2, c/2) + "/" + Recursiva(a/3,b-1,c/3) + ")";
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
				ac = "("+ a.toString() + "+" + b.toString() + "+" +c.toString() + ")";
				tupla t = new tupla(a, b, c);
				m.put(t,ac);
			}else if (a<3 || b<3 & c<=3) {
				ac = "(" + c.toString() + "-" + b.toString() + "-" + a.toString()+")";
				tupla t = new tupla(a, b, c);
				m.put(t,ac);
			}else if (b%a==0 & (a%2==0 || b%3==0)) {
				ac = "(" + Recursiva(a-1, b/a, c-1) + "*" + Recursiva(a-2,b/2,c/2) + ")";
				tupla t = new tupla(a, b, c);
				m.put(t,ac);
			}else {
				ac = "(" + Recursiva(a/2, b-2, c/2) + "/" + Recursiva(a/3,b-1,c/3) + ")";
				tupla t = new tupla(a, b, c);
				m.put(t,ac);
			}
			
			return ac;
		}
		
		
		public static String SolucionIterativa(Integer a, Integer b, Integer c) {
			Map<tupla, String> aux = new HashMap<tupla, String>();
			String ac;
			for(int i = 0; i<=a; i++) {
				for(int j = 0; j<=b; j++) {
					for(int k = 0; k<=c; k++) {
						if(i<2 && j<=2 || k <2) {
							ac = String.format("(%d+%d+%d)", i,j,k);
						}else if(i<3 || j<3 & k<=3) {
							ac = String.format("(%d-%d-%d)", k,j,i);
						}else if(j%i==0 & (i%2==0 || i%3==0)){
							ac = "("+Recursiva(i-1,j/a,k-1)+"*"+Recursiva(i-2,j/2,k/2) + ")";
						}else {
							ac = "(" + Recursiva(i/2, j-2, k/2) + "/" + Recursiva(i/3,j-1,k/3) + ")";
						}
						
						tupla clave = new tupla(i, j, k);
						aux.put(clave, ac);
						
					}
				}
			}
			
			return aux.get(tupla.of(a, b, c));
			
		}
		
		
		public static record tupla(Integer s,Integer a, Integer b) {
			
			public static tupla of(Integer s,Integer a, Integer b) {
				return new tupla(s,a,b);
			}
			
		}
		
		

}
