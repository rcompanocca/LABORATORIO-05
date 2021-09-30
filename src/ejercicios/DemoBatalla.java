//AUTOR: RONI COMPANOCCA CHECCO
//LABORATORIO 05
//ARREGLOS DE OBJETOS, BUSQUEDA Y ORDENAMIENTO DE BURBUJA
package ejercicios;
import java.util.*;
import java.util.Scanner;

public class DemoBatalla {
	public static void main(String[] args) {
		Nave[] misNaves = new Nave[10];
		Scanner scan = new Scanner(System.in);
		String nomb, col;
		int fil, punt;
		boolean est;

		for (int i = 0; i < misNaves.length; i++) {
			System.out.println("Nave " + (i + 1));
			System.out.print("Nombre: ");
			nomb = scan.next();
			System.out.println("Fila ");
			fil = scan.nextInt();
			System.out.print("Columna: ");
			col = scan.next();
			System.out.print("Estado: ");
			est = scan.nextBoolean();
			System.out.print("Puntos: ");
			punt = scan.nextInt();

			// SE CREA UN OBEJETO NAVE Y SE ASIGNA SU REFERENCIA A MISNAVES
			misNaves[i] = new Nave();
			
			misNaves[i].setNombre(nomb);
			misNaves[i].setFila(fil);
			misNaves[i].setColumna(col);
			misNaves[i].setEstado(est);
			misNaves[i].setPuntos(punt);
		}

		System.out.println("\nNaves creadas:");
		mostrarNaves(misNaves);
		mostrarPorNombre(misNaves);
		mostrarPorPuntos(misNaves);
		System.out.println("\nNave con mayor número de puntos: "+mostrarMayorPuntos(misNaves));
		
		// LEER UN NOMBRE
		// MOSTRAR LOS DATOS DE LA NAVE CON DICHO NOMBRE, MENSAJE DE "NO ENCONTRADO" EN CASO CONTRARIO
		
		int pos = busquedaLinealNombre(misNaves, nombre);
		
		ordenarPorPuntosBurbuja(misNaves);
		mostrarNaves(misNaves);
		ordenarPorNombreBurbuja(misNaves);
		mostrarNaves(misNaves);
		
		// MOSTRAR LOS DATOS DE LA NAVE CON DICHO NOMBRE, MENSAJE DE "NO ENCONTRADO" EN CASO CONTRARIO
		pos = busquedaBinariaNombre(misNaves, nombre);
		
		ordenarPorPuntosSeleccion(misNaves);
		mostrarNaves(misNaves);
		OrdenarPorPuntosInsercion(misNaves);
		mostrarNaves(misNaves);
		OrdenarPorNombreSeleccion(misNaves);
		mostrarNaves(misNaves);
		ordenarPorNombreInsercion(misNaves);
		mostrarNaves(misNaves);

	}
	//METODO PARA MOSTRAR TODAS LAS NAVES
	public static void mostrarNaves(Nave[] flota) {
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<flota.length; i++) {
			System.out.println(flota[i]);
		}
	}
	//METODO PARA MOSTRAR TODAS LAS NAVES DE UN NOMBRE QUE SE PIDE POR TECLADO
	public static void mostrarPorNombre(Nave[] flota) {
		Scanner scan = new Scanner(System.in);
		int cont =0;
		String nav;
		System.out.println("Ingrsese el nombre de la nave: ");
		nav = scan.next();
		for(int i=0; i<flota.length; i++){
			if (nav == flota[i]) {
				System.out.println(flota[i]);
				cont ++;
			}
			else {
				System.out.println("No hay coincidencias. ");
			}
		}
		System.out.println("se repiten: "+cont+" veces.");
	}
	//METODO PARA MOSTRAR TODAS LAS NAVES CON UN NUMERO DE PUNTOS INFERIOR O IGUAL
	//AL NUMERO DE PUNTOS QUE SE PIDE POR TECLADO
	public static void mostrarPorPuntos(Nave[] flota) {
		Scanner scan = new Scanner(System.in);
		int punto, cont=0;
		System.out.println("Ingrsese los puntos de la nave: ");
		punto = scan.nextInt();
		for(int i=0; i<flota.length; i++){
			if (punto == flota[i]) {
				System.out.println(flota[i]);
				cont ++;
			}
			else {
				System.out.println("No hay coincidencias. ");
			}
		}
		System.out.println("se repiten: "+cont+" veces.");
	}
	//METODO QUE DEVUELVE LA NAVE CON MAYOR NUMERO DE PUNTOS
	public static Nave mostrarMayorPuntos(Nave[] flota) {
		
	}
	//METODO PARA BUSCAR LA PRIMERA NAVE CON UN NOMBREQUE SE PIDIO POR TECLADO
	public static int busquedaLinealNombre(Nave[] flota) {
		int num = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("ingrese el nombre para buscar:");
		num = scan.nextInt();
		for (int i = 0; i < flota.length; i++) {
			if (num == flota[i]) {
				return i;
			}
		return -1;
		}
		if (num != -1) {
			System.out.println("encontrado en la posicion: " + num);
		} else {
			System.out.println("no se encontro");
		}
	}
	//METODO QUE ORDENA POR NUMERO DE PUNTOS DE MENOR A MAYOR
	public static void ordenarPorPuntosBurbuja(Nave[] flota) {
		int num, indice;
		for (int i = 0; i < flota.length; i++) {
			System.out.println("--" + flota[i]);
	    }
		System.out.println("Ordenado:");
		for (int i = 1; i < flota.length; i++)
			for (int j = 0; j < flota.length - i; j++) {
				if (flota[j] > flota[j + 1]) {
					int temp;
					temp = flota[i];
					flota[i] = flota[j];
					flota[j] = temp;
				}
			}
		for (int i = 0; i < flota.length; i++)
			System.out.println("--" + flota[i]);
	}
	//METODO QUE ORDENA POR NOMBRE DE A a Z
	public static void ordenarPorNombreBurbuja(Nave[] flota) {
	}
	//METODO PARA BUSCAR LA PRIMERA NAVE CON UN NOMBRE QUE SE PIDIO POR TECLADO
	public static int busquedaBinariaNombre(Nave[] flota, String s) {
	}
	//METODO QUE ORDENA POR NUMERO DE PUNTOS  DE MENOR A MAYOR
	public static void ordenarPorPuntosSeleccion(Nave[] flota) {
		System.out.println("Lista de números: ");
		for(int i=0; i<flota.length; i++) {
			System.out.print("["+flota[i]+"]\t");
		}
		for(int i=0; i<flota.length-1; i++) {
			int minimo = 1;
			for(int j=i+1; j<flota.length-1; j++) {
				if(flota[j] < flota[minimo]) {
					minimo = j;
				}
			}
			aux = flota[i];
			flota[i] = flota[minimo];
			flota[minimo] = aux;
		}
		System.out.println("\nOrdenado por método de selección: ");
		for(int i=0; i<flota.length; i++) {
			System.out.print("["+flota[i]+"]\t");
		}
	}
	//METODO QUE ORDENA POR NOMBRE DE A a Z
	public static void ordenarPorNombreSeleccion(Nave[] flota) {
	}
	//METODO QUE MUESTRA LAS NAVES ORDENADAS POR NUMERO DE PUNTOS DE MAYOR A MENOR
	public static void ordenarPorPuntosInsercion(Nave[] flota) {
		System.out.println("Lista de números: ");
		int lista[] = new int[9];
		for(int i=0; i<lista.length; i++) {
			lista[i] = (int)(Math.random()*100+1);
			System.out.print("["+lista[i]+"]\t");
		}
		for(int i=0; i<lista.length; i++) {
			int pos = i;
			int aux = lista[i];
			while((pos > 0) && (lista[pos-1] > aux)){
				lista[pos] = lista[pos-1];
				pos--;
			}
			lista[pos] = aux;
		}
		System.out.println("\nOrdenado por método de inserción: ");
		for(int i=0; i<lista.length; i++) {
			System.out.print("["+i+"]\t");
		}
	}
	//METODO QUE MUESTRA LAS NAVES ORDENADAS POR NOMBRE DE Z a A
	public static void ordenarPorNombreInsercion(Nave[] flota) {
	}
}


