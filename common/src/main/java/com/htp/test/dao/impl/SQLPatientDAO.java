package com.htp.test.dao.impl;

import com.htp.test.dao.PatientDAO;
import com.htp.test.dao.connection_pool.ConnectionPool;
import com.htp.test.dao.connection_pool.ConnectionPoolException;
import com.htp.test.domain.to.Patient;
import com.htp.test.domain.to.User;
import com.htp.test.exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLPatientDAO  implements PatientDAO {



    private static class SingletonHolder {
        private static final PatientDAO instance = new SQLPatientDAO();
    }

    public static PatientDAO getInstance() {
        return SingletonHolder.instance;
    }



    private static final ConnectionPool POOL = ConnectionPool.getInstance();

    private static final String SEARCH_BY_ID = "SELECT * FROM Patient WHERE patient_id = ?";

    private static final String NEW_PATIENT = "INSERT INTO Patient (idPatient, PatientName, PatientSurname," +
            " Diagnosis, Wards_idWard)";
    private static final String LAST_INSERT_ID = "SELECT last_insert_id() as lastId";
    private static final String LAST_ID = "lastId";
    private static final String PATIENT_ID = "patient_id";
    private static final String PATIENT_NAME = "PatientName";
    private static final String PATIENT_SURNAME = "PatientSurname";
    private static final String DIAGNOSIS = "Diagnosis";
    private static final String WARD = "Wards_idWard";
    private static final String DELETE_PATIENT = "DELETE FROM Patient WHERE patient_id =?";
    private static final String UPDATE_PATIENT = "UPDATE Patient SET idPatient= ?, PatientName = ?, PatientSurname = ?,Diagnosis = ?, " +
            "Wards_idWard= ? ";
    private static final String FIND_ALL = "SELECT * FROM Patient";


    @Override
    public int create(Patient entity) throws DaoException {
        try (Connection connect = POOL.getConnection();
             PreparedStatement statement = connect.prepareStatement(NEW_PATIENT);
             PreparedStatement statement2 = connect.prepareStatement(LAST_INSERT_ID)) {
            statement.setLong(1, entity.getPatientId());
            statement.setString(2, entity.getPatientName());
            statement.setString(3, entity.getPatientSurname());
            statement.setString(4, entity.getDiagnosis());
            statement.setLong(5, entity.getWard());
            statement.executeUpdate();
            ResultSet set = statement2.executeQuery();
            set.next();
            return set.getInt(LAST_ID);
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public Boolean checkPatientNodeById(Long id) throws DaoException {
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
    public Patient findById(Long id) throws DaoException {
        try (Connection connect = POOL.getConnection();
             PreparedStatement statement = connect.prepareStatement(SEARCH_BY_ID)) {
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                Patient patient = new Patient();
                patient.setPatientId(set.getLong(PATIENT_ID));
                patient.setPatientName(set.getString(PATIENT_NAME));
                patient.setDiagnosis(set.getString(DIAGNOSIS));
                patient.setWard(set.getInt(WARD));
                patient.setPatientSurname(set.getString(PATIENT_SURNAME));

                return patient;
            } else {
                return null;
            }

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }


    @Override
    public boolean delete(Long id) throws DaoException {
        try (Connection connect = POOL.getConnection();
             PreparedStatement statement = connect.prepareStatement(DELETE_PATIENT)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }

    }


    @Override
    public Long update(Patient entity) throws DaoException {
        try(Connection connect = POOL.getConnection();
            PreparedStatement statement = connect.prepareStatement(UPDATE_PATIENT)) {
            statement.setLong(1, entity.getPatientId());
            statement.setString(2, entity.getPatientName());
            statement.setString(3, entity.getPatientSurname());
            statement.setString(4, entity.getDiagnosis());
            statement.setInt(5, entity.getWard());
            statement.executeUpdate();
            return entity.getPatientId();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public List<Patient> findAll() throws DaoException {
        List<Patient> patientList = new ArrayList<>();

        try(Connection connect = POOL.getConnection();
            PreparedStatement statement = connect.prepareStatement(FIND_ALL)) {
            ResultSet set = statement.executeQuery();
            while(set.next()) {
                Patient patient = new Patient();

                patient.setPatientId(set.getLong(PATIENT_ID));
                patient.setPatientName(set.getString(PATIENT_NAME));
                patient.setDiagnosis(set.getString(DIAGNOSIS));
                patient.setWard(set.getInt(WARD));
                patient.setPatientSurname(set.getString(PATIENT_SURNAME));

                patientList.add(patient);
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return patientList;
    }
    }










