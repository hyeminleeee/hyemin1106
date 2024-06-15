package fitness;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AdminPassword adminPassword;
	private Myinfo myinfo;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Itwill Fitness Center");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Welcome Guys!!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("나눔고딕코딩", Font.BOLD, 42));
		scrollPane.setViewportView(lblNewLabel);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
		JButton myinfoButtion = new JButton("내 정보");
		myinfoButtion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myinfo=new Myinfo();
				myinfo.setVisible(true);
				setVisible(false);
			}
		});
		myinfoButtion.setFont(new Font("굴림체", Font.PLAIN, 14));
		panel.add(myinfoButtion);
		
		JButton managerButton = new JButton("관리자");
		managerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminPassword =new AdminPassword();
				adminPassword.setVisible(true);
				setVisible(false);
			}
		});
		managerButton.setFont(new Font("굴림체", Font.PLAIN, 14));
		panel.add(managerButton);
	}

}
