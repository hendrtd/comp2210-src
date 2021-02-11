import java.util.Iterator;

/**
 * PlayListClient.java
 * Provides a client for the PlayList class.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-08-24
 *
 */
public class PlayListClient {

   /** Drives execution. */
   public static void main(String[] args) {

      PlayList music = new PlayList();
      music.add(new Song("Simple Man", "Lynyrd Skynyrd", 1973, 357));
      music.add(new Song("I Still Haven't Found What I'm Looking For", "U2", 1987, 277));
      music.add(new Song("Lost!", "Coldplay", 2008, 235));
      music.add(new Song("California Dreamin'", "The Mamas & The Papas", 1965, 158));
      music.add(new Song("God Only Knows", "The Beach Boys", 1966, 175));
      music.add(new Song("Flirtin' With Disaster", "Molly Hatchet", 1980, 498));

      System.out.println(music + "\n");

      music.play();
      System.out.println("\n");

      music.shuffle();
      for (Song song : music) {
         System.out.println(song);
      }
      System.out.println("\n");

      music.shuffle();
      Iterator<Song> itr = music.iterator();
      while (itr.hasNext()) {
         System.out.println(itr.next());
      }
      System.out.println("\n");

      music.shuffle();
      music.forEach(song -> System.out.println(song));
      System.out.println("\n");

   }
}
