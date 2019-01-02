package classu;

public class Calculer {
	
	public int somme(int a,int b) {
		if(a>b)
			throw new IllegalArgumentException("Erreur a>b");
		else
			return a+b;
	}
	

}
