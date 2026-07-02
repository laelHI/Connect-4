import java.util.Scanner;
public class Main{
    public static Scanner scan = new Scanner(System.in);
    public static void main(String args[]) {
        boolean playAgain = true;
        
        Game g1;
        Methods run; 
        
        System.out.println("\nWelcome to connect 4!\n");

        while(playAgain){
            //create board and ask for dimensions
            run = new Methods();
            g1 = run.makeGame(scan);

            g1.printBoard();
            
            playAgain = false;

            System.out.println("Choose a mode pick 1 or 2:");
            System.out.println("Two player \t or \t Play against the computer");
            
            int mode = 0;
            while (mode != 1 && mode != 2) {
                System.out.println("Choose a mode pick 1 or 2:");
                mode = scan.nextInt();
            }
            g1.setMode(mode);//edit for letters as well
            if(mode == 1){
                System.out.println("you picked 1");
                                
                while (g1.matchWon() == false){
                    run.play(g1, scan, 2);
                    if (g1.matchWon() == true){
                        break;
                    }
                    if (g1.tie()){
                        break;
                    }
                    run.play(g1, scan, 1);
                }
                System.out.println("The match is over... Loading results... \nCongratulations! " + g1.getWinner() + " won");
                playAgain = run.playAgain(scan, g1);
            }
            else if (mode == 2){
                System.out.println("you picked 2");
                while (g1.matchWon() == false) {
                    run.play(g1, scan, 1);
                    if (g1.matchWon() == true){
                        break;
                    }
                    if (g1.tie()){
                        break;
                    }
                    g1.computer();
                    g1.printBoard();
                    if (g1.matchWon() == true){
                        break;
                    }
                    if (g1.tie()){
                        break;
                    }
                }
                System.out.println("The match is over... Loading results... \nCongratulations! " + g1.getWinner() + " won");
                playAgain = run.playAgain(scan, g1);
            }
            else{
                System.out.println("Sorry thats not a valid input. Please enter the number 1 or the number 2");
            }
        }
    }
}

//