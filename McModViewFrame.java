package minecraftModView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class McModViewFrame implements ActionListener, KeyListener {
	private JFrame jFrame;
	private JLabel jLabel;
	private BorderLayout borderLayout;
	private JButton searchButton;
    private JTextField searchField;
    private JTextArea resultArea;
	private BinarySearchTree searchTree;
	private ImageIcon backgroundImage;
    
    public McModViewFrame(BinarySearchTree searchTree) {
		this.searchTree = searchTree;
		jFrame = new JFrame();
		jFrame.setSize(480, 900);
		jFrame.setTitle("Minecraft Mod View");
		jLabel = new JLabel();
		borderLayout = new BorderLayout(10,10);
		searchButton = new JButton("Search");
		searchField = new JTextField(20);
		resultArea = new JTextArea();
		backgroundImage = new ImageIcon("minecraft.png");
		ImageIcon icon = new ImageIcon("curseforge-logo.png");
		
		jFrame.setIconImage(icon.getImage());
		
		resultArea.setLineWrap(true);
		resultArea.setWrapStyleWord(true);
		resultArea.setPreferredSize(new Dimension(980,900));
		
		resultArea.setFont(new Font("Consolas",Font.PLAIN,22));
		resultArea.setEditable(false);
		resultArea.setText("Welcome to Minecraft Mod View.To see mod details enter a mod name.\nIf you want to see all modes type 'HELP'.\nIf you want to exit the program type 'EXIT'.");
		
		jFrame.setResizable(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLayout(borderLayout);
		
		JPanel panelMainSection = new JPanel(new BorderLayout());
		JPanel panelSearchSection = new JPanel();
		
		jLabel.setIcon(backgroundImage);
		panelSearchSection.add(searchButton);
		panelSearchSection.add(searchField);
		panelMainSection.add(resultArea, BorderLayout.CENTER);
		panelMainSection.add(jLabel, BorderLayout.SOUTH);
		panelSearchSection.setPreferredSize(new Dimension(1000, 100));
		panelMainSection.setPreferredSize(new Dimension(1000,900));
		
		jFrame.add(panelMainSection, BorderLayout.CENTER);
		jFrame.add(panelSearchSection, BorderLayout.NORTH);
		
		searchField.addKeyListener(this);
		searchButton.addActionListener(this);
		jFrame.setVisible(true);
    }
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == searchButton) {
			String searchMod = searchField.getText();
			String lowerSearchMod = searchMod.toLowerCase();
			searchField.setText(null);
			if(lowerSearchMod.isEmpty()) {
				resultArea.setText("Enter a mod name. If you want to see all modes type 'HELP'. \n If you want to exit the program type 'EXIT'");
				return;
			}
			else{
				if(lowerSearchMod.equals("help")) {
					resultArea.setText("Available Mods: "+searchTree.inorder(searchTree.getRoot()).toString()+"\nIf you want to exit program type'EXIT'.");
				}
				else if(lowerSearchMod.equals("exit")) {
					jFrame.dispose();
				}
				else {
				Mod searchedMod = searchTree.search(lowerSearchMod);
				if (searchedMod != null) {
					resultArea.setText("Title: "+searchedMod.getModList().getFirst()+"\n\nFeatures: "+searchedMod.getModList().get(1)+"\n\nDescription: "+searchedMod.getModList().get(2)+
						"\n\nLink: "+searchedMod.getModList().get(3)+"\n\nSize: "+searchedMod.getModList().get(4));}
				else
					resultArea.setText("Mod not found. To see all modes type 'HELP'.\nIf you want to exit the program type 'EXIT'.");
				}
			}
		}
	}



	@Override
	public void keyTyped(KeyEvent e) {
	}



	@Override
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            searchButton.doClick();
        }
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
	}
}
