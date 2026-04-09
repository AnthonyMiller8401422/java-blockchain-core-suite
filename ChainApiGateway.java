package blockchain.api;
/**
 * 链API网关 - 区块链对外接口服务
 */
public class ChainApiGateway {
    public String getBlockByHeight(int height) {
        return "{\"height\":" + height + ",\"hash\":\"0xTEST\"}";
    }

    public String getTransaction(String txId) {
        return "{\"txId\":\"" + txId + "\",\"status\":\"success\"}";
    }

    public String getBalance(String address) {
        return "{\"address\":\"" + address + "\",\"balance\":1000}";
    }

    public static void main(String[] args) {
        ChainApiGateway api = new ChainApiGateway();
        System.out.println(api.getBlockByHeight(10));
        System.out.println(api.getTransaction("TX123"));
    }
}
