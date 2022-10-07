package fase1;


import java.util.ArrayList;
import java.util.Scanner;


public class AplicacionIMDB {
	
	public static void main(String[] args){

          //TO DO: ...
		// CARGAR DATOS (PELICULAS E INTERPRETES)
		CatalogoIMDB catalogo = new CatalogoIMDB("C:\\Users\\Eneko\\Desktop\\Proyecto EDA\\EVazquezIVilelaJNavarlaz\\src\\fase1./films_tiny.txt");
		System.out.println(catalogo.listaInterpretes);
		System.out.println(catalogo.listaPeliculas);
		
		Pelicula p = new Pelicula("AAAAAAAAAA", 2020, 0.0f, 0);
		
		catalogo.listaPeliculas.addPelicula(p);
		System.out.println(catalogo.listaPeliculas);
		
		Interprete i = new Interprete("AAAAAAAA", new ArrayList<Pelicula>());
		catalogo.listaInterpretes.addInterprete(i);
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
			System.out.println("1. Mostrar informacion de pelicula//IN_PROGRESS");
			System.out.println("2. Mostrar informacion de interprete //TODO");
			System.out.println("3. Anadir voto a pelicula //TODO");

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
				   System.out.println("Introduzca el título de una película:\\r\\n");
					   str = sc.nextLine();
					   pel = catalogo.listaPeliculas.getPelicula(str);
					   
					   if (pel != null)
					   {
						  
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