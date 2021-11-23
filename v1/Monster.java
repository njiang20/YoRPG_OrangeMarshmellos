public class Monster extends Character{
  private int _life;
  private int _strength;
  private int _defense;
  private double _attack;
  /**
     default constructor
     pre:  instance vars are declared
     post: initializes instance vars.
  **/
  public Monster() {
    _life = 150;
    _strength = 20 + (int)( Math.random() * 45 ); // [20,65)
    _defense = 20;
    _attack = 1;
  }




}//end class Monster
