package com.bugstrack.interfaces;

import java.sql.Timestamp;
import java.util.List;

import com.bugstrack.domain.Exceptions;

public interface ExceptionInterface {
	
	public List<Exceptions> getAllException();

	void logException(String logname, int userId, Timestamp timestamp);

	List<Exceptions> getExceptionsByUser(int userId);

}
