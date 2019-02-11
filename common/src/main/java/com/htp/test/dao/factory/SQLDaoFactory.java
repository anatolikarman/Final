package com.htp.test.dao.factory;

//

import com.htp.test.dao.PatientDAO;
import com.htp.test.dao.PrescriptionDAO;
import com.htp.test.dao.UserDao;
import com.htp.test.dao.WardDAO;
import com.htp.test.dao.impl.SQLPatientDAO;
import com.htp.test.dao.impl.SQLPrescriptionDAO;
import com.htp.test.dao.impl.SQLUserDao;
import com.htp.test.dao.impl.SQLWardDAO;

public class SQLDaoFactory extends DaoFactory {
    private static final SQLDaoFactory instance = new SQLDaoFactory();

    private SQLDaoFactory(){}

    public static SQLDaoFactory getInstance(){
        return instance;
    }

    @Override
    public UserDao getUserDao() {
        return SQLUserDao.getInstance();
    }

    @Override
    public WardDAO getWardDAO() {
        return SQLWardDAO.getInstance();
    }

    @Override
    public PrescriptionDAO getPrescriptionDAO() {
        return SQLPrescriptionDAO.getInstance();
    }

    @Override
    public PatientDAO getPatientDao() {
        return SQLPatientDAO.getInstance();
    }



}
