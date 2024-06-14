package xyz.itwill.project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UiUpdateDialog extends JDialog {

    

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField noTF; 
    private JTextField nameTF;
    private JTextField birthTF;
    JComboBox<String> genderComboBox;
    private JTextField phoneTF;
    private JComboBox<String> memberTypeComboBox;
    private JTextField joinDateTF;
    //private JTextField endDateTF;
    //private JTextField visitCountTF;
    
    public UiUpdateDialog(JFrame frame, String title) {
        super(frame, title, true);
        
        setBounds(100, 100, 1000, 800);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                init();
            }
        });
         
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[] {100, 300};
        gbl_contentPanel.rowHeights = new int[] {50, 50, 50, 50, 50, 50, 50, 50};
        gbl_contentPanel.columnWeights = new double[]{0.0, 0.0};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        contentPanel.setLayout(gbl_contentPanel);
        {
           JLabel noLabel = new JLabel("회원번호");
            noLabel.setFont(new Font("굴림체", Font.BOLD, 20));
            GridBagConstraints gbc_noLabel = new GridBagConstraints();
            gbc_noLabel.insets = new Insets(0, 0, 5, 5);
            gbc_noLabel.gridx = 0;
            gbc_noLabel.gridy = 0;
            contentPanel.add(noLabel, gbc_noLabel);
        }
        {
            noTF = new JTextField();
            noTF.setFont(new Font("굴림체", Font.PLAIN, 20));
            GridBagConstraints gbc_noTF = new GridBagConstraints();
            gbc_noTF.fill = GridBagConstraints.HORIZONTAL;
            gbc_noTF.insets = new Insets(0, 0, 5, 0);
            gbc_noTF.gridx = 1;
            gbc_noTF.gridy = 0;
            contentPanel.add(noTF, gbc_noTF);   
           
           
           
        }
        {
            JLabel nameLabel = new JLabel("이름");
            nameLabel.setFont(new Font("굴림체", Font.BOLD, 20));
            GridBagConstraints gbc_nameLabel = new GridBagConstraints();
            gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
            gbc_nameLabel.gridx = 0;
            gbc_nameLabel.gridy = 1;
            contentPanel.add(nameLabel, gbc_nameLabel);
        }
        {
            nameTF = new JTextField();
            nameTF.setFont(new Font("굴림체", Font.PLAIN, 20));
            GridBagConstraints gbc_nameTF = new GridBagConstraints();
            gbc_nameTF.fill = GridBagConstraints.HORIZONTAL;
            gbc_nameTF.insets = new Insets(0, 0, 5, 0);
            gbc_nameTF.gridx = 1;
            gbc_nameTF.gridy = 1;
            contentPanel.add(nameTF, gbc_nameTF);
        }
        {
            JLabel birthLabel = new JLabel("생년월일");
            birthLabel.setFont(new Font("굴림체", Font.BOLD, 20));
            GridBagConstraints gbc_birthLabel = new GridBagConstraints();
            gbc_birthLabel.insets = new Insets(0, 0, 5, 5);
            gbc_birthLabel.gridx = 0;
            gbc_birthLabel.gridy = 2;
            contentPanel.add(birthLabel, gbc_birthLabel);
        }
        {
            birthTF = new JTextField();
            birthTF.setFont(new Font("굴림체", Font.PLAIN, 20));
            GridBagConstraints gbc_birthTF = new GridBagConstraints();
            gbc_birthTF.fill = GridBagConstraints.HORIZONTAL;
            gbc_birthTF.insets = new Insets(0, 0, 5, 0);
            gbc_birthTF.gridx = 1;
            gbc_birthTF.gridy = 2;
            contentPanel.add(birthTF, gbc_birthTF);
        }
        {
            JLabel genderLabel = new JLabel("성별");
            genderLabel.setFont(new Font("굴림체", Font.BOLD, 20));
            GridBagConstraints gbc_genderLabel = new GridBagConstraints();
            gbc_genderLabel.insets = new Insets(0, 0, 5, 5);
            gbc_genderLabel.gridx = 0;
            gbc_genderLabel.gridy = 3;
            contentPanel.add(genderLabel, gbc_genderLabel);
        }
        {
            genderComboBox = new JComboBox<>(new String[]{"여자", "남자"});//탭 기능 추가
            genderComboBox.setFont(new Font("굴림체", Font.PLAIN, 20));
            GridBagConstraints gbc_genderComboBox = new GridBagConstraints();
            gbc_genderComboBox.fill = GridBagConstraints.HORIZONTAL;
            gbc_genderComboBox.insets = new Insets(0, 0, 5, 0);
            gbc_genderComboBox.gridx = 1;
            gbc_genderComboBox.gridy = 3;
            contentPanel.add(genderComboBox, gbc_genderComboBox);
        }
        {
            JLabel phoneLabel = new JLabel("핸드폰");
            phoneLabel.setFont(new Font("굴림체", Font.BOLD, 20));
            GridBagConstraints gbc_phoneLabel = new GridBagConstraints();
            gbc_phoneLabel.insets = new Insets(0, 0, 5, 5);
            gbc_phoneLabel.gridx = 0;
            gbc_phoneLabel.gridy = 4;
            contentPanel.add(phoneLabel, gbc_phoneLabel);
        }
        {
            phoneTF = new JTextField();
            phoneTF.setFont(new Font("굴림체", Font.PLAIN, 20));
            GridBagConstraints gbc_phoneTF = new GridBagConstraints();
            gbc_phoneTF.fill = GridBagConstraints.HORIZONTAL;
            gbc_phoneTF.insets = new Insets(0, 0, 5, 0);
            gbc_phoneTF.gridx = 1;
            gbc_phoneTF.gridy = 4;
            contentPanel.add(phoneTF, gbc_phoneTF);
        }
        {
            JLabel memberTypeLabel = new JLabel("회원유형");
            memberTypeLabel.setFont(new Font("굴림체", Font.BOLD, 20));
            GridBagConstraints gbc_memberTypeLabel = new GridBagConstraints();
            gbc_memberTypeLabel.insets = new Insets(0, 0, 5, 5);
            gbc_memberTypeLabel.gridx = 0;
            gbc_memberTypeLabel.gridy = 5;
            contentPanel.add(memberTypeLabel, gbc_memberTypeLabel);
        }
        {
            memberTypeComboBox = new JComboBox<>(new String[]{"GOLD", "SILVER", "BRONZE"}); //탭 기능 추가
            memberTypeComboBox.setFont(new Font("굴림체", Font.PLAIN, 20));
            GridBagConstraints gbc_memberTypeComboBox = new GridBagConstraints();
            gbc_memberTypeComboBox.fill = GridBagConstraints.HORIZONTAL;
            gbc_memberTypeComboBox.insets = new Insets(0, 0, 5, 0);
            gbc_memberTypeComboBox.gridx = 1;
            gbc_memberTypeComboBox.gridy = 5;
            contentPanel.add(memberTypeComboBox, gbc_memberTypeComboBox);
        }
        {
            JLabel joinDateLabel = new JLabel("가입일");
            joinDateLabel.setFont(new Font("굴림체", Font.BOLD, 20));
            GridBagConstraints gbc_joinDateLabel = new GridBagConstraints();
            gbc_joinDateLabel.insets = new Insets(0, 0, 5, 5);
            gbc_joinDateLabel.gridx = 0;
            gbc_joinDateLabel.gridy = 6;
            contentPanel.add(joinDateLabel, gbc_joinDateLabel);
        }
        {
            joinDateTF = new JTextField();
            joinDateTF.setFont(new Font("굴림체", Font.PLAIN, 20));
            GridBagConstraints gbc_joinDateTF = new GridBagConstraints();
            gbc_joinDateTF.fill = GridBagConstraints.HORIZONTAL;
            gbc_joinDateTF.insets = new Insets(0, 0, 5, 0);
            gbc_joinDateTF.gridx = 1;
            gbc_joinDateTF.gridy = 6;
            contentPanel.add(joinDateTF, gbc_joinDateTF);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                 JButton addButton = new JButton("수정");
                  addButton.setFont(new Font("굴림체", Font.BOLD, 18));
                  addButton.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent e) {
                       
                         //updateMemberToDatabase();
                         //setVisible(false);
                    	  
                      }
                  });
                  buttonPane.add(addButton);
                  getRootPane().setDefaultButton(addButton);
              }
              {
                  JButton cancelButton = new JButton("취소");
                  cancelButton.setFont(new Font("굴림체", Font.BOLD, 18));
                  cancelButton.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent e) {
                          setVisible(false);
                          init();
                      }
                  });
                  buttonPane.add(cancelButton);
              }
          }
      }
      
      private void init() {//TextField 초기화 시켜주는 메소드
          noTF.setText(""); 
          nameTF.setText("");
          birthTF.setText("");
          genderComboBox.setSelectedIndex(0); // Default to the first item
          phoneTF.setText("");
          memberTypeComboBox.setSelectedIndex(0); // Default to the first item
          joinDateTF.setText("");
      }
      
      private void updateMemberToDatabase() {
    	  String noString = noTF.getText();
    	  String name=nameTF.getText();
    	  String birth=birthTF.getText();
    	  String gender=(String) genderComboBox.getSelectedItem();
    	  String phone=phoneTF.getText();
    	  String type=(String) memberTypeComboBox.getSelectedItem();
    	  String startdate=joinDateTF.getText();
      }
          
     /*     
          if (noString.equals("")) {
              JOptionPane.showMessageDialog(this, "회원번호를 입력해 주세요.");
              noTF.requestFocus();
              return;
          }
          
          String noReg="^[1-9][0-9]{3}$";
           
          if(!Pattern.matches(noReg, noString)) {//정규표현식과 입력값의 패턴이 맞지 않는 경우
           JOptionPane.showMessageDialog(this, "회원번호는 4자리 숫자로만 입력해 주세요.");
           noTF.requestFocus();
           return;
        }
          
          int no = Integer.parseInt(noString);
          
          if (MemberDAOImpl.getDao().selectMemberByno(no) != null) {
              JOptionPane.showMessageDialog(this, "이미 사용중인 회원번호를 입력 하였습니다.");
              noTF.requestFocus();
              return;
          }
          
          String name = nameTF.getText();
          
          if (name.equals("")) {
              JOptionPane.showMessageDialog(this, "이름을 입력해 주세요.");
              nameTF.requestFocus();
              return;
          }
          
          String birth = birthTF.getText();
          
          if (birth.equals("")) {
              JOptionPane.showMessageDialog(this, "생년월일을 입력해 주세요.");
              phoneTF.requestFocus();
              return;
          }
          
          String birthReg = "(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
          if (!Pattern.matches(birthReg, birth)) {
              JOptionPane.showMessageDialog(this, "생년월일을 형식에 맞게 입력해 주세요.");
              birthTF.requestFocus();
              return;
          }
          
          String gender = (String) genderComboBox.getSelectedItem();     
          
          String phone = phoneTF.getText();
          
          if (phone.equals("")) {
              JOptionPane.showMessageDialog(this, "전화번호를 입력해 주세요.");
              phoneTF.requestFocus();
              return;
          }
          
          String phoneReg = "(01[016789])-\\d{3,4}-\\d{4}";
          if (!Pattern.matches(phoneReg, phone)) {
              JOptionPane.showMessageDialog(this, "전화번호를 형식에 맞게 입력해 주세요.");
              phoneTF.requestFocus();
              return;
          }       

          String type = (String) memberTypeComboBox.getSelectedItem();
          
          String startdate = joinDateTF.getText();
          
          if (startdate.equals("")) {
              JOptionPane.showMessageDialog(this, "가입일을 입력해 주세요.");
              joinDateTF.requestFocus();
              return;
          }
          
          String startdateReg = "(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
          if (!Pattern.matches(startdateReg, startdate)) {
              JOptionPane.showMessageDialog(this, "가입일을 형식에 맞게 입력해 주세요.");
              joinDateTF.requestFocus();
              return;
          }

          // Create a MemberDTO object with the entered information
          MemberDTO newMember = new MemberDTO(no, name, birth, gender, phone, type, startdate);

          // Call the insertMember method of MemberDAOImpl to add the new member to the database
          int rowsAffected = MemberDAOImpl.getDao().insertMember(newMember);

          if (rowsAffected > 0) {
              JOptionPane.showMessageDialog(this, "회원이 수정되었습니다.");
              setVisible(false);
              init();
              
              // 추가된 회원 정보를 테이블에 표시하기 위해 UiFrame의 displayAllMember() 호출
              if (getParent() instanceof UiFrame) { 
                  ((UiFrame) getParent()).displayAllMember();
              }
          }
      }
      */

      
      public void setMemberInfo(int no, String name, String birth, String gender, String phone, String type, String startdate) {
          noTF.setText(String.valueOf(no));
          nameTF.setText(name);
          birthTF.setText(birth);
          genderComboBox.setSelectedItem(gender);
          phoneTF.setText(phone);
          memberTypeComboBox.setSelectedItem(type);
          joinDateTF.setText(startdate);
      }
   // 회원정보 수정
      public void setMemberInfo(String no, String name, String birth, String gender, String phone, 
              String memberType, String joinDate /*String endDate, String visitCount*/) {
          noTF.setText(no);
         nameTF.setText(name);
          birthTF.setText(birth);
          genderComboBox.setSelectedItem(gender);
          phoneTF.setText(phone);
          memberTypeComboBox.setSelectedItem(memberType);
          joinDateTF.setText(joinDate);
          //endDateTF.setText(endDate);
          //visitCountTF.setText(visitCount);
      }
} 
































