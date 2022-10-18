package ejemplos;

import java.util.stream.Stream;

public class Ejemplo2 {

	public static String solucionRecursivaNoFinal(Integer a, Integer b) {
		String r = null;
		
		if(a<5 || b<5) {
			r = String.format("(%d)", a*b);
		}else {
			r = String.format("%d",a+b) + solucionRecursivaNoFinal(a/2,b-2);
		}
	
	
	
	
	
		return r;
	}
	
	public static String solucionRecursivaFinal(Integer a, Integer b) {
		//secuencia a y b
		//Estado inicial: a y b
		//Estado final : hasta (a<5 || b<5)
		
		//acumulador String resultado
		return recFinal(a,b,"");
	}
	private static String recFinal(Integer a, Integer b, String ac) {
		String r = null;
		
		if(a<5 || b<5) {
			r = ac + String.format("(%d)", a*b);
		}else {
			r = recFinal(a/2,b-2,ac + String.format("%d",a+b));
		}
		
		return r;
	}
	public static String solucionIterativa(Integer a, Integer b) {
		String ac = "";
		while(!(a<5 || b<5)) {
			//dentro del whle equivale  aaso recursivo
			ac = a+ String.format("%d", a+b);
			a /= 2;
			b -= 2;
		}
		//fuera del while equivale a caso base
	return ac + String.format("%d", a*b);
	
	}
	private static record Tupla(String ac,Integer a, Integer b) {
		//constructor
		public static Tupla of(String s, Integer a, Integer b) {
			return new Tupla(s,a,b);
		}
		//inicializacion
		public static Tupla first(Integer a, Integer b) {
			return of("",a,b);
		}
		//actualizacion(caso recursivo)
		public Tupla next() {
			return of(ac + String.format("%d", a+b),a/2,b-2);
		}
	}
	public static String solucionFuncional(Integer a, Integer b) {
		Tupla t = Stream.iterate(Tupla.first(a, b)
										, e-> e.next())
										.filter(e->e.a()<5 || e.b()<5)
										.findFirst()
										.get();
		return t.ac() +  String.format("(%)", t.a() * t.b());
	}
}
