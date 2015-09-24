import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CardGame implements ActionListener {

	ArrayList<Card> cardPack = new ArrayList<Card>(50);

	Boolean cardChosen = false;

	Card chosen1;
	Card chosen2;

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	JTextField textField = new JTextField("Choose a Button");
	int buttonNumber = 4;
	int cardCounter = buttonNumber;
	int numOfCards;

	public static void main(String[] args) {
		new CardGame().go();
	}

	private void go() {
		makeCardList();
		makeGameBoard();

	}

	private void makeGameBoard() {
		/*
		 * for (int i = 0; i < buttonNumber; i++) {
		 * 
		 * "b"+i.setText(cardPack.get(i).cardText);
		 * 
		 * }
		 */
		panel.add(textField);
		
		b1.addActionListener(this);
		b1.setText(cardPack.get(0).cardText);
		panel.add(b1);
		b2.addActionListener(this);
		b2.setText(cardPack.get(1).cardText);
		panel.add(b2);
		b3.addActionListener(this);
		b3.setText(cardPack.get(2).cardText);
		panel.add(b3);
		b4.addActionListener(this);
		b4.setText(cardPack.get(3).cardText);
		panel.add(b4);
		
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	void makeCardList() {
		Card a6 = new Card(6, "2 x 3");
		Card b6 = new Card(6, "double 3");
		Card a4 = new Card(4, "2 x 2");
		Card b4 = new Card(4, "double 2");
		Card c6 = new Card(6, "half 12");
		Card d6 = new Card(6, "12/2");
		Card c4 = new Card(4, "half 8");
		Card d4 = new Card(4, "8/2");
		numOfCards = 8;

		cardPack.add(a6);
		cardPack.add(b6);
		cardPack.add(c6);
		cardPack.add(d6);
		cardPack.add(a4);
		cardPack.add(b4);
		cardPack.add(c4);
		cardPack.add(d4);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println(((JButton) e.getSource()).getText());

		if (!cardChosen) {
			cardChosen = true;
			System.out.println("First card");
		//	chosen1.cardText = (((JButton) e.getSource()).getText());
	//		System.out.println(chosen1.cardText);
		/*	for (int i = 0; i < numOfCards; i++) {
				if (chosen1.cardText.equals(cardPack.get(i).cardText)) {
					chosen1.value = cardPack.get(i).value;
				}
			}
			*/
			textField.setText("Chose another button");

		}
		/*
		 * } else { chosen2.cardText=((JButton) e.getSource()).getText(); if (chosen2.cardText.equals(chosen1.cardText)){ System.out.println("same button"); cardChosen = false;
		 * textField.setText("Chose a button"); } else{ for (int i = 0; i < numOfCards; i++) { if (chosen2.cardText.equals(cardPack.get(i).cardText)){ chosen2.value =
		 * cardPack.get(i).value; } if (chosen1.value==chosen2.value){ JOptionPane.showMessageDialog(null, "Match"); } else{ JOptionPane.showMessageDialog(null,
		 * "Sorry these don't match"); }
		 * 
		 * } }
		 * 
		 * 
		 * 
		 * // TODO Auto-generated method stub
		 */

	}
}
