/**
 * 
 */
package com.example.udaan.Test.DTO;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Vivek Sanodiya
 */
public class ScreenDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private HashMap<String, SeatDeatilsDTO> seatInfo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, SeatDeatilsDTO> getSeatInfo() {
		return seatInfo;
	}

	public void setSeatInfo(HashMap<String, SeatDeatilsDTO> seatInfo) {
		this.seatInfo = seatInfo;
	}

	@Override
	public String toString() {
		return "ScreenDetailsDTO [name=" + name + ", seatInfo=" + seatInfo + "]";
	}

}
