public class Character {

  protected int health;
  protected int strength;
  protected int defense;
  protected double attack;
  protected String name = "";
  protected int damage;

  public Character() {
    damage = 10;
    health = 125;
    strength = 100;
    defense = 40;
    attack = 0.4;
  }

  public Character(String name) {
      this();
      name = name;
  }

  public String getName() {
    return name;
  }

  public boolean isAlive() {
     return health > 0;
  }

  public int getDefense() {
    return defense; }

  public double getAttack() {
    return attack; }

  public int getHealth() {
    return health; }

  public int getStrength() {
    return strength; }

  public int attack( Character opponent ) {

      int damage = (int)( (strength * attack) - opponent.getDefense() );
      //System.out.println( "\t\t**DIAG** damage: " + damage );

      if ( damage < 0 )
          damage = 0;

      opponent.lowerHP( damage );

      return damage;
  }//end attack

  public void lowerHP( int damageInflicted ) {
      health = health - damageInflicted;
  }

  public void specialize() {
      attack = .75;
      defense = 20;
  }

  //revert to normal mode
  public void normalize() {
      attack = .4;
      defense = 40;
  }

}
