/**
 * Fibonacci class for lab01 part c
 * @author Onur Ertunc
 * @version
 */
public class Fibonacci {
  public static void main( String[] args ) {
    
    // Variables
    IntBag bag1 = new IntBag();
    
    // Program code
    bag1.add(0);
    bag1.add(1);
    
    for ( int i = 2; i < 40; i++ ) {
      bag1.add( bag1.getValue(i-1) + bag1.getValue(i-2) );
    }
    
    System.out.println( "Fibonacci series first 40 terms: \n" + bag1.toString() );
  }
}
