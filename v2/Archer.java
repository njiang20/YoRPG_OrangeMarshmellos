public class Archer extends Protagonist{
  public Archer() {
    super();
    health = 125;
    strength = 110;
    defense = 40;
    attack = .4;
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
