import java.util.ArrayList;


public class CardPackFactory {
	
	static ArrayList<Card> makeCardList() {

		ArrayList<Card> cardPack = new ArrayList<Card>(50);

			cardPack.add(new Card(6, "2 x 3"));
			cardPack.add(new Card(6, "double 3"));
			cardPack.add(new Card(2, "half 4"));
			cardPack.add(new Card(2, "4/2"));
			cardPack.add(new Card(4, "2 x 2"));
			cardPack.add(new Card(4, "double 2"));
			cardPack.add(new Card(6, "half 12"));
			cardPack.add(new Card(6, "12/2"));
			cardPack.add(new Card(4, "half 8"));
			cardPack.add(new Card(4, "8/2"));
			cardPack.add(new Card(2, "2 x 1"));
			cardPack.add(new Card(2, "double 1"));
			
			return cardPack;
		}

}
