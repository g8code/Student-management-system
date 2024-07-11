import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;

public class ViewOneUser  implements ActionListener
{
	static JFrame f=new JFrame("Database Records");

	private static JPanel jpRec = new JPanel();

	private static JLabel lbrollno;
	private static JLabel lbname;
	private static JLabel lbm1;
	private static JLabel lbm2;
	private static JLabel lbm3;
	private static JLabel lbper;
	private static JLabel lbRec;



	private static JTextField txtrollno;
	private static JTextField txtname;
	private static JTextField txtm1;
	private static JTextField txtm2;
	private static JTextField txtm3;
	private static JTextField txtper;
	private static JTextField txtRec;

	private static JButton btnFirst;
	private static JButton btnBack;
	private static JButton btnNext;
	private static JButton btnLast;

	private static int recCount = 0;
	private static	int total = DisplyAllRecords.row;

	static void populateArray ()
	{
		f.setSize (350, 300);
		f.setResizable(false);
		f.setLocationRelativeTo(null);

		jpRec.setLayout (null);

		lbrollno = new JLabel ("rollno:");
		lbrollno.setForeground (Color.black);
		lbrollno.setBounds (15, 20, 80, 25);

        lbname = new JLabel ("name:");
		lbname.setForeground (Color.black);
        lbname.setBounds (15, 55, 80, 25);

		lbm1 = new JLabel ("m1:");
		lbm1.setForeground (Color.black);
		lbm1.setBounds (15, 90, 80, 25);
		
		lbm2 = new JLabel ("m2 :");
		lbm2.setForeground (Color.black);
		lbm2.setBounds (15, 120, 60, 25);
		
		lbm3 = new JLabel ("m3 :");
		lbm3.setForeground (Color.black);
		lbm3.setBounds (15, 150, 100, 25);
		
		lbper = new JLabel ("per :");
		lbper.setForeground (Color.black);
		lbper.setBounds (15, 180, 100, 25);

		txtrollno = new JTextField ();
		txtrollno.setFont(new Font("Arial",Font.BOLD,20));
		txtrollno.setHorizontalAlignment (JTextField.CENTER);
		txtrollno.setBounds (125, 20, 200, 25);
		txtrollno.setEnabled(false);

		txtname = new JTextField ();
		txtname.setFont(new Font("Arial",Font.BOLD,20));
		txtname.setHorizontalAlignment (JTextField.CENTER);
		txtname.setEnabled (false);
		txtname.setBounds (125, 55, 200, 25);

		txtm1 = new JTextField ();
		txtm1.setFont(new Font("Arial",Font.BOLD,20));
		txtm1.setHorizontalAlignment (JTextField.CENTER);
		txtm1.setEnabled (false);
		txtm1.setBounds (125, 90, 200, 25);
		
		

		txtm2 = new JTextField ();
		txtm2.setFont(new Font("Arial",Font.BOLD,20));
		txtm2.setHorizontalAlignment (JTextField.CENTER);
		txtm2.setEnabled (false);
		txtm2.setBounds (125, 120, 200, 25);
		

		txtm3 = new JTextField ();
		txtm3.setFont(new Font("Arial",Font.BOLD,20));
		txtm3.setHorizontalAlignment (JTextField.CENTER);
		txtm3.setEnabled (false);
		txtm3.setBounds (125, 150, 200, 25);
		
		

		txtper = new JTextField ();
		txtper.setFont(new Font("Arial",Font.BOLD,20));
		txtper.setHorizontalAlignment (JTextField.CENTER);
		txtper.setEnabled (false);
		txtper.setBounds (125, 180, 200, 25);

		btnFirst = new JButton ("<<");
		btnFirst.setBounds (15, 230, 50, 25);
		btnFirst.addActionListener (new ViewOneUser());

		btnBack = new JButton ("<");
		btnBack.setBounds (65, 230, 50, 25);
		btnBack.addActionListener (new ViewOneUser());

		btnNext = new JButton (">");
		btnNext.setBounds (225, 230, 50, 25);
		btnNext.addActionListener (new ViewOneUser());

		btnLast = new JButton (">>");
		btnLast.setBounds (275, 230, 50, 25);
		btnLast.addActionListener (new ViewOneUser());

		txtRec = new JTextField ();
		txtRec.setEnabled (false);
		txtRec.setHorizontalAlignment (JTextField.CENTER);
		txtRec.setBounds (130, 230, 70, 25);

		jpRec.add (lbrollno);
		jpRec.add (txtrollno);
		jpRec.add (lbname);
		jpRec.add (txtname);
		jpRec.add (lbm1);
		jpRec.add (txtm1);
		jpRec.add (lbm2);
		jpRec.add (txtm2);
		jpRec.add (lbm3);
		jpRec.add (txtm3);
		jpRec.add (lbper);
		jpRec.add (txtper);
		jpRec.add (btnFirst);
		jpRec.add (btnBack);
		jpRec.add (btnNext);
		jpRec.add (btnLast);
		jpRec.add (txtRec);

		f.getContentPane().add (jpRec);

		showRec (0);

		f.setVisible (true);
	}

	public void actionPerformed (ActionEvent ae)
	{
		Object obj = ae.getSource();

		if (obj == btnFirst)
		{
			recCount = 0;
			showRec (recCount);
		}
		else if (obj == btnBack)
		{
			recCount = recCount - 1;
			if (recCount < 0)
			{
				recCount = 0;
				showRec (recCount);
				JOptionPane.showMessageDialog (f, "You are on First Record.","UserSystem - 1st Record", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				showRec (recCount);
			}
		}
		else if (obj == btnNext)
		{
			recCount = recCount + 1;
			if (recCount == total)
			{
				recCount = total - 1;
				showRec (recCount);
				JOptionPane.showMessageDialog (f, "You are on Last Record.","UserSystem - End of Records", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				showRec (recCount);
			}
		}
		else if (obj == btnLast)
		{
			recCount = total - 1;
			showRec (recCount);
		}
	}

	public static void showRec (int intRec)
	{
		txtrollno.setText (DisplyAllRecords.rows[intRec][0]);
		txtname.setText (DisplyAllRecords.rows[intRec][1]);
		txtm1.setText (DisplyAllRecords.rows[intRec][2]);
		txtm2.setText (DisplyAllRecords.rows[intRec][3]);
		txtm3.setText (DisplyAllRecords.rows[intRec][4]);
		txtper.setText (DisplyAllRecords.rows[intRec][5]);

		if (total == 0)
			txtRec.setText (intRec + "/" + total); //Showing Record No. and Total Records.
		else
			txtRec.setText ((intRec + 1) + "/" + total); //Showing Record No. and Total Records.
	}
}








