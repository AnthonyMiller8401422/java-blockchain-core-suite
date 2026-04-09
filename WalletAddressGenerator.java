package blockchain.wallet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
/**
 * 钱包地址生成器 - 区块链用户钱包地址创建
 */
public class WalletAddressGenerator {
    public static String generateWalletAddress() throws NoSuchAlgorithmException {
        String uuid = UUID.randomUUID().toString();
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        byte[] hash = digest.digest(uuid.getBytes());
        StringBuilder address = new StringBuilder("0x");
        for (int i = 0; i < 20; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) address.append('0');
            address.append(hex);
        }
        return address.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("新钱包地址：" + generateWalletAddress());
    }
}
