package fase1;

import java.util.ArrayList;

public class Interprete {
	String nombre;
	ArrayList<Pelicula> peliculas;
	
	public Interprete(String nombre, ArrayList<Pelicula> peliculas) {
		super();
		this.nombre = nombre;
		this.peliculas = peliculas;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	
	public float calcularRating()  //TODO
	{
		float rating = 0.0f;
		int invalidFilms = 0;
		for (Pelicula p : getPeliculas())
		{
			if (p.getRating() >= 0) // detect if the film has valid rating
			{
				rating += p.getRating();
			}
			else
			{
				invalidFilms++;
			}
			if ((getPeliculas().size() - invalidFilms) != 0) // n/0 is not posible...
			{
				return rating / (getPeliculas().size() - invalidFilms);
			}
			else
			{
				return -1;
			}
			
			
		}
		return rating; 
	}
	
	public void addPelicula(Pelicula pel) // anadirPelicula //DUDA estas pelis tienen que estar en orden alfabético??
	{
		this.peliculas.add(pel);
	}
	
	public void print()
	{
		System.out.println(getNombre());
		System.out.println("=============================");
		System.out.println("Rating ----> " + calcularRating());
		System.out.println("Total de películas del intérprete: --> " + getPeliculas().size());
		for (int i = 0; i < getPeliculas().size(); i++)
		{
			System.out.println("* " + this.peliculas.get(i));
		}
		
		
		System.out.println("\n\n");
		
	}
}
