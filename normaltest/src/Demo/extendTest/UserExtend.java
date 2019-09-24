package Demo.extendTest;

public class UserExtend extends UserBasic {

    private String department;
    private String nickName;
    private int workId;

    public UserExtend() {
    }

    public UserExtend(String department, String nickName, int workId) {
        this.department = department;
        this.nickName = nickName;
        this.workId = workId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    @Override
    public String toString() {
        return "UserExtend{" +
                "department='" + department + '\'' +
                ", nickName='" + nickName + '\'' +
                ", workId=" + workId +
                '}';
    }
}

class testTest {
    public static void main(String[] args) {
        UserExtend us = new UserExtend();
        us.setId(1);
        us.setWorkId(2002);
        System.out.println(us.getId() + ":" + us.getWorkId());
    }
}
