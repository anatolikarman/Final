package com.htp.test.dao.factory;

import com.htp.test.dao.PatientDAO;
import com.htp.test.dao.PrescriptionDAO;
import com.htp.test.dao.UserDao;
import com.htp.test.dao.WardDAO;
public abstract class DaoFactory {
   public static DaoFactory getDaoFactory() {
       return SQLDaoFactory.getInstance();
   }

  public abstract UserDao getUserDao();
  public abstract WardDAO getWardDAO();
  public abstract PrescriptionDAO getPrescriptionDAO();
  public abstract PatientDAO getPatientDao();
  //  public abstract ApplicationDao getApplicationDao();
 //   public abstract PaymentDao getPaymentDao();
}
