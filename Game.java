public class Game{
    private int rows;
    private int cols;
    private int[][] board;
    private static int playerOneWins;
    private static int playerTwoWins;
    private String winner;
    private String mode;
    //creating the game board
    public Game(){
        rows = 6;
        cols = 7;
        playerOneWins = 0;
        playerTwoWins = 0;
        board = new int[rows][cols];
    }
    public Game(int rowsize, int colsize){
        rows = rowsize;
        cols = colsize;
        board = new int[rowsize][colsize];
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
        for (int j = 0; j < rows; j++){
            for (int k = 0; k < cols; k++){
                System.out.print(board[j][k]);
            }  
            System.out.println();
        }
    }
    // individual games
    public void twoPlayer(int move, int player){
        //looks at the last row to see if there is a value there or no
        if (player == 1){
            for (int j = rows - 1; j >= 0; j--){
                if (board[j][move - 1] == 0){
                    board[j][move - 1] = 1;
                    j = -1; /////////////////could be break but idk if we are allowed 
                }   
            }
        }
        else if (player == 2){
            for (int j = rows - 1; j >= 0; j--){
                if (board[j][move - 1] == 0){
                    board[j][move - 1] = 2;

                    j = -1;
                }                
            }
        }
    }
    
    public void computer(int move){
        //usermove
        for (int j = rows - 1; j >= 0; j--){
            if (board[j][move - 1]== 0){
                board[j][move - 1] = 1;
                j = -1;
            }                
        }
        int compmove = (int)(Math.random() * cols) + 1;
        for (int j = rows - 1; j >= 0; j--){
            if (board[j][compmove -1] == 0){
                board[j][compmove -1] = 2;
                j = -1;
            }                
        }
    } 
    
    //check if the match was won 
    public boolean matchWon(){
        boolean won = false;
        for (int j = 0; j < rows; j++){
            for (int k = 0; k < cols - 3; k++){
                if (board[j][k] != 0 && board[j][k] == board[j][k + 1] && board[j][k] == board[j][k + 2] && board[j][k] == board[j][k + 3] ){
                    won = true;
                    theWinnerIs(board[j][k]);
                }
            }
        }
        for (int j = 0; j < rows - 3; j++){
            for (int k = 0; k < cols; k++){
                if (board[j][k] != 0 && board[j][k] == board[j + 1][k] && board[j][k] == board[j + 2][k] && board[j][k] == board[j + 3][k] ){
                    won = true;
                    theWinnerIs(board[j][k]);
                }
            }
        }
        for (int j = 0; j < rows - 3; j++){
            for (int k = 0; k < cols -3; k++){
                if (board[j][k] != 0 && board[j][k] == board[j + 1][k + 1] && board[j][k] == board[j + 2][k + 2] && board[j][k] == board[j + 3][k + 3] ){
                    won = true;
                    theWinnerIs(board[j][k]);
                }
            }
        }
        for (int j = 0; j < rows - 3; j++){
            for (int k = 3; k < cols; k++){
                if (board[j][k] != 0 && board[j][k] == board[j + 1][k - 1] && board[j][k] == board[j + 2][k - 2] && board[j][k] == board[j + 3][k - 3] ){
                    won = true;
                    theWinnerIs(board[j][k]);
                }
            }
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
}
