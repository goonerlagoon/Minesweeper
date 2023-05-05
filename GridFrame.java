
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridBagLayout;


public class GridFrame extends JFrame {
	
	private JButton[][] bombs;
	
	public GridFrame() {
		
		
		
		setTitle("Minesweeper");
		
		setLayout(new GridBagLayout());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
