import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.applet.Applet;



public class Regi implements ActionListener {
Label L1,L2,L3,L4;
JLabel L5,L6;
TextField tf1,tf2,tf3,tf4,tf5;
Button b1,b2,b3;
int flag=0;
JFrame f1;
//JProgressBar br=new JProgressBar();


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   Regi obj=new Regi ();
	}
	Regi(){
		f1=new JFrame();
		f1.setSize(800,500);
		f1.setLayout(null);
	
		
		//f1.setResizable(false);
		
		/* br.setOrientation(0);
		 br.setBounds(275,30,250,25);
		 br.setBackground(Color.black);
		 br.setFont(new Font("Arrial",Font.BOLD,25));
	//	 br.setForeground(Color.white);
		 br.setIndeterminate(true);
		 br.setString("DATA ENTER");
		 br.setStringPainted(true);
		 f1.add(br);*/
		
	L1=new Label("-: DATA ENTER :-");
		L1.setBounds(275,30,250,25);
		L1.setFont(new Font("Arial",Font.BOLD,22));
		f1.add(L1);
		

	
		
		L2=new Label("rollno :-");
		L2.setBounds(400,110,55,25);
		f1.add(L2);
		
		tf1=new TextField();
		tf1.setBounds(475,110,250,25);
		f1.add(tf1);
		
		L3=new Label("name :-");
		L3.setBounds(400,140,80,25);
		f1.add(L3);
		
		tf2=new TextField();
		tf2.setBounds(475,140,250,25);
		f1.add(tf2);
		
		L4=new Label("m1 :-");
		L4.setBounds(400,170,80,25);
		f1.add(L4);
		
		tf3=new TextField();
		tf3.setBounds(475,170,250,25);
		f1.add(tf3);
		
		L4=new Label("m2 :-");
		L4.setBounds(400,200,80,25);	
		f1.add(L4);
		
		tf4=new TextField();
		tf4.setBounds(475,200,250,25);
		f1.add(tf4);
		
		L4=new Label("m3 :-");
		L4.setBounds(400,230,80,25);
		f1.add(L4);
		
		tf5=new TextField();
		tf5.setBounds(475,230,250,25);
		f1.add(tf5);
		

		b1=new Button("Submit");
		b1.setBounds(400,280,100,30);
		f1.add(b1);
		
		b2=new Button("Cancel");
		b2.setBounds(520,280,100,30);
		f1.add(b2);
		
		b3=new Button("Display");
		b3.setBounds(630,280,100,30);
		f1.add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		
	
		
	L6=new JLabel();
    Image img=new ImageIcon (this.getClass().getResource("/image1.png")).getImage();
    L6.setIcon(new ImageIcon(img));
    L6.setBounds(50,80,300,300);
    f1.add(L6);
		 
		f1.setVisible(true);
		
		tf2.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent ke)
			{
				char ch=ke.getKeyChar();
			if(!((ch>='a'&& ch<='z')||(ch>='A' && ch<='Z')||ch==KeyEvent.VK_BACK_SPACE))
			{
				f1.getToolkit().beep();
				ke.consume();
			}
			}
		});
		
		tf1.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent ke)
			{
				char ch=ke.getKeyChar();
			if(!((ch>='0' && ch<='9')||ch==KeyEvent.VK_BACK_SPACE))
			{
				f1.getToolkit().beep();
				ke.consume();
			}
			else 
				if(tf3.getText().length()==10)
				{
					if(ch==KeyEvent.VK_BACK_SPACE)
					f1.getToolkit().beep();
					tf3.setText(tf3.getText().substring(0,tf3.getText().length()-1));
					ke.consume();
				}
			}
		});

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object ob=e.getSource();
		if(ob==b2)
		f1.dispose();
		else
			if(ob==b1)
				insertintodatabase.insert(tf1.getText(),tf2.getText(), tf3.getText(),tf4.getText(),tf5.getText());
			else
				if(ob==b3)
		DisplyAllRecords.display();
		
		
						
		Object obj=e.getSource();
		if(obj==b1&&flag==0)
		{
			b1.setBackground(Color.green);
		flag=1;
		}
		else
		if(obj==b1&&flag==1)
			{
			b1.setBackground(Color.white);
			flag=0;
			}
		else
			
			if(obj==b2&&flag==0)
			{
				b2.setBackground(Color.red);
			flag=1;
			}
			else
			if(obj==b2&&flag==1)
				{
				b2.setBackground(Color.white);
				flag=0;
				}
			else
				if(obj==b3&&flag==0)
				{
					b3.setBackground(Color.blue);
				flag=1;
				}
				else
				if(obj==b3&&flag==1)
					{
					b3.setBackground(Color.white);
					flag=0;
					}
		
		}

		}
		
	


