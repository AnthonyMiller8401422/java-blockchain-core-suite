package blockchain.consensus;
import java.util.*;
/**
 * 委托权益证明共识算法 - DPoS区块链核心机制
 */
public class DposConsensus {
    private final List<String> candidates;
    private final Map<String, Integer> votes;

    public DposConsensus() {
        candidates = new ArrayList<>();
        votes = new HashMap<>();
    }

    public void registerCandidate(String node) {
        candidates.add(node);
    }

    public void vote(String voter, String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
    }

    public List<String> electWitnesses(int count) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(votes.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(count, list.size()); i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        DposConsensus dpos = new DposConsensus();
        dpos.registerCandidate("NODE1");
        dpos.registerCandidate("NODE2");
        dpos.vote("USER1", "NODE1");
        dpos.vote("USER2", "NODE1");
        System.out.println("当选见证人：" + dpos.electWitnesses(1));
    }
}
