/**
 * LinkedBagClient.java
 * Provides a sample client of Bag behavior from
 * the LinkedBag class.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-09-26
 *
 */
public class LinkedBagClient {
   /** Drives execution. */
   public static void main(String[] args) {
      Bag<Integer> bag = new LinkedBag<>();
      for (int i = 0; i < 10; i++) {
         bag.add(i);
      }
      System.out.println(bag);
   }
}
