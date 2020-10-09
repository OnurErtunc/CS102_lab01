import java.util.Scanner;
/**
 * The test class of IntBag 
 * @author Onur Ertunc
 * @version
 */
public class TestIntBag {
  public static void main( String[] args ) {
    
    // Variables
    Scanner scan = new Scanner( System.in );
    int decision;
    IntBag bag = null;
    
    // Program code
    do {
      System.out.println( "1. Create a new empty collection (any previous values are lost!)" );
      System.out.print( "2. Read a set of positive values into the collection" );
      System.out.println( "(use zero to indicate all values have been entered.)" );
      System.out.println( "3. Print the collection of values." );
      System.out.println( "4. Add a value to the collection of values at a specified location" );
      System.out.println( "5. Remove the value at a specified lovation from the collection of values." );
      System.out.println( "6. Remove all instances of a value within the collection." );
      System.out.print( "7. Quit the program." );
      decision = scan.nextInt();
      
      if ( decision == 1 ) {
        bag = new IntBag();
        System.out.println( "A new empty collection created successfully." );
      }
      
      else if ( decision == 2 ) {
        
        if ( !scan.hasNextInt() ) {
          System.out.println( "Please enter an integer." );
        }
        else {
          System.out.println( "Use zero to indicate all values have been entered." );
          int value = scan.nextInt();
          while ( value != 0 ) {
            if ( value < 0 ) {
              System.out.println( "Please enter a positive integer." );
            }
            else {
              bag.add(value);
              value = scan.nextInt();
            }
          }
        }
      }
      
      else if ( decision == 3 ) {
        System.out.println( "The values in the collection: \n" + bag.toString() );
      }
      
      else if ( decision == 4 ) {
        boolean check = true;
        boolean check2 = false;
        System.out.println( "Press q to return to main menu: " );
        String up = scan.next();
        if ( up.equals("q") ) {
          check = false;
        }
        do {
          System.out.print( "Enter the value and specified location respectively: " );
          int value = scan.nextInt();
          int pos = scan.nextInt();
          if ( bag.add(value, pos) ) {
            check2 = true;
          }
        } while ( !check2 && check );
      }
      
      else if ( decision == 5 ) {
        System.out.println( "Enter the location: " );
        int pos = scan.nextInt();
        bag.remove(pos);
      }
      
      else if ( decision == 6 ) {
        System.out.println( "Enter the value that you want to remove from collection: " );
        int value = scan.nextInt();
        bag.removeAll( value );
      }
      
    } while ( decision != 7 );
    System.out.println( "Goodbye..." );
  }
}





