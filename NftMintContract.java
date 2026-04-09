package blockchain.contract;
import java.util.HashMap;
import java.util.Map;
/**
 * NFT铸造合约 - 区块链非同质化通证发行
 */
public class NftMintContract extends SmartContractBase {
    private final Map<String, String> nftOwners;
    private int tokenId;

    public NftMintContract(String address) {
        super(address);
        nftOwners = new HashMap<>();
        tokenId = 0;
    }

    public String mintNft(String owner) {
        String id = "NFT_" + tokenId++;
        nftOwners.put(id, owner);
        System.out.println("NFT铸造成功：" + id + " 所有者：" + owner);
        return id;
    }

    public String getNftOwner(String nftId) {
        return nftOwners.getOrDefault(nftId, "无");
    }

    @Override
    public boolean executeContract(String params) {
        return true;
    }

    @Override
    public String getContractState() {
        return "已铸造NFT数量：" + tokenId;
    }

    public static void main(String[] args) {
        NftMintContract nft = new NftMintContract("NFT001");
        nft.mintNft("USER1");
        System.out.println(nft.getNftOwner("NFT_0"));
    }
}
