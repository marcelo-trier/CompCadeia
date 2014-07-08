package br.compstring;

public class CompString {
	String A;
	String B;
	int m = 0;
	int n = 0;
	int M[][];
	int[][] trace;
	int custo = 0;

	String formato[] = { "%3d", "%3c" };
	
	public void updateM() {
		for( int i=1; i<M.length; i++ ) {
			M[i][0] = ( int )A.charAt( i-1 );
		}
		
		for( int j=1; j<M[0].length; j++ ) {
			M[0][j] = ( int )B.charAt( j-1 );
		}
	}

	public String toString() {
		String strM = "M = \n";
		String strT = "Trace = (aqui mostra o que foi percorrido para escolha do novo valor)\n";
		
		updateM();
		for( int i=0; i<M.length; i++ ) {
			for( int j=0; j<M[0].length; j++ ) {
				int fid = 0;
				if( i==0 && j!=0 || i!=0 && j==0 )
					fid = 1;
				strM += String.format( formato[ fid ], M[i][j] );
				strT += String.format( formato[ 0 ], trace[i][j] );
			}
			strM += "\n";
			strT += "\n";
		}
		
		return strM + "---------------------\n" + strT;
	}
	public void init( String a, String b ) {
		A = a;
		B = b;
		m = A.length();
		n = B.length();
		if( m==0 || n== 0 )
			return;
		M = new int[ m+1 ][ n+1 ];
		trace = new int[ m+1 ][ n+1 ];
		custo = 0;
		for( int i=0; i<m+1; i++ ) {
			M[i][0] = i;
		}
		for( int j=0; j<n+1; j++ ) {
			M[0][j] = j;
		}
		
	}
	
	public int min( int v1, int v2, int v3 ) {
		int result = 99999;
		if( v1 < result )
			result = v1;
		if( v2 < result )
			result = v2;
		if( v3 < result )
			result = v3;
		return result;
	}

	static int[] add = { 1, 1, 0 };
	
	static int[][] offset = {
			{ -1, 0 },
			{ 0, -1 },
			{ -1, -1 }
	};
	
	public void setMin( int linha, int coluna, int custo ) {
		int result = 99999;
		add[ 2 ] = custo;
		int xResult = 0, yResult = 0;
		for( int i=0; i<offset.length; i++ ) {
				int x = linha + offset[i][0];
				int y = coluna + offset[i][1];
				int valor = M[x][y] + add[i];
				trace[x][y] = 0;
				if( valor < result ) {
					result = valor;
					xResult = x;
					yResult = y;
				}
		}
		
		M[linha][coluna] = result;
		trace[xResult][yResult] = 1;
	}
	
	public void execute() {
		for( int i=1; i<=m; i++ ) {
			for( int j=1; j<=n; j++ ) {
				if( A.charAt( i-1) == B.charAt( j-1 ) ) {
					custo = 0;
				} else {
					custo = 1;
				}
				setMin( i, j, custo );
				//M[i][j] = min( M[i-1][j]+1, M[i][j-1]+1,M[i-1][j-1]+custo);
			}
		}
	}
}
