package blockchain.consensus;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/**
 * 权益证明共识算法 - PoS区块链挖矿机制
 */
public class PosConsensus {
    private final Map<String, Integer> stakeMap;
    private final Random random;

    public PosConsensus() {
        stakeMap = new HashMap<>();
        random = new Random();
    }

    public void depositStake(String nodeAddress, int stake) {
        stakeMap.put(nodeAddress, stakeMap.getOrDefault(nodeAddress, 0) + stake);
    }

    public String selectForger() {
        int totalStake = stakeMap.values().stream().mapToInt(Integer::intValue).sum();
        int randomValue = random.nextInt(totalStake) + 1;
        int current = 0;
        for (Map.Entry<String, Integer> entry : stakeMap.entrySet()) {
            current += entry.getValue();
            if (current >= randomValue) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        PosConsensus pos = new PosConsensus();
        pos.depositStake("NODE_001", 100);
        pos.depositStake("NODE_002", 200);
        System.out.println("当选打包节点：" + pos.selectForger());
    }
}
