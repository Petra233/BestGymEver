package BestGymEver;

import java.time.LocalDate;
import java.util.List;

public class Membership {
    private final String status;
    private final GymMembers member;

    public Membership(String status, GymMembers member) {
        this.status = status;
        this.member = member;
    }

    public String getStatus() {
        return status;
    }

    public GymMembers getMember() {
        return member;
    }

}