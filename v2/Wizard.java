public class Wizard extends Protagonist{
	public Wizard() {
		super();
		health = 150;
	}

	public static String about() {
		return "A reserved but powerful mage who values knowledge and sacred wisdom. It wields a mystical staff and banishes the world of all that stand in its way. [Health increased by 25.]";
	}

	public static void main(String[] args) {
		Wizard wiz = new Wizard();
		System.out.println(wiz.health);
		System.out.println(wiz.strength);
		System.out.println(wiz.defense);
		System.out.println(wiz.attack);
		System.out.println(wiz.about());
	}
}
