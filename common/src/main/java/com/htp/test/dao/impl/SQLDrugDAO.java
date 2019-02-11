package com.htp.test.dao.impl;

import com.htp.test.dao.DrugDAO;
import com.htp.test.dao.connection_pool.ConnectionPool;

import com.htp.test.dao.connection_pool.ConnectionPoolException;
import com.htp.test.domain.to.Drug;
import com.htp.test.domain.to.Prescription;
import com.htp.test.exceptions.DaoException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SQLDrugDAO implements DrugDAO {


    private static final ConnectionPool POOL = ConnectionPool.getInstance();
    private  static final String DRUG_ID = "idDrug";
    private static final String DRUG_NAME = "DrugName";
    private static final String ROLE_ID = "Role_Id";
    private static final String SEARCH_BY_ID = "SELECT * FROM Drug WHERE idDrug = ?";
    private static final String DELETE_DRUG = "DELETE FROM Drug WHERE idDrug = ?";
    private static final String NEW_DRUG =  "INSERT INTO Drug (idDrug, DrugName, Role_Id) VALUES (?, ?, ?)";
    private static final String LAST_INSERT_ID = "SELECT last_insert_id() as lastId";
    private static final String LAST_ID = "lastId";
    private static final String FIND_ALL = "SELECT * FROM Drug";




    @Override
    public List<Drug> findAll() throws DaoException {
        return null;
    }

    @Override
    public Drug findById(Long id) throws DaoException {
        try (Connection connect = POOL.getConnection();
             PreparedStatement statement = connect.prepareStatement(SEARCH_BY_ID)) {
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                Drug drug = new Drug();
                drug.setDrugId(set.getLong(DRUG_ID));
                drug.setDrugName(set.getString(DRUG_NAME));
                drug.setRoleId(set.getLong(ROLE_ID));

                return drug;
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
             PreparedStatement statement = connect.prepareStatement(DELETE_DRUG)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public int create(Drug entity) throws DaoException {
        try (Connection connect = POOL.getConnection();
             PreparedStatement statement = connect.prepareStatement(NEW_DRUG);
             PreparedStatement statement2 = connect.prepareStatement(LAST_INSERT_ID)) {
            statement.setLong(1, entity.getDrugId());
            statement.setString(2, entity.getDrugName());
            statement.setLong(3, entity.getDrugId());
            statement.executeUpdate();

            ResultSet set = statement2.executeQuery();
            set.next();
            return set.getInt(LAST_ID);
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public Long update(Drug entity) throws DaoException {
        return null;
    }
}
