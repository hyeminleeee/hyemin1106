package xyz.itwill.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

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

import xyz.itwill.student.StudentDAOImpl;
import xyz.itwill.student.StudentDTO;


public class UiFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    JTable table;
    private UiDialog uidialog;
    private JTextField textField;

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
        
        //displayAllMember();//질문사항

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        String[] columnNames = { "회원번호", "이름", "생년월일", "성별", "핸드폰", "회원유형", "가입일", "가격","기간" };
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setFont(new Font("굴림체", Font.PLAIN, 16));
        scrollPane.setViewportView(table);
        table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		

        JPanel panel = new JPanel(new BorderLayout());

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblNewLabel = new JLabel("회원번호 : ");
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
        searchPanel.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("굴림", Font.PLAIN, 20));
        searchPanel.add(textField);
        textField.setColumns(10);

        JButton addButton_1_1 = new JButton("검색");
        addButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		searchNoMember();
        		textField.setText("");
        	}
        });
        addButton_1_1.setFont(new Font("굴림체", Font.BOLD, 18));
        searchPanel.add(addButton_1_1);

        panel.add(searchPanel, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton addButton = new JButton("회원추가");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uidialog.setVisible(true);
            }
        });
        
        displayAllMember();
        
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

                // 회원 번호를 Integer 타입으로 가져옵니다.
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
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1)
                    return;
                String no = (String) tableModel.getValueAt(selectedRow, 0);
                String name = (String) tableModel.getValueAt(selectedRow, 1);
                String birth = (String) tableModel.getValueAt(selectedRow, 2);
                String gender = (String) tableModel.getValueAt(selectedRow, 3);
                String phone = (String) tableModel.getValueAt(selectedRow, 4);
                String memberType = (String) tableModel.getValueAt(selectedRow, 5);
                String joinDate = (String) tableModel.getValueAt(selectedRow, 6);

                uidialog.setMemberInfo(no, name, birth, gender, phone, memberType, joinDate);
                uidialog.setVisible(true);

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
    }
    
    public void displayAllMember() {
    	List<MemberDTO> memberList=MemberDAOImpl.getDao().selectMemberAll();
    	
    	if(memberList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "저장된 학생정보가 없습니다.");
			return;
		}
    	
    	DefaultTableModel defaultTableModel=(DefaultTableModel)table.getModel();
    	
    	for(int i=defaultTableModel.getRowCount();i>0;i--) {
    		defaultTableModel.removeRow(0);
    	}
    	
    	for(MemberDTO student : memberList) {
    		Vector<Object> rowData=new Vector<Object>();
    		
			rowData.add(student.getNo());
			rowData.add(student.getName());
			rowData.add(student.getBirth());
			rowData.add(student.getGender());
			rowData.add(student.getPhone());
			rowData.add(student.getType());
			rowData.add(student.getStardate().substring(0, 10));
			
			defaultTableModel.addRow(rowData);
    	}
    	
    } 
    
    public void searchNoMember() {
    	String noString=textField.getText();
    	
    	if(noString.equals("")) {//JTextField 컴퍼넌트에 입력된 값이 없는 경우
			JOptionPane.showMessageDialog(this, "회원번호를 입력해 주세요.");
			textField.requestFocus();//JTextField 컴퍼넌트를 포커스가 위치되도록 커서 이동
			return;
		}
    	
    	String noReg="^[1-9][0-9]{3}$";
		if(!Pattern.matches(noReg, noString)) {
			JOptionPane.showMessageDialog(this, "회원번호는 4자리 숫자로만 입력해 주세요.");
			textField.requestFocus();
			return;
		}
		
		int no=Integer.parseInt(noString);
		
		//매개변수로 회원번호를 전달받아 STUDENT 테이블에 저장된 해당 회원번호의 행을 검색하여
		//DTO 객체로 반환하는 DAO 클래스의 메소드 호출
		MemberDTO member=MemberDAOImpl.getDao().selectMemberByno(no);
		
		if(member == null) {//학번으로 검색된 학생정보가 없는 경우
			JOptionPane.showMessageDialog(this, "변경할 학번의 학생정보를 찾을 수 없습니다.");
			textField.requestFocus();
			textField.setText("");
			return;
		}
		
		DefaultTableModel defaultTableModel=(DefaultTableModel)table.getModel();
		
		for(int i=defaultTableModel.getRowCount();i>0;i--) {
			defaultTableModel.removeRow(0);
		}
		/*
		if(member != null) {
			String[] rowdata= {
					member.getName(),
					member.getBirth(),
					member.getGender(),
					member.getPhone(),
					member.getType(),
					member.getStardate()
				};
			table.addRow(rowdata);
		}
		*/
		 if (member != null) {
	            Vector<Object> rowData = new Vector<Object>();

	            rowData.add(member.getNo());
	            rowData.add(member.getName());
	            rowData.add(member.getBirth());
	            rowData.add(member.getGender());
	            rowData.add(member.getPhone());
	            rowData.add(member.getType());
	            rowData.add(member.getStardate().substring(0, 10));

	            defaultTableModel.addRow(rowData);
	        }
    }
    
}



























