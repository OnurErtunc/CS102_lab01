import java.util.Arrays;
/**
 * the class IntBag for lab01
 * @author Onur Ertunc
 * @version
 */
public class IntBag {
  
  // Properties
  private int[] bag;
  
  // Constructor
  public IntBag() {
    bag = new int[4];
    bag[0] = -1;
  }
  
  // Methods
  
  public int size() {
    int indexOfLastElement = 0;
    boolean found = false; // will be true when -1 is found
    while ( indexOfLastElement < bag.length && !found ) {
      if ( getValue(indexOfLastElement) != -1 ) {
        indexOfLastElement++;
      }
      else {
        found = true;
      }
    }
    return indexOfLastElement;
  }
  
  /**
   * a method that adds numbers to the array bag
   * @param value
   */
  public void add( int value ) {
    int currentSize = size();
    if ( currentSize < bag.length - 1 ) {
      bag[currentSize] = value;
      bag[currentSize + 1] = -1;
    }
    else {
      bag = Arrays.copyOf( bag, bag.length * 2 );
      bag[currentSize] = value;
      bag[currentSize+1] = -1;
    }
  }
  
  /**
   * this method adds a value to a specific index 
   * @param pos, value
   */
  public boolean add( int value, int pos) {
    
    if ( pos > bag.length - 1 ) {
      System.out.println( "You have enterred an invalid location!" );
      return false;
    }
    else {
      boolean capacity = true;
      int posTracker = 0;
      // This part checks the bag array has a available space
      while ( capacity && posTracker < bag.length - 1 ) {
        if ( bag[posTracker] == -1 ) {
          capacity = false;
        }
        else {
          posTracker++;
        }
      }
      if ( !capacity ) {
        bag = Arrays.copyOf( bag, bag.length * 2 );
      }
      
      // This part moves the values at a specific index to next index
      // and inserts the given value to the given index
      for (int i = posTracker; i >= pos; i-- ) {
        bag[i+1] = bag[i];
      }
      bag[pos] = value;
      bag[posTracker + 1] = -1;
    }
    System.out.println( "Process completed successfully..." );
    return true;
  }
  
  
  /**
   * this method removes an element at given index
   * @param pos
   */
  public void remove( int pos ) {
    bag[pos] = bag[size() -1];
    for ( int i = size() - 1; i < bag.length - 1; i++ ) { 
      bag[i] = bag[i+1];
    }
    bag = Arrays.copyOf( bag, bag.length - 1 );
  }
  
  /**
   * toString method that returns a String representation of the collection
   * @return result
   */
  public String toString() {
    String result = "";
    for ( int i = 0; i <= size() - 1; i++ ) {
      result = result + bag[i];
      if ( i != size() ) {
        result = result + " ";
      }
    }
    return result;
  }
  
  /**
   * a method that returns the number in an specific index
   * @param index
   * @return number
   */
  public int getValue( int index ) {
    return bag[index];
  }
  
  /**
   * this method removes a number from the collection
   * @param value
   */
  public void removeAll( int value ) {
    int[] removed = new int[size()];
    int pos = 0;
    for ( int i = 0; i < size(); i++ ) {
      if ( bag[i] != value ) {
        removed[pos] = bag[i];
        pos++;
      }
    }
    int[] afterRemoved = new int[pos];
    afterRemoved = removed;
    bag = afterRemoved;
    bag = Arrays.copyOf( bag, pos );
  }
}










