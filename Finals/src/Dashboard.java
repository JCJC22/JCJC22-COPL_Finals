import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	JLabel lbluserT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setForeground(Color.BLACK);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 302);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome !");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 32));
		lblNewLabel.setBounds(212, 54, 197, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\ACAD\\OOP\\Eclipse\\finals\\Finals\\img\\33.png"));
		lblNewLabel_1.setBounds(147, 54, 94, 64);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Thank you for signing up");
		lblNewLabel_2.setFont(new Font("SimSun", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(222, 102, 153, 14);
		contentPane.add(lblNewLabel_2);
		
		lbluserT = new JLabel("");
		lbluserT.setFont(new Font("Century Gothic", Font.BOLD, 23));
		lbluserT.setBounds(232, 129, 126, 30);
		contentPane.add(lbluserT);
	}

}
