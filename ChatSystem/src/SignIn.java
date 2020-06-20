import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.nio.charset.*;
import java.text.*;

public class SignIn {

    //建立客户端
    public static Socket signin=null;

    public static void main(String[] args) throws Exception{

        //创建登录窗口对象
        SignInFrame cframe = new SignInFrame();
        //获取本机屏幕横向分辨率
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        //获取本机屏幕纵向分辨率
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        //将窗口置中
        cframe.setLocation((w - cframe.width)/2, (h - cframe.height)/2);
        //设置客户端窗口为可见
        cframe.setVisible(true);

        
        try {
            //连接服务器
        	signin = new Socket(InetAddress.getLocalHost(), 6666);
            //获取输入输出流
            InputStream in = signin.getInputStream();
            OutputStream out = signin.getOutputStream();

            //获取服务端欢迎信息
            byte[] bytes = new byte[1024];
            int len = in.read(bytes);

            //持续等待服务器信息直至退出
            while (true) {

                //读取服务器发来的信息
                in = signin.getInputStream();
                len = in.read(bytes);
               // System.out.println(len);
                //处理服务器传来的消息
                String msg = new String(bytes, 0, len);

                //获取消息类型：更新在线名单或者聊天
                String type = msg.substring(0, msg.indexOf("/"));
                //消息本体：更新后的名单或者聊天内容
                String chat = msg.substring(msg.indexOf("/")+1);

                //根据消息类型分别处理
                //更新在线名单
            }
        }catch(Exception e){
            
        }
    }
}
