package Practica;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;

public class Ejercicio3 {
	
	public static List<Punto2D> leerPunto(String fichero1, String fichero2){
		List<Punto2D> ac = new ArrayList<Punto2D>();
		try {

			File f1 = new File(fichero1); // creamos objetos de tipo File para cada fichero
			File f2 = new File(fichero2);
			Scanner s1 = new Scanner(fichero1); // creamos objetos de tipo Scanner para cada fichero
			Scanner s2 = new Scanner(fichero2);
			
			while(s1.hasNext() || s2.hasNext()) {
				// mientras que uno de los dos ficheros no esté vacío
				
				if (s1.hasNext() && s2.hasNext()) { // si ninguno de los ficheros está vacío
					Punto2D p1 = parsePunto(s1.nextLine()); // parseamos a objetos de tipo Punto2D
					Punto2D p2 = parsePunto(s2.nextLine());
					Predicate<Punto2D> p = x->x.getCuadrante()==Cuadrante.PRIMER_CUADRANTE || x.getCuadrante()==Cuadrante.TERCER_CUADRANTE;
					// filtramos por cuadrante:
					if(p.test(p1) & !p.test(p2) ) { // si p1 está en el cuadrante:
						ac.add(p1); 
						s1.nextLine();
						s2.nextLine(); // añadimos a la lista p1 e incrementamos punteros
					}else if (!p.test(p1) & p.test(p2)) {  // si p2 está en la lista:
						ac.add(p2);
						s1.nextLine();
						s2.nextLine(); // añadimos a la lista p2 e incrementamos punteros
					}else if(p.test(p1) & p.test(p2)) { // si los dos están en los cuadrantes:
						if (p1.compareTo(p2)<0){ // si p1 es menor que p2:
							ac.add(p1);
							s1.nextLine(); // añadimos p1 a la lista e incrementamos SÓLO p1
						}else {
							ac.add(p2);
							s2.nextLine(); // añadimos p2 a la lista e incrementamos SÓLO p2
						}
					}else {
						s1.nextLine();
						s2.nextLine();
					}
					}

				}
			
				if(!s1.hasNext()) { // si el fichero 1 está vacío:
					Punto2D p2 = parsePunto(s2.nextLine()); // 
					ac.add(p2);
					s2.next();
				}else if(!s2.hasNext()) {
					Punto2D p1 = parsePunto(s1.nextLine());
					ac.add(p1);
					s1.next();
				}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ac;
}

	private static Punto2D parsePunto(String string) {
		String[] trozos = string.toString().split(",");
		return Punto2D.of(Double.valueOf(trozos[0].trim()), Double.valueOf(trozos[1].trim()));
		
	}
}
