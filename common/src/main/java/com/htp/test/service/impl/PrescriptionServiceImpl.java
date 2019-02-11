package com.htp.test.service.impl;


import com.htp.test.dao.PrescriptionDAO;
import com.htp.test.dao.factory.DaoFactory;
import com.htp.test.domain.to.Prescription;
import com.htp.test.exceptions.DaoException;
import com.htp.test.exceptions.ServiceException;
import com.htp.test.service.PrescriptionService;


import java.util.List;

public class PrescriptionServiceImpl implements PrescriptionService {

    public static PrescriptionService getInstance() {
        return SingletonHolder.instance;
    }
    private static class SingletonHolder {
        private static final PrescriptionService instance = new PrescriptionServiceImpl();
    }


    private static final DaoFactory factory = DaoFactory.getDaoFactory();


    public PrescriptionServiceImpl() {
    }

    @Override
    public boolean checkPrescriptionNodeById(Long id) throws DaoException {
        PrescriptionDAO prescriptionDAO = factory.getPrescriptionDAO();
        {
            prescriptionDAO.checkPrescriptionNodeById(id);
            return true;
        }


    }

    @Override
    public boolean delete(Long id) throws DaoException {
        PrescriptionDAO prescriptionDAO = factory.getPrescriptionDAO();
        {
            prescriptionDAO.delete(id);
            return true;
        }
    }

    @Override
    public boolean update(Prescription entity) throws DaoException {
        PrescriptionDAO prescriptionDAO = factory.getPrescriptionDAO();
        {
            prescriptionDAO.update(entity);
            return true;
        }
    }

    @Override
    public boolean findById(Long id) throws DaoException {
        PrescriptionDAO prescriptionDAO = factory.getPrescriptionDAO();
        {
            prescriptionDAO.findById(id);
            return true;
        }
    }

    @Override
    public Prescription create(Prescription entity) throws ServiceException, DaoException {
        PrescriptionDAO prescriptionDAO = factory.getPrescriptionDAO();
        {
            prescriptionDAO.create(entity);
            return entity;
        }
    }

    @Override
    public List<Prescription> loadAll() throws ServiceException {
        return null;
    }





}
