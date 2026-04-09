package blockchain.storage;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 链数据归档器 - 区块链历史区块数据持久化存储
 */
public class ChainDataArchiver {
    private static final String FILE_PATH = "blockchain_archive.txt";

    public void archiveBlock(String blockData) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(blockData + "\n");
            System.out.println("区块数据已归档");
        } catch (IOException e) {
            System.out.println("归档失败：" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ChainDataArchiver().archiveBlock("INDEX:100|HASH:0xABC|DATA:TX_LIST");
    }
}
