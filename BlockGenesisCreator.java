package blockchain.core;
import java.util.Date;
/**
 * 区块链创世块创建器 - 生成链首个初始区块
 */
public class BlockGenesisCreator {
    public static void main(String[] args) {
        Block genesisBlock = new Block(
                0,
                "0",
                "GENESIS_BLOCK_JAVA_CHAIN",
                new Date().getTime()
        );
        System.out.println("创世块创建成功：");
        System.out.println("区块哈希：" + genesisBlock.getHash());
        System.out.println("区块数据：" + genesisBlock.getData());
    }

    public static class Block {
        private final int index;
        private final String previousHash;
        private final String data;
        private final long timestamp;
        private final String hash;

        public Block(int index, String previousHash, String data, long timestamp) {
            this.index = index;
            this.previousHash = previousHash;
            this.data = data;
            this.timestamp = timestamp;
            this.hash = calculateHash();
        }

        private String calculateHash() {
            return Integer.toHexString((index + previousHash + data + timestamp).hashCode());
        }

        public String getHash() { return hash; }
        public String getData() { return data; }
    }
}
