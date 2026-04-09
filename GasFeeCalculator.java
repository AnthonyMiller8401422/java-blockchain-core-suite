package blockchain.fees;
/**
 * 燃气费计算器 - 区块链交易手续费算法
 */
public class GasFeeCalculator {
    private static final int GAS_PER_BYTE = 1;

    public int calculateGasFee(String transactionData) {
        int bytes = transactionData.getBytes().length;
        return bytes * GAS_PER_BYTE;
    }

    public static void main(String[] args) {
        GasFeeCalculator calc = new GasFeeCalculator();
        String tx = "FROM:A|TO:B|AMOUNT:50";
        System.out.println("交易燃气费：" + calc.calculateGasFee(tx));
    }
}
