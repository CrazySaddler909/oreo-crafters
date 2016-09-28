package wedsite.Epic.Bro;

import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Browser extends JFrame {
	
	private TextField filed = new TextField();
    private JEditorPane display = new JEditorPane();
	private JScrollPane panee = new JScrollPane(display);
	
	public static void main(String args[]) {
		
		Browser file =  new Browser();
		file.frameHandler();
	}

	public void frameHandler() {
		
		setTitle("Browser");
		setSize(1280, 880);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		addComponetsToFrame(getContentPane());
		
		
	}

	public void addComponetsToFrame(Container Pane) {
		
		Insets insets = getInsets();
		
		Pane.add(filed);
		Pane.add(panee);
		
		Font font = new Font("Menlon",Font.ITALIC, 12);
		
		filed.setFont(font);
		
		filed.setBounds(8 - insets.left, 30 - insets.top, 1268 , 20);
		panee.setBounds(8 - insets.left, 52 - insets.top, 1268, 830);
		
}
	
	
}