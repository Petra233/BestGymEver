package BestGymEver;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CurrentMembers {

    DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final List<GymMembers> members = new ArrayList<>();

    public List<GymMembers> getMembers() { //metod som kallar på List<GymMembers> och returnerar listan som är sparad som private.
        return members;
    }

    public CurrentMembers() { // Konstruktor för klassen CurrentMembers som kallar på metodern loadMembers när den används
        loadMembers();
    }

    private void loadMembers() { //metod för att loopa igenom textfilen och spara den i en listan List<GymMembers> members
        String filePath = "src/BestGymEver/members.txt";
        Path inFilePath = Paths.get(filePath);


        try (BufferedReader br = new BufferedReader(new FileReader(inFilePath.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) { //om raden inte är tom så kör programmet.
                String[] parts = line.split(","); //splittar meningen där ett , finns.
                String dateOfBirth = parts[0].trim(); // första delen av meningen sparas i [0]. trim() används för att ta bort typ mellanrum etc.
                String name = (parts[1].trim()); //samma som ovan men andra delen av meningen
                LocalDate payDate = LocalDate.parse(br.readLine(), DATE_FORMATTER); //Tredje raden läses av och parsas till ett datumtal och formateras enligt DATE_FORMATTER
                members.add(new GymMembers(dateOfBirth, name, payDate)); //extraherad data adderas till listan.
            }
        } catch (IOException e) {
            throw new RuntimeException("Gick ej att ladda" + e.getMessage()); //felmeddelande
        }
    }


    public Membership memberCheck(List<GymMembers> members, String checkVisitor) {
        LocalDate currentDate = LocalDate.now();
        LocalDate oneYearAgo = currentDate.minusYears(1);

        for (GymMembers member : members) {
            if (member.getName().equals(checkVisitor) ||
                    member.getDateOfBirth().equals(checkVisitor)) {

                if (member.getPayDate().isAfter(oneYearAgo)) {
                    return new Membership("Är medlem", member);
                } else {
                    return new Membership("Tidigare medlem", member);
                }
            }
        }
        return new Membership("Ej medlem", null);
    }
}

