package blockchain.crypto;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Base64;
/**
 * RSA加密工具 - 区块链非对称加密签名
 */
public class RsaCryptoTool {
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        return generator.generateKeyPair();
    }

    public static String sign(String data, KeyPair keyPair) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(keyPair.getPrivate());
        signature.update(data.getBytes());
        return Base64.getEncoder().encodeToString(signature.sign());
    }

    public static boolean verify(String data, String sign, KeyPair keyPair) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(keyPair.getPublic());
        signature.update(data.getBytes());
        return signature.verify(Base64.getDecoder().decode(sign));
    }

    public static void main(String[] args) throws Exception {
        KeyPair key = generateKeyPair();
        String data = "RSA签名测试";
        String sign = sign(data, key);
        System.out.println("验证结果：" + verify(data, sign, key));
    }
}
