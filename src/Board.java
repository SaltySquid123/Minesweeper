public class Board {
    Tile[][] board;
    String[] numEmojis;
    int numOfMines;
    int size;

    public Board(int size, int numOfMines) {
        numEmojis = new String[]{"1️⃣", "2️⃣", "3️⃣", "4️⃣", "5️⃣", "6️⃣", "7️⃣", "8️⃣", "9️⃣", "🔟"};
        this.numOfMines = numOfMines;
        this.size = size;
        board = new Tile[size][size];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = new Tile("⬜");
            }
        }
        for (int x = 0; x < numOfMines; x++) {
            board[getRandRow()][getRandCol()] = new Mine();
        }
    }

    public void printBoard() {
        System.out.print("  ");
        for (String str : numEmojis) {
            System.out.print(str);
        }
        for (int row = 0; row < board.length; row++) {
            System.out.println();
            System.out.print(numEmojis[row]);
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col].getSymbol());
            }
        }
    }

    public String click(int row, int col) {
        int mines = 0;
        if (board[row][col] instanceof Mine) {
            return "mine";
        } else {
            // Check the surrounding 8 boxes, if any are mines then leave them, if tiles then click on them again
            if (validRow(row + 1)){
                if (board[row + 1][col] instanceof Mine){
                    mines ++;
                }
            }
            if (validCol(col + 1)){
                if (board[row][col + 1] instanceof Mine){
                    mines ++;
                }
            }
            if (validRow(row - 1)){
                if (board[row - 1][col] instanceof Mine){
                    mines ++;
                }

            }
            if (validCol(col - 1) && validRow(row - 1)){
                if (board[row - 1][col - 1] instanceof Mine){
                    mines ++;
                }

            }
            if (validCol(col - 1) && validRow(row + 1)){
                if (board[row + 1][col - 1] instanceof Mine){
                    mines ++;
                }

            }
            if (validCol(col + 1) && validRow(row - 1)){
                if (board[row - 1][col + 1] instanceof Mine){
                    mines ++;
                }

            }
            if (validCol(col + 1) && validRow(row + 1)){
                if (board[row + 1][col + 1] instanceof Mine){
                    mines ++;
                }

            }
        }
        System.out.println(mines);
        board[row][col].clickTile(mines);
        return "safe";
    }
    private int getRandRow() {
        return (int) (Math.random() * size);

    }
    private int getRandCol() {
        return (int) (Math.random() * size);
    }
    public int getLength(){
        return board.length;
    }
    public int getLength2(){
        return board[0].length;
    }
    private boolean validRow(int row){
        return (row >= 0 && row < board.length);
    }
    private boolean validCol(int col){
        return (col >= 0 && col < board[0].length);
    }
}
