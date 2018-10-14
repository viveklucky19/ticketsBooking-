/**
* 
*/
package com.example.udaan.Test.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.udaan.Test.DTO.ScreenDetailsDTO;
import com.example.udaan.Test.DTO.SeatDeatilsDTO;
import com.example.udaan.Test.DTO.SeatsDTO;
import com.example.udaan.Test.Entity.ScreenEntity;
import com.example.udaan.Test.Entity.ScreenInfoEntity;
import com.example.udaan.Test.Entity.SeatEntity;
import com.example.udaan.Test.Repository.ScreenRepository;
import com.example.udaan.Test.Repository.SeatRepository;
import com.example.udaan.Test.ServiceInterface.ServiceInterface;

/**
 * @author Vivek Sanodiya
 */
@Service
public class ServiceImpl implements ServiceInterface {

	@Autowired
	ScreenRepository screenRepository;
	@Autowired
	SeatRepository seatRepository;

	@Override
	public String saveScreen(ScreenDetailsDTO data) {

		ScreenEntity screenEntity = new ScreenEntity();
		List<ScreenInfoEntity> screenInfoEntityList = new ArrayList<>();

		screenEntity.setScreenName(data.getName());

		System.out.println("screen name=" + data.getName());

		for (Map.Entry<String, SeatDeatilsDTO> e : data.getSeatInfo().entrySet()) {
			ScreenInfoEntity screenInfoEntity = new ScreenInfoEntity();
			List<SeatEntity> seatEntityList = new ArrayList<>();
			screenInfoEntity.setRowName(e.getKey());
			System.out.println("row name=" + e.getKey());
			screenInfoEntity.setNumberOfSeats(e.getValue().getNumberOfSeats());

			System.out.println("no of seats name=" + e.getValue().getNumberOfSeats());

			for (long i = 0; i < e.getValue().getNumberOfSeats(); i++) {

				SeatEntity seatEntity = new SeatEntity();
				seatEntity.setSeatNumber(i);
				seatEntity.setAisleSeat("no");
				seatEntity.setAlreadyBooked("no");

				for (long j : e.getValue().getAisleSeats()) {

					if (i == j) {
						seatEntity.setAisleSeat("yes");
						break;
					}
				}

				seatEntityList.add(seatEntity);

			}

			screenInfoEntity.setSeatEntityList(seatEntityList);
			screenInfoEntityList.add(screenInfoEntity);

		}

		screenEntity.setScreenInfoEntityList(screenInfoEntityList);

		screenRepository.save(screenEntity);

		return "saved";
	}

	@Override
	public String reserveSeat(String screenName, SeatsDTO data) {

		ScreenEntity screenEntity = screenRepository.findByScreenName(screenName);

		String canBeBooked = "no";

		for (Map.Entry<String, List<Long>> e : data.getSeats().entrySet()) {

			System.out.println("key =" + e.getKey() + e.getKey().length());

			for (ScreenInfoEntity screenInfoEntity : screenEntity.getScreenInfoEntityList()) {
				System.out
						.println("row name " + screenInfoEntity.getRowName() + screenInfoEntity.getRowName().length());
				if (screenInfoEntity.getRowName().equals(e.getKey())) {
					System.out.println("row name matched" + screenInfoEntity.getRowName());
					for (SeatEntity seatEntity : screenInfoEntity.getSeatEntityList()) {
						for (long i : e.getValue()) {
							if (seatEntity.getSeatNumber().equals(i)) {
								System.out.println("seat matched " + i);
								if (seatEntity.getAlreadyBooked().equals("no")) {

									seatEntity.setAlreadyBooked("yes");
									canBeBooked = "yes";
									System.out.println("editing..........");
									seatRepository.save(seatEntity);
								}

								else {
									canBeBooked = "no";

									return canBeBooked;

								}

							}
						}
					}
				}
			}
		}

		return canBeBooked;
	}

	@Override
	public SeatsDTO getAvailableSeats(String screenName, String status) {

		ScreenEntity screenEntity = screenRepository.findByScreenName(screenName);

		SeatsDTO seatsDTO = new SeatsDTO();

		HashMap<String, List<Long>> answer = new HashMap<String, List<Long>>();

		for (ScreenInfoEntity screenInfoEntity : screenEntity.getScreenInfoEntityList()) {
			List<Long> seatList = new ArrayList<>();
			for (SeatEntity seatEntity : screenInfoEntity.getSeatEntityList()) {
				if (seatEntity.getAlreadyBooked().equals(status)) {
					seatList.add(seatEntity.getSeatNumber());
				}
			}

			answer.put(screenInfoEntity.getRowName(), seatList);
		}

		seatsDTO.setSeats(answer);

		return seatsDTO;
	}

	@Override
	public HashMap<String, SeatsDTO> getAvailableSeatsAtGivenPosition(String screenName, Long numSeats, String choice) {

		HashMap<String, SeatsDTO> answer = new HashMap<String, SeatsDTO>();
		answer = null;
		SeatsDTO seatsDTO = new SeatsDTO();
		String av = "availableSeats";
		HashMap<String, List<Long>> setDTO = new HashMap<String, List<Long>>();
		List<Long> availableSeats = new ArrayList<>();

		char row = choice.charAt(0);
		String rowNumber = Character.toString(row);

		char seat = choice.charAt(1);
		String seatNumber = Character.toString(seat);
		Long sn = Long.parseLong(seatNumber);

		ScreenEntity screenEntity = screenRepository.findByScreenName(screenName);
		for (ScreenInfoEntity screenInfoEntity : screenEntity.getScreenInfoEntityList()) {

			if (screenInfoEntity.getRowName().equals(rowNumber)) {

				for (SeatEntity seatEntity : screenInfoEntity.getSeatEntityList()) {

					if (seatEntity.getAlreadyBooked().equals("no")) {
						availableSeats.add(seatEntity.getSeatNumber());
					}

				}

				break;
			}

		}

		for (long i = 0; i < availableSeats.size(); i++) {

		}

		return answer;
	}

}
