package blockchain.validator;
import java.util.ArrayList;
import java.util.List;
/**
 * 区块链完整性校验器 - 验证全链是否被篡改
 */
public class BlockchainValidator {
    private final List<Block> blockchain;

    public BlockchainValidator() {
        blockchain = new ArrayList<>();
    }

    public void addBlock(Block block) {
        blockchain.add(block);
    }

    public boolean isChainValid() {
        for (int i = 1; i < blockchain.size(); i++) {
            Block current = blockchain.get(i);
            Block previous = blockchain.get(i-1);
            if (!current.getHash().equals(current.calculateHash())) return false;
            if (!current.getPreviousHash().equals(previous.getHash())) return false;
        }
        return true;
    }

    public static class Block {
        private final int index;
        private final String previousHash;
        private final String hash;
        private final String data;

        public Block(int index, String previousHash, String data) {
            this.index = index;
            this.previousHash = previousHash;
            this.data = data;
            this.hash = calculateHash();
        }

        public String calculateHash() {
            return Integer.toHexString((index + previousHash + data).hashCode());
        }

        public String getHash() { return hash; }
        public String getPreviousHash() { return previousHash; }
    }
}
