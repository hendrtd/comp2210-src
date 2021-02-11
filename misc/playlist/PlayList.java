import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * PlayList.java
 * Models a playlist of music.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-08-24
 *
 */
public class PlayList implements Iterable<Song> {

   // List of songs in this PlayList
   List<Song> list;

   /** Creates a new PlayList instance. */
   public PlayList() {
      list = new ArrayList<>();
   }

   /** Adds the specified Song to this PlayList. */
   public void add(Song song) {
      list.add(song);
   }

   /** Removes the specified Song from this PlayList. */
   public void remove(Song song) {
      while (list.remove(song)) {
      }
   }

   /** Randomize the order of the Songs in this PlayList. */
   public void shuffle() {
      Collections.shuffle(list);
   }

   /** Play all the Songs in this PlayList in the current order. */
   public void play() {
      list.forEach(song -> song.play());
   }

   /** Provides an Iterator over the Songs in this Playlist. */
   @Override
   public Iterator<Song> iterator() {
      return list.iterator();
   }

   /** Returns a String representation of this PlayList. */
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      list.forEach(song -> sb.append(song.toString() + "\n"));
      return sb.toString();
   }
}

