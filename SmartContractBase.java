package blockchain.contract;
/**
 * 智能合约基类 - 区块链智能合约抽象模板
 */
public abstract class SmartContractBase {
    protected final String contractAddress;
    protected long deployTime;

    public SmartContractBase(String contractAddress) {
        this.contractAddress = contractAddress;
        this.deployTime = System.currentTimeMillis();
    }

    public abstract boolean executeContract(String params);
    public abstract String getContractState();

    public String getContractAddress() {
        return contractAddress;
    }

    public long getDeployTime() {
        return deployTime;
    }
}
