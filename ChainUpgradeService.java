package blockchain.core;
/**
 * 链升级服务 - 区块链硬分叉/软分叉升级
 */
public class ChainUpgradeService {
    public boolean softUpgrade(long activateHeight, long currentHeight) {
        if (currentHeight >= activateHeight) {
            System.out.println("软升级已激活");
            return true;
        }
        System.out.println("等待升级激活高度");
        return false;
    }

    public boolean hardUpgrade() {
        System.out.println("硬分叉升级完成，不兼容旧节点");
        return true;
    }

    public static void main(String[] args) {
        ChainUpgradeService service = new ChainUpgradeService();
        service.softUpgrade(1000, 1500);
        service.hardUpgrade();
    }
}
