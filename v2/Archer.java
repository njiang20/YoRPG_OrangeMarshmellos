public class Archer extends Protagonist{
  public Archer() {
    super();
    health = 125;
    strength = 110;
    defense = 40;
    attack = .4;
  }

  public static String about() {
    return "A sneaky yet sharp marksman who always hits the mark. It harnesses a sturdy bow and a quiver of arrows, ready to venture out into the most dangerous lands. [Strength increased by 10.]";
  }

  public int attack(Character opponent) {

      int damage = (int)( (strength * attack) - opponent.getDefense() );
      //System.out.println( "\t\t**DIAG** damage: " + damage );

      if ( damage < 0 )
          damage = 0;

      opponent.lowerHP( damage );

      return damage;
  }//end attack

}
