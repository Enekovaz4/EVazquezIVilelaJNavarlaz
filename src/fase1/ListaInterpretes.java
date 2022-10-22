package fase1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ListaInterpretes {
	ArrayList<Interprete> interpretes;

	public ListaInterpretes(ArrayList<Interprete> casts) {
		super();
		this.interpretes = casts;
	}

	public ListaInterpretes() {
		super();
		this.interpretes = new ArrayList<Interprete>();
	}
	
	public ArrayList<Interprete> getInterpretes() {
		return interpretes;
	}

	public void setInterpretes(ArrayList<Interprete> interpretes) {
		this.interpretes = interpretes;
	}

	
	public Interprete getInterprete (String nombre) // buscarInterprete
	{
		int l = 0;
		int r = this.interpretes.size() - 1;
		int m = (int)((l + r) / 2);
		int compare;
		
		//búsqueda dicotómica --> https://es.wikipedia.org/wiki/B%C3%BAsqueda_binaria#Algoritmo:~:text=fuera%20de%20consideraci%C3%B3n.-,Procedimiento,-%5Beditar%5D
		while (l <= r)
		{
			m = (int)((l + r) / 2);
			compare = this.interpretes.get(m).getNombre().compareTo(nombre);
			
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
				return this.interpretes.get(m);
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Lista de Intérpretes :: " + this.interpretes.size();
	}
	
	public void AnadirInterprete(Interprete i)  //anadirInterprete
	{
		this.interpretes.add(i);
		
		// sort casts arraylist by name
		Collections.sort(this.interpretes, new Comparator<Interprete>(){
		    public int compare(Interprete i1, Interprete i2) {
		        return i1.getNombre().compareToIgnoreCase(i2.getNombre());
		    }
		});
		
	}
}
