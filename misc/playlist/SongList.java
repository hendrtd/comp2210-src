import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * SongList.java
 * Illustrates iteration and aggregate operations on a List of Songs.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-08-25
 *
 */
public class SongList {

   /** Drives execution. */
   public static void main(String[] args) {

      List<Song> playlist = Arrays.asList(
         new Song("Simple Man", "Lynyrd Skynyrd", 1973, 357),
         new Song("I Still Haven't Found What I'm Looking For", "U2", 1987, 277),
         new Song("Lost!", "Coldplay", 2008, 235),
         new Song("California Dreamin'", "The Mamas & The Papas", 1965, 158),
         new Song("God Only Knows", "The Beach Boys", 1966, 175),
         new Song("Flirtin' With Disaster", "Molly Hatchet", 1980, 498));
      System.out.println(playlist + "\n");

      //////////////////////////////////////////////////////////////
      // Shuffle-play the songs using various iteration patterns. //
      //////////////////////////////////////////////////////////////

      Collections.shuffle(playlist);
      for (Song song : playlist) {
         song.play();
      }
      System.out.println("\n");

      Collections.shuffle(playlist);
      Iterator<Song> itr = playlist.iterator();
      while (itr.hasNext()) {
         itr.next().play();
      }
      System.out.println("\n");

      Collections.shuffle(playlist);
      playlist.forEach(song -> song.play());
      System.out.println("\n");


      /////////////////////////////////////////////////////
      // Use streams and pipelines on the list of songs. //
      /////////////////////////////////////////////////////

      // play only the songs released before 1970
      playlist
         .stream()
         .filter(song -> song.getYear() < 1970)
         .forEach(song -> song.play());

      // list the names of the songs from the 80s
      playlist
         .stream()
         .filter(song -> song.getYear() > 1979 && song.getYear() < 1990)
         .map(Song::getTitle)
         .forEach(title -> System.out.println(title));

      // get the total runtime of playlist
      int runtime = playlist
         .stream()
         .mapToInt(Song::getDuration)
         .sum();
      System.out.println(runtime);
   }
}
