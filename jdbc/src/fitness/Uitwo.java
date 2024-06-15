package fitness;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class Uitwo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nameTF;
    private JTextField startdateTF;
    private JTextField typeTF;
    private JTextField priceTF;
    private JTextField phoneTF;
    private JTextField noTF;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Uitwo frame = new Uitwo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Uitwo() {
    	  
    	setLocationRelativeTo(null);
    	
    	setTitle("아이티윌 피트니스");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel phoneLB = new JLabel("전화번호");
        phoneLB.setFont(new Font("굴림", Font.BOLD, 20));
        phoneLB.setBounds(24, 10, 100, 30);
        contentPane.add(phoneLB);

        JButton selectButton = new JButton("검색");
        selectButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//setMyData();
        		//selectMyData();
        }
        });
        selectButton.setFont(new Font("굴림", Font.BOLD, 8));
        selectButton.setBounds(300, 10, 55, 30);
        contentPane.add(selectButton);

        JLabel nameLB = new JLabel("이름");
        nameLB.setHorizontalAlignment(SwingConstants.RIGHT);
        nameLB.setFont(new Font("굴림", Font.BOLD, 30));
        nameLB.setBounds(130, 140, 110, 50);
        contentPane.add(nameLB);

        nameTF = new JTextField();
        nameTF.setSize(200, 40);
        nameTF.setLocation(240, 140);
        nameTF.setFont(new Font("굴림", Font.PLAIN, 30));
        contentPane.add(nameTF);
        nameTF.setColumns(10);

        JLabel startdateLB = new JLabel("시작일");
        startdateLB.setHorizontalAlignment(SwingConstants.RIGHT);
        startdateLB.setFont(new Font("굴림", Font.BOLD, 30));
        startdateLB.setBounds(130, 260, 110, 50);
        contentPane.add(startdateLB);

        startdateTF = new JTextField();
        startdateTF.setSize(200, 40);
        startdateTF.setLocation(240, 260);
        startdateTF.setFont(new Font("굴림", Font.PLAIN, 30));
        contentPane.add(startdateTF);
        startdateTF.setColumns(10);

        JLabel typeLB = new JLabel("회원유형");
        typeLB.setHorizontalAlignment(SwingConstants.RIGHT);
        typeLB.setFont(new Font("굴림", Font.BOLD, 30));
        typeLB.setBounds(110, 320, 130, 50);
        contentPane.add(typeLB);

        priceTF = new JTextField();
        priceTF.setSize(200, 40);
        priceTF.setLocation(240, 380);
        priceTF.setFont(new Font("굴림", Font.PLAIN, 30));
        contentPane.add(priceTF);
        priceTF.setColumns(10);

        JLabel priceLB = new JLabel("  금액");
        priceLB.setHorizontalAlignment(SwingConstants.RIGHT);
        priceLB.setFont(new Font("굴림", Font.BOLD, 30));
        priceLB.setBounds(130, 380, 100, 50);
        contentPane.add(priceLB);

        typeTF = new JTextField();
        typeTF.setSize(200, 40);
        typeTF.setLocation(240, 320);
        typeTF.setFont(new Font("굴림", Font.PLAIN, 30));
        contentPane.add(typeTF);
        typeTF.setColumns(10);

        JButton backButton = new JButton("뒤로가기");
        backButton.setFont(new Font("굴림", Font.BOLD, 18));
        backButton.setBounds(450, 520, 130, 40);
        contentPane.add(backButton);
        
        phoneTF = new JTextField();
        phoneTF.setFont(new Font("굴림", Font.PLAIN, 20));
        phoneTF.setBounds(120, 13, 170, 25);
        contentPane.add(phoneTF);
        phoneTF.setColumns(10);
        
        JLabel noLB = new JLabel("회원번호");
        noLB.setFont(new Font("굴림", Font.BOLD, 30));
        noLB.setBounds(110, 200, 130, 50);
        contentPane.add(noLB);
        
        noTF = new JTextField();
        noTF.setFont(new Font("굴림", Font.PLAIN, 30));
        noTF.setBounds(240, 200, 200, 40);
        contentPane.add(noTF);
        noTF.setColumns(10);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Uione uione = new Uione();
                uione.setVisible(true);
                setVisible(false);
            }
        });
    }
  /* 
    public void setMyData(MemberDTO member) {
    	nameTF.setText(member.getName());
    	noTF.setText(String.valueOf(member.getNo()));
    	startdateTF.setText(member.getStardate());
    	typeTF.setText(member.getType());
    	priceTF.setText(member.getPrice());
    }
    
    public void selectMyData(String phone) {
    	MemberDTO member=new MemberDTO();
    	member.setName(nameTF.getText());
    	member.setNo(Integer.parseInt(noTF.getText()));
    	member.setStardate(startdateTF.getText());
    	member.setType(typeTF.getText());
    	member.setPrice(priceTF.getText());
    	
    	MemberDAOImpl.getDao().selectMemberByphone(phone);
    }
    */
}





















