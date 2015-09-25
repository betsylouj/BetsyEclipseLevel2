import javax.swing.JButton;


public class CardButton extends JButton{
	
	Boolean firstClick;
	Boolean secondClick;
	Card card;
	
	
	CardButton(Boolean firstClick,Boolean secondClick,Card card){
		this.card = card;
		this.firstClick = firstClick;
		this.secondClick = secondClick;
		
	}
	
	void setClick(){
		this.firstClick = true;
		System.out.println("set click");
	}
	
	Boolean getClick(){
		return this.firstClick;
	}

	public void unsetClick() {
		this.firstClick = false;
		System.out.println("unset click");
	}
	
	Card getCard(){
		return this.card;
	}
	
	int getValue(){
		return this.card.value;
	}

}
