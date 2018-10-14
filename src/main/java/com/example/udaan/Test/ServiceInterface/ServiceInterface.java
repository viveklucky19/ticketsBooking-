/**
 * 
 */
package com.example.udaan.Test.ServiceInterface;

import java.util.HashMap;

import com.example.udaan.Test.DTO.ScreenDetailsDTO;
import com.example.udaan.Test.DTO.SeatsDTO;

/**
 * @author Vivek Sanodiya
 */
public interface ServiceInterface {

	String saveScreen(ScreenDetailsDTO data);

	String reserveSeat(String screenName, SeatsDTO data);

	/**
	 * @param screenName
	 * @param status
	 * @return
	 */
	SeatsDTO getAvailableSeats(String screenName, String status);

	/**
	 * @param screenName
	 * @param numSeats
	 * @param choice
	 * @return
	 */
	HashMap<String, SeatsDTO> getAvailableSeatsAtGivenPosition(String screenName, Long numSeats, String choice);

}
