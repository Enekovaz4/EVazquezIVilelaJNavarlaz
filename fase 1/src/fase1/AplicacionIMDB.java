package fase1;


import java.util.ArrayList;
import java.util.Scanner;


public class AplicacionIMDB {
	
	public static void main(String[] args){

          //TO DO: ...
		// CARGAR DATOS (PELICULAS E INTERPRETES)
		CatalogoIMDB catalogo = new CatalogoIMDB("./src/fase1/films_tiny.txt");
		System.out.println(catalogo.listaInterpretes);
		System.out.println(catalogo.listaPeliculas);
		
		Pelicula p = new Pelicula("AAAAAAAAAA", 2020, 0.0f, 0);
		
		catalogo.listaPeliculas.AnadirPelicula(p);
		System.out.println(catalogo.listaPeliculas);
		
		Interprete i = new Interprete("AAAAAAAA");
		catalogo.listaInterpretes.AnadirInterprete(i);
		System.out.println(catalogo.listaInterpretes);
		
		Interprete in = catalogo.listaInterpretes.getInterprete("Donner, Richard");
		if (in != null)
		{
			System.out.println(in.getPeliculas());
		}
		
		
		System.out.println("\n\n ////////////////////////////// \n \n");
	    
		
	
		//System.out.println("HE BUSCADO y ENCONTRADO :: " + listaPeliculas.getPelicula("Fields of Valor: The Civil War"));
		//Menu
		Scanner sc = new Scanner(System.in);
		int opcion=-1;
		String str = "";
		Pelicula pel;
		Interprete inter;
		
		while(opcion!=0) {
			System.out.println("Escoja una opcion:");
			System.out.println("1. Mostrar informacion de pelicula");
			System.out.println("2. Mostrar informacion de interprete");
			System.out.println("3. Anadir voto a pelicula");

			System.out.println("0. Salir");
			opcion = Integer.parseInt(sc.nextLine());
			switch(opcion) {
			   case 1: 
				   System.out.println("Introduzca el título de una película:\r\n"
				   		+ "");
				   str = sc.nextLine();
				   catalogo.imprimirInfoPelicula(str); // print film info
			        break;
			   case 2:
				   System.out.println("Introduzca el nombre de un intérprete:");
					   str = sc.nextLine();
					   
					   catalogo.imprimirInfoInterprete(str);
					   
				   break;
			   case 3:
				   System.out.println("Introduzca el título de una película: ");
					   str = sc.nextLine();
					   pel = catalogo.listaPeliculas.BuscarPelicula(str);
					   float rating;
					   
					   if (pel != null)
					   {
						   System.out.println("Introduzca una puntuación entre 0.0 y 10.0 ");
						   str = sc.nextLine();
						   // validate input data (is float?)
						    try{
						       rating = Float.parseFloat(str);
						       
						       // add rating and vote to film
						       pel.AnadirVoto(rating);
						    }catch(NumberFormatException e){
						        System.out.println("¡El valor insertado no es válido!");
						    }
					   }
					   else
					   {
						   System.out.println("¡Esa película no existe!");
					   }
				   break;
	              // TO DO
			}
		}
		sc.close();
		

	}

	private static ListaPeliculas cargarPeliculas() {
		// TODO Auto-generated method stub
		return null;
	}

}