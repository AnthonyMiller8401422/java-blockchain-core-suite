package blockchain.contract;
/**
 * 合约审计工具 - 智能合约安全漏洞检测
 */
public class ContractAuditTool {
    public String auditContract(String code) {
        if (code.contains("reentrancy")) {
            return "高危：重入漏洞";
        }
        if (code.contains("overflow")) {
            return "中危：整数溢出";
        }
        return "安全：未发现漏洞";
    }

    public static void main(String[] args) {
        ContractAuditTool audit = new ContractAuditTool();
        System.out.println(audit.auditContract("safe contract code"));
    }
}
