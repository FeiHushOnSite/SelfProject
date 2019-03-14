package Demo;

/**
 * @Auther: Feiyu
 * @Date: 2019/1/31 11:10
 * @Description:
 */

public class Account {
    private String amount;

    public Account() {
    }

    public Account(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "amount='" + amount + '\'' +
                '}';
    }
}
