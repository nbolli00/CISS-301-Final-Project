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
	int but_width = 60;
	int but_height = 40;
	JTextField txtf = new JTextField();
	JButton wait = new JButton("Wait");
	JButton dot = new JButton("dot");
	JButton dash = new JButton("dash");
	JButton startstop = new JButton("Start/Stop");

	// override constructor
	public morsegui(){
		
		// This defines the JFrame
		JFrame f = new JFrame("Morse Code Translater");
		f.setBackground (new Color(255, 255, 255));
		f.setForeground (new Color(153, 204, 255));
		f.setSize(1000,600);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// defines objects on the JFrame
		txtf.setBounds(40, 10, 240, 20);
		wait.setBounds(but_x_base + 60,but_y_pos + 200,but_width,but_height);
		dot.setBounds(but_x_base + 0,but_y_pos + 80,but_width,but_height);
		dash.setBounds(but_x_base + 60,but_y_pos + 80,but_width,but_height);
		startstop.setBounds(but_x_base + 120,but_y_pos + 80,but_width,but_height);
		ButtonListener listener = new ButtonListener();

		// adds listeners to the buttons
		wait.addActionListener(listener);
		dot.addActionListener(listener);
		dash.addActionListener(listener);
		startstop.addActionListener(listener);

		// adds the objects to the JFrame
		f.add(txtf);
		f.add(wait);
		f.add(dot);
		f.add(dash);
		f.add(startstop);
		
		//setting the color of the buttons
		wait.setBackground(new Color(128, 128, 128));
		dot.setBackground(new Color(128, 128, 128));
		dash.setBackground(new Color(128, 128, 128));
		startstop.setBackground(new Color(128, 128, 128));
		
		//setting the color of the background
		
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
				System.out.println("listening!");
			}
			else if (e.getSource() == startstop && ml.getListening())  {
				System.out.println(ml.stopListen());
			}
			else if (e.getSource() == wait) 
				ml.getInput(0);
			else if (e.getSource() == dot)
				ml.getInput(1);
			else if (e.getSource() == dash) 
				ml.getInput(2);
		}
	}
}
