package com.htp.test.service;

import com.htp.test.domain.to.Prescription;
import com.htp.test.exceptions.DaoException;

public interface PrescriptionService extends GenericServiceInterface<Prescription, Long> {
     boolean checkPrescriptionNodeById(Long id) throws DaoException;
     boolean delete(Long id) throws DaoException;
     boolean update(Prescription entity) throws DaoException;
     boolean findById(Long id) throws DaoException;
}
