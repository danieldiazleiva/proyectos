 package cine;

import java.util.Scanner;

public class Entradas 
{
	
	static Scanner read = new Scanner(System.in);
	public static void main(String[] args) 
	{
		
		int entni=0;
		int entad=0;
		/*int t=1;*/
		int tiposala=0;
		double totaldia=0;
		int horario=0;
		int disp=0;
		Sala [] sala= new Sala[4];
		sala[0] = new Sala_2d(40,2000);
		sala[1] = new Sala_3d(35,3000);
		sala[2] = new Sala_4dx(30,7000);
		sala[3] = new Sala_imax(40,5000);
		Funciones fun = new Funciones();
		for(int i=0;i<4;i++)
		{
			int [] as = new int[sala[i].getdimension()];
			for(int j=0;j<as.length;j++)
			{
				as[j]=1;
			}
			sala[i].setasientos(as);
		}
		int op=0;	
	while(op<=2)
	{	
		int valid = 0;
		int valid2 = 0;
		while (valid==0) 
		{
		
			System.out.println("MENU");
			System.out.println("");
			System.out.println("ELIJA UNA OPCIÓN");
			System.out.println("");
			System.out.println("1.- Realizar venta");
			System.out.println("2.- obtener recaudacion total del dia");
			System.out.println("3.- salir");
			op=read.nextInt();
			fun.linea();
			/*if (op==2 && t==1) 
			{
				System.out.println("NO CUMPLE VENTAS MÍNIMAS DIARIAS");
				System.out.println("");
			}*/
			if (op>3 && op<0) 
			{
				System.out.println("ESTA OPCIÓN NO EXISTE");
				fun.linea();
			}
			if (op==1 || op==3) 
			{
				valid = 1;
			}
			if (op==2) 
			{
				System.out.println("EL TOTAL RECAUDADO ES: "+totaldia);
				fun.linea();
			}
		}
		if (op==1) 
		{ 
			while (valid==1) 
			{
				System.out.println("DETERMINE LA TARIFA DE COBRO");
				System.out.println("");
				System.out.println("1.- mañana");
				System.out.println("2.- tarde");
				horario=read.nextInt();
				fun.linea(); 
				if (horario>3 || horario<0)
				{
					System.out.println("ESTA OPCIÓN NO ES VÁLIDA");
					fun.linea();
				}
				 else 
				{
					valid = 0;
				}

			}


			while (valid2==0) 
			{
				while (valid==0) 
				{
					System.out.println("ELIA UNA SALA");
					System.out.println("");
					System.out.println("1.- SALA 2D");
					System.out.println("VALOR ENTRADA: 2000");
					System.out.println("");
					System.out.println("2.- SALA 3D");
					System.out.println("VALOR ENTRADA: 3000");
					System.out.println("");
					System.out.println("3.- SALA 4DX");
					System.out.println("VALOR ENTRADA: 7000");
					System.out.println("");
					System.out.println("4.- SALA IMAX");
					System.out.println("VALOR ENTRADA: 5000");
					tiposala = read.nextInt()-1;
					fun.linea();
					if (tiposala>3 || tiposala<0) 
					{
						System.out.println("ESTA SALA NO EXISTE");
						fun.linea();
					}
					else
					{
						sala[tiposala].setdisponible();
						disp=sala[tiposala].getdisponible();
						valid=1;
					}
				}
				while(valid==1 && valid2==0)
				{
					System.out.println("ingrese cantidad de entradas niños");
					entni =read.nextInt();
					fun.linea();
					if (entni>=0) 
					{
						System.out.println("ingrese cantidad de entradas adultos");
						entad = read.nextInt();
						if (entad>=0) 
						{
							if(disp<entni+entad)
							{
								valid = 0;
								System.out.println("NO QUEDAN SUFICIENTES ASIENTOS DISPONIBLES");
								System.out.println("ELIJA OTRA SALA");
								fun.linea();
							} 
							else 
							{
								valid2 = 1;
								valid = 1;
								int [] as = new int[entad+entni];
								as= fun.reserva(entad, entni,sala[tiposala].getasientos(), sala[tiposala].getdimension());
								totaldia=totaldia+fun.recaudacion(horario, sala[tiposala].getValor(), entni, entad);
								sala[tiposala].setreservados(as);
								fun.linea();
								
							}
					
						}
						else 
						{
							System.out.println("error de ingreso");
							fun.linea();
							
						}
					}
					else
					{
						System.out.println("error de ingreso");
						fun.linea();
					}
					
				}
			}
	
	}//fin si (op==1)
		
	

	}
}
}


