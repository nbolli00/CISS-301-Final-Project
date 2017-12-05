//The GUI of the Morse translator program
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class morsegui extends JFrame{
	
	// class attributes
	String numberString = "";
	MorseListener ml = new MorseListener();
	int but_x_base = 40;
	int but_y_pos = 40;
	int but_width = 120;
	int but_height = 20;
	JTextArea txtf = new JTextArea();
	JButton wait = new JButton("Wait");
	JButton dot = new JButton("dot");
	JButton dash = new JButton("dash");
	JButton startstop = new JButton("Start");
	JButton clear = new JButton("Clear");

	// override constructor
	public morsegui(){
		
		// This defines the JFrame
		JFrame f = new JFrame("Morse Code Translater");
		f.getContentPane().setBackground (new Color(156, 170, 223));
		f.setSize(1000,600);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// defines objects on the JFrame
		txtf.setBounds(40, 325, 300, 220);
		wait.setBounds(but_x_base + 120,but_y_pos + 20,but_width,but_height);
		dot.setBounds(but_x_base + 120,but_y_pos + 60,but_width,but_height);
		dash.setBounds(but_x_base + 120,but_y_pos + 100,but_width,but_height);
		startstop.setBounds(but_x_base + 120,but_y_pos + 140,but_width,but_height);
		clear.setBounds(but_x_base + 120,but_y_pos + 180,but_width,but_height);
		ButtonListener listener = new ButtonListener();

		// adds listeners to the buttons
		wait.addActionListener(listener);
		dot.addActionListener(listener);
		dash.addActionListener(listener);
		startstop.addActionListener(listener);
		clear.addActionListener(listener);

		// adds the objects to the JFrame
		f.add(txtf);
		f.add(wait);
		f.add(dot);
		f.add(dash);
		f.add(startstop);
		f.add(clear);
		
		//setting the color of the buttons
		wait.setBackground(new Color(128, 128, 128));
		dot.setBackground(new Color(128, 128, 128));
		dash.setBackground(new Color(128, 128, 128));
		startstop.setBackground(Color.GREEN);
		clear.setBackground(new Color(128, 128, 128));
		
		// makes it visible
		f.setVisible(true);  
	}

	public static void main(String args[]) {
		// Creates the JFrame by calling the override constructor
		new morsegui();
	}

	// this is a class method that is called each time a button with a listener is pressed
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == startstop && (!(ml.getListening()))) {
				ml.listen();
				startstop.setBackground(Color.RED);
				startstop.setText("Stop");
			}
			else if (e.getSource() == startstop && ml.getListening())  {
				txtf.append(ml.stopListen());
				startstop.setBackground(Color.GREEN);
				startstop.setText("Start");
			}
			else if (e.getSource() == wait) 
				ml.getInput(0);
			else if (e.getSource() == dot)
				ml.getInput(1);
			else if (e.getSource() == dash) 
				ml.getInput(2);
			else if (e.getSource() == clear) 
				txtf.setText("");
		}
	}
}
