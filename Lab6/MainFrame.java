import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

	public class MainFrame extends JFrame {
		ConfigPanel configPanel;
		ControlPanel controlPanel;
		DrawingPanel canvas;

		public MainFrame() {
			super("My Drawing Application");
			init();
		}

		private void init() {
			
			setTitle("Frame");
			setSize(800, 600);
			setLocation(500, 500);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			canvas = new DrawingPanel(this);
			configPanel = new ConfigPanel(this);
			controlPanel = new ControlPanel(this);

			add(canvas, BorderLayout.CENTER); 
			add(configPanel, BorderLayout.NORTH);
			add(controlPanel, BorderLayout.SOUTH);
			
			pack();
		}
	}

