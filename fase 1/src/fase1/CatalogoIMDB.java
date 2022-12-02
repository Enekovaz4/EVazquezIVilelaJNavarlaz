package fase1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CatalogoIMDB {
ListaPeliculas listaPeliculas;
ListaInterpretes listaInterpretes;
public CatalogoIMDB(String filename) {
	super();
	cargarPeliculas(filename);
	//this.listaInterpretes = new ListaInterpretes(cargarInterpretes(this.listaPeliculas));
	cargarInterpretes(this.listaPeliculas);
}

private void cargarPeliculas(String filename)
{
	ListaPeliculas films = new ListaPeliculas();
	
	 try {
	      File myObj = new File(filename);
	      Scanner myReader = new Scanner(myObj);
	      
	      
	      while (myReader.hasNextLine()) {
	        String readLine = myReader.nextLine();
	        String[] p = readLine.split("\t"); // split data from string (detect Tabs)
		      
		    Pelicula film = new Pelicula(p[0],Integer.parseInt(p[1]), Float.parseFloat(p[2]), Integer.parseInt(p[3]));
	     
		    films.getPeliculas().add(film);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	this.listaPeliculas = films;
}

private void cargarInterpretes(ListaPeliculas listaPeliculas)
{
	ListaInterpretes casts = new ListaInterpretes();
	
	 try {
	      File myObj = new File("./src/fase1/cast_tiny.txt");
	      Scanner myReader = new Scanner(myObj);
	      
	      
	      while (myReader.hasNextLine()) {
	        String readLine = myReader.nextLine();
	        String[] c1 = readLine.split("->"); // split data from string (detect ->)
	        String[] c2 = c1[1].split("\\|\\|");
	      
	        // get cast films
	        ListaPeliculas castFilms = new ListaPeliculas();
	        for (int i = 0; i<c2.length; i++)
	        {
	        	Pelicula p = listaPeliculas.BuscarPelicula(c2[i]);
	        	castFilms.getPeliculas().add(p);
	        }
	            
		    Interprete cast = new Interprete(c1[0], castFilms); 
		    casts.getInterpretes().add(cast);
		    
		    //add cast to films
		    for (Pelicula p : castFilms.getPeliculas())
		    {
		    	p.getInterpretes().add(cast);
		    } 
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	 
	// sort arraylist by cast name
	Collections.sort(casts.getInterpretes(), new Comparator<Interprete>(){
	    public int compare(Interprete i1, Interprete i2) {
	        return i1.getNombre().compareToIgnoreCase(i2.getNombre());
	    }
	});
	 
	this.listaInterpretes = casts;
}

	public void imprimirInfoPelicula(String titulo)
	{
		Pelicula p = listaPeliculas.BuscarPelicula(titulo);
		
		if (p != null)
		{
			System.out.println(p.getTitulo());
			System.out.println("=============================");
			System.out.println("Año: " + p.getAno());
			System.out.println("Rating: " + p.getRating());
			System.out.println("Num. votos: " + p.getNumVotos());
			System.out.println("Total de intérpretes de la película: " + p.getInterpretes().size() + "");
			
			for (Interprete i : p.getInterpretes())
			{
				System.out.println("   * " + i);
			}
			
			
			System.out.println("\n\n");
		}
		else
		{
			System.out.println("NO EXISTE ESA PELÍCULA");
		}
		
	}
	
	public void imprimirInfoInterprete(String nombre)
	{
		Interprete in = listaInterpretes.getInterprete(nombre);
		
		if (in != null)
		{
			System.out.println("Nombre: " + in.getNombre());
			System.out.println("Rating: " + in.calcularRating());
			System.out.println("Total de películas del intérprete: " + in.getPeliculas().getPeliculas().size());
			for (Pelicula p : in.getPeliculas().getPeliculas())
			{
				System.out.println("     * " + p.getTitulo());
			}
			
			
			System.out.println("\n\n");
		}
		else
		{
			System.out.println("NO EXISTE ESE INTÉRPRETE");
		}
	}




public void AnadirVoto(String titulo, float voto)  //AnadirVoto 
{
	Pelicula p = listaPeliculas.BuscarPelicula(titulo);
	
	p.AnadirVoto(voto); // if the vote is valid or not, is decided on this function
}

}
