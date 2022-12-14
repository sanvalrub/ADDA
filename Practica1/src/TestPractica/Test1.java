package TestPractica;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Practica.Ejercicio1;
import us.lsi.streams.Stream2;

public class Test1 {

	public static void main(String[] args) {
		String file = "ficheros/PI1Ej1DatosEntrada.txt";
		List<Tupla> ls = Stream2.file(file).map(s-> parseTupla(s)).collect(Collectors.toList());
		
		for (int i=0; i<ls.size();i++) {
			Tupla element = ls.get(i);
			Integer a = element.a;
			String b = element.b;
			Integer c = element.c;
			String d = element.d;
			Integer e = element.e;
			
			Map<Integer, List<String>> Resultado = Ejercicio1.solucionIterativa(a, b,
					c, d, e);
			
			Map<Integer, List<String>> Resultado1 = Ejercicio1.solucionARecursivaFinal(a, b, c, d, e);
			System.out.println("TEST"+i+": ");
			System.out.println("1)Solucion Iterativa" + Resultado);
			System.out.println("1)Solucion Recursiva" + Resultado1+ "\n");
		}
	}
	
	public static Tupla parseTupla(String cadena) {
		String[] trozos = cadena.split(",");
		Integer a = Integer.parseInt(trozos[0].trim());
		String b = trozos[1].trim();
		Integer c = Integer.parseInt(trozos[2].trim());
		String d = trozos[3].trim();
		Integer e = Integer.parseInt(trozos[4].trim());
		
		return new Tupla(a,b,c,d,e);
	}
	
	public static record Tupla(Integer a, String b, Integer c, String d, Integer e) {
		public static Tupla of(Integer a, String b, Integer c, String d, Integer e) {
			return new Tupla(a,b,c,d,e);
		}
		
	}

}
