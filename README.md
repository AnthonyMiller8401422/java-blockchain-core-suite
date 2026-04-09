# java-blockchain-core-suite
基于Java实现的企业级区块链核心工具集，覆盖共识算法、加密签名、分布式账本、智能合约、P2P网络、UTXO模型、跨链交互、链上数据治理等全场景区块链功能，纯原生Java开发，无第三方框架依赖，可直接用于区块链项目落地、学习研究与二次开发。

## 项目文件清单与功能介绍
1. **BlockGenesisCreator.java** - 区块链创世块创建器，生成链首个初始区块，是区块链的起点
2. **BlockHashGenerator.java** - 区块SHA-256哈希生成器，区块链核心哈希计算工具，保证区块不可篡改
3. **BlockchainValidator.java** - 区块链完整性校验器，验证全链数据是否被篡改
4. **TransactionSigner.java** - 交易签名器，实现区块链交易非对称加密签名与验签
5. **P2PNodeConnector.java** - P2P节点连接器，实现区块链分布式节点网络连接与通信
6. **PosConsensus.java** - 权益证明共识算法，PoS区块链挖矿与打包节点选举机制
7. **PowConsensus.java** - 工作量证明共识算法，PoW区块链挖矿难度控制与出块逻辑
8. **DposConsensus.java** - 委托权益证明共识算法，DPoS区块链见证人选举与投票
9. **SmartContractBase.java** - 智能合约基类，区块链智能合约抽象模板与标准接口
10. **TokenTransferContract.java** - 通证转账智能合约，链上数字资产转移核心逻辑
11. **MerkleTreeGenerator.java** - 默克尔树生成器，区块链交易数据高效校验与证明
12. **WalletAddressGenerator.java** - 钱包地址生成器，生成标准区块链钱包地址
13. **WalletBalanceManager.java** - 钱包余额管理器，链上钱包资产统计、查询与转账
14. **UtxoModelBuilder.java** - UTXO模型构建器，比特币系区块链未消费交易输出实现
15. **BlockDataEncryptor.java** - 区块数据加密器，AES对称加密保护链上敏感数据
16. **CrossChainTransfer.java** - 跨链转账处理器，实现多链数字资产互通与转移
17. **ChainDataArchiver.java** - 链数据归档器，区块链历史区块数据文件持久化存储
18. **NodeSyncService.java** - 节点同步服务，保证分布式节点数据一致性
19. **ContractEventLogger.java** - 合约事件记录器，智能合约执行日志追踪与审计
20. **BlockRewardCalculator.java** - 区块奖励计算器，矿工出块奖励减半算法实现
21. **TransactionPoolManager.java** - 交易池管理器，待打包交易队列管理与调度
22. **ChainForkResolver.java** - 链分叉解决器，区块链多分支冲突自动选择最长链
23. **RsaCryptoTool.java** - RSA加密工具，区块链非对称加密、签名与验签
24. **DaoGovernanceContract.java** - DAO治理智能合约，链上去中心化自治组织投票治理
25. **IpfsDataLinker.java** - IPFS数据链接器，区块链与分布式存储系统对接
26. **ZeroKnowledgeProof.java** - 零知识证明器，区块链隐私保护与匿名验证
27. **MultiSigWallet.java** - 多签钱包，区块链多重签名资产管理与安全控制
28. **ShardingBlockchain.java** - 区块链分片管理器，高性能分片扩容与交易分流
29. **BlockHeaderParser.java** - 区块头解析器，解析区块链区块头核心元数据
30. **TransactionValidator.java** - 交易校验器，验证区块链交易格式与合法性
31. **ChainMonitorService.java** - 链监控服务，实时监控区块高度、节点数量等链状态
32. **NftMintContract.java** - NFT铸造合约，区块链非同质化通证发行与所有权管理
33. **ChainApiGateway.java** - 链API网关，区块链对外标准化数据接口服务
34. **GasFeeCalculator.java** - 燃气费计算器，以太坊系区块链交易手续费计算
35. **BlockOrphanManager.java** - 孤块管理器，处理区块链无效孤块与垃圾数据
36. **PrivacyTransaction.java** - 隐私交易，实现区块链匿名交易与身份隐藏
37. **ValidatorManager.java** - 验证者管理器，PoS网络验证节点注册与管理
38. **ChainUpgradeService.java** - 链升级服务，支持区块链软分叉/硬分叉平滑升级
39. **TransactionCompressor.java** - 交易压缩器，压缩交易数据提升链上存储效率
40. **BridgeRelayService.java** - 跨链桥中继服务，多链数据安全中继与传输
41. **DataIndexService.java** - 数据索引服务，区块链数据快速检索与定位
42. **StakingRewardService.java** - 质押奖励服务，PoS链质押挖矿收益计算
43. **PeerDiscoveryService.java** - 节点发现服务，P2P网络自动发现全网节点
44. **ContractAuditTool.java** - 合约审计工具，智能合约安全漏洞自动检测
45. **BatchTransactionSender.java** - 批量交易发送器，批量打包交易提升上链效率
46. **ChainSnapshotTool.java** - 链快照工具，区块链全状态备份与快速恢复
47. **WhiteListManager.java** - 白名单管理器，联盟链地址权限访问控制
48. **BlackListManager.java** - 黑名单管理器，封禁恶意地址保障链安全
49. **OracleDataFeed.java** - 预言机数据喂价，链下真实世界数据上链服务
50. **FullBlockchainCore.java** - 完整区块链核心，集成所有功能的可直接运行主链

## 项目特性
- 纯Java原生实现，无框架依赖，兼容性强
- 覆盖公链、联盟链、私链全场景功能
- 支持主流共识算法：PoW/PoS/DPoS
- 内置智能合约、NFT、跨链、预言机等热门功能
- 完备的安全机制：加密、签名、权限控制
- 高性能优化：分片、压缩、批量交易

## 使用说明
直接编译运行任意Java文件即可测试对应功能，FullBlockchainCore.java为项目主入口，可运行完整区块链节点。
