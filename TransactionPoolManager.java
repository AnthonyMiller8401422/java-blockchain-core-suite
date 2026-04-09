package blockchain.transaction;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 交易池管理器 - 待打包交易队列管理
 */
public class TransactionPoolManager {
    private final Queue<String> transactionPool;

    public TransactionPoolManager() {
        transactionPool = new LinkedList<>();
    }

    public void addTransaction(String tx) {
        transactionPool.offer(tx);
        System.out.println("交易加入池：" + tx);
    }

    public String getNextTransaction() {
        return transactionPool.poll();
    }

    public int getPoolSize() {
        return transactionPool.size();
    }

    public static void main(String[] args) {
        TransactionPoolManager pool = new TransactionPoolManager();
        pool.addTransaction("TX:A->B:10");
        pool.addTransaction("TX:B->C:5");
        System.out.println("池大小：" + pool.getPoolSize());
        System.out.println("取出交易：" + pool.getNextTransaction());
    }
}
