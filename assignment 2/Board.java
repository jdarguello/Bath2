import Column;
import Player;

public class Board implements Screen {
    private Stack[] columns;

    public Board() {
        columns = new Column[7];
        initColumns();
    }

    public Stack[] getColumns() {
        return columns;
    }

    private void initColumns() {
        for (int i=0; i<7; i++) {
            columns[i] = new Column();
        }
    }

    public void setPosition (int position, Player player) throws Exception {
        positionValidations(position);
        columns[position-1].placeCounter(player);
    }

    private void positionValidations(int position) throws Exception {
        if (position <= 0 || position > 7) {
            new Exception("Playable position value should be between 1 and 7!");
        }
    }

    @Override
    public void display() {
        for (int slot=5; slot >=0; slot--) {
            String line = "";
            for (Stack stack : columns) {
                line += stack.printRow(slot) + "  ";
            }
            System.out.println(line);
        }
        System.out.println(" 1    2    3    4    5    6    7");
    }
}
