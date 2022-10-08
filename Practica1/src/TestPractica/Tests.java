package TestPractica;
import java.util.List;
import java.util.stream.Collectors;

import Practica.Practica;
import us.lsi.geometria.Punto2D;
import us.lsi.streams.Stream2;

public class Tests {
	
	public static void main(String[] args) {

}
	public static void testEjemplo1() {
		String file = "ficheros/Ejemplo1DatosEntrada.txt";
		List<Punto2D> ls = Stream2.file(file).map(s-> parsePunto(s)).collect(Collectors.toList());
		System.out.println("1)Solución iterativa:\n" + solucionRecursivaFinal(ls));

	}
	private static Punto2D parsePunto(String s) {
		String[] v = s.split(",");
		Double x = Double.valueOf(v[0]);
		Double y = Double.valueOf(v[1]);
		Punto2D p = Punto2D.of(x,y);
		return p;
	}

}
