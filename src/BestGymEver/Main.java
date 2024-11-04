package BestGymEver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CurrentMembers currentMembers = new CurrentMembers();
        List<GymMembers> members = currentMembers.getMembers();
        Scanner sc = new Scanner(System.in);
        boolean continueProgram = true;


        while (continueProgram) {
            System.out.println("Välkommen till Best Gym Ever! Skriv in namn eller personnummer på besökande gäst: ");
            String checkVisitor = sc.nextLine();

            Membership result = currentMembers.memberCheck(members, checkVisitor);
            System.out.println(result.getStatus());

            if (result.getStatus().equals("Är medlem")) {
                logForPT logg = new logForPT();
                try {
                    logg.logPT(result.getMember(), LocalDate.now().toString(), "CurrentMembersVisiting.txt");
                    System.out.println("Besök loggat för: " + result.getMember().getName());
                } catch (IOException e) {
                    System.out.println("Kunde inte logga besöket: " + e.getMessage());
                }

            }

            while (true) {
                System.out.println("Vill du checka in en annan besökare?: ");
                System.out.println("1. Ja");
                System.out.println("2. Nej. ");
                System.out.printf("Välj alternativ 1 eller 2:");

                String option = sc.nextLine().trim();

                if (option.equals("1")) {
                    break;
                } else if (option.equals("2")) {
                    continueProgram = false;
                    System.out.printf("Då avslutas programmet! Hejdå!");
                    break;
                } else {
                    System.out.println("Felaktig inmatning. Försök igen.");
                }
            }
        }


        sc.close();
    }
}



