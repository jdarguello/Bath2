package services;

import Board;
import Column;

public abstract class WinningConditions {

    protected final Board board;

    public WinningConditions() {
        this.board = new Board();
    }

    public Boolean haveYouWon() {
        Column[] columns = (Column[]) board.getColumns();
        return isVertical(columns) || isHorizontal(columns) || isDiagonal(columns);
    }

    private Boolean isVertical(Column[] columns) {
        for (Column column : columns) {   //Iteration per column (vertical analysis)
            char[] stack = column.getStack();
            int count = 0;
            for (int i=1; i<stack.length; i++) {
                count = charCounter(stack[i], stack[i-1], count);
                if (count >= 3) {   //4 of the same char (color) => We have a winner!
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean isHorizontal(Column[] columns) {
        for (int row=0; row<6; row++) {   //Let's analyze row per row!
            int count = 0;
            for (int column = 1; column < 7; column++) {   
                count = charCounter(columns[column-1].getStack()[row], 
                    columns[column].getStack()[row],count);
                if (count >= 3) {   //4 of the same char (color) => We have a winner!
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean isDiagonal(Column[] columns) {
        return isDiagonalUp(columns) || isDiagonalDown(columns);
    }

    private Boolean isDiagonalUp(Column[] columns) {
        for (int i=1; i<7; i++) {       //Row iteration
            int position = 0;   //Diagonal positioner
            int count = 0;
            for (int j=1; j<6; j++) {   //Column iteration
                //Break! -> Reached the limit!
                if (i+position >= 7) {
                    continue;
                }
                count = charCounter(columns[i+position-1].getStack()[j-1], 
                    columns[i+position].getStack()[j], count);

                if (count >= 3) {   //4 of the same char (color) => We have a winner!
                    return true;
                }
                position++;
            }
        }
        return false;
    }

    private Boolean isDiagonalDown(Column[] columns) {
        for (int i=1; i<7; i++) {       //Row iteration
            int position = 0;           //Diagonal positioner
            int count = 0;
            for (int j=5; j>=0; j--) {
                //Break! -> Reached the limit!
                if ((i+position) >= 7 || j <= 0) {
                    continue;
                }
                count = charCounter(columns[i+position-1].getStack()[j], 
                    columns[i+position].getStack()[j-1], count);
                if (count >= 3) {   //4 of the same char (color) => We have a winner!
                    return true;
                }
                position++;
            }
        }
        return false;
    }

    private Integer charCounter (char value1, char value2, Integer count) {
        if (value1 != '\0' && value1 == value2) {
            return count+1;
        }
        return 0;
    }

}
