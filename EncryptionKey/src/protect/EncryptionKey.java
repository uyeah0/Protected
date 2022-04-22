package protect;

import java.awt.AlphaComposite;


import java.util.ArrayList;
import java.util.Scanner;
import static protect.m3108.encryptionKey;
import static protect.m3108.planText;

import javax.management.Descriptor;


public class EncryptionKey {

	public static char alphabetBoard[][] = new char[5][5];
	public static boolean oddFlag = false; //���ڼ� ���
	public static String zCheck ="";
	public static void main(String[] args) { // main
		
		String decryption;
		String encryption;
		
		String key = encryptionKey;
		String str = planText;
		System.out.println(key);
		System.out.println(str);
		
		/*
		Scanner sc = new Scanner(System.in); 	//�Է��� ���� Scanner ����
		System.out.print("��ȣȭ�� ���� Ű�� �Է��ϼ��� : ");
		String key = sc.nextLine();				//key �Է�
		System.out.print("��ȣȭ�� ���ڿ��� �Է��ϼ��� : ");
		String str =  sc.nextLine();				//���ڿ� �Է�
		*/
		String blankCheck="";
		int blankCheckCount=0;

		setBoard(key);							//��ȣȭ�� ���� ��ȣ�� ����
		
		for( int i = 0 ; i < str.length() ; i++ ) 
		{
			if(str.charAt(i)==' ') //��������
			{
				str = str.substring(0,i)+str.substring(i+1,str.length());
				blankCheck+=10;
			}
			else
			{
				blankCheck+=0;
			}
			if(str.charAt(i)=='z') //z�� q�� �ٲ��༭ ó����.
			{
				str = str.substring(0,i)+'q'+str.substring(i+1,str.length());
				zCheck+=1;
			}
			else 
			{
				zCheck+=0;
			}
		}
		
		encryption = strEncryption(key, str);
		

		//��ºκ�
		System.out.println("��ȣȭ�� ���ڿ� : " + encryption);
		


		for( int i = 0 ; i < encryption.length() ; i++ ) 
		{
			if(encryption.charAt(i)==' ') //��������
				encryption = encryption.substring(0,i)+encryption.substring(i+1,encryption.length());
		}
		
		decryption = strDecryption(key, encryption, zCheck);
		
		for( int i = 0 ; i < decryption.length() ; i++)
		{
			if(blankCheck.charAt(i)=='1')
			{
				decryption = decryption.substring(0,i)+" "+decryption.substring(i,decryption.length());
			}
		}
		
		System.out.println("��ȣȭ�� ���ڿ� : " + decryption);
	} // main finish
	
	private static String strDecryption(String key, String str, String zCheck) {
		ArrayList<char[]> playFair = new ArrayList<char[]>(); //�ٲٱ� �� ���ھ�ȣ�� ������ ��
		ArrayList<char[]> decPlayFair = new ArrayList<char[]>(); //�ٲ� ���� ���ھ�ȣ ������ ��
		int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0; //���� ��ȣ �� ������ ������ ��,�� ��
		String decStr ="";

		int lengthOddFlag = 1;
		
		
		for( int i = 0 ; i < str.length() ; i+=2 ) // ���� ��ȣ ����
		{
			char[] tmpArr = new char[2];
			tmpArr[0] = str.charAt(i);
			tmpArr[1] = str.charAt(i+1);
			playFair.add(tmpArr);
		}
		
		
		for(int i = 0 ; i < playFair.size() ; i++ )
		{

			char[] tmpArr = new char[2];
			for( int j = 0 ; j < alphabetBoard.length ; j++ )
			{
				for( int k = 0 ; k < alphabetBoard[j].length ; k++ )
				{
					if(alphabetBoard[j][k] == playFair.get(i)[0])
					{
						x1 = j;
						y1 = k;
					}
					if(alphabetBoard[j][k] == playFair.get(i)[1])
					{
						x2 = j;
						y2 = k;
					}
				}
			}
			
			if(x1==x2) //���� ���� ��� ���� �ٷ� �Ʒ��� ����
			{
				tmpArr[0] = alphabetBoard[x1][(y1+4)%5];
				tmpArr[1] = alphabetBoard[x2][(y2+4)%5];
			}
			else if(y1==y2) //���� ���� ��� ���� �ٷ� �� �� ����
			{
				tmpArr[0] = alphabetBoard[(x1+4)%5][y1];
				tmpArr[1] = alphabetBoard[(x2+4)%5][y2];
			}
			else //��, �� �ٸ���� ���� �밢���� �ִ� ��.
			{
				tmpArr[0] = alphabetBoard[x2][y1];
				tmpArr[1] = alphabetBoard[x1][y2];
			}
			
			decPlayFair.add(tmpArr);
			
		}
		
		for(int i = 0 ; i < decPlayFair.size() ; i++) //�ߺ� ���ڿ� ��������
		{
			if(i!=decPlayFair.size()-1 && decPlayFair.get(i)[1]=='x' 
					&& decPlayFair.get(i)[0]==decPlayFair.get(i+1)[0])
			{	
				decStr += decPlayFair.get(i)[0];
			}
			else
			{
				decStr += decPlayFair.get(i)[0]+""+decPlayFair.get(i)[1];
			}
		}
		
		
		
		for(int i = 0 ; i < zCheck.length() ; i++ )//z��ġ ã�Ƽ� q�� ��������
		{
			if( zCheck.charAt(i) == '1' ) 
				decStr = decStr.substring(0,i)+'z'+decStr.substring(i+1,decStr.length());
			
		}
		
		
		
		if(oddFlag) decStr = decStr.substring(0,decStr.length()-1);
		
		/*
		 //����
		for(int i = 0 ; i < decStr.length(); i++)
		{
			if(i%2==lengthOddFlag){
				decStr = decStr.substring(0, i+1)+" "+decStr.substring(i+1, decStr.length());
				i++;
				lengthOddFlag = ++lengthOddFlag %2;
			}
		}
		*/
		return decStr;
	}

