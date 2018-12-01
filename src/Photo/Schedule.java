package Photo;


public class Schedule {
	static int Count = 3000;
	boolean[][] available;
	Button[][] buttons;
 	int id;
	

	public Schedule() {
		this.available = new boolean[16][6];
		this.buttons = new Button[16][6];
		
		
		for(int i = 0 ; i < available.length ; i++) {
			for(int j = 0 ; j < available[i].length ; j++ ) {
				available[i][j] = true;
				buttons[i][j] = new Button(i, j);
				buttons[i][j].setClicked(true);
			}
		}
		
		
		this.id = Count++;
	}
	
	
	public Button[][] getButtons() {
		return buttons;
	}

	public void setButtons(Button[][] buttons) {
		this.buttons = buttons;
	}

	public  void setTrue(int a , int b) {
		this.available[a][b] = true;
	}

	public  void setFalse(int a , int b) {
		this.available[a][b] = false;
	}
	
	
	
	
	public int getId() {
		return id;
	}


	public void setAvailable(boolean[][] available) {
		this.available = available;
	}


	public boolean[][] getAvailable() {
		return this.available;
	}




	}


