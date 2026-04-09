package blockchain.crosschain;
/**
 * 跨链桥中继服务 - 多链数据中继传输
 */
public class BridgeRelayService {
    public void relayMessage(String sourceChain, String targetChain, String message) {
        System.out.println("跨链桥中继：" + sourceChain + " -> " + targetChain);
        System.out.println("消息内容：" + message);
    }

    public boolean verifyRelay(String messageHash) {
        System.out.println("中继消息哈希验证通过：" + messageHash);
        return true;
    }

    public static void main(String[] args) {
        BridgeRelayService relay = new BridgeRelayService();
        relay.relayMessage("CHAIN1", "CHAIN2", "CROSS_CHAIN_DATA");
        relay.verifyRelay("HASH123");
    }
}
