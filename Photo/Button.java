package Photo;

public class Button {
	int a;
	int b;
	boolean clicked;

	Button(int a,int b){
		this.a = a;
		this.b = b;
		clicked = false;
	}
	
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public void setClicked() {
		if(this.clicked)
			this.clicked = false;
		else
			this.clicked = true;
	}

	public String toString() { 
		if(clicked == true)
			return"<input type=\"button\" class=\"true\" onmouseover=\"drag(this)\" onclick=\"myFunction(this)\"   id=\""+ a + "," + b +"\"> </button>";
		else
			return"<input type=\"button\" class=\"false\" onmouseover=\"drag(this)\" onclick=\"myFunction(this)\"   id=\""+ a + "," + b +"\"> </button>";
	}

	public int getA() {
		return a;
	}


	public void setA(int a) {
		this.a = a;
	}


	public int getB() {
		return b;
	}


	public void setB(int b) {
		this.b = b;
	}

}
