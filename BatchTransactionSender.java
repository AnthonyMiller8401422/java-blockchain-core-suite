package blockchain.transaction;
import java.util.List;
/**
 * 批量交易发送器 - 区块链批量交易打包上链
 */
public class BatchTransactionSender {
    public void sendBatchTransactions(List<String> transactions) {
        System.out.println("批量交易发送，总数：" + transactions.size());
        for (String tx : transactions) {
            System.out.println("发送：" + tx);
        }
    }

    public static void main(String[] args) {
        BatchTransactionSender sender = new BatchTransactionSender();
        sender.sendBatchTransactions(List.of("TX1", "TX2", "TX3"));
    }
}
