package projectAOP.projectAOPTicTacToe;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends Model {
	protected JFrame frame;
	protected Container c;
	protected JPanel backgroundPanel = new JPanel();
	protected JButton [] buttons = new JButton[9];

	public View() {
		super();
		frame = new JFrame(getGameName());

		for (int i=0; i<buttons.length;i++){
			backgroundPanel.add(buttons[i]=new JButton());
		}
		
		c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		setContainer(c);
		setButtonsDefault(buttons);

		backgroundPanel.setLayout(new GridLayout(3,3));

		c.add(backgroundPanel,BorderLayout.CENTER);
	
		frame.setVisible(true);
		frame.setSize(getHeight(),getWidth());
		frame.setResizable(false);
		frame.setLocation(gameLocationOnScreen()[0],gameLocationOnScreen()[1]);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.requestFocusInWindow();


	}
	
}
