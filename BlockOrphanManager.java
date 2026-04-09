package blockchain.core;
import java.util.ArrayList;
import java.util.List;
/**
 * 孤块管理器 - 区块链无效区块处理
 */
public class BlockOrphanManager {
    private final List<String> orphanBlocks;

    public BlockOrphanManager() {
        orphanBlocks = new ArrayList<>();
    }

    public void addOrphanBlock(String blockHash) {
        orphanBlocks.add(blockHash);
        System.out.println("孤块加入列表：" + blockHash);
    }

    public void cleanOrphanBlocks() {
        orphanBlocks.clear();
        System.out.println("孤块已清理");
    }

    public int getOrphanCount() {
        return orphanBlocks.size();
    }

    public static void main(String[] args) {
        BlockOrphanManager manager = new BlockOrphanManager();
        manager.addOrphanBlock("0xORPHAN");
        System.out.println("孤块数量：" + manager.getOrphanCount());
    }
}
