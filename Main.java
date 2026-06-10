//APCSA final project

import java.util.Scanner;

public class Main{
    public static Scanner scan = new Scanner(System.in);
    private static int move;
    public static void main(String args[]) {
        Game g1;
        Methods run = new Methods(); 
        
        System.out.println("\nWelcome to connect 4!");
        
        //create board 
        System.out.println("Would you like to create a custom board? \ny/n...");
        
        String input  = scan.next();
        while (run.yesOrNo(input) == false){
            System.out.println("Would you like to create a custom board? \n\n\ty/n...");
            input = scan.next();
        }
        if (run.ans.equals("yes")){
            System.out.println("You picked yes. Please state the dimensions");
            System.out.println("Number of rows: ");
            int r = scan.nextInt();
            System.out.println("Number of columns: ");
            int c = scan.nextInt();
            
            g1 = new Game(r,c);
        }
        else{
            g1 = new Game();
        }
        
        g1.printBoard();

        System.out.println("Choose a mode pick 1 or 2:");
        System.out.println("Two player \t or \t Play against the computer");
        
        boolean valid = true;
        while (valid){
            int mode = scan.nextInt();
            if(mode == 1){
                g1.setMode(mode);
                System.out.println("you picked 1");
                //
                move = scan.nextInt();
                g1.twoPlayer(move, 1);
                move = scan.nextInt();
                g1.twoPlayer(move, 2);
                g1.printBoard();
                while (g1.matchWon() == false){////////////////////////idk
                    move = scan.nextInt();
                    g1.twoPlayer(move, 1);
                    move = scan.nextInt();
                    g1.twoPlayer(move, 2);
                    g1.printBoard();
                }
                //fix the match logic so that it checks after every turn
                System.out.println("The match is over... Loading results... \nCongradulations! " + g1.getWinner() + " won");

                // valid = false;
            }
            else if (mode == 2){
                g1.setMode(mode);
                System.out.println("you picked 2");
                //
                move = scan.nextInt();
                g1.computer(move);
                g1.printBoard();
                while (g1.matchWon() == false){
                    move = scan.nextInt();
                    g1.computer(move);
                    g1.printBoard();
                }
                //fix
                System.out.println("The match is over... Loading results... \nCongradulations! " + g1.getWinner() + " won");
                // valid = false;
            } 
            else{
                System.out.println("Sorry thats not a valid input. Please enter the number 1 or the number 2");
            }
        }
        
    }
    
}

//