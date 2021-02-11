/**
 * Describes the abstract behavior of a disjoint set 
 * (union-find). Ack: Kevin Wayne.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2013-04-24
 *
 */
public interface DisjointSet {
    
    /**
     * combine components containing p and q
     */
    void union(int p, int q);
    
    /**
     * return component id for p
     */
    int find(int p);
    
    /**
     * are p and q in the same component?
     */
    boolean connected(int p, int q);
    
    /**
     * return number of connected components
     */
    int count();
}