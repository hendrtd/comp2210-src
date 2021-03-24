

/**
 * Models a position in a two-dimensional square grid.
 * A position holds content of type variable T.
 */
public class GridPosition<T> {

    private T content;
    private int row;
    private int col;
    private int rowMajor;
    private int colMajor;

    public GridPosition(T content, int row, int col) {
        this.content = content;
        this.row = row;
        this.col = col;

    }

}
