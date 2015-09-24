import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CardGame implements ActionListener {
	
	ArrayList<Card> cardPack = CardPackFactory.makeCardList();
	ArrayList<CardButton> displayButtons = new ArrayList<CardButton>(16);

	Boolean cardChosen = false;

	int buttonNumber = 4;
	int cardCounter = buttonNumber;
	int score = 0;
	int cardPackCounter=0;
	
	Card chosen1 = new Card(100, "chosen 1");
	Card chosen2 = new Card(100, "chosen 2");

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	Dimension buttonSize = new Dimension(200,200);
	Dimension textSize = new Dimension(200,100);
	Dimension scoreSize = new Dimension(200,100);
	JTextField textField = new JTextField("Select a card");
	JTextField scoreField = new JTextField("No of matches: "+ score);

	public static void main(String[] args) {
		new CardGame().go();
	}

	private void go() {
		setupDisplayButtons();
		makeGameBoard();
	}

	private void setupDisplayButtons() {
		for (int i = 0; i < buttonNumber; i++) {
			displayButtons.add(new CardButton(false,false,cardPack.get(i),i));
			cardPackCounter++;
		}
	}

	private void makeGameBoard() {

		textField.setPreferredSize(textSize);
		panel.add(textField);
		scoreField.setPreferredSize(scoreSize);
		panel.add(scoreField);
		
		 for (int i = 0; i < buttonNumber; i++) {  
			  CardButton button = displayButtons.get(i);
			  button.addActionListener(this);
			  button.setText(button.card.cardText);
			  button.setPreferredSize(buttonSize);
			  panel.add(button);
			  }
		

		frame.setSize(500,600);
		frame.add(panel);
		//frame.pack();
		frame.setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {

		
		CardButton clickedCardButton = (CardButton) e.getSource();
		clickedCardButton.setClick();
		System.out.println(clickedCardButton.getText());
		if (!cardChosen) {
			cardChosen = true;
			System.out.println("First card");
			chosen1.cardText = (clickedCardButton.getText());
	// Change the button color to red
			clickedCardButton.setOpaque(true);
			clickedCardButton.setBackground(Color.RED);
			
			System.out.println(chosen1.cardText);
			for (int i = 0; i < cardPack.size(); i++) {
				if (chosen1.cardText.equals(cardPack.get(i).cardText)) {
					chosen1.value = cardPack.get(i).value;
				}
			}
			textField.setText("Chose another card with the same value");

		}
		
		  
	else { 
		chosen2.cardText=((JButton) e.getSource()).getText(); 
		if (chosen2.cardText.equals(chosen1.cardText)){ 
			System.out.println("same button"); 
			clickedCardButton.unsetClick();
			resetCard(((JButton) e.getSource())); 
		  } 
		else{ 
			for (int i = 0; i < cardPack.size(); i++) { 
				if (chosen2.cardText.equals(cardPack.get(i).cardText)){ 
					chosen2.value = cardPack.get(i).value; 
					} 
			}
				if (chosen1.value==chosen2.value){ 
					JOptionPane.showMessageDialog(null, "Match"); 
					score++;
					System.out.println(score);
					
					replaceCards();
					resetCard((JButton) e.getSource()); 
					} 
				else{ 
					JOptionPane.showMessageDialog(null, "Sorry these don't match"); 
					}
		  
		  } 
		}
		  
		  
		  
		  // TODO Auto-generated method stub
		 

	}

	private void resetCard(JButton jButton) {
		cardChosen = false;
		jButton.setOpaque(false);
  textField.setText("Select a card");
	}

	private void replaceCards() {
		System.out.println("Replace the cards");
	}
}
