public class Tile {
    private String symbol;
    private String[] numEmojis;
    private boolean opened;
    private int minesTouching;
    public Tile(String symbol){
        numEmojis = new String[]{"1️⃣", "2️⃣", "3️⃣", "4️⃣", "5️⃣", "6️⃣", "7️⃣", "8️⃣", "9️⃣", "🔟"};
       this.symbol = symbol;
       opened = false;
    }
    public String getSymbol() {
        return symbol;
    }
    public void clickTile(int i){
        if (i == 0){
            symbol = "⬛";
        }
        else {
            symbol = numEmojis[i - 1];
        }
        minesTouching = i;
    }
}
