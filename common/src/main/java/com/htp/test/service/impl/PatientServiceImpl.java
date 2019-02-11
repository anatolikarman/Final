package com.htp.test.service.impl;

import com.htp.test.dao.PatientDAO;
import com.htp.test.dao.factory.DaoFactory;
import com.htp.test.domain.to.Patient;
import com.htp.test.exceptions.DaoException;
import com.htp.test.exceptions.ServiceException;
import com.htp.test.service.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    private static final DaoFactory factory = DaoFactory.getDaoFactory();

    private static class SingletonHolder {
        private static final PatientService instance = new PatientServiceImpl();
    }

    public static PatientService getInstance() {
        return SingletonHolder.instance;
    }



    @Override
    public boolean update(Patient entity) throws DaoException {
        PatientDAO patientDAO = factory.getPatientDao();
        {
            patientDAO.update(entity);
            return true;
        }
    }

    @Override
    public boolean checkPatientNodeById(Long id) throws DaoException {
        PatientDAO patientDAO = factory.getPatientDao();
        {
            patientDAO.checkPatientNodeById(id);
            return true;
        }
    }

    @Override
    public boolean delete(Long id) throws DaoException {
        PatientDAO patientDAO = factory.getPatientDao();
        {
            patientDAO.delete(id);
            return true;
        }
    }

    @Override
    public boolean findById(Long id) throws DaoException {
        PatientDAO patientDAO = factory.getPatientDao();
        {
            patientDAO.findById(id);
            return true;
        }
    }

    @Override
    public Patient create(Patient entity) throws ServiceException, DaoException {
        PatientDAO patientDAO = factory.getPatientDao();
        {
            patientDAO.create(entity);
            return entity;
        }
    }

    @Override
    public List<Patient> loadAll() throws ServiceException {
        return null;
    }
}
