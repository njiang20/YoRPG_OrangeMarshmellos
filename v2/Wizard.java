public class Wizard extends Protagonist{
	public Wizard( String name ) {
		super( name );
		health = 150;
	}

	public static String about() {
		return "\nWizard:\nA reserved but powerful mage who values knowledge and sacred wisdom. It wields a mystical staff and banishes the world of all that stand in its way. [Health increased by 25.]\n";
	}
}
