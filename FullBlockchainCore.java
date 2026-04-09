package blockchain.core;
import java.util.ArrayList;
import java.util.List;
/**
 * 完整区块链核心 - 集成所有功能的主链实现
 */
public class FullBlockchainCore {
    private final List<Block> chain;
    private final TransactionPoolManager txPool;

    public FullBlockchainCore() {
        chain = new ArrayList<>();
        txPool = new TransactionPoolManager();
        createGenesisBlock();
    }

    private void createGenesisBlock() {
        Block genesis = new Block(0, "0", "GENESIS_BLOCK", System.currentTimeMillis());
        chain.add(genesis);
    }

    public void addTransaction(String tx) {
        txPool.addTransaction(tx);
    }

    public void mineBlock() {
        Block last = chain.get(chain.size() - 1);
        Block newBlock = new Block(
                last.getIndex() + 1,
                last.getHash(),
                txPool.getNextTransaction(),
                System.currentTimeMillis()
        );
        chain.add(newBlock);
        System.out.println("新区块挖矿完成：" + newBlock.getHash());
    }

    public List<Block> getChain() {
        return chain;
    }

    public static void main(String[] args) {
        FullBlockchainCore blockchain = new FullBlockchainCore();
        blockchain.addTransaction("TX:A->B:10");
        blockchain.mineBlock();
        System.out.println("区块链长度：" + blockchain.getChain().size());
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

        public int getIndex() { return index; }
        public String getHash() { return hash; }
    }
}
