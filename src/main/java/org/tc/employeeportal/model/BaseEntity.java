package org.tc.employeeportal.model;

import java.util.Date;

public abstract class BaseEntity {

	protected Long id;
	protected Date createdOn;

	abstract Long getId();

	public void setId(Long id) {
		this.id = id;
	}

	abstract Date getCreatedOn();

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}
