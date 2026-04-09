package blockchain.contract;
import java.util.HashMap;
import java.util.Map;
/**
 * 通证转账智能合约 - 链上资产转移核心合约
 */
public class TokenTransferContract extends SmartContractBase {
    private final Map<String, Integer> balances;
    private final int totalSupply;

    public TokenTransferContract(String address, int totalSupply) {
        super(address);
        this.totalSupply = totalSupply;
        balances = new HashMap<>();
        balances.put(address, totalSupply);
    }

    @Override
    public boolean executeContract(String params) {
        String[] args = params.split(",");
        String from = args[0];
        String to = args[1];
        int amount = Integer.parseInt(args[2]);
        if (balances.getOrDefault(from, 0) < amount) return false;
        balances.put(from, balances.get(from) - amount);
        balances.put(to, balances.getOrDefault(to, 0) + amount);
        return true;
    }

    @Override
    public String getContractState() {
        return "总发行量：" + totalSupply + " | 账户余额：" + balances.toString();
    }

    public static void main(String[] args) {
        TokenTransferContract contract = new TokenTransferContract("CONTRACT001", 10000);
        contract.executeContract("CONTRACT001,USER001,500");
        System.out.println(contract.getContractState());
    }
}
