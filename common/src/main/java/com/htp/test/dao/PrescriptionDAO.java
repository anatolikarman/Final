package com.htp.test.dao;

import com.htp.test.domain.to.Prescription;

import com.htp.test.exceptions.DaoException;

public interface PrescriptionDAO extends GenericDAO <Prescription, Long> {
    Boolean checkPrescriptionNodeById(Long id) throws DaoException;

}
