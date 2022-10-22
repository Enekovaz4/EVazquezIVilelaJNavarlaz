package fase1;

import java.util.ArrayList;

public class Interprete {
	String nombre;
	//ArrayList<Pelicula> peliculas;
	ListaPeliculas peliculas;
	
	public Interprete(String nombre, ListaPeliculas peliculas) {
		super();
		this.nombre = nombre;
		this.peliculas = peliculas;
	}
	public Interprete(String nombre) {
		super();
		this.nombre = nombre;
		this.peliculas = new ListaPeliculas();
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ListaPeliculas getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(ListaPeliculas peliculas) {
		this.peliculas = peliculas;
	}
	
	public float calcularRating()  //TODO
	{
		float rating = 0.0f;
		int invalidFilms = 0;
		for (Pelicula p : getPeliculas().getPeliculas())
		{
			if (p.getRating() >= 0) // detect if the film has valid rating
			{
				rating += p.getRating();
			}
			else
			{
				invalidFilms++;
			}
			if ((getPeliculas().getPeliculas().size() - invalidFilms) != 0) // n/0 is not posible...
			{
				return rating / (getPeliculas().getPeliculas().size() - invalidFilms);
			}
			else
			{
				return -1;
			}
			
			
		}
		return rating; 
	}
	
	public void anadirPelicula(Pelicula pel) // anadirPelicula //DUDA estas pelis tienen que estar en orden alfabético??
	{
		this.peliculas.getPeliculas().add(pel);
	}
	
	public void print()
	{
		System.out.println(getNombre());
		System.out.println("=============================");
		System.out.println("Rating ----> " + calcularRating());
		System.out.println("Total de películas del intérprete: --> " + getPeliculas().getPeliculas().size());
		for (int i = 0; i < getPeliculas().getPeliculas().size(); i++)
		{
			System.out.println(this.peliculas.getPeliculas().get(i));
		}
		
		
		System.out.println("\n\n");
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNombre();
	}
}


