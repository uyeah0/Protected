package protect;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import static protect.m3108.encryptionKey;
import static protect.m3108.planText;

public class m3108_2 extends JFrame {

	public static char alphabetBoard[][] = new char[5][5];
	public static boolean oddFlag = false; // ���ڼ� ���
	public static String zCheck = "";
	public static String board[] = new String[5];
	static String strPlayFair = "";

	public m3108_2() {

		String decryption;
		String encryption;

		String key = encryptionKey;
		String str = planText;
		System.out.println(key);
		System.out.println(str);

		String blankCheck = "";
		int blankCheckCount = 0;

		setBoard(key); // ��ȣȭ�� ���� ��ȣ�� ����

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') // ��������
			{
				str = str.substring(0, i) + str.substring(i + 1, str.length());
				blankCheck += 10;
			} else {
				blankCheck += 0;
			}
			if (str.charAt(i) == 'z') // z�� q�� �ٲ��༭ ó����.
			{
				str = str.substring(0, i) + 'q' + str.substring(i + 1, str.length());
				zCheck += 1;
			} else {
				zCheck += 0;
			}
		}

		encryption = strEncryption(key, str);

		// ��ºκ�
		System.out.println("��ȣȭ�� ���ڿ� : " + encryption);

		String encryptionBase = encryption;

		for (int i = 0; i < encryption.length(); i++) {
			if (encryption.charAt(i) == ' ') // ��������
				encryption = encryption.substring(0, i) + encryption.substring(i + 1, encryption.length());
		}

		decryption = strDecryption(key, encryption, zCheck);


		for (int i = 0; i < decryption.length(); i++) {
			if (blankCheck.charAt(i) == '1') {
				decryption = decryption.substring(0, i) + " " + decryption.substring(i, decryption.length());
			}
		}

		System.out.println("��ȣȭ�� ���ڿ� : " + decryption);

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
		Font fontKeyTitle = new Font("�޸յձ�������", Font.PLAIN, 35);
		Font fontKey = new Font("�޸յձ�������", Font.PLAIN, 25);
		Font fontMapping = new Font("�޸յձ�������", Font.PLAIN, 35);
		Font fontBoard = new Font("�޸յձ�������", Font.PLAIN, 35);
		Font fontButton = new Font("�޸յձ�������", Font.PLAIN, 35);

		// Ÿ��Ʋ ǥ��
		JLabel label = new JLabel();
		label.setForeground(Color.WHITE);
		label.setBounds(337, 112, 407, 78);
		label.setText("PROTECT");
		label.setFont(fontTitle);
		frame.getContentPane().add(label);
		frame.add(label);

		// ��ȣ�� ���
		for(int i = 0; i < board.length; i++) {
			int y = 260;
			JLabel labelBoardPrint = new JLabel();
			labelBoardPrint.setForeground(Color.WHITE);
			labelBoardPrint.setBounds(91, y+45*i, 320, 41);
			labelBoardPrint.setText(board[i]);
			labelBoardPrint.setFont(fontBoard);
			frame.getContentPane().add(labelBoardPrint);
			frame.add(labelBoardPrint);
		}
		
		// ��ȣȭ ��ư ����
		RoundedButton deyptionBtn = new RoundedButton("��ȣȭ", 2);
		deyptionBtn.setBounds(364, 764, 176, 81);
		deyptionBtn.setFont(fontButton);
		frame.getContentPane().add(deyptionBtn);
		
		// �ٽ��ϱ� ��ư ����
		RoundedButton returnBtn = new RoundedButton("�ٽ��ϱ�", 2);
		returnBtn.setBounds(569, 763, 176, 81);
		returnBtn.setFont(fontButton);
		frame.getContentPane().add(returnBtn);

		// ��ȣ�� �� ����
		JLabel labelEncryptionKey = new JLabel();
		labelEncryptionKey.setForeground(Color.WHITE);
		labelEncryptionKey.setBounds(470, 260, 120, 41);
		labelEncryptionKey.setText("��ȣ��");
		labelEncryptionKey.setFont(fontKeyTitle);
		frame.getContentPane().add(labelEncryptionKey);

		// ��ȣ�� ���
		JLabel labelEncryptionKeyPrint = new JLabel();
		labelEncryptionKeyPrint.setForeground(Color.WHITE);
		labelEncryptionKeyPrint.setBounds(470, 321, 600, 53);
		labelEncryptionKeyPrint.setText(encryptionBase);
		labelEncryptionKeyPrint.setFont(fontKey);
		frame.getContentPane().add(labelEncryptionKeyPrint);
		frame.add(labelEncryptionKeyPrint);

		// ��ȣ�� �� ����
		JLabel labelDeryption = new JLabel();
		labelDeryption.setForeground(Color.WHITE);
		labelDeryption.setBounds(470, 416, 120, 41);
		labelDeryption.setText("��ȣ��");
		labelDeryption.setFont(fontKeyTitle);
		frame.getContentPane().add(labelDeryption);
		frame.add(labelDeryption);

