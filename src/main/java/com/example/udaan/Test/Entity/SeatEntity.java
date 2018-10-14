/**
 * 
 */
package com.example.udaan.Test.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Vivek Sanodiya
 */
@Entity
public class SeatEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long seatNumber;

	public Long getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Long seatNumber) {
		this.seatNumber = seatNumber;
	}

	private String aisleSeat;

	private String alreadyBooked;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAisleSeat() {
		return aisleSeat;
	}

	public void setAisleSeat(String aisleSeat) {
		this.aisleSeat = aisleSeat;
	}

	public String getAlreadyBooked() {
		return alreadyBooked;
	}

	public void setAlreadyBooked(String alreadyBooked) {
		this.alreadyBooked = alreadyBooked;
	}

}
