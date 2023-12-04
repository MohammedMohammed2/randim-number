
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random n = new Random();
        while (true){
            System.out.println("welcome and good luck on your guesses! for every right guess you get a new number to guess ");
            /*Generates a number for the player to guess*/
            int i = n.nextInt(100);
            /*variable for the amount of tries it took the player to get the right number*/
            int T = 0;
            System.out.println(Counter(i,T));
        }
    }
    static int Counter(int i , int T) {
        Scanner scan = new Scanner(System.in);
        Random n = new Random();
        i = n.nextInt(100);
        T = 0;
        while (true) {
            System.out.println("guess a number between 0 and 100");
            //everytime the player guesses wrong it increases the number by 1 which displays the amount of tries it took the player to guess it right//
            T++;
            /*variable for the number that the player is going to give as a guess*/
            Number = scan.nextInt();
            if (Number == i) {
                System.out.println("wow you did it");
                System.out.println("it took you" + " " + T + " " + "tries");
                break;
            }
            else if (Number > i) {
                System.out.println("my number is smaller. click enter to try again!");
            }
            else {
                System.out.println("my number is bigger click enter to try again");
            }
        }
        return T;
    }
    private static int Number;
}