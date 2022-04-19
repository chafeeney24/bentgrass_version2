package BentgrassLeague.model;

public class Member {
    private int member_id;
    private String userName;

    public Member() {}

    public Member(int member_id, String userName) {
        this.member_id = member_id;
        this.userName = userName;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
