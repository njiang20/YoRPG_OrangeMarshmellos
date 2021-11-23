/* public class Monster {
	private boolean isAlive = true;
	public int health = 100;
	private int attack = 10;

	public boolean isAlive() {
		if (health > 0) {
			isAlive = true;
		} else {
			isAlive = false;
		}
		return isAlive;
	}

	public int attack (Protagonist p) {
		p.health -= attack;
		return attack;
	}
}
*/

/*
  class Monster -- Represents random incarnations of
  the adventurer's natural enemy in Ye Olde RPG
**/

public class Monster extends Character{

  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
  private int _hitPts;
  private int _strength;
  private int _defense;
  private double _attack;
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  /**
     default constructor
     pre:  instance vars are declared
     post: initializes instance vars.
  **/
  public Monster() {
    _hitPts = 150;
    _strength = 20 + (int)( Math.random() * 45 ); // [20,65)
    _defense = 20;
    _attack = 1;
  }




}//end class Monster
