package TestPractica;
import Practica.*;

public class Test3 {

	public static void main(String[] args) {
		String F1A = "ficheros/PI1Ej3DatosEntrada1A.txt";
		String F1B = "ficheros/PI1Ej3DatosEntrada1B.txt";
		String F2A = "ficheros/PI1Ej3DatosEntrada2A.txt";
		String F2B = "ficheros/PI1Ej3DatosEntrada2B.txt";
		String F3A = "ficheros/PI1Ej3DatosEntrada3A.txt";
		String F3B = "ficheros/PI1Ej3DatosEntrada3B.txt";
		
		
		System.out.println(Ejercicio3.leerPuntoIterativa(F1A, F1B));
		/*
		Ejercicio3.leerPuntoRecursiva(F1A, F1B);
		Ejercicio3.leerPuntoFuncional(F1A, F1B);
		System.out.println("");
		System.out.println("TEST 2:");
		Ejercicio3.leerPuntoIterativa(F2A, F2B);
		Ejercicio3.leerPuntoRecursiva(F2A, F2B);
		Ejercicio3.leerPuntoFuncional(F2A, F2B);
		System.out.println("");
		System.out.println("TEST 3:");
		Ejercicio3.leerPuntoIterativa(F3A, F3B);
		Ejercicio3.leerPuntoRecursiva(F3A, F3B);
		Ejercicio3.leerPuntoFuncional(F3A, F3B);
		*/

	}
	
	public void testEjercicio3Iterativo(String fichero1, String fichero2) {
		String F1A = "ficheros/PI1Ej3DatosEntrada1A.txt";
		String F1B = "ficheros/PI1Ej3DatosEntrada1B.txt";
		System.out.println("TEST 1: ");
		System.out.println("Iterativo: "+ Ejercicio3.leerPuntoIterativa(F1A, F1B));
		System.out.println("Recursivo: "+ Ejercicio3.leerPuntoRecursiva(F1A, F1B));
		System.out.println("Funcional: "+ Ejercicio3.leerPuntoFuncional(F1A, F1B));
	}

}
