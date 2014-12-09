package com.emc.dpc.school.dao;

import com.emc.dpc.school.domain.School;


public interface SchoolDAO {

	School getSchoolDetails();
	void updateSchoolDetails(School school);
	
}
