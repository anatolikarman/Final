package com.htp.test.service;

import com.htp.test.domain.to.Patient;
import com.htp.test.exceptions.DaoException;

public interface PatientService extends GenericServiceInterface<Patient, Long>{
    boolean update(Patient entity) throws DaoException;
    boolean checkPatientNodeById(Long number) throws DaoException;
    boolean delete(Long id) throws DaoException;
    boolean findById(Long id) throws DaoException;
}
