package xyz.itwill.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class UiFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private UiDialog uidialog;
    private JTextField textField;
    private UiUpdateDialog uiUpdateDialog;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UiFrame frame = new UiFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UiFrame() {
        setTitle("아이티윌 피트니스");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        String[] columnNames = { "회원번호", "이름", "생년월일", "성별", "핸드폰", "회원유형", "가입일", "가격", "기간" };
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setFont(new Font("굴림체", Font.PLAIN, 16));
        scrollPane.setViewportView(table);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setDefaultEditor(Object.class, null);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblNewLabel = new JLabel("회원번호 : ");
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
        searchPanel.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("굴림", Font.PLAIN, 20));
        searchPanel.add(textField);
        textField.setColumns(10);

        JButton searchButton = new JButton("검색");
        searchButton.setFont(new Font("굴림체", Font.BOLD, 18));
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText().trim();
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(UiFrame.this, "회원번호를 입력하세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int memberNo = Integer.parseInt(input);
                    displayMemberByNo(memberNo);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(UiFrame.this, "유효한 회원번호를 입력하세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        searchPanel.add(searchButton);

        panel.add(searchPanel, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton addButton = new JButton("회원추가");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uidialog.setVisible(true);
            }
        });
        
                JButton addButton_1 = new JButton("초기화");
                addButton_1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        displayAllMember();
                    }
                });
                addButton_1.setFont(new Font("굴림체", Font.BOLD, 18));
                buttonPanel.add(addButton_1);
        addButton.setFont(new Font("굴림체", Font.BOLD, 18)); // 버튼의 폰트 크기 조정
        buttonPanel.add(addButton);

        JButton removeButton = new JButton("회원삭제");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                int selectedRow = table.getSelectedRow();

                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(UiFrame.this, "삭제할 회원을 선택해주세요.", "선택 오류", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int memberNo = (Integer) tableModel.getValueAt(selectedRow, 0);

                int response = JOptionPane.showConfirmDialog(UiFrame.this, "정말로 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    int result = MemberDAOImpl.getDao().deleteMember(memberNo);
                    if (result > 0) {
                        tableModel.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(UiFrame.this, "회원이 성공적으로 삭제되었습니다.", "삭제 완료", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(UiFrame.this, "회원 삭제에 실패했습니다.", "삭제 오류", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        removeButton.setFont(new Font("굴림체", Font.BOLD, 18)); // 버튼의 폰트 크기 조정
        buttonPanel.add(removeButton);

        JButton modifyButton = new JButton("회원수정");
        modifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	updateMember();
            	//updateMemberToDatabase();
            	uiUpdateDialog.setVisible(true);

            }
        });
        modifyButton.setFont(new Font("굴림체", Font.BOLD, 18)); // 버튼의 폰트 크기 조정
        buttonPanel.add(modifyButton);

        JButton backButton = new JButton("뒤로가기");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // 현재 UiFrame 창 닫기
                Uione uioneFrame = new Uione(); // Uione 클래스의 인스턴스 생성
                uioneFrame.setVisible(true); // Uione 창 보이기
            }
        });
        backButton.setFont(new Font("굴림체", Font.BOLD, 18)); // 폰트 크기 조정
        buttonPanel.add(backButton);

        panel.add(buttonPanel, BorderLayout.EAST);

        contentPane.add(panel, BorderLayout.NORTH);

        uidialog = new UiDialog(this, "회원추가");

        displayAllMember(); // 프레임 생성 시 모든 회원 정보를 테이블에 표시
    }

    public void displayAllMember() {
        List<MemberDTO> memberList = MemberDAOImpl.getDao().selectMemberAll();

        if (memberList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "저장된 회원 정보가 없습니다.");
            return;
        }

        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();

        // 기존의 테이블 데이터를 모두 삭제
        while (defaultTableModel.getRowCount() > 0) {
            defaultTableModel.removeRow(0);
        }

        // 회원 리스트에서 각 회원의 정보를 테이블에 추가
        for (MemberDTO member : memberList) {
            Vector<Object> rowData = new Vector<Object>();

            rowData.add(member.getNo());
            rowData.add(member.getName());
            rowData.add(member.getBirth());
            rowData.add(member.getGender());
            rowData.add(member.getPhone());
            rowData.add(member.getType());
            rowData.add(member.getStardate().substring(0, 10)); // 가입일에서 날짜 부분만 표시

            defaultTableModel.addRow(rowData);
        }
    }

    public void displayMemberByNo(int memberNo) {
        MemberDTO member = MemberDAOImpl.getDao().selectMemberByno(memberNo);

        if (member == null) {
            JOptionPane.showMessageDialog(this, "해당 회원번호로 검색된 회원이 없습니다.", "검색 결과", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        defaultTableModel.setRowCount(0); // 현재 테이블 데이터 지우기

        Vector<Object> rowData = new Vector<Object>();
        rowData.add(member.getNo());
        rowData.add(member.getName());
        rowData.add(member.getBirth());
        rowData.add(member.getGender());
        rowData.add(member.getPhone());
        rowData.add(member.getType());

        // 가입일이 null인 경우 처리
        String stardate = member.getStardate();
        if (stardate != null) {
            rowData.add(stardate.substring(0, Math.min(stardate.length(), 10))); // 가입일에서 날짜 부분만 표시
        } else {
            rowData.add(""); // 가입일이 null인 경우 빈 문자열 추가
        }

        defaultTableModel.addRow(rowData);
    }
    
    public void updateMember() {
    	DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(UiFrame.this, "수정할 회원을 선택해주세요.", "선택 오류", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int no = (Integer) tableModel.getValueAt(selectedRow, 0);
        String name = (String) tableModel.getValueAt(selectedRow, 1);
        String birth = (String) tableModel.getValueAt(selectedRow, 2);
        String gender = (String) tableModel.getValueAt(selectedRow, 3);
        String phone = (String) tableModel.getValueAt(selectedRow, 4);
        String type = (String) tableModel.getValueAt(selectedRow, 5);
        String startdate = (String) tableModel.getValueAt(selectedRow, 6);

        uiUpdateDialog.setMemberInfo(String.valueOf(no), name, birth, gender, phone, type, startdate);
    }
    
}
























