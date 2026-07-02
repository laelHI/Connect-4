import java.util.Scanner;

public class Methods {
    public static boolean yesOrNo = false;
    public String ans;
    public Methods(){
        ans = " ";
    }
    public boolean yesOrNo(String in){ // simple yes or no questions
        if(in.equals("y")){
            ans = "yes";
            yesOrNo = true;
            return yesOrNo;
        } 
        else if (in.equals("n")){
            ans = "no";
            yesOrNo = true;
            return yesOrNo;
        } 
        if(in.equals("yes")){
            ans = "yes";
            yesOrNo = true;
            return yesOrNo;
        } 
        else if (in.equals("n")){
            ans = "no";
            yesOrNo = true;
            return yesOrNo;
        }
        else{
            System.out.println("invalid input");
            yesOrNo = false;
            return yesOrNo;
        }
    }
    //make a play again method
    public boolean playAgain(Scanner scan, Game g1){
        yesOrNo = false;
        String answer;
        while (yesOrNo == false){
            System.out.println("Would you like to play again? \n\n\ty/n...\n");
            answer = scan.next();
            yesOrNo(answer);
        }
        if (ans.equals("yes")){
            return true;
        }
        else{
            System.out.println("Thanks for playing!");
            return false;
        }
    }
    public boolean checkDimensions(int r, int c){
        if(r >= 3 && c >= 3){
            return true;
        }
        else{
            System.out.println("Sorry those dimensions are invalid, try again");
            return false;
        }
    }
    public void play(Game g1, Scanner scan, int player){
        System.out.println("Player " + player + " enter a column number to drop your piece on the board");
        int move = scan.nextInt();
        while (g1.checkmove(move) == -1) {
            move = scan.nextInt();
        }
        g1.dropPiece(move, player);
        g1.printBoard();
    }
    
    public Game makeGame(Scanner scan){
        yesOrNo = false;
        Game g1;
        String input;
        while (yesOrNo == false){
                System.out.println("Would you like to create a custom board? \n\n\ty/n...\n");
                input = scan.next();
                yesOrNo(input);

            }

            if (ans.equals("yes")){
                System.out.println("You picked yes. Please state the dimensions");
                int row = scan.nextInt();
                int col = scan.nextInt();
                
                while (checkDimensions(row, col) == false){
                    System.out.println("Sorry those dimensions are invalid, try again");
                    row = scan.nextInt();
                    col = scan.nextInt();
                }
                
                g1 = new Game(row, col);
                return g1;
            }
            else{
                System.out.println("You picked no. Starting with default board...");
                g1 = new Game();
                return g1;
            }
    }
}