package xyz.itwill.project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class FitnessManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTable table;
	private JPanel panel;
	private JButton addButton;
	private JButton updateButton;
	private JPanel panel_1;
	private JLabel nameLB;
	private JTextField nameTF;
	private JLabel birthLB;
	private JTextField birthTF;
	private JLabel genderLB;
	private JTextField genderTF;
	private JLabel phoneLB;
	private JTextField phoneTF;
	private JLabel startdateLB;
	private JTextField startdateTF;
	private JLabel usertypeLB;
	private JTextField usertypeTF;
	private JButton removeButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FitnessManager frame = new FitnessManager();
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
	public FitnessManager() {
		setFont(new Font("굴림체", Font.PLAIN, 12));
		setTitle("회원관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 200, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		String[] columnNames={"이름", "생년월일", "성별", "핸드폰", "회원 유형","가입일","종료일","횟수"};
		DefaultTableModel tableModel=new DefaultTableModel(columnNames, 0);
		
		table = new JTable(tableModel);
		table.setFont(new Font("굴림체", Font.BOLD, 12));
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		addButton = new JButton("추가");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=nameTF.getText();
				String birth=birthTF.getText();
				String gender=genderTF.getText();
				String phone=phoneTF.getText();
				String startdate=startdateTF.getText();
				String usertype=usertypeTF.getText();
				
				Vector<String> vector=new Vector<String>();
				vector.add(name);
				vector.add(birth);
				vector.add(gender);
				vector.add(phone);
				vector.add(startdate);
				vector.add(usertype);
				
				TableModel tableModel=table.getModel();
				((DefaultTableModel) tableModel).addRow(vector);
			}
		});
		addButton.setFont(new Font("굴림", Font.PLAIN, 13));
		panel.add(addButton);
		
		updateButton = new JButton("수정");
		updateButton.setFont(new Font("굴림체", Font.PLAIN, 13));
		panel.add(updateButton);
		
		removeButton = new JButton("삭제");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
				
				if(tableModel.getRowCount()==0) return;
				int row=table.getSelectedRow();
				if(row==-1) return;
				
				tableModel.removeRow(row);
			}
		});
		removeButton.setFont(new Font("굴림체", Font.PLAIN, 13));
		panel.add(removeButton);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{100, 200,100,200};
		gbl_panel_1.rowHeights = new int[] {25, 25, 25};
		gbl_panel_1.columnWeights = new double[]{0.0,0.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel_1.setLayout(gbl_panel_1);
		
		/*
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {100, 300};
		gbl_contentPanel.rowHeights = new int[] {50, 50, 50};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		 */
		
		nameLB = new JLabel("이름");
		nameLB.setFont(new Font("굴림체", Font.PLAIN, 12));
		GridBagConstraints gbc_nameLB = new GridBagConstraints();
		gbc_nameLB.fill = GridBagConstraints.VERTICAL;
		gbc_nameLB.insets = new Insets(0, 0, 5, 0);
		gbc_nameLB.gridx = 0;
		gbc_nameLB.gridy = 0;
		panel_1.add(nameLB, gbc_nameLB);
		
		nameTF = new JTextField();
		nameTF.setFont(new Font("굴림체", Font.PLAIN, 12));
		GridBagConstraints gbc_nameTF = new GridBagConstraints();
		gbc_nameTF.fill = GridBagConstraints.BOTH;
		gbc_nameTF.insets = new Insets(0, 0, 5, 0);
		gbc_nameTF.gridx = 1;
		gbc_nameTF.gridy = 0;
		panel_1.add(nameTF, gbc_nameTF);
		nameTF.setColumns(10);
		
		birthLB = new JLabel("생년월일");
		birthLB.setFont(new Font("굴림체", Font.PLAIN, 12));
		GridBagConstraints gbc_birthLB = new GridBagConstraints();
		gbc_birthLB.insets = new Insets(0, 0, 5, 0);
		gbc_birthLB.fill = GridBagConstraints.VERTICAL;
		gbc_birthLB.gridx = 0;
		gbc_birthLB.gridy = 1;
		panel_1.add(birthLB, gbc_birthLB);
		
		birthTF = new JTextField();
		birthTF.setFont(new Font("굴림체", Font.PLAIN, 12));
		GridBagConstraints gbc_birthTF = new GridBagConstraints();
		gbc_birthTF.insets = new Insets(0, 0, 5, 0);
		gbc_birthTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_birthTF.gridx = 1;
		gbc_birthTF.gridy = 1;
		panel_1.add(birthTF, gbc_birthTF);
		birthTF.setColumns(10);
		
		genderLB = new JLabel("성별");
		genderLB.setFont(new Font("굴림체", Font.PLAIN, 12));
		GridBagConstraints gbc_genderLB = new GridBagConstraints();
		gbc_genderLB.insets = new Insets(0, 0, 5, 0);
		gbc_genderLB.gridx = 0;
		gbc_genderLB.gridy = 2;
		panel_1.add(genderLB, gbc_genderLB);
		
		genderTF = new JTextField();
		genderTF.setFont(new Font("굴림체", Font.PLAIN, 12));
		GridBagConstraints gbc_genderTF = new GridBagConstraints();
		gbc_genderTF.insets = new Insets(0, 0, 5, 0);
		gbc_genderTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_genderTF.gridx = 1;
		gbc_genderTF.gridy = 2;
		panel_1.add(genderTF, gbc_genderTF);
		genderTF.setColumns(10);
		
		phoneLB = new JLabel("핸드폰");
		phoneLB.setFont(new Font("굴림체", Font.PLAIN, 12));
		GridBagConstraints gbc_phoneLB = new GridBagConstraints();
		gbc_phoneLB.insets = new Insets(0, 0, 5, 0);
		gbc_phoneLB.gridx = 2;
		gbc_phoneLB.gridy = 0;
		panel_1.add(phoneLB, gbc_phoneLB);
		
		phoneTF = new JTextField();
		phoneTF.setFont(new Font("굴림체", Font.PLAIN, 12));
		GridBagConstraints gbc_phoneTF = new GridBagConstraints();
		gbc_phoneTF.insets = new Insets(0, 0, 5, 0);
		gbc_phoneTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneTF.gridx = 3;
		gbc_phoneTF.gridy = 0;
		panel_1.add(phoneTF, gbc_phoneTF);
		phoneTF.setColumns(10);
		
		startdateLB = new JLabel("등록일");
		startdateLB.setFont(new Font("굴림체", Font.PLAIN, 12));
		GridBagConstraints gbc_startdateLB = new GridBagConstraints();
		gbc_startdateLB.insets = new Insets(0, 0, 5, 0);
		gbc_startdateLB.gridx = 2;
		gbc_startdateLB.gridy = 1;
		panel_1.add(startdateLB, gbc_startdateLB);
		
		startdateTF = new JTextField();
		startdateTF.setFont(new Font("굴림체", Font.PLAIN, 12));
		GridBagConstraints gbc_startdateTF = new GridBagConstraints();
		gbc_startdateTF.insets = new Insets(0, 0, 5, 0);
		gbc_startdateTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_startdateTF.gridx = 3;
		gbc_startdateTF.gridy = 1;
		panel_1.add(startdateTF, gbc_startdateTF);
		startdateTF.setColumns(10);
		
		usertypeLB = new JLabel("회원 유형");
		usertypeLB.setFont(new Font("굴림체", Font.PLAIN, 12));
		GridBagConstraints gbc_usertypeLB = new GridBagConstraints();
		gbc_usertypeLB.insets = new Insets(0, 0, 5, 0);
		gbc_usertypeLB.gridx = 2;
		gbc_usertypeLB.gridy = 2;
		panel_1.add(usertypeLB, gbc_usertypeLB);
		
		usertypeTF = new JTextField();
		usertypeTF.setFont(new Font("굴림체", Font.PLAIN, 12));
		GridBagConstraints gbc_usertypeTF = new GridBagConstraints();
		gbc_usertypeTF.insets = new Insets(0, 0, 5, 0);
		gbc_usertypeTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_usertypeTF.gridx = 3;
		gbc_usertypeTF.gridy = 2;
		panel_1.add(usertypeTF, gbc_usertypeTF);
		usertypeTF.setColumns(10);


		
		
	}

}