	private static String strEncryption(String key, String str){
		ArrayList<char[]> playFair = new ArrayList<char[]>();
		ArrayList<char[]> encPlayFair = new ArrayList<char[]>();
		int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0;
		String encStr ="";
		
		
		
		for( int i = 0 ; i < str.length() ; i+=2 ) // arraylist ����
		{
			char[] tmpArr = new char[2];
			tmpArr[0] = str.charAt(i);
			try{
				if( str.charAt(i) == str.charAt(i+1)) //���� �ݺ��Ǹ� x�߰�
				{
					tmpArr[1] = 'x';
					i--;
				}else{
					tmpArr[1] = str.charAt(i+1);
				}
			}catch(StringIndexOutOfBoundsException e)
			{
				tmpArr[1] = 'x'; 
				oddFlag = true;
			}
			tmpArr[0] = Character.toLowerCase(tmpArr[0]);
			tmpArr[1] = Character.toLowerCase(tmpArr[1]);
			playFair.add(tmpArr);
		}
		
		// �ٲٱ� �� ���� ��ȣ ���
		for(int i = 0 ; i < playFair.size() ; i++ )
		{
			System.out.print(playFair.get(i)[0]+""+playFair.get(i)[1]+" ");
		}
		System.out.println();
		
		for(int i = 0 ; i < playFair.size() ; i++ )
		{
			char[] tmpArr = new char[2];
			for( int j = 0 ; j < alphabetBoard.length ; j++ ) //���ھ�ȣ�� ���� ��ġüũ
			{
				for( int k = 0 ; k < alphabetBoard[j].length ; k++ )
				{
					if(alphabetBoard[j][k] == playFair.get(i)[0])
					{
						x1 = j;
						y1 = k;
					}
					if(alphabetBoard[j][k] == playFair.get(i)[1])
					{
						x2 = j;
						y2 = k;
					}
				}
			}
			
			
			if(x1==x2) //���� �������
			{
				tmpArr[0] = alphabetBoard[x1][(y1+1)%5];
				tmpArr[1] = alphabetBoard[x2][(y2+1)%5];
			}
			else if(y1==y2) //���� ���� ���
			{
				tmpArr[0] = alphabetBoard[(x1+1)%5][y1];
				tmpArr[1] = alphabetBoard[(x2+1)%5][y2];
			} 
			else //��, �� ��� �ٸ����
			{
				tmpArr[0] = alphabetBoard[x2][y1];
				tmpArr[1] = alphabetBoard[x1][y2];
			}
			
			encPlayFair.add(tmpArr);
			
		}
		
		for(int i = 0 ; i < encPlayFair.size() ; i++)
		{
			encStr += encPlayFair.get(i)[0]+""+encPlayFair.get(i)[1]+" ";
		}
		
		
		return encStr;
	}

	private static void setBoard(String key) {
		
		// �Է� ���� ��� �ҹ��ڷ� �ٲٱ�
		key = key.toLowerCase();
		
		String keyForSet = "";					// �ߺ��� ���ڰ� ���ŵ� ���ڿ��� ������ ���ڿ�.
		boolean duplicationFlag = false;		// ���� �ߺ��� üũ�ϱ� ���� flag ����.
		int keyLengthCount = 0;					// alphabetBoard�� keyForSet�� �ֱ� ���� count����.
		
		key += "abcdefghijklmnopqrstuvwxyz"; 	// Ű�� ��� ���ĺ��� �߰�.

		
		// �ߺ�ó��
		for( int i = 0 ; i < key.length() ; i++ ) 
		{
			for( int j = 0 ; j < keyForSet.length() ; j++ )
			{
				if(key.charAt(i)==keyForSet.charAt(j))
				{
					duplicationFlag = true;
					break;
				}
			}
			if(!(duplicationFlag)) keyForSet += key.charAt(i);
			duplicationFlag = false;
		}
		//�迭�� ����
		for( int i = 0 ; i < alphabetBoard.length ; i++ )
		{
			for( int j = 0; j <alphabetBoard[i].length ; j++ )
			{
				alphabetBoard[i][j] = keyForSet.charAt(keyLengthCount++);
			}
		}		
		//�迭�� ����
		for( int i = 0 ; i < alphabetBoard.length ; i++ )
		{
			for( int j = 0; j <alphabetBoard[i].length ; j++ )
			{
				System.out.print(alphabetBoard[i][j]+"-");
			}
			System.out.println();
		}		
						
		
	}

}