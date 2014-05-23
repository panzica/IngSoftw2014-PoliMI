package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherData implements Subject{
	private List<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData(){
		observers = new ArrayList<>();
	}
	public float getTemperature(){
		//already provided
		return new Random().nextFloat() * 10;
	}
	public float getHumidity(){
		//already provided
		return new Random().nextFloat() * 10;
	}
	public float getPressure(){
		//already provided
		return new Random().nextFloat() * 10;
	}
	
	public void measurementsChanged(){
		notifyObservers();
	}
	
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
		
	}
	@Override
	public void unregisterObserver(Observer o) {
		observers.remove(o);
		
	}
	@Override
	public void notifyObservers() {
		for (Observer o: observers) {
			o.update(temperature,humidity, pressure);
		}
		
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure){
		this.humidity = humidity;
		this.temperature = temperature;
		this.pressure = pressure;
		measurementsChanged();
	}
	
}
