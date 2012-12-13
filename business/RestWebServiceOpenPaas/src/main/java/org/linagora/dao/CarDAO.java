package org.linagora.dao;

import org.linagora.dto.Car;

public interface CarDAO {

	public Car findAvailableCar();

	public int getNumberOfAvailableCars();

	public void add(Car car);

	public void rent(Car car);

}
