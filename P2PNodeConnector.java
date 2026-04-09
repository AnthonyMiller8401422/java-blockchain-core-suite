package blockchain.p2p;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * P2P节点连接器 - 区块链分布式节点网络连接
 */
public class P2PNodeConnector {
    public static void startServer(int port) {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("P2P节点服务启动，端口：" + port);
            while (true) {
                Socket client = server.accept();
                System.out.println("新节点连接：" + client.getInetAddress());
                new Thread(() -> handleNode(client)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleNode(Socket socket) {
        try {
            System.out.println("处理节点通信：" + socket.getInetAddress());
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void connectNode(String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            System.out.println("成功连接远程节点：" + host + ":" + port);
        } catch (Exception e) {
            System.out.println("连接节点失败");
        }
    }

    public static void main(String[] args) {
        new Thread(() -> startServer(8888)).start();
    }
}
