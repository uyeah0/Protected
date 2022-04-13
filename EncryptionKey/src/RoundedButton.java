import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.border.Border;

public class RoundedButton extends JButton{
	
	Color color; // 배경색 초기화
	int radius;

	public RoundedButton(String text, int i) {
		super(text);

		if (i == 1) {
			color = new Color(241, 76, 76); // 빨강
		} else 
			color = new Color(255,255,255); // 흰색
		
		radius = 50;
		decorate();
	}

	public RoundedButton(String text) {
		super(text);
		color = new Color(67, 168, 255); // 파랑
		radius = 100;
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Color textColor = new Color(0, 0, 0); // 글자색 결정
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (getModel().isArmed()) {
			graphics.setColor(color.darker());
		} else if (getModel().isRollover()) {
			graphics.setColor(color.brighter());
		} else {
			graphics.setColor(color);
		}
		graphics.fillRoundRect(0, 0, width, height, radius, radius);
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
		
		graphics.setColor(textColor); 
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		super.paintComponent(g);
	}
	
}
