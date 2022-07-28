import java.util.Scanner;
import java.lang.Math;

public class Main {
    static int method(){
        //look i tried to make a method to make my life easier adn it dont work like that so im gonna cry
        //user's turn
        Scanner input = new Scanner(System.in);

        int card = ((int)(Math.random()*13)); //draws a card
        int j = 0;
        int x = 0;

        //checks for king, queen, jack, ace cases
        switch(card){
            case 1: //ace
                System.out.print("You have pulled an Ace! Would you like it to equal 1 or 11? ");
                while(x == 0){
                    j = input.nextInt();

                    if (j == 1 || j == 11) {
                        System.out.println("Good choice!");
                        card = j;
                        x = 1;
                    } else {
                        System.out.print("That is not a jack...please rechoose...");
                        x = 0;
                    }
                }
                break;
            case 12://queen
                System.out.println("You have pulled Queen! Queens are equivalent to 10.");
                card = 10;
                break;
            case 13://king
                System.out.println("You have pulled a King! Kings are equivalent to 10.");
                card = 10;
                break;
            case 11://jack
                System.out.println("You have pulled a Jack! Jacks are equivalent to 10.");
                card = 10;
                break;
            default://other
                System.out.println("You have pulled a " + card + "!");
        }
        return card;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        int a = 0;

        String yn = "";
        while(a!=1){
            int cardX = method();
            sum += cardX;
            if(sum>=21){    //checks if next move is viable
                a = 1;
            }else{ //checks whether use wants to draw again
                System.out.println("Your current sum is " + sum + ". Would you like to pull again? (type 0 for yes and 1 for no)");
                a = input.nextInt();
            }

        }
        System.out.println("Your sum is " + sum + ". Now it is my turn to go!");
        int sumT = 0;
        int t = 0;
        while(t!=1){
            int cardT = ((int)(Math.random()*51)+1)%13; //draws card
            switch(cardT) {  //checks for cases
                case 1:
                    System.out.println("I drew an Ace");
                    if (sumT < 10) {
                        cardT = 11;
                    } else {
                        cardT = 1;
                    }
                    break;
                case 12:
                    System.out.println("I drew a Queen");
                    cardT = 10;
                    break;
                case 13:
                    System.out.println("I drew a King");
                    cardT = 10;
                    break;
                case 11:
                    System.out.println("I drew a Jack");
                    cardT = 10;
                    break;
                default:
                    System.out.println("I drew a " + cardT);
            }
            sumT += cardT;
            if(sumT<=15){ //if the sum is over 15, the program won't draw again
                t=0;
            }else{
                t=1;
            }
        }
        System.out.println("My sum is " + sumT); //checks for busts
        int b = 0;
        int tb = 0;
        if(sum > 21){
            b = 1;
        }if(sumT > 21){
            tb = 1;
        }
        if(tb==1 && b==1){ //results
            System.out.println("We both busted! Draw!");
        }else if(tb ==1){
            System.out.println("I busted! You win!");
        }else if(b == 1){
            System.out.println("You busted! I win!");
        }else{
            if(sum>sumT){
                System.out.println("Your sum is greater than mine! You win!");
            }else if(sumT>sum){
                System.out.println("My sum is greater than yours! I win!");
            }else if(sumT==sum) {
                System.out.println("We tied!");
            }
        }
    }
}
