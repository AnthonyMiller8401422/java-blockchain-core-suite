package blockchain.contract;
import java.util.ArrayList;
import java.util.List;
/**
 * 合约事件记录器 - 智能合约执行日志追踪
 */
public class ContractEventLogger {
    private final List<String> eventLogs;

    public ContractEventLogger() {
        eventLogs = new ArrayList<>();
    }

    public void logEvent(String contractAddress, String eventType, String params) {
        String log = String.format("[%d] %s | %s | %s",
                System.currentTimeMillis(), contractAddress, eventType, params);
        eventLogs.add(log);
        System.out.println("合约事件：" + log);
    }

    public List<String> getLogs() {
        return eventLogs;
    }

    public static void main(String[] args) {
        ContractEventLogger logger = new ContractEventLogger();
        logger.logEvent("C001", "TRANSFER", "FROM:A TO:B AMOUNT:100");
    }
}
