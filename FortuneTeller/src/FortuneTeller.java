import javax.swing.*;
import java.util.Scanner;

/**
 * @class Fortune Teller
 * @brief User provides a number, and a fortune is generated.
 * @author Harshini Bellamkonda
 */
class FortuneTeller {
    Scanner scanner = new Scanner(System.in);
    int num;
    String[] fortunes = {
            "A dubious friend may be an enemy in camouflage.",
            "Your success will astonish everyone.",
            "You will soon be surrounded by good friends and laughter.",
            "Many will travel to hear you speak.",
            "Now is a good time to buy stock.",
            "Physical activity will dramatically improve your outlook today.",
            "Say hello to others. You will have a happier day.",
            "You should be able to undertake and complete anything.",
            "You will be pleasantly surprised tonight.",
            "You will be traveling and coming into a fortune.",
    };


    /**
     * @brief prompts user for number, stores user input in a variable, and returns int form of that variable
     * @return int which is number inputted by user
     */
    int askQuestions() {
        System.out.println("Please enter a number.");
        String num = scanner.next();
        return Integer.parseInt(num);
    }


    /**
     * @brief returns the corresponding fortune
     * @param num which represents the number inputted by the user
     * @return String of the fortune
     */
    String tellFortune(int num) {
        num = num % fortunes.length;
        return fortunes[num];
    }


    /**
     * @brief defines how the fortune is printed to the screen
     * @param fortune to be printed
     */
    void printingOutput(String fortune) {
        System.out.println("YOUR FORTUNE: " + fortune);
    }


    /**
     * @brief checks if the user would like to receive another fortunes, and corresponding actions follow
     */
    void checkForFortune(){
        System.out.println("Would you like to do receive another fortune?");
        String response = scanner.next();
        if (response.toLowerCase().equals("yes")) {
            int number = askQuestions();
            String out = tellFortune(number);
            printingOutput(out);
            checkForFortune();
        }
        else if (response.toLowerCase().equals("no")) {
            System.out.println("Thanks for using the fortune teller!");
        }
        else {
            System.out.println("Please enter a valid response (\"yes\" or \"no\")");
            checkForFortune();
        }
    }
}

class Main {
    public static void main(String[] args) {

        FortuneTeller ft = new FortuneTeller();
        int result = ft.askQuestions();
        String response = ft.tellFortune(result);
        ft.printingOutput(response);
        ft.checkForFortune();
    }
}