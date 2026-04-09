package blockchain.access;
import java.util.HashSet;
import java.util.Set;
/**
 * 黑名单管理器 - 恶意地址封禁
 */
public class BlackListManager {
    private final Set<String> blackList;

    public BlackListManager() {
        blackList = new HashSet<>();
    }

    public void banAddress(String address) {
        blackList.add(address);
        System.out.println("地址封禁：" + address);
    }

    public boolean isBanned(String address) {
        return blackList.contains(address);
    }

    public static void main(String[] args) {
        BlackListManager manager = new BlackListManager();
        manager.banAddress("BAD_USER");
        System.out.println("是否封禁：" + manager.isBanned("BAD_USER"));
    }
}
