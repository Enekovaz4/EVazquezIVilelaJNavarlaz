package fase1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class ListaPeliculas {
	ArrayList<Pelicula> peliculas;

	public ListaPeliculas(ArrayList<Pelicula> films) {
		super();
		this.peliculas = films;
	}
	public ListaPeliculas() {
		super();
		this.peliculas = new ArrayList<Pelicula>();
	}

	public ArrayList<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Lista Peliculas --> " + peliculas.size() + " películas."; 
	}
	
	public Pelicula BuscarPelicula (int index)
	{
		return this.peliculas.get(index);
	}

	public Pelicula BuscarPelicula(String filmToSearch) { // BuscarPelicula(String titulo)
		int l = 0;
		int r = this.peliculas.size() - 1;
		int m = (int)((l + r) / 2);
		int compare;
		
		//búsqueda dicotómica --> https://es.wikipedia.org/wiki/B%C3%BAsqueda_binaria#Algoritmo:~:text=fuera%20de%20consideraci%C3%B3n.-,Procedimiento,-%5Beditar%5D
		while (l <= r)
		{
			m = (int)((l + r) / 2);
			compare = this.peliculas.get(m).compareTo(filmToSearch);
			
			if(compare < 0)
			{
				l = m + 1;
			}
			else if (compare > 0)
			{
				r = m - 1;
			}
			else
			{
				return this.peliculas.get(m);
			}
		}
		return null;
	}
	
	public void AnadirPelicula(Pelicula p)
	{
		this.peliculas.add(p); // add film to the arraylist
		
		// sort films
		Collections.sort(this.peliculas, new Comparator<Pelicula>(){
		    public int compare(Pelicula s1, Pelicula s2) {
		        return s1.getTitulo().compareToIgnoreCase(s2.getTitulo());
		    }
		});
	}
}
