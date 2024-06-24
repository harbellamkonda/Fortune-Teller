import java.util.Scanner;

class FortuneTeller {
    Scanner scanner = new Scanner(System.in);
    int one, two, three;

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

    void getName() {
        System.out.println("What's your first name?");
        String name = scanner.next();
        one = name.length();
    }

    void getColor() {
        System.out.println("What's your favorite color?");
        String color = scanner.next();
        two = color.length();
    }

    void getFood() {
        System.out.println("What's your favorite food?");
        String food = scanner.next();
        three = food.length();
    }

    void askQuestions() {
        getName();
        getColor();
        getFood();
    }

    void tellFortune() {
        int res = one + two + three;
        res = res % fortunes.length;
        System.out.println("YOUR FORTUNE: " + fortunes[res]);
        checkForFortune();
    }

    void checkForFortune(){
        System.out.println("Would you like to do receive another fortune?");
        String response = scanner.next();
        if (response.toLowerCase().equals("yes")) {
            getName();
            getColor();
            getFood();
            tellFortune();
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
        ft.askQuestions();
        ft.tellFortune();
    }
}