package fase1;

import java.util.ArrayList;
import java.util.Comparator;

public class Pelicula implements Comparable<Pelicula>{
	String titulo;
	int ano;
	float rating;
	int numVotos;
	ArrayList<Interprete> interpretes;
	
	public Pelicula(String titulo, int ano, float rating, int numVotos) {
		super();
		this.titulo = titulo;
		this.ano = ano;
		this.rating = rating;
		this.numVotos = numVotos;
		this.interpretes = new ArrayList<Interprete>();
	}
	public Pelicula ()
	{
		super();
	}

	public ArrayList<Interprete> getInterpretes() {
		return interpretes;
	}
	public void setInterpretes(ArrayList<Interprete> interpretes) {
		this.interpretes = interpretes;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getNumVotos() {
		return numVotos;
	}

	public void setNumVotos(int numVotos) {
		this.numVotos = numVotos;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getTitulo();
	}
	
	
	public void AnadirVoto (float voto) //anadirVoto 
	{
		if (voto < 0 || voto > 10) { System.out.println("VOTO NO VÁLIDO"); return; }
		if (this.getRating() >= 0) // with valid vote
		{
			this.setRating( (this.getRating() * this.getNumVotos() + voto) / (this.getNumVotos()+1) );
			this.setNumVotos(this.getNumVotos() + 1);
		}
		else // with invalid vote (-1)
		{
			this.setRating( voto );
			this.setNumVotos(1);
		}
		
	}
	
	@Override
	public int compareTo(Pelicula o) {
		  if (  getTitulo().compareTo( o.getTitulo() ) == 1  ) {
		      return 1;
		    }else if (  getTitulo().compareTo( o.getTitulo() ) == -1  ) {
		      return -1;
		    }else {
		      return 0;
		    }
	}	
	public int compareTo(String s) {
		//System.out.println("Comaparar -->  " +  this.getTitulo() + "    CON    " + s + "   =   " + this.getTitulo().compareTo( s ));
		  if (  this.getTitulo().compareTo( s ) > 0  ) {
		      return 1;
		    }else if (  getTitulo().compareTo( s ) < 0  ) {
		      return -1;
		    }else {
		      return 0;
		    }
	}
}
