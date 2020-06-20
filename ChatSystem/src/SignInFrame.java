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
public class SignInFrame extends JFrame{
	//设置窗口宽度高度
	final int width = 300;
	final int height = 300;
	boolean isSigning = false;
	//创建登录按钮
	JButton logIn = new JButton("登录");
	//创建注册按钮
	JButton signIn = new JButton("注册");
	//创建登录按钮
	JButton confirm = new JButton("确认");
	//创建注册按钮
	JButton back = new JButton("返回");
	JButton forgot = new JButton("忘记密码？");
	//创建软件名称标签
    JLabel programName = new JLabel("QQPlus");
    //创建用户名标签
    JLabel userName = new JLabel("用户名：");
    //创建密码标签
    JLabel passWord = new JLabel("密码：");
    //创建确认密码标签
    JLabel confirmPassWord = new JLabel("确认密码：");
  //创建用户名输入框, 参数分别为行数和列数
    JTextArea userNameText = new JTextArea();
  //创建密码输入框, 参数分别为行数和列数
    JTextArea passWordText = new JTextArea();
  //创建确认密码输入框，参数分别为行数和列数
    JTextArea passWordAgain = new JTextArea();
  //创建保存密码和自动登录的复选框
    JCheckBox rememberPassWord = new JCheckBox("保存密码");
    JCheckBox autoEnter = new JCheckBox("自动登录");
    public SignInFrame() {
    	//标题
        setTitle("欢迎");
        //大小
        setSize(width, height);
        //不可缩放
        setResizable(false);
        //设置布局:不适用默认布局，完全自定义
        setLayout(null);
      //设置按钮大小和位置
        logIn.setBounds(40, 200, 80, 40);
        signIn.setBounds(180, 200, 80, 40);
        confirm.setBounds(40, 200, 80, 40);
        back.setBounds(180, 200, 80, 40);
      //设置标签大小和位置
        userName.setBounds(30, 60, 100, 20);
        passWord.setBounds(30, 100, 100, 20);
        confirmPassWord.setBounds(30, 140, 100, 20);
      //设置复选框大小和位置
        rememberPassWord.setBounds(70, 145, 100, 20);
        autoEnter.setBounds(150, 145, 100, 20);
      //设置按钮文本的字体
        logIn.setFont(new Font("宋体", Font.BOLD, 18));
        signIn.setFont(new Font("宋体", Font.BOLD, 18));
        confirm.setFont(new Font("宋体", Font.BOLD, 18));
        back.setFont(new Font("宋体", Font.BOLD, 18));
      //添加按钮
        this.add(logIn);
        this.add(signIn);
        this.add(confirm);
        this.add(back);
        this.add(forgot);
        confirm.setVisible(false);
        back.setVisible(false);
        //添加标签
        this.add(userName);
        this.add(passWord);
        this.add(confirmPassWord);
        confirmPassWord.setVisible(false);
        //添加复选框
        this.add(rememberPassWord);
        this.add(autoEnter);
        
        //设置文本输入框大小和位置
        userNameText.setBounds(30, 80, 240, 20);
        passWordText.setBounds(30, 120, 240, 20);
        passWordAgain.setBounds(30, 160, 240, 20);
        //设置文本输入框字体
        userNameText.setFont(new Font("楷体", Font.BOLD, 16));
        passWordText.setFont(new Font("楷体", Font.BOLD, 16));
        passWordAgain.setFont(new Font("楷体", Font.BOLD, 16));
        //添加文本输入框
        this.add(userNameText);
        this.add(passWordText);
        this.add(passWordAgain);
        passWordAgain.setVisible(false);
      //添加注册按钮的响应事件
        if(rememberPassWord.isSelected()) {
        	
        }
        
        signIn.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
            	 userNameText.setText("");
             	 passWordText.setText("");
            	 confirm.setVisible(true);
                 back.setVisible(true);
                 signIn.setVisible(false);
                 logIn.setVisible(false);
                 autoEnter.setVisible(false);
                 rememberPassWord.setVisible(false);
                 passWordAgain.setVisible(true);
                 confirmPassWord.setVisible(true);
             }
         }); 
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	userNameText.setText("");
            	passWordText.setText("");
            	passWordAgain.setText("");
           	 	confirm.setVisible(false);
                back.setVisible(false);
                signIn.setVisible(true);
                logIn.setVisible(true);
                autoEnter.setVisible(true);
                rememberPassWord.setVisible(true);
                passWordAgain.setVisible(false);
                confirmPassWord.setVisible(false);
            }
        });
        logIn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	new Thread(new Client()).start();
            }
        });
        rememberPassWord.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
        		if(rememberPassWord.isSelected()) {
        			try {
        				DataInputStream di
        				= new DataInputStream(new FileInputStream("test.txt"));
        				BufferedReader din = new BufferedReader(new InputStreamReader(di));
        				String str;
        				str = din.readLine();
        				String currentUser = userNameText.getText().toString();
        				String[] record = str.split("\\s+");
        				if(currentUser.equals(record[0])){
        					passWordText.setText(record[1]);
        				}
        			}catch(IOException exp){
	                	System.out.println(exp);
	                }
        		}else{
        			passWordText.setText("");
        		}
        	}
        });
        confirm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	String white = "";
            	String test0 = userNameText.getText().toString().trim();
            	String test1 = passWordText.getText().toString().trim();
            	String test2 = passWordAgain.getText().toString().trim();
            	if(test0.equals(white)) {
            		JOptionPane.showMessageDialog(null,"请输入一个用户名！","错误",JOptionPane.WARNING_MESSAGE);
            	}else if(test0.length()<6) {
            		JOptionPane.showMessageDialog(null,"用户名过短，请重新输入！","错误",JOptionPane.WARNING_MESSAGE);
            	}else{
            		if(test1.equals(test2)) {
            			if(test1.equals(white)) {
            				JOptionPane.showMessageDialog(null,"请输入一个密码","错误",JOptionPane.WARNING_MESSAGE);
            			}else if(test1.length()<6){
            				JOptionPane.showMessageDialog(null,"密码过短，请重新输入！","错误",JOptionPane.WARNING_MESSAGE);
            				passWordText.setText("");
            				passWordAgain.setText("");
            			}else{
	    	           	 	confirm.setVisible(false);
	    	                back.setVisible(false); 
	    	                signIn.setVisible(true);
	    	                logIn.setVisible(true);
	    	                autoEnter.setVisible(true);
	    	                rememberPassWord.setVisible(true);
	    	                passWordAgain.setVisible(false);
	    	                confirmPassWord.setVisible(false);
	    	                passWordAgain.setText("");
	    	                String content[] = {test0+" ",test1+"\n"};
	    	                try {
	    	                	FileWriter dout = new FileWriter("test.txt");
	    	                	dout.write(content[0]+" "+content[1]);
	    	                	dout.flush();
	    	                }catch(IOException exp){
	    	                	System.out.println(exp);
	    	                }
            			}
                	}else{
                		JOptionPane.showMessageDialog(null,"两次密码不一致！","错误",JOptionPane.WARNING_MESSAGE);
                	}
            	}
            }
        });
    }
}
