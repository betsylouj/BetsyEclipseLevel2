import javax.swing.JButton;


public class CardButton extends JButton{
	
	Boolean firstClick;
	Boolean secondClick;
	Card card;
	int index;
	
	CardButton(Boolean firstClick,Boolean secondClick,Card card,int index){
		this.card = card;
		this.firstClick = firstClick;
		this.secondClick = secondClick;
		this.index = index;
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

}
