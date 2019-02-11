package com.htp.test.dao;



import com.htp.test.domain.to.Patient;
import com.htp.test.exceptions.DaoException;

public interface PatientDAO extends GenericDAO <Patient, Long>{
  // Boolean checkPatienNodeByName(String patientName) throws DaoException;
   Boolean checkPatientNodeById(Long id) throws DaoException;
  // Boolean checkPatientNodeByDiagnosis(String diagnosis) throws DaoException;
  // Boolean checkPatientNodeByDoctor(String assignedDoctor) throws DaoException;
  // Boolean checkPatientNodeByPrescriptionId(Long prescr_Id) throws DaoException;


}