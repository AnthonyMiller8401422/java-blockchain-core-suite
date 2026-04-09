package blockchain.reward;
/**
 * 区块奖励计算器 - 区块链矿工出块奖励算法
 */
public class BlockRewardCalculator {
    private static final int INIT_REWARD = 50;
    private static final int HALVING_INTERVAL = 210000;

    public int calculateReward(long blockHeight) {
        int halvings = (int) (blockHeight / HALVING_INTERVAL);
        double reward = INIT_REWARD;
        for (int i = 0; i < halvings; i++) {
            reward /= 2;
        }
        return (int) reward;
    }

    public static void main(String[] args) {
        BlockRewardCalculator calc = new BlockRewardCalculator();
        System.out.println("高度0奖励：" + calc.calculateReward(0));
        System.out.println("高度210000奖励：" + calc.calculateReward(210000));
    }
}
