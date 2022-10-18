package TestPractica;

import java.util.List;
import java.util.stream.Collectors;

import Practica.Ejercicio2;
import us.lsi.streams.Stream2;

public class Test2 {

	public static void main(String[] args) {
		String file = "ficheros/PI1Ej2DatosEntrada.txt";
		List<Tupla> ls = Stream2.file(file).map(s-> parseTupla(s)).collect(Collectors.toList());
		for (int i=0; i<ls.size();i++) {
			Tupla element = ls.get(i);
			Integer a = element.a;
			Integer b = element.b;
			String s = element.s;
			
			Integer resNoFinal= Ejercicio2.SolucionRecursivaNoFinal(a, b, s);
			Integer resFinal= Ejercicio2.SolucionRecursivaFinal(a, b, s);
			Integer resIt= Ejercicio2.Iterativa(a, b, s);
			System.out.println("TEST"+i+": ");
			System.out.println("1)Solución Recursiva no Final :\n" + resNoFinal);
			System.out.println("1)Solución Recursiva Final :\n" + resFinal);
			System.out.println("1)Solución Iterativa :\n" + resIt);
			
		}
		
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

