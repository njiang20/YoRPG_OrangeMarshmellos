public class Archer extends Protagonist{
  public Archer() {
    super();
    health = 125;
    strength = 110;
    defense = 40;
    attack = .4;
  }

  public int attack(Character e) {
    calcNewDamage(this);
    if (attackState.equals("specialize")) {
      //System.out.println("Swinging Hammer...");
      int amplifier = (int) (Math.random() * 10);
      if (amplifier > 5) {
        this.health += 20;
        System.out.println("Youg hath used shield of holy powers!");

      } else {
        System.out.println("Youg swung too hard, and bashed thy skull. Ye lost 5 health!");
        lowerHP(5);

      }
    }
    e.lowerHP(this.damage);
    return this.damage;
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
