package strategy;

public class Client {
	public static void main(String[] args){
		Robot robot = new Robot(new DefensiveBehavior());
		robot.move();
		robot.changeBehavior(new AggressiveBehavior());
		robot.move();
	}
}
