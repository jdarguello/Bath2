import Player;

public class Column implements Stack {
    char[] stack;     //Slots of the column

    public Column () {
        stack = new char[6]; //Initializes with empty slots
    }

    public char[] getStack() {
        return stack;
    }

    @Override
    public void placeCounter(Player player) {
        for (int i=0; i<6; i++) {
            if (stack[i] == '\0' ) {
                stack[i] = player.playerColor();    //Set player's color if empty slot
                return;                             //Break the loop
            }
        }
    }

    @Override
	public String printRow(int position) {
        if (stack[position] == '\0') {
            return "| |";
        }
		return "|" + stack[position] + "|";
	}

    @Override
    public String toString() {
        String lineContent = "";
        for (int i=5; i>=0; i--) {
            lineContent += printRow(i) + "\n";
        }
        return lineContent;
    }
}
