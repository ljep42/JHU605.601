import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


/**
 * Creates the board game image. Created using windows builder. 
 */
public class Board extends JPanel 
{

	
	public Board() 
	{
		// Location of the image
		final ImageIcon BOARD_IMAGE = new ImageIcon("C:\\Users\\bpawling\\eclipse-workspace\\JHUClueLess\\WorkingCLueBoard.png");
		
		// places the board into the panel
		JLabel board = new JLabel("New label");
		board.setVerticalAlignment(SwingConstants.TOP);
		add(board);
		 board.setIcon(BOARD_IMAGE);
		 
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1000, 1000));
		add(layeredPane);

	
	}

}
