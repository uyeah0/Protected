import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class m3108 {
	
	public m3108() {
		
		// ������ ����
		JFrame frame = new JFrame("Protect");
		
		// ���� ����
		frame.setTitle("3108");
		
		// ������ ũ�� ����
		frame.setSize(980, 860);
		
		// �������� ȭ�� ����� ��ġ
		frame.setLocationRelativeTo(null);
		
		// �������� ũ�⸦ �������� ���ϰ� ����
		frame.setResizable(false);

		
		// ������ ���̰� ����
		frame.setVisible(true);
		
		// ���� ����
		frame.getContentPane().setBackground(Color.BLUE);
		
		
		// �������� �ݾ��� �� �޸𸮿��� ���ŵǵ��� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public static void main(String args[]) {
		new m3108();
	}
}
