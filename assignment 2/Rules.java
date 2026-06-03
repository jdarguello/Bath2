public interface Rules {
    public Boolean haveYouWon();
    public void yourTurn(Player player);
    public void yourTurn(Bot robot);
    public Boolean differentColors(Player player1, Player player2);
}
