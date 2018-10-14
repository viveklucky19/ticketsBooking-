package com.example.udaan.Test.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.udaan.Test.DTO.ScreenDetailsDTO;
import com.example.udaan.Test.DTO.SeatsDTO;
import com.example.udaan.Test.Entity.ScreenEntity;
import com.example.udaan.Test.Repository.ScreenRepository;
import com.example.udaan.Test.ServiceInterface.ServiceInterface;

@RestController
public class TicketsController {

	/**
	 * @author Vivek Sanodiya
	 */

	@Autowired
	ServiceInterface serviceInterface;

	@Autowired
	ScreenRepository screenRepository;

	// API to accept details of a movie screen.
	@PostMapping(path = "/screens")

	private ResponseEntity<String> saveScreen(@RequestBody ScreenDetailsDTO data) {

		try {

			return new ResponseEntity<String>(serviceInterface.saveScreen(data), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(new String(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// API to see screen details by screen name
	@GetMapping(path = "/screens/{screenName}")

	private ResponseEntity<ScreenEntity> getScreen(@PathVariable("screenName") String screenName) {

		try {

			return new ResponseEntity<ScreenEntity>(screenRepository.findByScreenName(screenName), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<ScreenEntity>(new ScreenEntity(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// API to reserve tickets for given seats in a given screen
	@PostMapping(path = "/screens/{screenName}/reserve")

	private ResponseEntity<String> reserveSeat(@PathVariable("screenName") String screenName,
			@RequestBody SeatsDTO data) {

		try {

			String success = serviceInterface.reserveSeat(screenName, data);

			if (success == "yes")
				return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

			else
				return new ResponseEntity<String>("Error ", HttpStatus.CONFLICT);

		} catch (Exception e) {
			return new ResponseEntity<String>(new String(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// API to get the available seats for a given screen
	/// screens/{screenName}/seats?status=no" type no instead of reserved as in
	// database alreadyBooked column has only yes or no

	@GetMapping(path = "/screens/{screenName}/seats")

	private ResponseEntity<SeatsDTO> getAvailableSeats(@PathVariable("screenName") String screenName,
			@RequestParam("status") String status) {

		try {

			return new ResponseEntity<SeatsDTO>(serviceInterface.getAvailableSeats(screenName, status), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<SeatsDTO>(new SeatsDTO(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// API to get information of available tickets at a given position

	@GetMapping(path = "/screens/{screenName}/seats")

	private ResponseEntity<HashMap<String, SeatsDTO>> getAvailableSeatsAtGivenPosition(
			@PathVariable("screenName") String screenName, @RequestParam("numSeats") Long numSeats,
			@RequestParam("choice") String choice) {

		try {

			return new ResponseEntity<HashMap<String, SeatsDTO>>(
					serviceInterface.getAvailableSeatsAtGivenPosition(screenName, numSeats, choice), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<HashMap<String, SeatsDTO>>(new HashMap<String, SeatsDTO>(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
