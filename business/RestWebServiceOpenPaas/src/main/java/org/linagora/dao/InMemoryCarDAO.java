package org.linagora.dao;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.linagora.dto.Car;


public class InMemoryCarDAO implements CarDAO {
	
	private Queue<Car> carlist;
	
	private final int MAX = 50;
	
	public InMemoryCarDAO(){
		carlist = new ArrayBlockingQueue<Car>(MAX);
	}


	@Override
	public Car findAvailableCar() {
		return carlist.peek();
	}

	@Override
	public int getNumberOfAvailableCars() {
		return carlist.size();
	}

	@Override
	public void add(Car car) {
		carlist.add(car);
	}

	@Override
	public void rent(Car car) {
		carlist.remove(car);
	}

}
