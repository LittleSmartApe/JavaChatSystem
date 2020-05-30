import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerFrame extends JFrame{
	//窗口宽度
    final int WIDTH = 500;
    //窗口高度
    final int HEIGHT = 200;
    JButton start = new JButton("Start");
    JButton exit = new JButton("Exit");
    public ServerFrame() {
        setTitle("Server");
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setLayout(new FlowLayout());
        this.add(exit);
        this.add(start);
        exit.addActionListener(
        		new ActionListener() {
        			public void actionPerformed(ActionEvent event) {
        				System.exit(0);
        			}
        		}
        	);
        start.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent event){

             new Thread(new Start()).start();
        		
        	}
        });
    }
}
class Start implements Runnable{
	public void run() {
		   //建立服务器
        ServerSocket server;
		try {
			server = new ServerSocket(6666);
			while(true) {
                //接收客户端Socket
                Socket client = server.accept();
                //提取客户端Ip
                String ip=client.getInetAddress().getHostAddress();
                //提取客户端端口号
                int port=client.getPort();
                //建立新的服务器线程, 向该线程提供服务器ServerSocket，客户端Socket，客户端IP和端口
                new Thread(new ServerThread(client, server, ip, port)).start();
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //提示服务端建立成功
        //socket.getInetAddress()返回InetAddress对象包含远程计算机的IP地址。
        // InetAddress.getHostAddress()返回String对象与该地址的文本表示。
      //  System.out.println("Server online...."+server.getInetAddress().getLocalHost().getHostAddress()+","+6666);
        //创建客户端窗口对象
	}
}
    

