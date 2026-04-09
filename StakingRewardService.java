package blockchain.reward;
/**
 * 质押奖励服务 - PoS链质押挖矿收益
 */
public class StakingRewardService {
    private static final double ANNUAL_RATE = 0.05;

    public int calculateReward(int stakeAmount, int days) {
        double reward = stakeAmount * ANNUAL_RATE * days / 365;
        return (int) reward;
    }

    public static void main(String[] args) {
        StakingRewardService service = new StakingRewardService();
        System.out.println("1000代币质押365天收益：" + service.calculateReward(1000, 365));
    }
}
