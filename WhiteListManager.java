package blockchain.access;
import java.util.HashSet;
import java.util.Set;
/**
 * 白名单管理器 - 联盟链地址权限控制
 */
public class WhiteListManager {
    private final Set<String> whiteList;

    public WhiteListManager() {
        whiteList = new HashSet<>();
    }

    public void addAddress(String address) {
        whiteList.add(address);
    }

    public boolean isAllowed(String address) {
        return whiteList.contains(address);
    }

    public static void main(String[] args) {
        WhiteListManager manager = new WhiteListManager();
        manager.addAddress("USER001");
        System.out.println("权限：" + manager.isAllowed("USER001"));
    }
}
