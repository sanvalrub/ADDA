package tests;

import java.util.List;
import java.util.stream.Collectors;

import ejemplos.Ejemplo1;
import us.lsi.geometria.Punto2D;
import us.lsi.streams.Stream2;

//import ejemplos.Ejemplo1;	
//import us.lsi.geometria.Punto2D;
//import us.lsi.streams.Stream2;
//
//public class TestsEjemplos {
//
//	public static void main(String[] args) {
//		testEjemplo();
//
//	}
//	private static void testEjemplo() {
//		String file = "ficheros/EjemploDatosEntrada.txt";
//		Stream2.file(file).map(s->parsePunto(s)).collect(Collectors.toList());
//		
//		System.out.println("1) Solucion funcional: \n" + Ejemplo1.ejemplo1(ls));
//		System.out.println("2) Solucion iterativa: \n" + Ejemplo1.solucionIterativa(ls));
//		System.out.println("3) Solucion recursiva final: \n" + Ejemplo1.solucionRecursivaFinal(ls));
//	}
//	
//	private static  Punto2D parsePunto(String s) {
//		String[] v = s.split(s);
//		
//		Double x = Double.valueOf(v[0]);
//		Double y = Double.valueOf(v[1]);
//		Punto2D p = Punto2D.of(x,y);
//		return p;
//	}
//
//}
public class TestsEjemplos {

	public static void main(String[] args) {
		testEjemplo1();
		
		

	}
	public static void testEjemplo1() {
		String file = "ficheros/Ejemplo1DatosEntrada.txt";
		List<Punto2D> ls = Stream2.file(file).map(s-> parsePunto(s)).collect(Collectors.toList());
		System.out.println("1)Solución funcional:\n" + Ejemplo1.solucionRecursivaFinal(ls));
		System.out.println("2)Solución funcional:\n" + Ejemplo1.ejemplo1(ls));
		System.out.println("3)Solución funcional:\n" + Ejemplo1.solucionIterativa(ls));
	}
	private static Punto2D parsePunto(String s) {
		String[] v = s.split(",");
		Double x = Double.valueOf(v[0]);
		Double y = Double.valueOf(v[1]);
		Punto2D p = Punto2D.of(x,y);
		return p;
	}

}
