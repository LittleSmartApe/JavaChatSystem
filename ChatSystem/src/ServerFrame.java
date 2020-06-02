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
    final int WIDTH = 300;
    //窗口高度
    final int HEIGHT = 120;
    JButton start = new JButton("Start");
    JButton exit = new JButton("Exit");
    JTextArea notice = new JTextArea();
    JLabel jl3= new JLabel();
    public ServerFrame() {
        setTitle("Server");
        setSize(WIDTH,HEIGHT);
        setResizable(true);
        setLayout(new GridLayout());//网格布局
        jl3.setIcon(new ImageIcon("img/QQ图片20200415114606.png"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 让JFrame的关闭按钮起作用
        this.add(exit);
        this.add(start);
        this.add(jl3);//添加图片

        exit.addActionListener(
        		new ActionListener() {
        			public void actionPerformed(ActionEvent event) {
        				System.out.println("服务器已关闭");
        				System.exit(0);
        			}
        		}
        	);
        start.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent event){

             new Thread(new Activate()).start();
        		
        	}
        });
    }
}
//多线程开启服务器 防止卡死
class Activate implements Runnable {
	public void run() {
		   //建立服务器
        ServerSocket server;
		try {
			server = new ServerSocket(6666);
			System.out.println("服务器正在运行······");
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
			System.out.println("请不要重复开启服务器！");
		}
	}
}
