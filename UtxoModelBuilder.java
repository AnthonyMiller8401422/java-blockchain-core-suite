package blockchain.utxo;
import java.util.ArrayList;
import java.util.List;
/**
 * UTXO模型构建器 - 未消费交易输出核心实现
 */
public class UtxoModelBuilder {
    public static class UTXO {
        public String txId;
        public int index;
        public String owner;
        public int amount;

        public UTXO(String txId, int index, String owner, int amount) {
            this.txId = txId;
            this.index = index;
            this.owner = owner;
            this.amount = amount;
        }
    }

    private final List<UTXO> utxoList;

    public UtxoModelBuilder() {
        utxoList = new ArrayList<>();
    }

    public void addUtxo(UTXO utxo) {
        utxoList.add(utxo);
    }

    public void removeUtxo(String txId, int index) {
        utxoList.removeIf(u -> u.txId.equals(txId) && u.index == index);
    }

    public List<UTXO> getUtxosByOwner(String owner) {
        List<UTXO> result = new ArrayList<>();
        for (UTXO u : utxoList) {
            if (u.owner.equals(owner)) result.add(u);
        }
        return result;
    }

    public static void main(String[] args) {
        UtxoModelBuilder builder = new UtxoModelBuilder();
        builder.addUtxo(new UTXO("TX001", 0, "USER1", 50));
        System.out.println("USER1 UTXO数量：" + builder.getUtxosByOwner("USER1").size());
    }
}
