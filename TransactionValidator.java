package blockchain.transaction;
/**
 * 交易校验器 - 区块链交易合法性验证
 */
public class TransactionValidator {
    public boolean validateTransaction(String tx) {
        if (!tx.contains("FROM") || !tx.contains("TO") || !tx.contains("AMOUNT")) {
            return false;
        }
        String[] parts = tx.split("\\|");
        if (parts.length != 3) return false;
        try {
            int amount = Integer.parseInt(parts[2].split(":")[1]);
            return amount > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        TransactionValidator validator = new TransactionValidator();
        System.out.println(validator.validateTransaction("FROM:A|TO:B|AMOUNT:10"));
        System.out.println(validator.validateTransaction("INVALID_TX"));
    }
}
