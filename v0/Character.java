public class Character {
  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
  private int _strength;
  private int _defense;
  private double _attack;
  private int _life;

  public Character() {
    _life = 125;
    _strength = 100;
    _defense = 40;
    _attack = .4;
  }

  public boolean isAlive() {
     return _life > 0;
  }

  public int getDefense() {
    return _defense; }

  public void lowerHP( int damageInflicted ) {
    _life = _life - damageInflicted;
  }

  public int attack( Character opponent ) {
    int damage = (int)( (_strength * _attack) - opponent.getDefense() );
    //System.out.println( "\t\t**DIAG** damage: " + damage );
    if ( damage < 0 )
      damage = 0;
      opponent.lowerHP( damage );
      return damage;
    }//end attack

}
