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
		
		// 프레임 생성
		JFrame frame = new JFrame("3108");
		
		// 프레임 크기 설정
		frame.setSize(1080, 900);
		
		// 프레임을 화면 가운데에 배치
		frame.setLocationRelativeTo(null);
		
		// 프레임의 크기를 변경하지 못하게 설정
		frame.setResizable(false);

		// 프레임 보이게 설정
		frame.setVisible(true);
		
		// 프레임을 닫았을 때 메모리에서 제거되도록 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 폰트 설정
		Font fontTitle = new Font("휴먼둥근헤드라인", Font.PLAIN, 70);
		Font fontKey = new Font("휴먼둥근헤드라인", Font.PLAIN, 35);
		Font fontButton = new Font("휴먼둥근헤드라인", Font.PLAIN, 35);
		Font fontHint = new Font("휴먼둥근헤드라인", Font.PLAIN, 25);
		

		
		// 암호키 입력 textField 설정 
		textFieldEncryptionKey = new JTextField();
		
		textFieldEncryptionKey.setBounds(287, 289, 592, 68);
		textFieldEncryptionKey.setColumns(10);
		textFieldEncryptionKey.setFont(fontHint);
		frame.add(textFieldEncryptionKey);
		
		// 라벨 생성
		JLabel label = new JLabel();
		label.setForeground(Color.WHITE);
		label.setBounds(337, 112, 407, 78);
		label.setText("PROTECT");
		label.setFont(fontTitle);
		frame.add(label);

		
		// 라벨 생성
		JLabel labelEncryptionKey = new JLabel();
		labelEncryptionKey.setForeground(Color.WHITE);
		labelEncryptionKey.setBounds(82, 293, 165, 57);
		labelEncryptionKey.setText("암호키");
		labelEncryptionKey.setFont(fontKey);
		frame.add(labelEncryptionKey);		
		
		// 라벨 생성
		JLabel labelDeryption = new JLabel();
		labelDeryption.setForeground(Color.WHITE);
		labelDeryption.setBounds(82, 475, 165, 57);
		labelDeryption.setText("평 문");
		labelDeryption.setFont(fontKey);
		frame.add(labelDeryption);
		
		// 평문 입력 textField 설정
		textFieldPlanText = new JTextField();
		
		textFieldPlanText.setBounds(287, 472, 592, 68);
		textFieldPlanText.setColumns(10);
		textFieldPlanText.setFont(fontHint);
		frame.add(textFieldPlanText);
		
		// 암호화 버튼 설정
		RoundedButton protectedBtn = new RoundedButton("암호화",2);
		protectedBtn.setBounds(346, 663, 288, 81);
		protectedBtn.setFont(fontButton);
		frame.getContentPane().add(protectedBtn);
		
		// 배경색 넣기
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
				// 현재의 프레임 종료
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
