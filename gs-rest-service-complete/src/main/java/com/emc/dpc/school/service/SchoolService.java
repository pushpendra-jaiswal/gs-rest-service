package com.emc.dpc.school.service;

import org.springframework.transaction.annotation.Transactional;

import com.emc.dpc.school.domain.School;

@Transactional
public interface SchoolService {

	School getSchoolDetails();
	void updateSchoolDetails(School school);
}
