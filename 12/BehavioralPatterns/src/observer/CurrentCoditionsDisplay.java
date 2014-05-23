package observer;

public class CurrentCoditionsDisplay implements Observer, DisplayElement{
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	public CurrentCoditionsDisplay(Subject weatherData){
		this.weatherData = weatherData;
		weatherData.registerObserver(this);;
	}
	

	@Override
	public void display() {
		System.out.println("Condizione attuale: " + temperature + 
				"gradi Celsius " + humidity + "% di umidita'");
		
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		display();
		
	}

}
