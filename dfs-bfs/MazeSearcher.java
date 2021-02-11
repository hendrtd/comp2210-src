import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Uses breadth-first search and depth-first search to solve a maze.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-03-07
 *
 */
public class MazeSearcher {

    // open and closed markers
    private static final int OPEN = 0;
    private static final int CLOSED = -1;

    // the maze
    private int[][] maze;

    // visited positions in the maze
    private boolean[][] visited;

    // dimensions of the maze
    private int numRows;
    private int numCols;

    // number of neighbors, degrees of motion
    private final int MAX_NEIGHBORS = 8;

    // goal position of the search
    private Position goalPosition;

    // the order in which cells are explored
    private int order;

    /**
     * Construct a new MazeSearcher object initialized
     * with a default open maze.
     */
    public MazeSearcher() {
        this(new int[][]{{0,0},{0,0}});
    }

    /**
     * Construct a new MazeSearcher object initialized
     * with the given maze specification.
     */
    public MazeSearcher(int[][] grid) {
        // initialize maze dimensions
        numRows = grid.length;
        numCols = grid[0].length;
        // initialize maze with values in grid
        maze = new int[numRows][numCols];
        int x = 0;
        for (int[] row : grid) {
            int y = 0;
            for (int entry : row) {
                maze[x][y] = entry;
                y++;
            }
            x++;
        }
        // initialize visited to false
        markAllUnvisited();
    }

