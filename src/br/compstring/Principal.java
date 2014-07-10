package br.compstring;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
//		String A = "antologia";
//		String B = "ontologico";
		String A = "instituto";
		String B = "instituição";
		Scanner teclado;
		teclado = new Scanner( System.in );
		System.out.print( "String A: " );
		A = teclado.nextLine();
		System.out.print( "String B: " );
		B = teclado.nextLine();
		CompString cs = new CompString();
		cs.init( A, B );
		cs.execute();
		System.out.println( cs );
		teclado.close();
	}

}
