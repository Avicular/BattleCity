package Poligon;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


// miejsce na przyciski, wyœwietlanie punktów, itp.
public class ekranGryMenu extends JPanel {

	
	public ekranGryMenu () {
		setLayout(null);
//		setBackground(Color.DARK_GRAY);
		
		JLabel playerOne = new JLabel("PLAYER 1");
		playerOne.setBounds(0,0,150,150);
		playerOne.setBackground(Color.BLUE);
		playerOne.setOpaque(true);
		add(playerOne);
		
		JLabel playerTwo = new JLabel("PLAYER 2");
		playerTwo.setBounds(650,0,150,150);
		playerTwo.setBackground(Color.RED);
		playerTwo.setOpaque(true);
		add(playerTwo);
		
		JLabel scorePlayerOne = new JLabel("SCORE P1");
		scorePlayerOne.setBounds(150,50,200,100);
		scorePlayerOne.setBackground(Color.WHITE);
		scorePlayerOne.setOpaque(true);
		add(scorePlayerOne);
		
		JLabel scorePlayerTwo = new JLabel("SCORE P2");
		scorePlayerTwo.setBounds(450,50,200,100);
		scorePlayerTwo.setBackground(Color.WHITE);
		scorePlayerTwo.setOpaque(true);
		add(scorePlayerTwo);
		
		JPanel lifePlayerOne = new JPanel();
		lifePlayerOne.setBounds(150,0,200,50);
		lifePlayerOne.setBackground(Color.DARK_GRAY);
		lifePlayerOne.setOpaque(true);
		add(lifePlayerOne);
		
		JPanel lifePlayerTwo = new JPanel();
		lifePlayerTwo.setBounds(450,0,200,50);
		lifePlayerTwo.setBackground(Color.DARK_GRAY);
		lifePlayerTwo.setOpaque(true);
		add(lifePlayerTwo);
		
		
		
		JButton backButton = new JButton("powrót");
		backButton.setBounds(350, 0, 100, 50);
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {
				setVisible(false);
			}
			
		});
		add(backButton);
		
		JButton pauseButton = new JButton("pauza");
		pauseButton.setBounds(350, 50, 100, 50);
		pauseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {
				
			}
			
		});
		add(pauseButton);
		
		JButton soundButton = new JButton("sound on/off");
		soundButton.setBounds(350, 100, 100, 50);
		soundButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {
				
			}
			
		});
		add(soundButton);
	}
}
