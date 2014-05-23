package observer;

public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentCoditionsDisplay currentDisplay = new CurrentCoditionsDisplay(weatherData);
		
		//simuliamo il cambiamento delle misure
		weatherData.setMeasurements(20, 65, 4.5f);
		weatherData.setMeasurements(24, 60, 4.2f);
		weatherData.setMeasurements(16, 100, 9.8f);
	}

}
