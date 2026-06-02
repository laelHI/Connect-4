public class Game{
    private int rows;
    private int cols;
    private int[][] board;
    private int playerOneWins;
    private int playerTwoWins;
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
    public int[][] getBoard(){
        return board;
    }
    public int getRows(){
        return rows;
    }    
    public int getCols(){
        return cols;
    }
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
        System.out.println("you picked 2");
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
        //System.out.println("")
        //code and stuff
        //for (int j = 0; j < rows; j++){
        //    for (int k = 0; k < cols; k++)
    }
    
    public boolean matchWon(){ // ts does NOT work :(
        boolean won = false;
        for (int j = 0; j < rows; j++){
            for (int k = 0; k < cols; k++){
                if (board[j][k] == board[j][k + 1] && board[j][k] == board[j][k + 2] && board[j][k] == board[j][k + 3] ){
                    won = true;
                    if (board[j][k] == 1){
                        playerOneWins++;
                    }
                    else if (board[j][k] == 2){
                        playerTwoWins++;
                    }
                }
                else if (board[j][k] == board[j + 1][k] && board[j][k] == board[j + 2][k] && board[j][k] == board[j + 3][k] ){
                    won = true;
                    if (board[j][k] == 1){
                        playerOneWins++;
                    }
                    else if (board[j][k] == 2){
                        playerTwoWins++;
                    }
                }/* 
                else if ((board[j][k] == board[j + 1][k] + 1 && board[j][k] == board[j + 2][k + 2] && board[j][k] == board[j + 3][k + 3] )){
                    won = true;
                    if (board[j][k] == 1){
                        playerOneWins++;
                    }
                    else if (board[j][k] == 2){
                        playerTwoWins++;
                    }
                }   */
            }
        }
        return won;
    }
    
}

