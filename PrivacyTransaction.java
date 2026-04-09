package blockchain.transaction;
/**
 * 隐私交易 - 区块链匿名交易实现
 */
public class PrivacyTransaction {
    public String createAnonymousTransaction(String from, String to, int amount) {
        String blindFrom = "ANON_" + Integer.toHexString(from.hashCode());
        String blindTo = "ANON_" + Integer.toHexString(to.hashCode());
        return "隐私交易：" + blindFrom + " -> " + blindTo + " 金额：" + amount;
    }

    public static void main(String[] args) {
        PrivacyTransaction tx = new PrivacyTransaction();
        System.out.println(tx.createAnonymousTransaction("USER_A", "USER_B", 200));
    }
}
