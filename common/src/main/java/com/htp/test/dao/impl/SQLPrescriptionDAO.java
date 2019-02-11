package com.htp.test.dao.impl;

import com.htp.test.dao.PrescriptionDAO;
import com.htp.test.dao.connection_pool.ConnectionPool;
import com.htp.test.dao.connection_pool.ConnectionPoolException;
import com.htp.test.domain.to.Prescription;

import com.htp.test.exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SQLPrescriptionDAO implements PrescriptionDAO {

    private static class SingletonHolder {
        private static final PrescriptionDAO instance = new SQLPrescriptionDAO();
    }

    public static PrescriptionDAO getInstance() {
        return SingletonHolder.instance;
    }


    private static final ConnectionPool POOL = ConnectionPool.getInstance();
    private static final String SEARCH_BY_ID = "SELECT * FROM Prescriptions WHERE idPrescriptions = ?";
    private static final String NEW_PRESCRIPTION = "INSERT INTO Prescriptions (idPrescriptions, Patient_idPatient, User_IdUser," +
          " + Drug_id ) VALUES (?, ?, ?, ?)";
    private static final String DELETE_PRESCRIPTION = "DELETE FROM Prescriptions WHERE idPrescriptions = ?";
    private static final String UPDATE_PRESCRIPTION = "UPDATE Ward SET idPrescriptions = ?, Patient_idPatient = ?, User_Iduser = ?";
    private static final String PRESCRIPTION_ID = "idPrescriptions";
    private static final String PRESCRIBED_BY = "User_IdUser";
    private static final String PRESCRIBED_TO = "Patient_idPatient = ?";
    private static final String DRUG_ID = "Drug_id";



    private static final String LAST_INSERT_ID = "SELECT last_insert_id() as lastId";
    private static final String LAST_ID = "lastId";


    private static final String FIND_ALL = "SELECT * FROM Prescription";


    @Override
    public int create(Prescription entity) throws DaoException {
        try (Connection connect = POOL.getConnection();
             PreparedStatement statement = connect.prepareStatement(NEW_PRESCRIPTION);
             PreparedStatement statement2 = connect.prepareStatement(LAST_INSERT_ID)) {
            statement.setLong(1, entity.getPrescriptionId());
            statement.setString(2, entity.getPrescribedBy());
            statement.setString(3, entity.getPrescribedTo());
            statement.setLong(4, entity.getDrug_id());
            statement.executeUpdate();

            ResultSet set = statement2.executeQuery();
            set.next();
            return set.getInt(LAST_ID);
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }

    }

    public Prescription findById(Long id) throws DaoException {
        try (Connection connect = POOL.getConnection();
             PreparedStatement statement = connect.prepareStatement(SEARCH_BY_ID)) {
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                Prescription prescription = new Prescription();
                prescription.setPrescriptionId(set.getLong(PRESCRIPTION_ID));
                prescription.setPrescribedTo(set.getString(PRESCRIBED_TO));
                prescription.setPrescribedBy(set.getString(PRESCRIBED_BY));
                prescription.setDrug_id(set.getLong(DRUG_ID));
                return prescription;
            } else {
                return null;
            }

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public Boolean checkPrescriptionNodeById(Long id) throws DaoException {
        try (Connection connect = POOL.getConnection();
             PreparedStatement statement = connect.prepareStatement(SEARCH_BY_ID)) {
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();
            return set.next();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }


    @Override
    public boolean delete(Long id) throws DaoException {
        try (Connection connect = POOL.getConnection();
             PreparedStatement statement = connect.prepareStatement(DELETE_PRESCRIPTION)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public Long update(Prescription entity) throws DaoException {
        try (Connection connect = POOL.getConnection();
             PreparedStatement statement = connect.prepareStatement(UPDATE_PRESCRIPTION)) {
            statement.setLong(1, entity.getPrescriptionId());
            statement.setString(2, entity.getPrescribedTo());
            statement.setString(3, entity.getPrescribedBy());
            statement.setLong(4, entity.getDrug_id());


            statement.executeUpdate();
            return entity.getPrescriptionId();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }


    @Override
    public List<Prescription> findAll() throws DaoException {

        List<Prescription> prescriptionList = new ArrayList<>();

        try (Connection connect = POOL.getConnection();
             PreparedStatement statement = connect.prepareStatement(FIND_ALL)) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Prescription prescription = new Prescription();
                prescription.setPrescriptionId(set.getLong(PRESCRIPTION_ID));
                prescription.setPrescribedTo(set.getString(PRESCRIBED_TO));
                prescription.setPrescribedBy(set.getString(PRESCRIBED_BY));
                prescription.setDrug_id(set.getLong(DRUG_ID));
                prescriptionList.add(prescription);
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return prescriptionList;


    }


}
