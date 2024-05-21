package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class ExampleDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField numTF;
	private JTextField nameTF;
	private JTextField phoneTF;

	public ExampleDialog(JFrame frame, String title) {
		super(frame, title, true);
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				numTF.setText("");
				nameTF.setText("");
				phoneTF.setText("");
			}
		});
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {100, 300};
		gbl_contentPanel.rowHeights = new int[] {50, 50, 50};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("학번");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			numTF = new JTextField();
			numTF.setColumns(25);
			GridBagConstraints gbc_numTF = new GridBagConstraints();
			gbc_numTF.insets = new Insets(0, 0, 5, 0);
			gbc_numTF.gridx = 1;
			gbc_numTF.gridy = 0;
			contentPanel.add(numTF, gbc_numTF);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("이름");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			nameTF = new JTextField();
			GridBagConstraints gbc_nameTF = new GridBagConstraints();
			gbc_nameTF.insets = new Insets(0, 0, 5, 0);
			gbc_nameTF.gridx = 1;
			gbc_nameTF.gridy = 1;
			contentPanel.add(nameTF, gbc_nameTF);
			nameTF.setColumns(25);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("전화번호");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			phoneTF = new JTextField();
			GridBagConstraints gbc_phoneTF = new GridBagConstraints();
			gbc_phoneTF.gridx = 1;
			gbc_phoneTF.gridy = 2;
			contentPanel.add(phoneTF, gbc_phoneTF);
			phoneTF.setColumns(25);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String num=numTF.getText();
						String name=nameTF.getText();
						String phone=phoneTF.getText();
						
						Vector<String> vector=new Vector<String>();
						vector.add(num);
						vector.add(name);
						vector.add(phone);
						
						//TableModel tableModel=((Example)frame).table.getModel();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
