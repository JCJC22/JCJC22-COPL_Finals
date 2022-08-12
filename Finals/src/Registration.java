import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtcpass;
	private JPasswordField txtpword;
	private JTextField txtuname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 451);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\ACAD\\OOP\\Eclipse\\finals\\Finals\\img\\5.png"));
		lblNewLabel_3.setBounds(203, 21, 128, 129);
		contentPane.add(lblNewLabel_3);
		
		JButton btnsignup = new JButton("Sign Up");
		btnsignup.setBackground(new Color(68, 138, 255));
		btnsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regUser();
			}
		});
		btnsignup.setBounds(102, 320, 135, 23);
		contentPane.add(btnsignup);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextfield();
			}
		});
		btnReset.setBackground(new Color(68, 138, 255));
		btnReset.setBounds(275, 320, 135, 23);
		contentPane.add(btnReset);
		
		txtcpass = new JPasswordField();
		txtcpass.setBounds(177, 263, 182, 23);
		contentPane.add(txtcpass);
		
		txtpword = new JPasswordField();
		txtpword.setBounds(177, 220, 182, 23);
		contentPane.add(txtpword);
		
		txtuname = new JTextField();
		txtuname.setBounds(177, 179, 182, 23);
		contentPane.add(txtuname);
		txtuname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(85, 185, 82, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(85, 226, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(51, 269, 116, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Sign Up");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.PLAIN, 29));
		lblNewLabel_4.setBounds(39, 11, 128, 59);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login f1 = new Login();
				f1.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(64, 64, 64));
		btnNewButton.setIcon(new ImageIcon("E:\\ACAD\\OOP\\Eclipse\\finals\\Finals\\img\\9.png"));
		btnNewButton.setBounds(408, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon("E:\\ACAD\\OOP\\Eclipse\\finals\\Finals\\img\\n4.png"));
		lblNewLabel_3_1.setBounds(158, 359, 29, 29);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon("E:\\ACAD\\OOP\\Eclipse\\finals\\Finals\\img\\n3.png"));
		lblNewLabel_4_1.setBounds(234, 359, 29, 29);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("E:\\ACAD\\OOP\\Eclipse\\finals\\Finals\\img\\n5.png"));
		lblNewLabel_5.setBounds(305, 359, 29, 29);
		contentPane.add(lblNewLabel_5);
	}
	
	//db connection
	static Connection connect() {
		try {
			String myDriver = "com.mysql.cj.jdbc.Driver";
			//connection string
			String url = "jdbc:mysql://localhost:3307/copl_db";
			Class.forName(myDriver);
			return (Connection)DriverManager.getConnection(url,"root","");
		}catch(Exception e) {
			System.out.print("Cannot connect to the database");
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public void regUser() {
		Connection con = connect();
		
		try {
			Statement stmt = con.createStatement();
			String chk = "SELECT * from final_tbl where username ='"+txtuname.getText() +"'and password='"+txtpword.getText()+"'";
			ResultSet rs = stmt.executeQuery(chk); 
			if(rs.next()) 
			{
				JOptionPane.showMessageDialog(null, "Username " + txtuname.getText() + " is already used...","Error", JOptionPane.ERROR_MESSAGE);
				clearTextfield();
			}
			else if (!txtcpass.getText().equals(txtpword.getText()))
			{
				JOptionPane.showMessageDialog(null, "Password is not match","Error", JOptionPane.ERROR_MESSAGE);
				clearTextfield();
			}
			else if (txtuname.getText().equals("") || txtpword.getText().equals("") || txtcpass.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "You must fill in all of the fields. ","Error", JOptionPane.ERROR_MESSAGE);
				clearTextfield();
			}else {
			String sql = "INSERT INTO final_tbl(username, password, cpass) VALUES (?,?,?)";
			PreparedStatement ps =(PreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1, txtuname.getText());
			ps.setString(2, txtpword.getText());
			ps.setString(3, txtcpass.getText());
			ps.execute();
			
			ImageIcon icon = new ImageIcon("E:\\ACAD\\OOP\\Eclipse\\finals\\Finals\\img\\7.png");
			 JOptionPane.showMessageDialog(null,"Registered successfully","Success",JOptionPane.PLAIN_MESSAGE,icon);
			
				Login f1 = new Login();
				f1.setVisible(true);
				dispose();
		}
			
			
		}catch(Exception e) {
			System.out.print("Error..." + e);
		}
	}// end of reg
	
	private void clearTextfield() {
		// TODO Auto-generated method stub
		txtuname.setText("");
		txtpword.setText("");
		txtcpass.setText("");
		//JOptionPane.showMessageDialog(null, "Clear successful");
	}
}
