package cine;

public class Sala 
{
	private int disp;
	private int dimension;
	private int valor;
	private int[] asientos = new int[dimension];
	public Sala(int dimension, int valor)
	{
		this.valor=valor;
		this.dimension=dimension;
		
	}
	public void setasientos(int [] as)
	{
		asientos=as;
	}
	public void setreservados(int [] aux)
	{
		for(int i=0; i<aux.length;i++)
		{
			asientos[aux[i]-1]=0;
		}
	}
	
	public void setdisponible()
	{
		disp=0;
		for(int i=0;i<getdimension();i++)
		{
			disp=disp+asientos[i];
		}
	}
	public int getdisponible()
	{	
			
			return disp;
	}
	public  int[] getasientos()
	{
			return asientos;
	}
	public int getdimension()
	{
		return dimension;
	}

	public int getValor() 
	{
		return valor;
	}
}

