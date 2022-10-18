package Practica;

public class Ejercicio2 {
	
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
	
	
	// ITERATIVA
	public static Integer Iterativa(Integer a, Integer b, String s) {
		Integer ac;
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
	
		

}

