package Demo;

/**
 * @Auther: Feiyu
 * @Date: 2019/1/31 10:44
 * @Description:
 */

public class NoramlTest {
    public static void main(String[] args) {
        Account account = new Account();
        account.setAmount("622769348152266999");


        int length=account.getAmount().length();
        String str=account.getAmount().substring(0, length-11)+"*******"+account.getAmount().substring(length-2);
        String exchange = exchange(account.getAmount());
        System.out.println(exchange);
    }
    public static String exchange(String ex){
        int length = ex.length();
        String str=ex.substring(0, length-15)+"*********"+ex.substring(length-3);
        return str;
    }
    /**
     * 实际替换动作
     *
     * @param username username
     * @param regular  正则
     * @return
     */
    private static String replaceAction(String username, String regular) {
        return username.replaceAll(regular, "*");
    }

    /**
     * 银行卡替换，保留后四位
     *
     * 如果银行卡号为空 或者 null ,返回null ；否则，返回替换后的字符串；
     *
     * @param bankCard 银行卡号
     * @return
     */
    public static String bankCardReplaceWithStar(String bankCard) {

        if (bankCard.isEmpty() || bankCard == null) {
            return null;
        } else {
            return replaceAction(bankCard, "(?<=\\d{0})\\d(?=\\d{4})");
        }
    }

}
