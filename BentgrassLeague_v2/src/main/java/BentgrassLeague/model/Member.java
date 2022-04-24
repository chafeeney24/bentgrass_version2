package BentgrassLeague.model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private int memberId;
    private String userName;

    public Member() {}

    public Member(int member_id, String userName) {
        this.memberId = member_id;
        this.userName = userName;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int member_id) {
        this.memberId = member_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Round> getMemberRounds(List<Round> rounds){
        List<Round> memberRounds = new ArrayList<>();
        for (Round round : rounds) {
            if (round.getMemberId() == memberId){
               memberRounds.add(round);
            }
        }
        return memberRounds;
    }
}
