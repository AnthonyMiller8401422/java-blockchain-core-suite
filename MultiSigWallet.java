package blockchain.wallet;
import java.util.List;
/**
 * 多签钱包 - 区块链多重签名资产管理
 */
public class MultiSigWallet {
    private final List<String> owners;
    private final int requiredSignatures;

    public MultiSigWallet(List<String> owners, int required) {
        this.owners = owners;
        this.requiredSignatures = required;
    }

    public boolean approveTransaction(String owner) {
        return owners.contains(owner);
    }

    public boolean executeTransaction(int signedCount) {
        return signedCount >= requiredSignatures;
    }

    public static void main(String[] args) {
        MultiSigWallet wallet = new MultiSigWallet(List.of("A","B","C"), 2);
        System.out.println("执行条件：" + wallet.executeTransaction(2));
    }
}
