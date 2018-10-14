
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
public class ScreenEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String screenName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "screenId", nullable = false)
	private List<ScreenInfoEntity> screenInfoEntityList = new ArrayList<ScreenInfoEntity>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public List<ScreenInfoEntity> getScreenInfoEntityList() {
		return screenInfoEntityList;
	}

	public void setScreenInfoEntityList(List<ScreenInfoEntity> screenInfoEntityList) {
		this.screenInfoEntityList = screenInfoEntityList;
	}

}
