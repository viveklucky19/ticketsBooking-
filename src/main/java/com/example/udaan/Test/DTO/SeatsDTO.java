/**
 * 
 */
package com.example.udaan.Test.DTO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * @author Vivek Sanodiya
 */
public class SeatsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private HashMap<String, List<Long>> seats;

	public HashMap<String, List<Long>> getSeats() {
		return seats;
	}

	public void setSeats(HashMap<String, List<Long>> seats) {
		this.seats = seats;
	}

}
