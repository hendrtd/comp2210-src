import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * LabExample.java
 * Provides an example for a lab on iterators.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-08-25
 *
 */
public class LabExample {

   /** Drives execution. */
   public static void main(String[] args) {

      ArrayList<Song> playlist = new ArrayList<>();
      playlist.add(new Song("Simple Man", "Lynyrd Skynyrd", 1973, 357));
      playlist.add(new Song("I Still Haven't Found What I'm Looking For", "U2", 1987, 277));
      playlist.add(new Song("Lost!", "Coldplay", 2008, 235));
      playlist.add(new Song("California Dreamin'", "The Mamas & The Papas", 1965, 158));
      playlist.add(new Song("God Only Knows", "The Beach Boys", 1966, 175));
      playlist.add(new Song("Flirtin' With Disaster", "Molly Hatchet", 1980, 498));
      System.out.println(playlist + "\n");

      for (Song song : playlist) {
         song.play();
      }
      System.out.println("\n");

      Iterator<Song> itr = playlist.iterator();
      while (itr.hasNext()) {
         itr.next().play();
      }
      System.out.println("\n");

      playlist.forEach(song -> song.play());
      System.out.println("\n");

   }
}
