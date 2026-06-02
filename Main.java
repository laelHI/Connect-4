//APCSA final project

import java.util.Scanner;

public class Main{
    public static Scanner scan = new Scanner(System.in);
    private static int move;
    public static void main(String args[]) {
        
        Game g1;
        Methods run = new Methods(); 
        //int[][] board = g1.getBoard();
        
        System.out.println("\nWelcome to connect 4!");
        
        //create board
        System.out.println("Would you like to create a coustom board? \ny/n...");
        
        String input  = scan.next();
        while (run.yesOrNo(input) == false){
            System.out.println("Would you like to create a coustom board? \n\n\ty/n...");
            input = scan.next();
        }
        if (run.ans.equals("yes")){
            System.out.println("You picked yes. Please state the diminsions");
            System.out.println("Number of rows");
            int r = scan.nextInt();
            System.out.println("Number of columns");
            int c = scan.nextInt();
            
            g1 = new Game(r,c);
        }
        else{
            g1 = new Game();
        }
            g1.printBoard();


        System.out.println("Choose a mode pick 1 or 2:");
        System.out.println("Two player \t or \t Play agianst the computer");
        
        boolean valid = false;
        while (valid == false){ 
            String mode = scan.next();
            if(mode.equals("1")){
                System.out.println("you picked 1");
                move = scan.nextInt();
                g1.twoPlayer(move, 1);
                move = scan.nextInt();
                g1.twoPlayer(move, 2);
                g1.printBoard();

                // valid = true;
            }
            else if (mode.equals("2")){
                System.out.println("you picked 2");
                while (g1.matchWon() == false){
                    move = scan.nextInt();
                    g1.computer(move);
                    g1.printBoard();
                }
                // valid = true;
            } 
            else{
                System.out.println(":(");
            }
        }
        
    }
    
}

//