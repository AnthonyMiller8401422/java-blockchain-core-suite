package blockchain.p2p;
import java.util.List;
/**
 * 节点同步服务 - 区块链节点数据一致性同步
 */
public class NodeSyncService {
    public void syncFullChain(List<String> localChain, List<String> remoteChain) {
        if (remoteChain.size() > localChain.size()) {
            localChain.clear();
            localChain.addAll(remoteChain);
            System.out.println("节点同步完成，最新区块高度：" + localChain.size());
        } else {
            System.out.println("本地链已是最新，无需同步");
        }
    }

    public static void main(String[] args) {
        NodeSyncService service = new NodeSyncService();
        service.syncFullChain(List.of("B1", "B2"), List.of("B1", "B2", "B3", "B4"));
    }
}
