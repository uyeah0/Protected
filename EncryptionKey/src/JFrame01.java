import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JFrame01 extends JFrame{
	
	private JPanel contentPane;
	
	public JFrame01() {
		
		// 제목 설정
		setTitle("3108");
		
		// 크기 설정
		setSize(980, 860);
		setResizable(false);
		setBackground(Color.BLUE);
		// 화면 가운데에 배치
		setLocationRelativeTo(null);
		setVisible(true);
		
		// 프레임을 닫았을 때 메모리에서 제거되도록 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 폰트 설정
		//Font font = new Font("")
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		
		contentPane.setBackground(Color.BLUE);
		
		// null Layout 사용 
		contentPane.setLayout(null);

		// 위젯 배치 (버튼 추가)
		JButton startBtn = new JButton("암호화/복호화");
		startBtn.setSize(10, 20);
		startBtn.setBounds(12, 10, 97, 23);
		contentPane.add(startBtn);

		
	}
}
