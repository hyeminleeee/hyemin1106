package xyz.itwill.project;

import java.awt.Dimension;
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

public class Uitwo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;

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
    	setTitle("아이티윌 피트니스");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setFont(new Font("굴림", Font.PLAIN, 40));
        textField.setBounds(350, 50, 300, 50);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("  No.");
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 40));
        lblNewLabel.setBounds(150, 50, 100, 50);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("✔");
        btnNewButton.setBounds(700, 50, 50, 50);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel(" 성명 ");
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 40));
        lblNewLabel_1.setBounds(150, 150, 150, 50);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("굴림", Font.PLAIN, 40));
        textField_1.setBounds(350, 150, 300, 50);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("회원권");
        lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 40));
        lblNewLabel_2.setBounds(150, 250, 200, 50);
        contentPane.add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("굴림", Font.PLAIN, 40));
        textField_2.setBounds(350, 250, 300, 50);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("시작일 ");
        lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 40));
        lblNewLabel_3.setBounds(150, 350, 200, 50);
        contentPane.add(lblNewLabel_3);

        textField_5 = new JTextField();
        textField_5.setFont(new Font("굴림", Font.PLAIN, 40));
        textField_5.setBounds(350, 350, 300, 50);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        JLabel lblPt = new JLabel("종료일");
        lblPt.setFont(new Font("굴림", Font.BOLD, 40));
        lblPt.setBounds(150, 450, 200, 50);
        contentPane.add(lblPt);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("굴림", Font.PLAIN, 40));
        textField_3.setBounds(350, 450, 300, 50);
        contentPane.add(textField_3);
        textField_3.setColumns(10);
/*
        JLabel lblNewLabel_4 = new JLabel("출석일");
        lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 40));
        lblNewLabel_4.setBounds(150, 550, 200, 50);
        contentPane.add(lblNewLabel_4);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("굴림", Font.PLAIN, 40));
        textField_4.setBounds(350, 550, 300, 50);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        JButton btnNewButton_1_2 = new JButton("출석");
        btnNewButton_1_2.setFont(new Font("굴림", Font.BOLD, 40));
        btnNewButton_1_2.setBounds(700, 550, 150, 50);
        contentPane.add(btnNewButton_1_2);
*/
        JButton btnNewButton_2 = new JButton("뒤로가기");
        btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 40));
        btnNewButton_2.setBounds(675, 650, 200, 50);
        contentPane.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Uione uione = new Uione();
                uione.setVisible(true);
                setVisible(false);
            }
        });
    }
}