		// ��ȣ�� ���
		JLabel labelDeryptionPrint = new JLabel();
		labelDeryptionPrint.setForeground(Color.WHITE);
		labelDeryptionPrint.setBounds(470, 477, 600, 53);
		labelDeryptionPrint.setFont(fontKey);
		frame.getContentPane().add(labelDeryptionPrint);
		frame.add(labelDeryptionPrint);

		// Mapping ��
		JLabel labelPlayFair = new JLabel();
		labelPlayFair.setForeground(Color.WHITE);
		labelPlayFair.setBounds(93, 613, 728, 41);
		labelPlayFair.setText(strPlayFair);
		labelPlayFair.setFont(fontMapping);
		frame.getContentPane().add(labelPlayFair);
		frame.add(labelPlayFair);

		// Mapping ��ȣ��
		JLabel labelEncryptionKeyPrint2 = new JLabel();
		labelEncryptionKeyPrint2.setForeground(Color.WHITE);
		labelEncryptionKeyPrint2.setBounds(91, 680, 800, 41);
		labelEncryptionKeyPrint2.setText(encryptionBase);
		labelEncryptionKeyPrint2.setFont(fontMapping);
		frame.getContentPane().add(labelEncryptionKeyPrint2);
		
		// ��ư ������ �� ��ȣ�� ����ϱ� ���� ����
		String decryptionValue = decryption;
		
