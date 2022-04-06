import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					 new JFrame01();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			
		});

		//frame.setBackground(new Color());;
	}

}
