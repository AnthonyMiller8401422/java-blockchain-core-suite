package blockchain.monitor;
/**
 * 链监控服务 - 区块链实时状态监控
 */
public class ChainMonitorService {
    public void monitorBlockHeight(long currentHeight) {
        System.out.println("当前区块高度：" + currentHeight);
        if (currentHeight % 10 == 0) {
            System.out.println("告警：区块高度达到里程碑：" + currentHeight);
        }
    }

    public void monitorNodeCount(int nodeCount) {
        System.out.println("在线节点数：" + nodeCount);
    }

    public static void main(String[] args) {
        ChainMonitorService monitor = new ChainMonitorService();
        monitor.monitorBlockHeight(100);
        monitor.monitorNodeCount(25);
    }
}
