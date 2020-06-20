import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class InformationinterfaceFrame extends JFrame{
	//设置宽度和高度
	final int width = 320;
	public JLabel getIP() {
		return IP;
	}
	public void setIP(JLabel iP) {
		IP = iP;
	}
	public JLabel getPORT() {
		return PORT;
	}
	public void setPORT(JLabel pORT) {
		PORT = pORT;
	}
	public JLabel getNAMES() {
		return NAMES;
	}
	public void setNAMES(JLabel nAMES) {
		NAMES = nAMES;
	}
	final int height = 320;
	//添加按钮
	JButton NAME = new JButton("确认");
	JButton PASSWORD = new JButton("确认");
	//添加标签
	JLabel ClientIP = new JLabel("客户端IP:");
	JLabel ClientPORT = new JLabel("客户端端口:");
	JLabel ClientNAME = new JLabel("用户名:");
	JLabel ClientNAMECHANGE = new JLabel("更改用户名:");
	JLabel ClientPASSWORD = new JLabel("密码:******");
	JLabel ClientPASSWORDCHANGE = new JLabel("更改密码:");
	
	public JLabel IP =new JLabel();
	public JLabel PORT =new JLabel();
	public JLabel NAMES =new JLabel();
	
	//添加输入框
	JTextArea textNAME = new JTextArea();
	JTextArea textPASSWORD = new JTextArea();
	public InformationinterfaceFrame(){
		//设置界面属性
		setTitle("信息界面");
		setSize(width,height);
		setResizable(false);
		setLayout(null);
		
		//设置按钮
		NAME.setBounds(230,130,66,20);
		NAME.setFont(new Font("楷体", Font.BOLD, 16));
		this.add(NAME);
		
		PASSWORD.setBounds(230,220,66,20);
		PASSWORD.setFont(new Font("楷体", Font.BOLD, 16));
		this.add(PASSWORD);
		
		//设置标签
		ClientIP.setBounds(20,-80,200,200);
		ClientIP.setFont(new Font("楷体", Font.BOLD, 16));
		this.add(ClientIP);
		
		IP.setBounds(100,-80,200,200);
		IP.setFont(new Font("楷体", Font.BOLD, 16));
		this.add(IP);
		
		ClientPORT.setBounds(20,-50,200,200);
		ClientPORT.setFont(new Font("楷体", Font.BOLD, 16));
		this.add(ClientPORT);
		
		PORT.setBounds(115,-50,200,200);
		PORT.setFont(new Font("楷体", Font.BOLD, 16));
		this.add(PORT);
		
		ClientNAME.setBounds(20,-20,200,200);
		ClientNAME.setFont(new Font("楷体", Font.BOLD, 16));
		this.add(ClientNAME);
		
		NAMES.setBounds(85,-20,200,200);
		NAMES.setFont(new Font("楷体", Font.BOLD, 16));
		this.add(NAMES);
		
		ClientNAMECHANGE.setBounds(20,10,200,200);
		ClientNAMECHANGE.setFont(new Font("楷体", Font.BOLD, 16));
		this.add(ClientNAMECHANGE);
		
		ClientPASSWORD.setBounds(20,70,200,200);
		ClientPASSWORD.setFont(new Font("楷体", Font.BOLD, 16));
		this.add(ClientPASSWORD);
		
		ClientPASSWORDCHANGE.setBounds(20,100,200,200);
		ClientPASSWORDCHANGE.setFont(new Font("楷体", Font.BOLD, 16));
		this.add(ClientPASSWORDCHANGE);
		
		//设置输入框
		textNAME.setBounds(20,130,200,20);
		textNAME.setFont(new Font("宋体", Font.BOLD, 16));
		this.add(textNAME);
		
		textPASSWORD.setBounds(20,220,200,20);
		textPASSWORD.setFont(new Font("宋体", Font.BOLD, 16));
		this.add(textPASSWORD);
		
		NAME.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
            	 if(textNAME.getText().equals("")) {
            		 JOptionPane.showMessageDialog(null,"用户名不能为空！","提示",JOptionPane.WARNING_MESSAGE);
                 }else {
                     textNAME.setText("");
                     JOptionPane.showMessageDialog(null,"更改用户名成功！","提示",JOptionPane.WARNING_MESSAGE);
             }
             }
         }); 
		
		PASSWORD.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	if(textPASSWORD.getText().equals("")) {
            		JOptionPane.showMessageDialog(null,"密码不能为空！","提示",JOptionPane.WARNING_MESSAGE);
            	}else {
                    textPASSWORD.setText("");
                    JOptionPane.showMessageDialog(null,"更改密码成功！","提示",JOptionPane.WARNING_MESSAGE);
            }
            }
        }); 
		
	}

}
