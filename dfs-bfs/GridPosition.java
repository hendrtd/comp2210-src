

/**
 * Models a position in a two-dimensional square grid.
 * A position holds content of type variable T.
 */
public class GridPosition<T> {

    private T content;
    private int rowMajor;

    public GridPosition(T content, int row, int col) {
        this.content = content;
        this.row = row;
    }

}
