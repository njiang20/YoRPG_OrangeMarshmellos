public class Archer extends Protagonist{
  public Archer( String name ) {
    super( name );
    strength = 110;
  }

  public static String about() {
    return "\nArcher:\nA sneaky yet sharp marksman who always hits the mark. It harnesses a sturdy bow and a quiver of arrows, ready to venture out into the most dangerous lands. [Strength increased by 10.]\n";
  }

}
