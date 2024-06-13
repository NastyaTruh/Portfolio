package MainCode;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainCode extends JFrame {

	public MainCode() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocationRelativeTo(null);
		
		JPanel Panel = new JPanel();
		Panel.setLayout(null);
		add(Panel);

		Button(Panel);
		
		setVisible(true);
	}

	void Button(JPanel Panel) {
		JButton Button = new JButton("Run");
		Button.setBounds(350, 100, 100, 50);
		Panel.add(Button);

		Logic(Button);
	}
	
	
	void Logic(JButton Button) {
		
		Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ButtonX = Button.getX();
				int ButtonY = Button.getY();
				
				if (ButtonX == 350 && ButtonY == 100) Button.setText("0");
				
				double x = Math.random() * 1000;
				double y = Math.random() * 1000;
				
				while ( !((x<= 700 && x >= 0) && (y <= 700 && y >= 0))){
					x = Math.random() * 1000;
					y = Math.random() * 1000;
				} 
				
				while (x == ButtonX && y == ButtonY) {
					x = Math.random() * 1000;
					y = Math.random() * 1000;
				}
				
				int count = Integer.parseInt(Button.getText());
				count += 1;
				Button.setText(Integer.toString(count));
				
				Random Random = new Random();
		        int RandomNumber = Random.nextInt(256*256*256+1);
				Color ButtonColor = new Color(RandomNumber);
				
				Button.setBackground(ButtonColor);
				Button.setBounds((int)x, (int)y, 100, 50);
			}
		});
		
	}
	
	
	public static void main(String []Args) {
		new MainCode();
	}

}
