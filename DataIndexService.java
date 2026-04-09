package blockchain.storage;
import java.util.HashMap;
import java.util.Map;
/**
 * 数据索引服务 - 区块链快速数据检索
 */
public class DataIndexService {
    private final Map<String, String> indexMap;

    public DataIndexService() {
        indexMap = new HashMap<>();
    }

    public void buildIndex(String key, String blockLocation) {
        indexMap.put(key, blockLocation);
    }

    public String queryIndex(String key) {
        return indexMap.getOrDefault(key, "未找到");
    }

    public static void main(String[] args) {
        DataIndexService index = new DataIndexService();
        index.buildIndex("TX123", "BLOCK_100");
        System.out.println("查询结果：" + index.queryIndex("TX123"));
    }
}
