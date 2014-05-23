package strategy;

public class Robot {
	private Behavior behavior;
	
	public Robot(Behavior behavior){
		this.behavior = behavior;		
	}
	
	public void changeBehavior(Behavior behavior){
		this.behavior = behavior;	
	}
	
	public void move(){
		behavior.move();
	}

}
