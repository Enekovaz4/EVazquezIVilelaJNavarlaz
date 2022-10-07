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
	this.listaPeliculas =  new ListaPeliculas(cargarPeliculas(filename));
	this.listaInterpretes = new ListaInterpretes(cargarInterpretes(this.listaPeliculas));
}

private ArrayList<Pelicula> cargarPeliculas(String filename)
{
	ArrayList<Pelicula> films = new ArrayList<Pelicula>();
	
	 try {
	      File myObj = new File(filename);
	      Scanner myReader = new Scanner(myObj);
	      
	      
	      while (myReader.hasNextLine()) {
	        String readLine = myReader.nextLine();
	        String[] p = readLine.split("\t"); // split data from string (detect Tabs)
		      
		    Pelicula film = new Pelicula(p[0],Integer.parseInt(p[1]), Float.parseFloat(p[2]), Integer.parseInt(p[3]));
	     
		    films.add(film);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	return films;
}

private ArrayList<Interprete> cargarInterpretes(ListaPeliculas listaPeliculas)
{
	ArrayList<Interprete> casts = new ArrayList<Interprete>();
	
	 try {
	      File myObj = new File("C:\\Users\\Eneko\\Desktop\\Proyecto EDA\\EVazquezIVilelaJNavarlaz\\src\\fase1./cast_tiny.txt");
	      Scanner myReader = new Scanner(myObj);
	      
	      
	      while (myReader.hasNextLine()) {
	        String readLine = myReader.nextLine();
	        String[] c1 = readLine.split("->"); // split data from string (detect ->)
	        String[] c2 = c1[1].split("\\|\\|");
	      
	        // get cast films
	        ArrayList<Pelicula> castFilms = new ArrayList<Pelicula>();
	        for (int i = 0; i<c2.length; i++)
	        {
	        	Pelicula p = listaPeliculas.getPelicula(c2[i]);
	        	castFilms.add(p);
	        }
	            
		    Interprete cast = new Interprete(c1[0], castFilms);
	     
		    casts.add(cast);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	 
	// sort arraylist by cast name
	Collections.sort(casts, new Comparator<Interprete>(){
	    public int compare(Interprete i1, Interprete i2) {
	        return i1.getNombre().compareToIgnoreCase(i2.getNombre());
	    }
	});
	 
	return casts;
}

	public void imprimirInfoPelicula(String titulo)
	{
		Pelicula p = listaPeliculas.getPelicula(titulo);
		
		if (p != null)
		{
			System.out.println(p.getTitulo());
			System.out.println("=============================");
			System.out.println("Año: " + p.getAno());
			System.out.println("Rating: " + p.getRating());
			System.out.println("Num. votos: " + p.getNumVotos());
			System.out.println("Total de intérpretes de la película: " + "//TODO");
			
			
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
			System.out.println("Total de películas del intérprete: " + in.getPeliculas().size());
			for (Pelicula p : in.getPeliculas())
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




public void addVoto(String titulo, float voto)  //AnadirVoto 
{
	Pelicula p = listaPeliculas.getPelicula(titulo);
	
	p.addVoto(voto); // if the vote is valid or not, is decided on this function
}

}
