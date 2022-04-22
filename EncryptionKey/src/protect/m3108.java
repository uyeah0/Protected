package protect;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class m3108 {
	
	private static JTextField textFieldEncryptionKey;
	private static JTextField textFieldPlanText;
	public static String encryptionKey;
	public static String planText;
	
	public m3108() {
		
		// ������ ����
		JFrame frame = new JFrame("3108");
		
		// ������ ũ�� ����
		frame.setSize(1080, 900);
		
		// �������� ȭ�� ����� ��ġ
		frame.setLocationRelativeTo(null);
		
		// �������� ũ�⸦ �������� ���ϰ� ����
		frame.setResizable(false);

		// ������ ���̰� ����
		frame.setVisible(true);
		
		// �������� �ݾ��� �� �޸𸮿��� ���ŵǵ��� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ��Ʈ ����
		Font fontTitle = new Font("�޸յձ�������", Font.PLAIN, 70);
		Font fontKey = new Font("�޸յձ�������", Font.PLAIN, 35);
		Font fontButton = new Font("�޸յձ�������", Font.PLAIN, 35);
		Font fontHint = new Font("�޸յձ�������", Font.PLAIN, 25);
		

		
		// ��ȣŰ �Է� textField ���� 
		textFieldEncryptionKey = new JTextField();
		
		textFieldEncryptionKey.setBounds(287, 289, 592, 68);
		textFieldEncryptionKey.setColumns(10);
		textFieldEncryptionKey.setFont(fontHint);
		frame.add(textFieldEncryptionKey);
		
		// �� ����
		JLabel label = new JLabel();
		label.setForeground(Color.WHITE);
		label.setBounds(337, 112, 407, 78);
		label.setText("PROTECT");
		label.setFont(fontTitle);
		frame.add(label);

		
		// �� ����
		JLabel labelEncryptionKey = new JLabel();
		labelEncryptionKey.setForeground(Color.WHITE);
		labelEncryptionKey.setBounds(82, 293, 165, 57);
		labelEncryptionKey.setText("��ȣŰ");
		labelEncryptionKey.setFont(fontKey);
		frame.add(labelEncryptionKey);		
		
		// �� ����
		JLabel labelDeryption = new JLabel();
		labelDeryption.setForeground(Color.WHITE);
		labelDeryption.setBounds(82, 475, 165, 57);
		labelDeryption.setText("�� ��");
		labelDeryption.setFont(fontKey);
		frame.add(labelDeryption);
		
		// �� �Է� textField ����
		textFieldPlanText = new JTextField();
		
		textFieldPlanText.setBounds(287, 472, 592, 68);
		textFieldPlanText.setColumns(10);
		textFieldPlanText.setFont(fontHint);
		frame.add(textFieldPlanText);
		
		// ��ȣȭ ��ư ����
		RoundedButton protectedBtn = new RoundedButton("��ȣȭ",2);
		protectedBtn.setBounds(346, 663, 288, 81);
		protectedBtn.setFont(fontButton);
		frame.getContentPane().add(protectedBtn);
		
		// ���� �ֱ�
		JLabel back = new JLabel();
		back.setOpaque(true);
		back.setBackground(new Color(55, 61, 221));
		back.setBounds(0, 0, 1980, 1080);
		back.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(back);
		
		protectedBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				encryptionKey = textFieldEncryptionKey.getText();
				planText = textFieldPlanText.getText();
				// ������ ������ ����
				frame.dispose();
				new m3108_2();
			}
		});
		frame.setVisible(true);
	}
	
	public static void main(String args[]) {
		new m3108();
	}
}
