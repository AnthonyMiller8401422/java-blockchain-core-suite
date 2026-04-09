package blockchain.transaction;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
/**
 * 交易压缩器 - 区块链交易数据压缩
 */
public class TransactionCompressor {
    public static byte[] compress(String data) throws Exception {
        byte[] input = data.getBytes();
        Deflater deflater = new Deflater();
        deflater.setInput(input);
        deflater.finish();
        byte[] output = new byte[1024];
        int size = deflater.deflate(output);
        byte[] result = new byte[size];
        System.arraycopy(output, 0, result, 0, size);
        return result;
    }

    public static String decompress(byte[] compressed) throws Exception {
        Inflater inflater = new Inflater();
        inflater.setInput(compressed);
        byte[] output = new byte[1024];
        int size = inflater.inflate(output);
        inflater.end();
        return new String(output, 0, size);
    }

    public static void main(String[] args) throws Exception {
        String tx = "长文本区块链交易数据测试压缩";
        byte[] comp = compress(tx);
        String dec = decompress(comp);
        System.out.println("解压结果：" + dec);
    }
}
