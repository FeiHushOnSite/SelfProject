package Demo;

/**
 * @Auther: Feiyu
 * @Date: 2019/2/14 14:04
 * @Description:
 */

public enum Repayment {
    ER,
    PR,
    FR;

    private String type;
    private Integer amount;

    Repayment() {
    }

    Repayment(String type, Integer amount){
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