		// ��ȣȭ ��ư
		deyptionBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ȣ�� ���
				labelDeryptionPrint.setText(decryptionValue);
			}
		});
		
		// �ٽ��ϱ� ��ư
		returnBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i = 0; i < board.length; i++) {
					board[i] = "";
					strPlayFair = "";
				}
				// ������ ������ ����
				frame.dispose();
				new m3108();
			}
		});

		// ���� �ֱ�
		JLabel back = new JLabel();
		back.setOpaque(true);
		back.setBackground(new Color(55, 61, 221));
		back.setBounds(0, 0, 1980, 1080);
		back.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(back);

		frame.setVisible(true);
	} // main finish

	private static String strDecryption(String key, String str, String zCheck) {
		ArrayList<char[]> playFair = new ArrayList<char[]>(); // �ٲٱ� �� ���ھ�ȣ�� ������ ��
		ArrayList<char[]> decPlayFair = new ArrayList<char[]>(); // �ٲ� ���� ���ھ�ȣ ������ ��
		int x1 = 0, x2 = 0, y1 = 0, y2 = 0; // ���� ��ȣ �� ������ ������ ��,�� ��
		String decStr = "";

		int lengthOddFlag = 1;

		for (int i = 0; i < str.length(); i += 2) // ���� ��ȣ ����
		{
			char[] tmpArr = new char[2];
			tmpArr[0] = str.charAt(i);
			tmpArr[1] = str.charAt(i + 1);
			playFair.add(tmpArr);
		}

		for (int i = 0; i < playFair.size(); i++) {

			char[] tmpArr = new char[2];
			for (int j = 0; j < alphabetBoard.length; j++) {
				for (int k = 0; k < alphabetBoard[j].length; k++) {
					if (alphabetBoard[j][k] == playFair.get(i)[0]) {
						x1 = j;
						y1 = k;
					}
					if (alphabetBoard[j][k] == playFair.get(i)[1]) {
						x2 = j;
						y2 = k;
					}
				}
			}

			if (x1 == x2) // ���� ���� ��� ���� �ٷ� �Ʒ��� ����
			{
				tmpArr[0] = alphabetBoard[x1][(y1 + 4) % 5];
				tmpArr[1] = alphabetBoard[x2][(y2 + 4) % 5];
			} else if (y1 == y2) // ���� ���� ��� ���� �ٷ� �� �� ����
			{
				tmpArr[0] = alphabetBoard[(x1 + 4) % 5][y1];
				tmpArr[1] = alphabetBoard[(x2 + 4) % 5][y2];
			} else // ��, �� �ٸ���� ���� �밢���� �ִ� ��.
			{
				tmpArr[0] = alphabetBoard[x2][y1];
				tmpArr[1] = alphabetBoard[x1][y2];
			}

			decPlayFair.add(tmpArr);

		}

		for (int i = 0; i < decPlayFair.size(); i++) // �ߺ� ���ڿ� ��������
		{
			if (i != decPlayFair.size() - 1 && decPlayFair.get(i)[1] == 'x'
					&& decPlayFair.get(i)[0] == decPlayFair.get(i + 1)[0]) {
				decStr += decPlayFair.get(i)[0];
			} else {
				decStr += decPlayFair.get(i)[0] + "" + decPlayFair.get(i)[1];
			}
		}

		for (int i = 0; i < zCheck.length(); i++)// z��ġ ã�Ƽ� q�� ��������
		{
			if (zCheck.charAt(i) == '1')
				decStr = decStr.substring(0, i) + 'z' + decStr.substring(i + 1, decStr.length());

		}

		if (oddFlag)
			decStr = decStr.substring(0, decStr.length() - 1);

		/*
		 * //���� for(int i = 0 ; i < decStr.length(); i++) { if(i%2==lengthOddFlag){
		 * decStr = decStr.substring(0, i+1)+" "+decStr.substring(i+1, decStr.length());
		 * i++; lengthOddFlag = ++lengthOddFlag %2; } }
		 */
		return decStr;
	}

	private static String strEncryption(String key, String str) {
		ArrayList<char[]> playFair = new ArrayList<char[]>();
		ArrayList<char[]> encPlayFair = new ArrayList<char[]>();
		int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
		String encStr = "";

		for (int i = 0; i < str.length(); i += 2) // arraylist ����
		{
			char[] tmpArr = new char[2];
			tmpArr[0] = str.charAt(i);
			try {
				if (str.charAt(i) == str.charAt(i + 1)) // ���� �ݺ��Ǹ� x�߰�
				{
					tmpArr[1] = 'x';
					i--;
				} else {
					tmpArr[1] = str.charAt(i + 1);
				}
			} catch (StringIndexOutOfBoundsException e) {
				tmpArr[1] = 'x';
				oddFlag = true;
			}
			tmpArr[0] = Character.toLowerCase(tmpArr[0]);
			tmpArr[1] = Character.toLowerCase(tmpArr[1]);
			playFair.add(tmpArr);
		}

		// �ٲٱ� �� ���� ��ȣ ���
		for (int i = 0; i < playFair.size(); i++) {
			String s = playFair.get(i)[0] + "" + playFair.get(i)[1] + " ";
			strPlayFair = strPlayFair.concat(s);
			System.out.print(s);
		}
		System.out.println();

		for (int i = 0; i < playFair.size(); i++) {
			char[] tmpArr = new char[2];
			for (int j = 0; j < alphabetBoard.length; j++) // ���ھ�ȣ�� ���� ��ġüũ
			{
				for (int k = 0; k < alphabetBoard[j].length; k++) {
					if (alphabetBoard[j][k] == playFair.get(i)[0]) {
						x1 = j;
						y1 = k;
					}
					if (alphabetBoard[j][k] == playFair.get(i)[1]) {
						x2 = j;
						y2 = k;
					}
				}
			}

			if (x1 == x2) // ���� �������
			{
				tmpArr[0] = alphabetBoard[x1][(y1 + 1) % 5];
				tmpArr[1] = alphabetBoard[x2][(y2 + 1) % 5];
			} else if (y1 == y2) // ���� ���� ���
			{
				tmpArr[0] = alphabetBoard[(x1 + 1) % 5][y1];
				tmpArr[1] = alphabetBoard[(x2 + 1) % 5][y2];
			} else // ��, �� ��� �ٸ����
			{
				tmpArr[0] = alphabetBoard[x2][y1];
				tmpArr[1] = alphabetBoard[x1][y2];
			}

			encPlayFair.add(tmpArr);

		}

		for (int i = 0; i < encPlayFair.size(); i++) {
			encStr += encPlayFair.get(i)[0] + "" + encPlayFair.get(i)[1] + " ";
		}

		return encStr;
	}

	private static void setBoard(String key) {

		// �Է� ���� ��� �ҹ��ڷ� �ٲٱ�
		key = key.toLowerCase();

		String keyForSet = ""; // �ߺ��� ���ڰ� ���ŵ� ���ڿ��� ������ ���ڿ�.
		boolean duplicationFlag = false; // ���� �ߺ��� üũ�ϱ� ���� flag ����.
		int keyLengthCount = 0; // alphabetBoard�� keyForSet�� �ֱ� ���� count����.

		key += "abcdefghijklmnopqrstuvwxyz"; // Ű�� ��� ���ĺ��� �߰�.

		// �ߺ�ó��
		for (int i = 0; i < key.length(); i++) {
			for (int j = 0; j < keyForSet.length(); j++) {
				if (key.charAt(i) == keyForSet.charAt(j)) {
					duplicationFlag = true;
					break;
				}
			}
			if (!(duplicationFlag))
				keyForSet += key.charAt(i);
			duplicationFlag = false;
		}
		// �迭�� ����
		for (int i = 0; i < alphabetBoard.length; i++) {
			for (int j = 0; j < alphabetBoard[i].length; j++) {
				alphabetBoard[i][j] = keyForSet.charAt(keyLengthCount++);
			}
		}

		// �迭 �� ���� �־ �󺧷� 4�� ���� �����
		// ���� �̸� board
		// �迭 ���
		for (int i = 0; i < alphabetBoard.length; i++) {
			board[i] = "";
			for (int j = 0; j < alphabetBoard[i].length; j++) {
				System.out.print(alphabetBoard[i][j] + "-");
				board[i] = board[i].concat(Character.toString(alphabetBoard[i][j]));
				board[i] = board[i].concat("  ");
			}
			System.out.println();
		}

	}

	public static void main(String args[]) {
		new m3108_2();
	}
}
