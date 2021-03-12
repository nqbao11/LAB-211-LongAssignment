package View;

import Util.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static boolean checkYNChoice() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                String choice = sc.nextLine();
                if (!(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n"))) {
                    throw new Exception("\nPlease enter Y for Yes or N for No!!");
                }
                return choice.equalsIgnoreCase("y");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true)
            try {
                System.out.println("\n\n=========TEXT NORMALIZATION=========");

                System.out.print("Enter path to file need normalize: ");
                String pathToInput = sc.nextLine();

                Normalize nm = new Normalize(pathToInput); //"src/Example/Input.txt" for test

                nm.normalize();

                System.out.print("Enter path to file save output: ");
                String pathToOutput = sc.nextLine();

                nm.export(pathToOutput); //"src/Example/Output.txt" for test
                break;
            } catch (IOException e) {
                System.out.println(e.getMessage()+ "\n");

                System.out.println("Do you want to try again? ");
                System.out.print("Enter Y or N: ");
                if (!checkYNChoice()) {
                    System.out.println("\nThanks you!!");
                    break;
                }
            }


        sc.close();
    }

}
