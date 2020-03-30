import java.util.Arrays;

/**
 *  CLASS CHUNKTEST
 */
public class ChunkTest {

   public static final int CHUNK_SIZE = 9;         // set this to the size you want

  /**
   *  helper method to display array contents using Arrays class method
   */
   public void toArray( int[] d ) {
      System.out.println( "Array contents: " + Arrays.toString( d ) );
   }

  /**
   *  method to "chunkify" a string of digits into an array of ints
   */
   public int[] makeChunks( String value, int chunkSize ) {

      int   chunkCount = (value.length() / chunkSize) + 1;
      int[] numRep = new int[chunkCount];
      int   index = 0;

      int   end   = value.length();
      int   start = (value.length()) - chunkSize;

      for( int i = value.length(); i >= 0; i -= chunkSize ) {
         numRep[index] = Integer.parseInt( value.substring( start, end ) );
         start -= chunkSize;
         end -= chunkSize;
         index++;
         if( 0 == end ) {
            break;            // handles even boundary
         } else if( 0 > start ) {
            start = 0;
         }
      }
      toArray( numRep );  System.out.println("");
      return numRep;

   }

  /**
   *  test main to check it all out
   */
   public static void main( String [] args ) {

      ChunkTest c = new ChunkTest();

     /**
      *  call the makeChunks() with several numbers to test it
      */

      //                       1111111111222222222233
      //             01234567890123456789012345678901
      c.makeChunks( "333333333222222222111111111", CHUNK_SIZE );
      c.makeChunks( "4333333333222222222111111111", CHUNK_SIZE );
      c.makeChunks( "44333333333222222222111111111", CHUNK_SIZE );
      c.makeChunks( "44444333333333222222222111111111", CHUNK_SIZE );

   }

}

