import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtuser;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\ACAD\\OOP\\Eclipse\\finals\\img\\2.png"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 490);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtuser = new JTextField();
		txtuser.setBounds(124, 182, 223, 27);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Noto Sans", Font.BOLD, 13));
		lblNewLabel.setBounds(203, 214, 72, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Noto Sans", Font.BOLD, 13));
		lblNewLabel_1.setBounds(203, 284, 61, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\ACAD\\OOP\\Eclipse\\finals\\Finals\\img\\3.png"));
		lblNewLabel_2.setBounds(172, 31, 134, 128);
		contentPane.add(lblNewLabel_2);
		
		JButton btnsignin = new JButton("Sign In");
		btnsignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnsignin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnsignin.setForeground(new Color(0, 0, 0));
		btnsignin.setBackground(new Color(68, 138, 255));
		btnsignin.setBounds(124, 309, 103, 23);
		contentPane.add(btnsignin);
		
		JButton btnreset = new JButton("Reset");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextfield();
			}
		});
		btnreset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnreset.setBackground(new Color(68, 138, 255));
		btnreset.setBounds(244, 309, 103, 23);
		contentPane.add(btnreset);
		
		JButton btnsignup = new JButton("Sign Up");
		btnsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration reg = new Registration();
				reg.setVisible(true);
				dispose();
			}
		});
		btnsignup.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnsignup.setBackground(new Color(68, 138, 255));
		btnsignup.setBounds(185, 343, 103, 23);
		contentPane.add(btnsignup);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(124, 256, 223, 27);
		contentPane.add(txtpass);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("E:\\ACAD\\OOP\\Eclipse\\finals\\Finals\\img\\n3.png"));
		lblNewLabel_4.setBounds(224, 388, 29, 29);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\ACAD\\OOP\\Eclipse\\finals\\Finals\\img\\n4.png"));
		lblNewLabel_3.setBounds(167, 388, 29, 29);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("E:\\ACAD\\OOP\\Eclipse\\finals\\Finals\\img\\n5.png"));
		lblNewLabel_5.setBounds(277, 388, 29, 29);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Sign In");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Century Gothic", Font.PLAIN, 29));
		lblNewLabel_6.setBounds(20, 11, 103, 53);
		contentPane.add(lblNewLabel_6);
	}
	
	public void login() {
		try {
			//set the mysql jdbc driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//set the mysql connection string
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/copl_db","root","");
			Statement stmt = (Statement) con.createStatement();
			//sql query for the login 
			String sql = "Select * from final_tbl where username='"+txtuser.getText() + "'and password='"+txtpass.getText()+"'";
			
			//execute query
			ResultSet rs = ((java.sql.Statement)stmt).executeQuery(sql);
								

			// conditions for uname & pword
			if(rs.next()) {
				String userName = txtuser.getText();
				Dashboard frmtwo = new Dashboard();
				frmtwo.lbluserT.setText("USER : "+userName);
				frmtwo.setVisible(true);
				dispose();
				JOptionPane.showMessageDialog(null, "Login successful...","Login Alert",2);
			}else if (txtuser.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Username is required...","Login Warning",2);
			}else if (txtpass.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Password is required...","Login Warning",2);
			}else {
				JOptionPane.showMessageDialog(null, "Username or password incorrect...","Login Warning",2);
			}
		}catch(Exception ex) {
			System.out.print(ex);
		}
	}
	private void clearTextfield() {
		// TODO Auto-generated method stub
		txtuser.setText("");
		txtpass.setText("");
		//JOptionPane.showMessageDialog(null, "Clear successful");
	}
}