    /**
     * Initializes visited to false.
     */
    public void markAllUnvisited() {
        visited = new boolean[numRows][numCols];
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }

    }


    /**
     * Returns a string representation of the current maze.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int fieldWidth = 4;
        for (int i = 0; i < fieldWidth * numRows; i++) {
            sb.append("*");
        }
        sb.append("\n");
        for (int[] row : maze) {
            for (int entry : row) {
                sb.append(String.format("%" + fieldWidth + "d", entry));
            }
            sb.append("\n");
        }
        for (int i = 0; i < fieldWidth * numRows; i++) {
            sb.append("*");
        }
        sb.append("\n");
        return sb.toString();
    }


    /////////////////////////////////////////////////////////////////////////////////////
    // Breadth-first and depth-first pair; almost identical except for queue v. stack. //
    /////////////////////////////////////////////////////////////////////////////////////

    /**
     * Starts breadth-first search at (x, y) with goal position (gx, gy).
     */
    public void breadthFirst(int x, int y, int gx, int gy) {
        markAllUnvisited();
        Position start = new Position(x, y);
        goalPosition = new Position(gx, gy);
        if (isValid(start)) {
            order = 1;
            bfs(start);
        }
    }

    /**
     * Search the current maze using breadth-first search. This algorithm is
     * almost identical to the depth-first search below. The only differences
     * are the use of a queue v. stack and the order in which positions are
     * processed.
     */
    private void bfs(Position start) {
        Deque<Position> queue = new ArrayDeque<>();
        visit(start);
        if (process(start)) {
            return;
        }
        queue.addLast(start);
        while (!queue.isEmpty()) {
            Position position = queue.removeFirst();
            for (Position neighbor : position.neighbors()) {
                if (!isVisited(neighbor)) {
                    visit(neighbor);
                    if (process(neighbor)) {
                        return;
                    }
                    queue.addLast(neighbor);
                }
            }
        }
    }

    /**
     * Initializes all to unvisited and launches a depth-first
     * search in the current maze starting at position (x, y)
     * with goal position (gx, gy).
     */
    public void depthFirstA(int x, int y, int gx, int gy) {
        markAllUnvisited();
        Position start = new Position(x, y);
        goalPosition = new Position(gx, gy);
        if (isValid(start)) {
            order = 1;
            dfsIterativeA(start);
        }
    }

    /**
     * Perform a depth-first traversal on maze starting from the given
     * position. This algorithm is almost identical to the breadth-first search
     * above. The only differences are the use of a queue v. stack and the
     * order in which positions are processed.
     */
    private void dfsIterativeA(Position start) {
        Deque<Position> stack = new ArrayDeque<>();
        visit(start);
        stack.addFirst(start);
        while (!stack.isEmpty()) {
            Position position = stack.removeFirst();
            if (process(position)) {
                return;
            }
            for (Position neighbor : position.neighbors()) {
                if (!isVisited(neighbor)) {
                    visit(neighbor);
                    stack.addFirst(neighbor);
                }
            }
        }
    }


    //////////////////////////////////////
    // Breadth-first search with memory //
    //////////////////////////////////////

    /**
     * Initializes all to unvisited and launches a breadth-first
     * search in the current maze starting at position (x,y)
     * with goal position (gx, gy).
     */
    public void breadthFirstMemory(int x, int y, int gx, int gy) {
        markAllUnvisited();
        Position start = new Position(x, y);
        goalPosition = new Position(gx, gy);
        if (isValid(start)) {
            order = 1;
            bfsMemory(start);
        }
    }

    /**
     * Search the current maze using breadth-first search. This algorithm is
     * identical to the breadth-first search above, except for the addition of
     * memory. Positions are added to the queue wrapped in a node, which is linked
     * to a node containing the position's immediately preceeding neighbor; that is,
     * the neighbor responsible for having this position added to the queue.
     */
    private void bfsMemory(Position start) {
        Deque<Node> queue = new ArrayDeque<>();
        visit(start);
        if (process(start)) {
            return;
        }
        queue.addLast(new Node(start, null));
        while (!queue.isEmpty()) {
            Node n = queue.removeFirst();
            Position position = n.position;
            for (Position neighbor : position.neighbors()) {
                if (!isVisited(neighbor)) {
                    visit(neighbor);
                    if (process(neighbor)) {
                        return;
                    }
                    queue.addLast(new Node(neighbor, n));
                }
            }
        }
    }


    /**
     * Constructs a node for linking positions together.
     */
    private class Node {
        Position position;
        Node predecessor;

        public Node(Position p, Node pred) {
            position = p;
            predecessor = pred;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////
    // Depth-first - depth-first pair; one is recursive, one iterative; same ordering //
    ////////////////////////////////////////////////////////////////////////////////////


    /**
     * Initializes all to unvisited and launches a depth-first
     * search in the current maze starting at position (x,y)
     * with goal position (gx, gy).
     */
    public void depthFirstB(int x, int y, int gx, int gy) {
        markAllUnvisited();
        Position start = new Position(x, y);
        goalPosition = new Position(gx, gy);
        if (isValid(start)) {
            order = 1;
            dfsIterativeB(start);
        }
    }


    /**
     * Perform a depth-first search/traversal on the current maze starting from
     * the given position. This algorithm is the one most closely associated
     * with "depth-first search with backtracking" as used in most writings.
     * This algorithm exhibits exactly the same search ordering as the
     * recursive versions below.
     */
    private void dfsIterativeB(Position start) {
        Deque<Position> stack = new ArrayDeque<>();
        visit(start);
        if (process(start)) {
            return;
        }
        stack.addFirst(start);
        while (!stack.isEmpty()) {
            Position position = stack.peekFirst();
            Position neighbor = getFirstUnvisited(position.neighbors());
            if (neighbor != null) {
                stack.addFirst(neighbor);
                visit(neighbor);
                if (process(neighbor)) {
                    return;
                }
            }
            else {
                stack.removeFirst();
            }
        }
    }

    /** Returns the first of the given positions that has not been visited. */
    private Position getFirstUnvisited(Position[] positions) {
        for (Position position : positions) {
            if (!isVisited(position)) {
                return position;
            }
        }
        return null;
    }

    /**
     * Initializes all to unvisited and launches a depth-first
     * search in the current maze starting at position (x,y)
     * with goal position (gx, gy).
     */
    public void depthFirstC1(int x, int y, int gx, int gy) {
        markAllUnvisited();
        Position start = new Position(x, y);
        goalPosition = new Position(gx, gy);
        if (isValid(start)) {
            order = 1;
            dfsRecursive1(start);
        }
    }

    /**
     * Perform a depth-first traversal on maze starting from the given
     * position. This algorithm is the one most closely associated with
     * "depth-first search with backtracking" as used in most writings. This
     * algorithm exhibits exactly the same search ordering as the iterative
     * version above.
     */
    private boolean dfsRecursive1(Position position) {
        visit(position);
        if (process(position)) {
            return true;
        }
        for (Position neighbor : position.neighbors()) {
            if (!isVisited(neighbor)) {
                return dfsRecursive1(neighbor);
            }
        }
        return false;
    }

    /**
     * Initializes all to unvisited and launches a depth-first
     * search in the current maze starting at position (x,y)
     * with goal position (gx, gy).
     */
    public void depthFirstC2(int x, int y, int gx, int gy) {
        markAllUnvisited();
        Position start = new Position(x, y);
        goalPosition = new Position(gx, gy);
        if (isValid(start)) {
            order = 1;
            dfsRecursive2(start);
        }
    }

    /**
     * Perform a depth-first traversal on maze starting from the given
     * position. This algorithm is the one most closely associated with
     * "depth-first search with backtracking" as used in most writings. This
     * algorithm exhibits exactly the same search ordering as the iterative
     * version above.
     */
    private boolean dfsRecursive2(Position position) {
        if (isVisited(position)) {
            return false;
        }
        visit(position);
        if (process(position)) {
            return true;
        }
        for (Position neighbor : position.neighbors()) {
            return dfsRecursive2(neighbor);
        }
        return false;
    }



    ///////////////////////////////////////////
    // Position class and associated methods //
    ///////////////////////////////////////////

    /**
     * Models an (x,y) position in the maze.
     */
    private class Position {
        int x;
        int y;

        /** Constructs a Position with coordinates (x,y). */
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /** Returns a string representation of this Position. */
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }

        /** Returns true if this Position equals the given object. */
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (obj.getClass() != this.getClass()) {
                return false;
            }
            Position other = (Position) obj;
            return this.x == other.x && this.y == other.y;
        }

        /** Returns all the neighbors of this Position. */
        public Position[] neighbors() {
            Position[] nbrs = new Position[MAX_NEIGHBORS];
            int count = 0;
            Position p;
            // generate all eight neighbor positions
            // add to return value if valid
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (!((i == 0) && (j == 0))) {
                        p = new Position(x + i, y + j);
                        if (isValid(p)) {
                            nbrs[count++] = p;
                        }
                    }
                }
            }
            return Arrays.copyOf(nbrs, count);
        }
    }

    /**
     * Is this position valid in the search area?
     */
    private boolean isValid(Position p) {
        return (p.x >= 0) && (p.x < numRows) && 
               (p.y >= 0) && (p.y < numCols) &&
               maze[p.x][p.y] == OPEN;
    }

    /**
     * Has this valid position been visited?
     */
    private boolean isVisited(Position p) {
        return visited[p.x][p.y];
    }

    /**
     * Mark this valid position as having been visited.
     */
    private void visit(Position p) {
        visited[p.x][p.y] = true;
    }

    /**
     * Process this valid position.
     */
    private boolean process(Position p) {
        maze[p.x][p.y] = order++;
        return p.equals(goalPosition);
    }

}
