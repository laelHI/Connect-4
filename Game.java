public class Game{
    private int rows;
    private int cols;
    private int[][] board;
    private static int playerOneWins;
    private static int playerTwoWins;
    private String winner;
    private String mode;
    private int winningNum;
    //creating the game board
    public Game(){
        rows = 6;
        cols = 7;
        playerOneWins = 0;
        playerTwoWins = 0;
        board = new int[rows][cols];
        winningNum = 4;
    }
    public Game(int rowsize, int colsize){
        boolean invalid = true;
        while(invalid){
            rows = rowsize;
            cols = colsize;
            if (rows >= 5 && cols >= 5){
                winningNum = 4;
                invalid = false;
            }
            else if (rows >= 3 && cols >= 3){
                winningNum = 3;
                invalid = false;
            }
            else{
                invalid = true;
                System.out.println("Sorry those dimensions are invalid, try again");
                }   
        }
        board = new int[rows][colsize];
    }
   //setters
    public void setMode(int num){//////////////////change var name
        if (num == 1){
            mode = "two player";
        }
        else if (num == 2){
            mode = "computer";
        }
    }
    //getters
    public int[][] getBoard(){
        return board;
    }
    public int getRows(){
        return rows;
    }    
    public int getCols(){
        return cols;
    }
    public String getWinner(){
        return winner;
    }
    public int getPlayerOneWins(){
        return playerOneWins;
    }    
    public int getPlayerTwoWins(){
        return playerTwoWins;
    }
    //print the board /////////////////////////////////////////////////////////////edit for fun
    public void printBoard(){
        System.out.print("\n\t\t");
        for (int j = 0; j < rows; j++){
            for (int k = 0; k < cols; k++){
                System.out.print(board[j][k] + " ");
            }  
            System.out.print("\n\t\t");
        }
        System.out.println();
    }
    // individual games
    public void dropPiece(int move, int player){
        //looks at the last row to see if there is a value there or no
        for (int j = rows - 1; j >= 0; j--){
            if (board[j][move - 1] == 0){
                board[j][move - 1] = player;
                j = -1; /////////////////could be break but idk if we are allowed 
            }   
        }
    }
    public void computer(){//////////////////edit for the ai
        int compmove = (int)(Math.random() * cols) + 1;
        dropPiece(compmove, 2);
    } 
    public int checkmove(int move){//validate move
        if (!(move > 0 && move <= cols)){ //check if the move is valid (are enough cols and > 0)
            System.out.println("Sorry that move is either out of bounds or invalid, try again");
            return -1;
        }
        if (board[0][move-1] != 0){ //check if the column is full
            System.out.println("Column is full, try placing a piece elsewhere");
            return -1;
        }
        return move;
    }
    
    //check if the match was won 
    public boolean matchWon(){
        boolean won = false;
        //horizontal check
        for (int j = 0; j < rows; j++){
            for (int k = 0; k <= cols - winningNum; k++){
                int piece = board[j][k];
                if (piece != 0){
                    boolean check = true;
                    for (int i = 1; i < winningNum; i++) {
                        if (board[j][k + i] != piece) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        theWinnerIs(piece);
                        return true;
                    }
                }
            }
        }
        //vertical check
        for (int j = 0; j <= rows - winningNum; j++){
            for (int k = 0; k < cols; k++){
                int piece = board[j][k];
                if (piece != 0) {
                    boolean check = true;
                    for (int i = 1; i < winningNum; i++) {
                        if (board[j + i][k] != piece) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        theWinnerIs(piece);
                        return true;
                    }
                }
            }
        }
        //diagonal check (downwards)
        for (int j = 0; j <= rows - winningNum; j++){
            for (int k = 0; k < cols - (winningNum - 1); k++){
                int piece = board[j][k];
                if (piece != 0) {
                boolean check = true;
                for (int i = 1; i < winningNum; i++) {
                    if (board[j + i][k + i] != piece) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    theWinnerIs(piece);
                    return true;
                }
            }
            }
        }
        //diagonal check (upwards)
        for (int j = 0; j <= rows - winningNum; j++){
            for (int k = winningNum - 1; k < cols; k++){
                int piece = board[j][k];
                if (piece != 0) {
                    boolean check = true;
                    for (int i = 1; i < winningNum; i++) {
                        if (board[j + i][k - i] != piece) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        theWinnerIs(piece);
                        return true;
                    }
                }
            }
        }
        if (tie()){
            winner = "No one";
            return true;
        }
        return won;
    }
    //determine the winner 
    public String theWinnerIs(int gamePiece){
        if (gamePiece == 1){
            playerOneWins++;
            winner = "Player One";
        }
        else if (gamePiece == 2 && mode.equals("two player")){
            playerTwoWins++;
            winner = "Player Two";
        }
        else if (gamePiece == 2 && mode.equals("computer")){
            playerTwoWins++;
            winner = "Computer";
        }
        return winner;
    }
    //ties may be added later
    public boolean tie(){
        for (int j = 0; j < cols; j++){
            if (board[0][j] == 0){
                return false;
            }
        }
        return true;
    }
}
