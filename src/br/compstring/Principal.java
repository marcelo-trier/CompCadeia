package br.compstring;

public class Principal {

	public static void main(String[] args) {
//		String A = "antologia";
//		String B = "ontologico";
		String A = "instituto";
		String B = "instituição";
		CompString cs = new CompString();
		cs.init( A, B );
		cs.execute();
		System.out.println( cs );
	}

}
