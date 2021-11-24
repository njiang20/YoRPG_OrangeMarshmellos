public class Swordsman extends Protagonist {
	public Swordsman( String name ) {
		super( name );
		defense = 50;
	}


	public static String about() {
		return "\nSwordsman:\nA valiant knight who specializes in the art of the sword. The swordsman wields a powerful blade and shield, confidently striking any enemies in its path. [Defense increased by 10.]\n";
	}
}
