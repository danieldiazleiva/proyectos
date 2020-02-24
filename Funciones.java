package cine;

import java.util.Scanner;

public class Funciones 
{
	static Scanner read = new Scanner(System.in);
	
	
	public void impsala(int dimension, int [] asientos) 
	{
		
		int k=1;
		for (int i=0;i<5;i++) {
			for (int j=0;j<dimension/5;j++) 
			{
				if (asientos[k-1]==1) 
				{
					if (k<10) 
					{
						System.out.print(" "+k+" - ");
					} else {
						System.out.print(k+" - ");
					}
				}
				if (asientos[k-1]==0) 
				{
					System.out.print("XX - ");
				}
				k = k+1;
			}
			System.out.println("");
		}
	}

	public  double recaudacion(int tarifa, int valent, int entni, int entad) 
	{
		double total=0;
	
		if (tarifa==1) 
		{
			System.out.println("total entradas:");
			System.out.println(entni+" entradas niños: "+entni*valent*8/10);
			System.out.println(entad+" entradas adultos: "+entad*valent);
			total = entad*valent+entni*valent*8/10;
			System.out.println("total a pagar: "+total);
		}
		if (tarifa==2) 
		{
			System.out.println("total entradas:");
			System.out.println(entni+" entradas niños: "+entni*valent*104/100);
			System.out.println(entad+" entradas adultos: "+entad*valent*13/10);
			total = entad*valent*13/10+entni*valent*104/100;
			System.out.println("total a pagar: "+total);
		}
		return total;
		
	}

	public int [] reserva(int entad, int entni, int [] asientos, int dimension)
	{	
		int [] aux = new int[entni+entad];
		int a=0;
		int z;
		
		linea();
		while (a<entad+entni) 
		{
			
		
			System.out.println("ELIJA UN ASIENTO");
			System.out.println();
			System.out.println();
			impsala(dimension, asientos);
					z = read.nextInt();
					System.out.println(""); 
					if (asientos[z-1]==1) 
					{
						aux[a]=z;
						asientos[z-1] = 0;
						a = a+1;	
						linea();

					} 
					else 
					{
						linea();
						System.out.println("ASIENTO OCUPADO");
						System.out.println();
					}
		}

		impsala(dimension, asientos);
		linea();
		return aux;
		
}
public void linea()
{
		System.out.println("");
		System.out.println("");
		System.out.println("=======================================================================================================");
		System.out.println("");
		System.out.println("");
}
}
