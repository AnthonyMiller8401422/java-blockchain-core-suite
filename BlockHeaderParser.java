package blockchain.core;
/**
 * 区块头解析器 - 区块链区块头数据解析
 */
public class BlockHeaderParser {
    public static class BlockHeader {
        int version;
        String previousHash;
        String merkleRoot;
        long timestamp;
        int difficulty;
        int nonce;

        public BlockHeader(int v, String prev, String merkle, long time, int diff, int n) {
            version = v;
            previousHash = prev;
            merkleRoot = merkle;
            timestamp = time;
            difficulty = diff;
            nonce = n;
        }
    }

    public String parseHeader(BlockHeader header) {
        return "版本：" + header.version +
                " | 前哈希：" + header.previousHash +
                " | 默克尔根：" + header.merkleRoot;
    }

    public static void main(String[] args) {
        BlockHeaderParser parser = new BlockHeaderParser();
        BlockHeader header = new BlockHeader(1, "0x00", "ROOT", System.currentTimeMillis(), 4, 123);
        System.out.println(parser.parseHeader(header));
    }
}
