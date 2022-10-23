package TestPractica;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Practica.Ejercicio1;
import Practica.Ejercicio4;
import TestPractica.Test1.Tupla;
import us.lsi.streams.Stream2;

public class Test4 {
	public static void main(String[] args) {
		String file = "ficheros/PI1Ej4DatosEntrada.txt";
		List<Tupla> ls = Stream2.file(file).map(s-> parseTupla(s)).collect(Collectors.toList());
		
		for (int i=0; i<ls.size();i++) {
			Tupla element = ls.get(i);
			Integer a = element.a;
			Integer b = element.b;
			Integer c = element.c;
			
			System.out.println("TEST"+i+": ");
			System.out.println("Resultado Recursiva: "+Ejercicio4.Recursiva(a, b, c));
			System.out.println("Resultado Recursiva con Memoria: "+Ejercicio4.RecursivaConMemoria(a, b, c));
			System.out.println("Resultado Iterativa: "+Ejercicio4.SolucionIterativa(a, b, c)+"\n\n");
		}
		}
	
	public static Tupla parseTupla(String cadena) {
		String[] trozos = cadena.split(",");
		Integer a = Integer.parseInt(trozos[0].trim());
		Integer b = Integer.parseInt(trozos[1].trim());
		Integer c = Integer.parseInt(trozos[2].trim());
		
		return new Tupla(a,b,c);
	}
	
	public static record Tupla(Integer a, Integer b, Integer c) {
		public static Tupla of(Integer a, Integer b, Integer c) {
			return new Tupla(a,b,c);
		}
		
	}

}
