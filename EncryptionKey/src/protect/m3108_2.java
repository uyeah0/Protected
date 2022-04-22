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
	public static boolean oddFlag = false; // 글자수 출력
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

		setBoard(key); // 암호화에 쓰일 암호판 세팅

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') // 공백제거
			{
				str = str.substring(0, i) + str.substring(i + 1, str.length());
				blankCheck += 10;
			} else {
				blankCheck += 0;
			}
			if (str.charAt(i) == 'z') // z를 q로 바꿔줘서 처리함.
			{
				str = str.substring(0, i) + 'q' + str.substring(i + 1, str.length());
				zCheck += 1;
			} else {
				zCheck += 0;
			}
		}

		encryption = strEncryption(key, str);

		// 출력부분
		System.out.println("암호화된 문자열 : " + encryption);

		String encryptionBase = encryption;

		for (int i = 0; i < encryption.length(); i++) {
			if (encryption.charAt(i) == ' ') // 공백제거
				encryption = encryption.substring(0, i) + encryption.substring(i + 1, encryption.length());
		}

		decryption = strDecryption(key, encryption, zCheck);


		for (int i = 0; i < decryption.length(); i++) {
			if (blankCheck.charAt(i) == '1') {
				decryption = decryption.substring(0, i) + " " + decryption.substring(i, decryption.length());
			}
		}

		System.out.println("복호화된 문자열 : " + decryption);

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
		Font fontKeyTitle = new Font("휴먼둥근헤드라인", Font.PLAIN, 35);
		Font fontKey = new Font("휴먼둥근헤드라인", Font.PLAIN, 25);
		Font fontMapping = new Font("휴먼둥근헤드라인", Font.PLAIN, 35);
		Font fontBoard = new Font("휴먼둥근헤드라인", Font.PLAIN, 35);
		Font fontButton = new Font("휴먼둥근헤드라인", Font.PLAIN, 35);

		// 타이틀 표시
		JLabel label = new JLabel();
		label.setForeground(Color.WHITE);
		label.setBounds(337, 112, 407, 78);
		label.setText("PROTECT");
		label.setFont(fontTitle);
		frame.getContentPane().add(label);
		frame.add(label);

		// 암호판 출력
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
		
		// 복호화 버튼 설정
		RoundedButton deyptionBtn = new RoundedButton("복호화", 2);
		deyptionBtn.setBounds(364, 764, 176, 81);
		deyptionBtn.setFont(fontButton);
		frame.getContentPane().add(deyptionBtn);
		
		// 다시하기 버튼 설정
		RoundedButton returnBtn = new RoundedButton("다시하기", 2);
		returnBtn.setBounds(569, 763, 176, 81);
		returnBtn.setFont(fontButton);
		frame.getContentPane().add(returnBtn);

		// 암호문 라벨 생성
		JLabel labelEncryptionKey = new JLabel();
		labelEncryptionKey.setForeground(Color.WHITE);
		labelEncryptionKey.setBounds(470, 260, 120, 41);
		labelEncryptionKey.setText("암호문");
		labelEncryptionKey.setFont(fontKeyTitle);
		frame.getContentPane().add(labelEncryptionKey);

		// 암호문 출력
		JLabel labelEncryptionKeyPrint = new JLabel();
		labelEncryptionKeyPrint.setForeground(Color.WHITE);
		labelEncryptionKeyPrint.setBounds(470, 321, 600, 53);
		labelEncryptionKeyPrint.setText(encryptionBase);
		labelEncryptionKeyPrint.setFont(fontKey);
		frame.getContentPane().add(labelEncryptionKeyPrint);
		frame.add(labelEncryptionKeyPrint);

		// 복호문 라벨 생성
		JLabel labelDeryption = new JLabel();
		labelDeryption.setForeground(Color.WHITE);
		labelDeryption.setBounds(470, 416, 120, 41);
		labelDeryption.setText("복호문");
		labelDeryption.setFont(fontKeyTitle);
		frame.getContentPane().add(labelDeryption);
		frame.add(labelDeryption);

		// 복호문 출력
		JLabel labelDeryptionPrint = new JLabel();
		labelDeryptionPrint.setForeground(Color.WHITE);
		labelDeryptionPrint.setBounds(470, 477, 600, 53);
		labelDeryptionPrint.setFont(fontKey);
		frame.getContentPane().add(labelDeryptionPrint);
		frame.add(labelDeryptionPrint);

		// Mapping 값
		JLabel labelPlayFair = new JLabel();
		labelPlayFair.setForeground(Color.WHITE);
		labelPlayFair.setBounds(93, 613, 728, 41);
		labelPlayFair.setText(strPlayFair);
		labelPlayFair.setFont(fontMapping);
		frame.getContentPane().add(labelPlayFair);
		frame.add(labelPlayFair);

		// Mapping 암호문
		JLabel labelEncryptionKeyPrint2 = new JLabel();
		labelEncryptionKeyPrint2.setForeground(Color.WHITE);
		labelEncryptionKeyPrint2.setBounds(91, 680, 800, 41);
		labelEncryptionKeyPrint2.setText(encryptionBase);
		labelEncryptionKeyPrint2.setFont(fontMapping);
		frame.getContentPane().add(labelEncryptionKeyPrint2);
		
		// 버튼 눌렀을 때 복호문 출력하기 위한 변수
		String decryptionValue = decryption;
		
		// 복호화 버튼
		deyptionBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 복호문 출력
				labelDeryptionPrint.setText(decryptionValue);
			}
		});
		
		// 다시하기 버튼
		returnBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i = 0; i < board.length; i++) {
					board[i] = "";
					strPlayFair = "";
				}
				// 현재의 프레임 종료
				frame.dispose();
				new m3108();
			}
		});

		// 배경색 넣기
		JLabel back = new JLabel();
		back.setOpaque(true);
		back.setBackground(new Color(55, 61, 221));
		back.setBounds(0, 0, 1980, 1080);
		back.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(back);

		frame.setVisible(true);
	} // main finish

	private static String strDecryption(String key, String str, String zCheck) {
		ArrayList<char[]> playFair = new ArrayList<char[]>(); // 바꾸기 전 쌍자암호를 저장할 곳
		ArrayList<char[]> decPlayFair = new ArrayList<char[]>(); // 바꾼 후의 쌍자암호 저장할 곳
		int x1 = 0, x2 = 0, y1 = 0, y2 = 0; // 쌍자 암호 두 글자의 각각의 행,열 값
		String decStr = "";

		int lengthOddFlag = 1;

		for (int i = 0; i < str.length(); i += 2) // 쌍자 암호 저장
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

			if (x1 == x2) // 행이 같은 경우 각각 바로 아래열 대입
			{
				tmpArr[0] = alphabetBoard[x1][(y1 + 4) % 5];
				tmpArr[1] = alphabetBoard[x2][(y2 + 4) % 5];
			} else if (y1 == y2) // 열이 같은 경우 각각 바로 옆 열 대입
			{
				tmpArr[0] = alphabetBoard[(x1 + 4) % 5][y1];
				tmpArr[1] = alphabetBoard[(x2 + 4) % 5][y2];
			} else // 행, 열 다른경우 각자 대각선에 있는 곳.
			{
				tmpArr[0] = alphabetBoard[x2][y1];
				tmpArr[1] = alphabetBoard[x1][y2];
			}

			decPlayFair.add(tmpArr);

		}

		for (int i = 0; i < decPlayFair.size(); i++) // 중복 문자열 돌려놓음
		{
			if (i != decPlayFair.size() - 1 && decPlayFair.get(i)[1] == 'x'
					&& decPlayFair.get(i)[0] == decPlayFair.get(i + 1)[0]) {
				decStr += decPlayFair.get(i)[0];
			} else {
				decStr += decPlayFair.get(i)[0] + "" + decPlayFair.get(i)[1];
			}
		}

		for (int i = 0; i < zCheck.length(); i++)// z위치 찾아서 q로 돌려놓음
		{
			if (zCheck.charAt(i) == '1')
				decStr = decStr.substring(0, i) + 'z' + decStr.substring(i + 1, decStr.length());

		}

		if (oddFlag)
			decStr = decStr.substring(0, decStr.length() - 1);

		/*
		 * //띄어쓰기 for(int i = 0 ; i < decStr.length(); i++) { if(i%2==lengthOddFlag){
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

		for (int i = 0; i < str.length(); i += 2) // arraylist 세팅
		{
			char[] tmpArr = new char[2];
			tmpArr[0] = str.charAt(i);
			try {
				if (str.charAt(i) == str.charAt(i + 1)) // 글이 반복되면 x추가
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

		// 바꾸기 전 쌍자 암호 출력
		for (int i = 0; i < playFair.size(); i++) {
			String s = playFair.get(i)[0] + "" + playFair.get(i)[1] + " ";
			strPlayFair = strPlayFair.concat(s);
			System.out.print(s);
		}
		System.out.println();

		for (int i = 0; i < playFair.size(); i++) {
			char[] tmpArr = new char[2];
			for (int j = 0; j < alphabetBoard.length; j++) // 쌍자암호의 각각 위치체크
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

			if (x1 == x2) // 행이 같은경우
			{
				tmpArr[0] = alphabetBoard[x1][(y1 + 1) % 5];
				tmpArr[1] = alphabetBoard[x2][(y2 + 1) % 5];
			} else if (y1 == y2) // 열이 같은 경우
			{
				tmpArr[0] = alphabetBoard[(x1 + 1) % 5][y1];
				tmpArr[1] = alphabetBoard[(x2 + 1) % 5][y2];
			} else // 행, 열 모두 다른경우
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

		// 입력 문자 모두 소문자로 바꾸기
		key = key.toLowerCase();

		String keyForSet = ""; // 중복된 문자가 제거된 문자열을 저장할 문자열.
		boolean duplicationFlag = false; // 문자 중복을 체크하기 위한 flag 변수.
		int keyLengthCount = 0; // alphabetBoard에 keyForSet을 넣기 위한 count변수.

		key += "abcdefghijklmnopqrstuvwxyz"; // 키에 모든 알파벳을 추가.

		// 중복처리
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
		// 배열에 대입
		for (int i = 0; i < alphabetBoard.length; i++) {
			for (int j = 0; j < alphabetBoard[i].length; j++) {
				alphabetBoard[i][j] = keyForSet.charAt(keyLengthCount++);
			}
		}

		// 배열 네 개에 넣어서 라벨로 4개 라인 만들기
		// 변수 이름 board
		// 배열 출력
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
