 package TestPractica;
 import Practica.*;
import java.util.List;

import java.util.stream.Collectors;

import Practica.Practica;
import Practica.*;
import us.lsi.geometria.Punto2D;
import us.lsi.streams.Stream2;

public class Tests {
	
	public static void main(String[] args) {

}
	public static void testEjemplo1() {
			String file = "ficheros/PI1Ej2DatosEntrada.txt";
			List<Tupla> ls = Stream2.file(file).map(s-> parseTupla(s)).collect(Collectors.toList());
			for (int i=0; i<ls.size();i++) {
				Tupla element = ls.get(i);
				Integer a = element.a;
				Integer b = element.b;
				String s = element.s;
				
				Integer resIt = Practica.SolucionRecursivaNoFinal(a, b, s);
				System.out.println("TEST"+i+": ");
				System.out.println("1)Solución Recursiva no Final :\n" + resIt);
			}
			
			System.out.println("1)Solución funcional:\n" + Ejemplo1.solucionRecursivaFinal(ls));
			System.out.println("2)Solución funcional:\n" + Ejemplo1.ejemplo1(ls));
			System.out.println("3)Solución funcional:\n" + Ejemplo1.solucionIterativa(ls));
		}
	
	public static Tupla parseTupla(String cadena) {
		String[] trozos = cadena.split(",");
		Integer a = Integer.parseInt(trozos[0]);
		Integer b = Integer.parseInt(trozos[1]);
		String s = trozos[2];
		
		return new Tupla(s,a,b);
	}
	
	public static record Tupla(String s,Integer a, Integer b) {
		public static Tupla of(String s, Integer a, Integer b) {
			return new Tupla(s,a,b);
		}
		
	}
	}

