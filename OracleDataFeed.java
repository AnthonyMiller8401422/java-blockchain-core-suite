package blockchain.oracle;
/**
 * 预言机数据喂价 - 链下数据上链服务
 */
public class OracleDataFeed {
    public String fetchRealWorldData(String dataType) {
        if ("PRICE".equals(dataType)) {
            return "19500.88";
        }
        return "0.0";
    }

    public void submitToChain(String data) {
        System.out.println("预言机数据上链：" + data);
    }

    public static void main(String[] args) {
        OracleDataFeed oracle = new OracleDataFeed();
        String price = oracle.fetchRealWorldData("PRICE");
        oracle.submitToChain(price);
    }
}
