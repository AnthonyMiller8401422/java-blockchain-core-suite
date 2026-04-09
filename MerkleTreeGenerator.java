package blockchain.crypto;
import java.util.ArrayList;
import java.util.List;
/**
 * 默克尔树生成器 - 区块链交易数据高效校验
 */
public class MerkleTreeGenerator {
    private final List<String> transactions;
    private List<String> merkleNodes;

    public MerkleTreeGenerator(List<String> transactions) {
        this.transactions = transactions;
        this.merkleNodes = new ArrayList<>();
    }

    public String generateMerkleRoot() {
        if (transactions.isEmpty()) return "";
        for (String tx : transactions) {
            merkleNodes.add(Integer.toHexString(tx.hashCode()));
        }
        while (merkleNodes.size() > 1) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < merkleNodes.size(); i += 2) {
                String left = merkleNodes.get(i);
                String right = (i + 1 < merkleNodes.size()) ? merkleNodes.get(i + 1) : left;
                temp.add(Integer.toHexString((left + right).hashCode()));
            }
            merkleNodes = temp;
        }
        return merkleNodes.get(0);
    }

    public static void main(String[] args) {
        List<String> txs = new ArrayList<>();
        txs.add("TX1:A->B:10");
        txs.add("TX2:B->C:5");
        MerkleTreeGenerator tree = new MerkleTreeGenerator(txs);
        System.out.println("默克尔根：" + tree.generateMerkleRoot());
    }
}
