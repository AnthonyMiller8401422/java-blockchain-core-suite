package blockchain.consensus;
import java.util.ArrayList;
import java.util.List;
/**
 * 验证者管理器 - PoS网络验证节点管理
 */
public class ValidatorManager {
    private final List<String> validators;

    public ValidatorManager() {
        validators = new ArrayList<>();
    }

    public void registerValidator(String node) {
        validators.add(node);
        System.out.println("验证者注册：" + node);
    }

    public void removeValidator(String node) {
        validators.remove(node);
        System.out.println("验证者移除：" + node);
    }

    public List<String> getValidators() {
        return validators;
    }

    public static void main(String[] args) {
        ValidatorManager manager = new ValidatorManager();
        manager.registerValidator("NODE_V1");
        System.out.println("验证者列表：" + manager.getValidators());
    }
}
