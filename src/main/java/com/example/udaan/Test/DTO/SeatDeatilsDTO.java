/**
 * 
 */
package com.example.udaan.Test.DTO;

import java.io.Serializable;
import java.util.List;

/**
 * @author Vivek Sanodiya
 */
public class SeatDeatilsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long numberOfSeats;

	private List<Long> aisleSeats;

	public Long getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Long numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public List<Long> getAisleSeats() {
		return aisleSeats;
	}

	public void setAisleSeats(List<Long> aisleSeats) {
		this.aisleSeats = aisleSeats;
	}

}
