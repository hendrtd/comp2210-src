/**
 * Illustrates calls to MazeSearcher.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-03-07
 *
 */
public class MazeSearcherClient {

    private static int[][] maze1 =
                     {
                      {0,   0,  0,  0, -1,},
                      {0,   0, -1, -1, -1,},
                      {0,  -1,  0,  0,  0,},
                      {0,  -1,  0,  0,  0,},
                      {0,  -1,  0,  0,  0,},
                      {-1, -1,  0, -1,  0,},
                     };

    /**
     * Drives execution.
     */
    public static void main(String[] args) {


        // start position
        int x = 0;
        int y = 0;

        // goal position
        int gx = 4;
        int gy = 4;

        System.out.println("/////////////////////////////////////////////");

        MazeSearcher searcher = new MazeSearcher(maze1);
        System.out.print("breadthFirst from " + "(" + x + ", " + y + ") ");
        System.out.println("with goal " + "(" + gx + ", " + gy + ") ");
        System.out.println(searcher);
        searcher.breadthFirst(x, y, gx, gy);
        System.out.println(searcher);
        System.out.println();
        System.out.println();


        System.out.println("/////////////////////////////////////////////");

        searcher = new MazeSearcher(maze1);
        System.out.print("breadthFirstMemory from " + "(" + x + ", " + y + ") ");
        System.out.println("with goal " + "(" + gx + ", " + gy + ") ");
        System.out.println(searcher);
        searcher.breadthFirstMemory(x, y, gx, gy);
        System.out.println(searcher);
        System.out.println();
        System.out.println();


        System.out.println("/////////////////////////////////////////////");

        searcher = new MazeSearcher(maze1);
        System.out.print("depthFirstA from " + "(" + x + ", " + y + ") ");
        System.out.println("with goal " + "(" + gx + ", " + gy + ") ");
        System.out.println(searcher);
        searcher.depthFirstA(x, y, gx, gy);
        System.out.println(searcher);
        System.out.println();
        System.out.println();


        System.out.println("/////////////////////////////////////////////");

        searcher = new MazeSearcher(maze1);
        System.out.print("depthFirstB from " + "(" + x + ", " + y + ") ");
        System.out.println("with goal " + "(" + gx + ", " + gy + ") ");
        System.out.println(searcher);
        searcher.depthFirstB(x, y, gx, gy);
        System.out.println(searcher);
        System.out.println();
        System.out.println();


        System.out.println("/////////////////////////////////////////////");

        searcher = new MazeSearcher(maze1);
        System.out.print("depthFirstC1 from " + "(" + x + ", " + y + ") ");
        System.out.println("with goal " + "(" + gx + ", " + gy + ") ");
        System.out.println(searcher);
        searcher.depthFirstC1(x, y, gx, gy);
        System.out.println(searcher);
        System.out.println();
        System.out.println();


        System.out.println("/////////////////////////////////////////////");

        searcher = new MazeSearcher(maze1);
        System.out.print("depthFirstC2 from " + "(" + x + ", " + y + ") ");
        System.out.println("with goal " + "(" + gx + ", " + gy + ") ");
        System.out.println(searcher);
        searcher.depthFirstC2(x, y, gx, gy);
        System.out.println(searcher);
        System.out.println();
        System.out.println();

        
     }

}
