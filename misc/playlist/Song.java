/**
 * Song.java
 * Models a musical song.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-08-24
 *
 */
public class Song implements Comparable<Song> {

   // title of the song
   String title;

   // name of the recording artist
   String artist;

   // year the song was released
   int year;

   // running time in seconds
   int duration;

   /** Creates a new Song instance. */
   public Song(String theTitle, String theArtist, int theYear, int theDuration) {
      title = theTitle;
      artist = theArtist;
      year = theYear;
      duration = theDuration;
   }

   /** Returns the title of this Song. */
   public String getTitle() {
      return title;
   }

   /** Returns the recording artist for this Song. */
   public String getArtist() {
      return artist;
   }

   /** Returns the year this Song was recorded. */
   public int getYear() {
      return year;
   }

   /** Returns the duration of this Song in seconds. */
   public int getDuration() {
      return duration;
   }

   /** Plays this Song. */
   public void play() {
      System.out.println(this);
   }

   /** Tests for equality of this Song and the given object. */
   @Override
   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (obj.getClass() != Song.class) {
         return false;
      }
      Song that = (Song) obj;
      return this.title.equals(that.title)
         && this.artist.equals(that.artist);
   }

   /** Defines the natural order for Songs. */
   @Override
   public int compareTo(Song that) {
      int cmp = this.title.compareTo(that.title);
      if (cmp == 0) {
         cmp = this.artist.compareTo(that.artist);
      }
      return cmp;
   }

   /** Returns a string representation of this Song. */
   @Override
   public String toString() {
      return "'" + title + "'"
         + ", " + artist + ", "
         + "(" + year + ")";
   }

}
