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
		
		// ���� ����
		setTitle("3108");
		
		// ũ�� ����
		setSize(980, 860);
		setResizable(false);
		setBackground(Color.BLUE);
		// ȭ�� ����� ��ġ
		setLocationRelativeTo(null);
		setVisible(true);
		
		// �������� �ݾ��� �� �޸𸮿��� ���ŵǵ��� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// ��Ʈ ����
		//Font font = new Font("")
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		
		contentPane.setBackground(Color.BLUE);
		
		// null Layout ��� 
		contentPane.setLayout(null);

		// ���� ��ġ (��ư �߰�)
		JButton startBtn = new JButton("��ȣȭ/��ȣȭ");
		startBtn.setSize(10, 20);
		startBtn.setBounds(12, 10, 97, 23);
		contentPane.add(startBtn);

		
	}
}
