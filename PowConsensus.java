package blockchain.consensus;
/**
 * 工作量证明共识算法 - PoW区块链挖矿机制
 */
public class PowConsensus {
    private static final int DIFFICULTY = 4;

    public String mineBlock(String blockData) {
        String target = new String(new char[DIFFICULTY]).replace('\0', '0');
        int nonce = 0;
        while (true) {
            String hash = calculateHash(blockData + nonce);
            if (hash.startsWith(target)) {
                System.out.println("挖矿成功！nonce：" + nonce + " 哈希：" + hash);
                return hash;
            }
            nonce++;
        }
    }

    private String calculateHash(String data) {
        return Integer.toHexString(data.hashCode());
    }

    public static void main(String[] args) {
        new PowConsensus().mineBlock("index:2|prevHash:genesis|data:tx1");
    }
}
