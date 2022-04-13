import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class m3108 {
	
	public m3108() {
		
		// 프레임 생성
		JFrame frame = new JFrame("Protect");
		
		// 제목 설정
		frame.setTitle("3108");
		
		// 프레임 크기 설정
		frame.setSize(980, 860);
		
		// 프레임을 화면 가운데에 배치
		frame.setLocationRelativeTo(null);
		
		// 프레임의 크기를 변경하지 못하게 설정
		frame.setResizable(false);

		
		// 프레임 보이게 설정
		frame.setVisible(true);
		
		// 배경색 설정
		frame.getContentPane().setBackground(Color.BLUE);
		
		
		// 프레임을 닫았을 때 메모리에서 제거되도록 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public static void main(String args[]) {
		new m3108();
	}
}
