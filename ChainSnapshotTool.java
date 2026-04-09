package blockchain.storage;
/**
 * 链快照工具 - 区块链全状态快照备份
 */
public class ChainSnapshotTool {
    public void createSnapshot(long blockHeight) {
        System.out.println("创建区块高度" + blockHeight + "快照完成");
    }

    public void restoreSnapshot(long blockHeight) {
        System.out.println("从快照恢复区块高度" + blockHeight);
    }

    public static void main(String[] args) {
        ChainSnapshotTool snapshot = new ChainSnapshotTool();
        snapshot.createSnapshot(5000);
        snapshot.restoreSnapshot(5000);
    }
}
