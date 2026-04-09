package blockchain.validator;
import java.util.List;
/**
 * 链分叉解决器 - 区块链多分支冲突自动处理
 */
public class ChainForkResolver {
    public List<String> resolveFork(List<String> chainA, List<String> chainB) {
        if (chainA.size() > chainB.size()) {
            System.out.println("选择最长链A");
            return chainA;
        } else {
            System.out.println("选择最长链B");
            return chainB;
        }
    }

    public static void main(String[] args) {
        ChainForkResolver resolver = new ChainForkResolver();
        resolver.resolveFork(List.of("B1","B2"), List.of("B1","B2","B3"));
    }
}
