public class Slime extends Monster {

        public Slime() {
                super();
                health = 70;
		strength = 5 + (int)( Math.random() * 45 );
		defense = 10;
		attack = 0.5;
        }

        public static String about() {
                return "\nSlime:\nA cute, transparent blob of slime that follows other entities around. Be careful though...if you feed them too much, they might grow even bigger than you! [Health: 70, Strength: 5, Defense: 10, Attack: 0.5]\n";
        }

}
