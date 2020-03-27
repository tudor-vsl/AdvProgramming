import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ControlPanel extends JPanel {
 
	final MainFrame frame;
	JButton saveBtn = new JButton("Save");
	JButton loadBtn = new JButton("Load");
	JButton resetBtn = new JButton("Reset");
	JButton exitBtn = new JButton("Exit");
	
	private final JFileChooser openFileChooser;
	private BufferedImage origBI;
	
	public ControlPanel(MainFrame frame) {
		this.frame = frame; 
		init();
		openFileChooser = new JFileChooser();
		openFileChooser.setCurrentDirectory(new File("c:\\temp)"));
		openFileChooser.setFileFilter(new FileNameExtensionFilter("PNG images", "png"));
	}
	
	private void init() {
 
		//change the default layout manager (just for fun)
		setLayout(new GridLayout(1, 4));
		add(saveBtn);
		add(loadBtn);
		add(resetBtn);
		add(exitBtn);
		
		saveBtn.addActionListener(this::save);
		exitBtn.addActionListener(this::exit);
		loadBtn.addActionListener(this::load);
		
	}
	

	private void save(ActionEvent e) {
		try {
			ImageIO.write(frame.canvas.image, "PNG", new File("d:/test.png"));
		} catch (IOException ex) { System.err.println(ex); }
	}
	
	private void exit(ActionEvent e) {
		System.exit(0);
	}
	
	private void load(ActionEvent e)//am incercat sa il fac dar nu mi-a reusit
	{
		 int returnVal = openFileChooser.showOpenDialog(this);
		 if(returnVal == JFileChooser.APPROVE_OPTION)
		 {
			try {
				origBI = ImageIO.read(openFileChooser.getSelectedFile());
			}catch(IOException ioe) {
				
			}
		 }
	}
}
