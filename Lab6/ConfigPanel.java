import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ConfigPanel extends JPanel implements ActionListener  { 
	
	final MainFrame frame;
	JLabel label; // we’re drawing regular polygons
	JSpinner sidesField; // number of sides
	JComboBox colorCombo; // the color of the shape

	public ConfigPanel(MainFrame frame) {
		this.frame = frame;
		init();
	}
	private void init() {
		
		label = new JLabel("Number of sides:");
		sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		System.out.println(sidesField.getValue());
		
		String s1[] = {"Black", "Color"};
		colorCombo = new JComboBox(s1);
		colorCombo.setSelectedIndex(1);
		colorCombo.addActionListener(this);
		sidesField.setValue(6);
		
		add(label); 
		add(sidesField);
		add(colorCombo);
		
	}
	
	public int returnVal()
	{
		return (int)sidesField.getValue();	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
		
	}
}
