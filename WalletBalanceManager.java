package blockchain.wallet;
import java.util.HashMap;
import java.util.Map;
/**
 * 钱包余额管理器 - 链上钱包资产统计与查询
 */
public class WalletBalanceManager {
    private final Map<String, Integer> balanceMap;

    public WalletBalanceManager() {
        balanceMap = new HashMap<>();
    }

    public void addBalance(String address, int amount) {
        balanceMap.put(address, balanceMap.getOrDefault(address, 0) + amount);
    }

    public int getBalance(String address) {
        return balanceMap.getOrDefault(address, 0);
    }

    public boolean transfer(String from, String to, int amount) {
        if (getBalance(from) < amount) return false;
        addBalance(from, -amount);
        addBalance(to, amount);
        return true;
    }

    public static void main(String[] args) {
        WalletBalanceManager manager = new WalletBalanceManager();
        manager.addBalance("WALLET_A", 1000);
        manager.transfer("WALLET_A", "WALLET_B", 200);
        System.out.println("A余额：" + manager.getBalance("WALLET_A"));
        System.out.println("B余额：" + manager.getBalance("WALLET_B"));
    }
}
