import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DrawingPanel extends JPanel {
	
	final MainFrame frame;
	ControlPanel cp;
	final static int W = 800, H = 600;

	
	BufferedImage image;
	Graphics2D graphics; 
	public DrawingPanel(MainFrame frame) {
		this.frame = frame; createOffscreenImage(); 
		init();
	
	}
	private void createOffscreenImage() {
		image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
		graphics = image.createGraphics();
		graphics.setColor(Color.WHITE); 
		graphics.fillRect(0, 0, W, H);
	}
	
	private void init() {
	 
			setPreferredSize(new Dimension(W, H)); 
			setBorder(BorderFactory.createEtchedBorder()); 
			this.addMouseListener(new MouseAdapter() {
				
			@Override
			public void mousePressed(MouseEvent e) {
			drawShape(e.getX(), e.getY()); repaint();
			}
		});
	 }
	 private void drawShape(int x, int y) {
		 int radius = (int)(10 + Math.random()*10);
		 int sides = 6; //get the value from UI (in ConfigPanel)
		 Random rand = new Random();
		 Color color = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),150); //create a transparent random Color.
		 graphics.setColor(color);
		 graphics.fill(new RegularPolygon(x, y, radius, sides));
	 }
	 @Override
	 public void update(Graphics g) { } 

	 @Override
	 protected void paintComponent(Graphics g) {
	 g.drawImage(image, 0, 0, this);
	 }
	}
