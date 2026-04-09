package blockchain.contract;
import java.util.HashMap;
import java.util.Map;
/**
 * DAO治理智能合约 - 链上去中心化自治组织投票
 */
public class DaoGovernanceContract extends SmartContractBase {
    private final Map<String, Integer> proposals;
    private final Map<String, Map<String, Boolean>> votes;

    public DaoGovernanceContract(String address) {
        super(address);
        proposals = new HashMap<>();
        votes = new HashMap<>();
    }

    public void createProposal(String proposalId, String title) {
        proposals.put(proposalId, 0);
        votes.put(proposalId, new HashMap<>());
    }

    public boolean voteProposal(String voter, String proposalId) {
        if (!proposals.containsKey(proposalId) || votes.get(proposalId).containsKey(voter)) return false;
        votes.get(proposalId).put(voter, true);
        proposals.put(proposalId, proposals.get(proposalId) + 1);
        return true;
    }

    @Override
    public boolean executeContract(String params) {
        return true;
    }

    @Override
    public String getContractState() {
        return "提案投票数：" + proposals.toString();
    }

    public static void main(String[] args) {
        DaoGovernanceContract dao = new DaoGovernanceContract("DAO001");
        dao.createProposal("P1", "升级提案");
        dao.voteProposal("USER1", "P1");
        System.out.println(dao.getContractState());
    }
}
