import javax.swing.JButton;


public class CardButton extends JButton{
	
	Boolean firstClick;
	
	Card card;
	
	
	CardButton(Boolean firstClick,Card card){
		this.card = card;
		this.firstClick = firstClick;
	}
	
	void setClick(){
		this.firstClick = true;
		
	}
	
	Boolean getClick(){
		return this.firstClick;
	}

	public void unsetClick() {
		this.firstClick = false;
		
	}
	
	Card getCard(){
		return this.card;
	}
	
	int getValue(){
		return this.card.value;
	}

}
