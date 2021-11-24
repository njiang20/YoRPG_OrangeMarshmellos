public class Goblin extends Monster {

        public Goblin() {
                super();
                health = 100;
                strength = 10 + (int)( Math.random() * 45 );
                defense = 15;
                attack = 0.7;
        }

        public static String about() {
                return "\nGoblin:\nA feisty creature that seems to always be irritated about something. Don't come too close or you might find a club in your face! [Health: 100, Strength: 10, Defense: 15, Attack: 0.7]\n";
        }

}
