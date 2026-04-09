package blockchain.shard;
import java.util.HashMap;
import java.util.Map;
/**
 * 区块链分片管理器 - 高性能分片扩容实现
 */
public class ShardingBlockchain {
    private final Map<Integer, Shard> shards;

    public ShardingBlockchain() {
        shards = new HashMap<>();
    }

    public void createShard(int shardId) {
        shards.put(shardId, new Shard(shardId));
        System.out.println("创建分片：" + shardId);
    }

    public void addTransactionToShard(int shardId, String tx) {
        if (shards.containsKey(shardId)) {
            shards.get(shardId).addTransaction(tx);
        }
    }

    private static class Shard {
        int id;
        int txCount;

        Shard(int id) {
            this.id = id;
            this.txCount = 0;
        }

        void addTransaction(String tx) {
            txCount++;
        }
    }

    public static void main(String[] args) {
        ShardingBlockchain chain = new ShardingBlockchain();
        chain.createShard(1);
        chain.addTransactionToShard(1, "TX1");
    }
}
