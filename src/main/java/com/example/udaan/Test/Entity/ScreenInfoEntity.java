package com.example.udaan.Test.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author Vivek Sanodiya
 */
@Entity
public class ScreenInfoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String rowName;

	private Long numberOfSeats;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "rowId", nullable = false)
	private List<SeatEntity> seatEntityList = new ArrayList<SeatEntity>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRowName() {
		return rowName;
	}

	public void setRowName(String rowName) {
		this.rowName = rowName;
	}

	public Long getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Long numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public List<SeatEntity> getSeatEntityList() {
		return seatEntityList;
	}

	public void setSeatEntityList(List<SeatEntity> seatEntityList) {
		this.seatEntityList = seatEntityList;
	}

}
