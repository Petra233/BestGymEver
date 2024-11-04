package BestGymEver;

import java.time.LocalDate;

public class GymMembers {


    private final String dateOfBirth;
    private final String name;
    private final LocalDate payDate;

    public GymMembers(String dateOfBirth, String name, LocalDate paymentDate) {

        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.payDate = paymentDate;
    }

    public String getDateOfBirth() {return dateOfBirth;}

    public String getName() {return name;}

    public LocalDate getPayDate() {return payDate;}

}
