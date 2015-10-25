import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CardGame implements ActionListener {

	ArrayList<Card> cardPack = CardPackFactory.makeCardList();
	ArrayList<CardButton> displayButtons = new ArrayList<CardButton>(16);

	Boolean cardChosen = false;
	Boolean moreCards = true;
	Boolean gameFinished = false;
	int random;

	int buttonNumber = 6;
	int cardCounter = buttonNumber;
	int score = 0;
	int misses = 0;

	Card chosen1 = new Card(100, "chosen 1");
	Card chosen2 = new Card(100, "chosen 2");

	JFrame frame;
	JPanel panel;
	// JButton b1 = new JButton();
	// JButton b2 = new JButton();
	// JButton b3 = new JButton();
	// JButton b4 = new JButton();
	Dimension buttonSize = new Dimension(200, 200);
	Dimension textSize = new Dimension(250, 100);
	Dimension scoreSize = new Dimension(150, 100);
	JLabel textField;
	JTextArea scoreField;

	public static void main(String[] args) {
		new CardGame().go();
	}

	private void go() {
		setupDisplayButtons();
		makeGameBoard();
	}

	private void setupDisplayButtons() {
		for (int i = 0; i < buttonNumber; i++) {
			CardButton cardB1 = makeDisplayButton();
			displayButtons.add(cardB1);

		}
	}

	private CardButton makeDisplayButton() {
		System.out.println(cardPack.size() - 1);
		CardButton cardB1 = new CardButton(false, cardPack.remove(new Random().nextInt(cardPack.size())));
		cardB1.addActionListener(this);
		return cardB1;
	}

	private void makeGameBoard() {
		frame = new JFrame();
		panel = new JPanel();
		textField = new JLabel("Select a card");
		scoreField = new JTextArea();
		setScoreField();
		scoreField.setEditable(false);
		textField.setPreferredSize(textSize);
		panel.add(textField);
		scoreField.setPreferredSize(scoreSize);
		panel.add(scoreField);
		if (gameFinished) {
			JLabel label = new JLabel();
			label.setText("Congratulations, you finished the game");
			panel.add(label);
		}

		for (int i = 0; i < displayButtons.size(); i++) {
			CardButton button = displayButtons.get(i);
			System.out.println("adding buttons " + button.firstClick + ", "
					+ button.card.cardText);
			button.setText(button.card.cardText);
			button.setPreferredSize(buttonSize);
			panel.add(button);
		}

		frame.setSize(500, 800);
		frame.add(panel);
		// frame.pack();
		frame.setVisible(true);
	}

	private void setScoreField() {
		scoreField.setText("\nCards remaining = " + (cardPack.size())
				+ "\n\nNo of matches: " + score + "\n\nNo of misses = "
				+ misses);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("No of buttons = " + displayButtons.size()
				+ "\nNo of cards = " + cardPack.size());

		CardButton clickedCardButton = (CardButton) e.getSource();
		clickedCardButton.setClick();
		if (!cardChosen) {
			cardChosen = true;
			System.out.println("First card");
			// save details of first card chosen
			chosen1 = clickedCardButton.getCard();
			System.out.println("chosen1 = " + chosen1.cardText + " "
					+ chosen1.value);
			// Change the button color to red
			setRed(clickedCardButton);
			textField.setText("Chose another card with the same value");
		} else {
			chosen2 = clickedCardButton.getCard();
			System.out.println("chosen2 = " + chosen2.cardText + " "
					+ chosen2.value);
			if (chosen2.cardText.equals(chosen1.cardText)) {
				System.out.println("same button");
				clickedCardButton.unsetClick();
				resetCard(clickedCardButton);
			} else {
				setRed(clickedCardButton);
				if (chosen1.value == chosen2.value) {
					JOptionPane.showMessageDialog(null, "Match");
					score++;
					System.out.println("Score = " + score);
					replaceCards();

				} else {
					JOptionPane.showMessageDialog(null,
							"Sorry these don't match");
					misses++;
					setScoreField();
					clickedCardButton.unsetClick();
					removeRed(clickedCardButton);
				}
			}
		}
	}

	private void setRed(JButton jButton) {
		jButton.setOpaque(true);
		jButton.setBackground(Color.RED);
	}

	private void removeRed(JButton jButton) {
		jButton.setOpaque(false);
	}

	private void resetCard(JButton jButton) {
		cardChosen = false;
		removeRed(jButton);
		textField.setText("Select a card");
	}

	private void replaceCards() {
		System.out.println("Replace the cards");
		cardChosen = false;
		chosen1 = new Card(100, "chosen 1");
		chosen2 = new Card(100, "chosen 2");
		for (int i = displayButtons.size() - 1; i >= 0; i--) {
			if (displayButtons.get(i).getClick() == true) {
				if (moreCards) {
					System.out.println(displayButtons.get(i).getClick());
					CardButton cardB1 = makeDisplayButton();
					displayButtons.set(i, cardB1);
					System.out.println("Card pack size is " + cardPack.size());
					if (cardPack.size() == 0) {
						System.out.println("No more cards");
						moreCards = false;

					}
				} else {
					displayButtons.remove(i);
					System.out.println("remove button " + i);
					if (displayButtons.isEmpty()) {
						gameFinished = true;

					}
				}
			}

		}
		frame.dispose();
		makeGameBoard();
	}
}
