package xyz.itwill.project;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class Uione extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnNewButton;
    private Uitwo uitwo; // Uitwo 인스턴스 변수 추가

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Uione frame = new Uione();
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
    public Uione() {
        setTitle("아이티윌 피트니스");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        btnNewButton = new JButton("내정보");
        btnNewButton.setFont(new Font("굴림", Font.BOLD, 50));

        JButton btnNewButton_1 = new JButton("관리자모드");
        btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 50));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(108)
                    .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
                    .addGap(104)
                    .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
                    .addGap(1125))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(225)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                        .addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                    .addGap(295))
        );
        contentPane.setLayout(gl_contentPane);

        // "내정보" 버튼에 ActionListener 추가
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 두 번째 클래스(Uitwo)를 생성하고 화면에 표시
                uitwo = new Uitwo();
                uitwo.setVisible(true);
                // 첫 번째 클래스 숨기기
                setVisible(false);
            }
        });

     // "관리자모드" 버튼에 ActionListener 추가
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPasswordDialog();
            }
        });
    }
        // 비밀번호를 입력하는 다이얼로그를 표시하는 메소드
        private void showPasswordDialog() {
            JPasswordField passwordField = new JPasswordField();
            Object[] message = {"비밀번호를 입력해주세요:", passwordField};
            int option = JOptionPane.showConfirmDialog(null, message, "Enter Password", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                char[] password = passwordField.getPassword();
                if (isCorrectPassword(password)) {
                    // 비밀번호가 맞는 경우
                    JOptionPane.showMessageDialog(null, "비밀번호가 맞습니다. 관리자 모드에 접속합니다.");
                    // UiFrame으로 이동
                    UiFrame uiFrame = new UiFrame();
                    uiFrame.setVisible(true);
                    // 현재 창 닫기
                    dispose();
                } else {
                    // 비밀번호가 틀린 경우
                    JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
                }
            }
        }

        // 입력된 비밀번호가 올바른지 확인하는 메소드
        private boolean isCorrectPassword(char[] inputPassword) {
            String correctPassword = "admin"; // 임시 비밀번호
            return new String(inputPassword).equals(correctPassword);
        }
}