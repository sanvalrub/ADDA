package Practica;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

import Practica.Ejercicio2.Tupla;
import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;

public class Ejercicio3 {
	
	
	// EJERCICIO 3 SOLUCIÓN ITERATIVA
	/**
	 * @param String fichero1, String fichero2.
	 * @return Lista de tipo Punto2D fusionada de los dos ficheros pasados como parámetros.     
	 */
	public static List<Punto2D> leerPuntoIterativa(String fichero1, String fichero2){
		List<Punto2D> ac = new ArrayList<Punto2D>();
		try {

			File f1 = new File(fichero1); // creamos objetos de tipo File para cada fichero
			File f2 = new File(fichero2);
			Scanner s1 = new Scanner(f1); // creamos objetos de tipo Scanner para cada objeto File
			Scanner s2 = new Scanner(f2);
			
			Punto2D p1 = null;
			Punto2D p2 = null;
			
			if(s1.hasNext() && s2.hasNext()) { 
				p1 = parsePunto(s1.nextLine()); // se asigna p1 a la primera posición del fichero 1 mientras que s1 y s2 no estén vacíos
				p2 = parsePunto(s2.nextLine());
			}
			
			Predicate<Punto2D> p = x->x.getCuadrante()==Cuadrante.PRIMER_CUADRANTE || x.getCuadrante()==Cuadrante.TERCER_CUADRANTE;
			
			
			while(s1.hasNext() || s2.hasNext()) { // mientras que uno de los dos ficheros no esté vacío
				
				if (s1.hasNext() && s2.hasNext()) { // caso 1: si ninguno de los ficheros está vacío
		
					// filtramos por cuadrante:
					if(p.test(p1) && !p.test(p2) ) { // si p1 está en los cuadrantes y p2 no:
						p2 = parsePunto(s2.nextLine()); // incrementamos iterador del f2 pero no del f1 pues se va a tener que comparar 
						                                // con el siguiente
					}else if (!p.test(p1) && p.test(p2)) {  // lo mismo si p2 es el que está esta vez en los cuadrantes
						p1 = parsePunto(s1.nextLine());

					}else if(p.test(p1) && p.test(p2)) { // si los dos están en los cuadrantes:
						if (p1.compareTo(p2)<0){ // si p1 es menor que p2:
							ac.add(p1); // se añade p1
							p1 = parsePunto(s1.nextLine()); // y se incrementa p1 (p2 se seguirá manteniendo para compararse con el siguiente)
						}else {
							ac.add(p2); // lo mismo pero si p2 es el menor
							p2 = parsePunto(s2.nextLine());
						}
					}else {
						p1 = parsePunto(s1.nextLine()); // si no están en los cuadrantes, se incrementan 
						p2 = parsePunto(s2.nextLine()); // los iteradores de ambos ficheros
					}
					
				}else if(!s1.hasNext()) { // caso 2: si f1 está vacío
					if(p.test(p2)) // comprobamos que el punto de f2 esté en el 2º cuadrante
						ac.add(p2);
					p2 = parsePunto(s2.nextLine());
					if (!s2.hasNext()) { // aquí preguntamos si ese punto es el último del fichero
						if(p.test(p2))   // si es, filtramos para comprobar si está en los cuadrantes
							ac.add(p2);  // añadimos y así no se saltaría el punto final y lo mete en la lista
					
					}
						
				}else { // caso 3: si f2 está vacío -> mismo algoritmo que el caso anterior
					if(p.test(p1))
						ac.add(p1);
					p1 = parsePunto(s1.nextLine());
					if (!s1.hasNext()) { 
						if(p.test(p2))   
							ac.add(p2);  
					
					}
						
				}
					
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return ac;
	
}
	
	
	// EJERCICIO 3 SOLUCIÓN RECURSIVA
	
	/**
	 * @param String fichero1, String fichero2.
	 * @return Llamada a la función auxiliar recursiva que hace todos los cálculos. Obtenemos una ista de tipo
	 *         Punto2D fusionada de los dos ficheros pasados como parámetros.     
	 */
	public static List<Punto2D> leerPuntoRecursiva(String fichero1, String fichero2){
		try {
			File f1 = new File(fichero1); // creamos objetos de tipo File para cada fichero
			File f2 = new File(fichero2);
			Scanner s1 = new Scanner(f1); // creamos objetos de tipo Scanner para cada objeto File
			Scanner s2 = new Scanner(f2);
			
			Punto2D p1 = null;
			Punto2D p2 = null;
			
			if(s1.hasNext() && s2.hasNext()) { 
				p1 = parsePunto(s1.nextLine()); // se asigna p1 a la primera posición del fichero 1 mientras que s1 y s2 no estén vacíos
				p2 = parsePunto(s2.nextLine());
				
			}
			
			return RecursivaAux(p1, p2, s1, s2, new ArrayList<Punto2D>());
		
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}


	}
		
		
		
	
	/**
	 * @param Punto2D p1, Punto2D p2, Scanner s1, Scanner s2, List<Punto2D> ac.
	 * @return Lista de tipo Punto2D fusionada de los dos ficheros pasados como parámetros.     
	 */
	private static List<Punto2D> RecursivaAux(Punto2D p1, Punto2D p2, Scanner s1, Scanner s2, List<Punto2D> ac) {
			
			Predicate<Punto2D> p = x->x.getCuadrante()==Cuadrante.PRIMER_CUADRANTE || x.getCuadrante()==Cuadrante.TERCER_CUADRANTE;
			
			
			if(s1.hasNext() || s2.hasNext()) { 
				
				
				if (s1.hasNext() && s2.hasNext()) { 
		
					// filtramos por cuadrante:
					if(p.test(p1) && !p.test(p2) ) { 
						p2 = parsePunto(s2.nextLine());  
						                                
					}else if (!p.test(p1) && p.test(p2)) {  
						p1 = parsePunto(s1.nextLine());

					}else if(p.test(p1) && p.test(p2)) { 
						if (p1.compareTo(p2)<0){ 
							ac.add(p1); 
							p1 = parsePunto(s1.nextLine()); 
						}else {
							ac.add(p2);
							p2 = parsePunto(s2.nextLine());
						}
					}else {
						p1 = parsePunto(s1.nextLine()); 
						p2 = parsePunto(s2.nextLine()); 
					}
					
					RecursivaAux(p1,p2,s1,s2,ac);
					
				}else if(!s1.hasNext()) { 
					if(p.test(p2)) 
						ac.add(p2);
					p2 = parsePunto(s2.nextLine());
					if (!s2.hasNext()) {
						if(p.test(p2)) 
							ac.add(p2);
					
					}
					
					RecursivaAux(p1,p2,s1,s2,ac);
						
				}else {
					if(p.test(p1))
						ac.add(p1);
					p1 = parsePunto(s1.nextLine());
					if (!s1.hasNext()) { // aquí preguntamos si ese punto es el último del fichero
						if(p.test(p1))   // si es, filtramos para comprobar si está en los cuadrantes
							ac.add(p1);
					RecursivaAux(p1,p2,s1,s2,ac);
					}
				}
			}
			return ac;
			
}
	
	
	// EJERCICIO 3 SOLUCIÓN FUNCIONAL
	
	/**
	 * @param String fichero1, String fichero2
	 * @return Lista de tipo Punto2D fusionada de los dos ficheros pasados como parámetros.     
	 */
	public static List<Punto2D> leerPuntoFuncional(String fichero1, String fichero2){
		List<Punto2D> ac = new ArrayList<Punto2D>();
		try {

			File f1 = new File(fichero1); // creamos objetos de tipo File para cada fichero
			File f2 = new File(fichero2);
			Scanner s1 = new Scanner(f1); // creamos objetos de tipo Scanner para cada objeto File
			Scanner s2 = new Scanner(f2);
			
			Punto2D p1 = null;
			Punto2D p2 = null;
			
			if(s1.hasNext() && s2.hasNext()) { 
				p1 = parsePunto(s1.nextLine()); // se asigna p1 a la primera posición del fichero 1 mientras que s1 y s2 no estén vacíos
				p2 = parsePunto(s2.nextLine());
			}
			
			Tupla t = Stream.iterate(Tupla.of(fichero1, fichero2, ac, s1, s2, p1, p2), x->nx(x))
					.dropWhile(x->x.s1.hasNext() || x.s2.hasNext())
					.findFirst().get();
			
			return t.ac;
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			
		}
	
		
	}
	
	public static record Tupla(String fichero1, String fichero2, List<Punto2D> ac, Scanner s1, Scanner s2, Punto2D p1, Punto2D p2) {
		public static Tupla of(String fichero1, String fichero2, List<Punto2D> ac, Scanner s1, Scanner s2, Punto2D p1, Punto2D p2) {
			return new Tupla(fichero1, fichero2, ac, s1, s2, p1, p2);
		}
	}
	
	public static Tupla nx(Tupla t) {
		String fichero1 = t.fichero1;
		String fichero2 = t.fichero2;
		Scanner s1 = t.s1;
		Scanner s2 = t.s2;
		Punto2D p1 = t.p1;
		Punto2D p2 = t.p2;
		List<Punto2D> ac = t.ac;
		
		Predicate<Punto2D> p = x->x.getCuadrante()==Cuadrante.PRIMER_CUADRANTE || x.getCuadrante()==Cuadrante.TERCER_CUADRANTE;
		
		
		if (s1.hasNext() && s2.hasNext()) { 
			
			if(p.test(p1) && !p.test(p2) ) { 
				p2 = parsePunto(s2.nextLine()); 
			}else if (!p.test(p1) && p.test(p2)) {  
				p1 = parsePunto(s1.nextLine());

			}else if(p.test(p1) && p.test(p2)) { 
				if (p1.compareTo(p2)<0){ 
					ac.add(p1); 
					p1 = parsePunto(s1.nextLine()); 
				}else {
					ac.add(p2);
					p2 = parsePunto(s2.nextLine());
				}
			}else {
				p1 = parsePunto(s1.nextLine()); 
				p2 = parsePunto(s2.nextLine()); 
			}
			
		}else if(!s1.hasNext()) { 
			if(p.test(p2)) 
				ac.add(p2);
			p2 = parsePunto(s2.nextLine());
			if (!s2.hasNext()) {
				if(p.test(p2)) 
					ac.add(p2);
			
			}
				
		}else {
			if(p.test(p1))
				ac.add(p1);
			p1 = parsePunto(s1.nextLine());
			if (!s1.hasNext()) { 
				if(p.test(p1))   
					ac.add(p1);
			}
				
		}
		
		return new Tupla(fichero1, fichero2, ac, s1, s2, p1, p2);
	}
		

	private static Punto2D parsePunto(String string) {
		String[] trozos = string.toString().split(",");
		return Punto2D.of(Double.valueOf(trozos[0].trim()), Double.valueOf(trozos[1].trim()));
		
	}
}
