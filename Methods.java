public class Methods {
    public String ans;
    public Methods(){
        ans = " ";
    }
    public boolean yesOrNo(String in){ // simple yes or no questions    
        if(in.equals("y")){
            ans = "yes";
            return true;
        } 
        else if (in.equals("n")){
            ans = "no";
            return true;
        } 
        if(in.equals("yes")){
            ans = "yes";
            return true;
        } 
        else if (in.equals("n")){
            ans = "no";
            return true;
        }
        else{
            System.out.println("invalid input");
            return false;
        }
    }
    //make a play again method
    public void playAgain(String in){
        
    }
}
