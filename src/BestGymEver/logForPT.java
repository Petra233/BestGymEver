package BestGymEver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class logForPT {

    public void logPT(GymMembers member, String date, String fileName) throws IOException {
        String outFilePath = "src/BestGymEver/CurrentMembersVisiting.txt";
        try(BufferedWriter w = new BufferedWriter(new FileWriter(outFilePath, true))) {
            w.write(member.getName() + ", " + member.getDateOfBirth() + ", " + date);
            w.newLine();
        } catch (IOException e) {
            System.err.println("Något gick fel! " + e.getMessage());
            throw e;
        }
    }
}