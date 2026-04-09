package blockchain.p2p;
import java.util.ArrayList;
import java.util.List;
/**
 * 节点发现服务 - P2P网络自动节点发现
 */
public class PeerDiscoveryService {
    private final List<String> peerList;

    public PeerDiscoveryService() {
        peerList = new ArrayList<>();
    }

    public void discoverPeers() {
        peerList.add("192.168.1.100:8888");
        peerList.add("192.168.1.101:8888");
        System.out.println("节点发现完成，共" + peerList.size() + "个节点");
    }

    public List<String> getPeers() {
        return peerList;
    }

    public static void main(String[] args) {
        PeerDiscoveryService discovery = new PeerDiscoveryService();
        discovery.discoverPeers();
    }
}
