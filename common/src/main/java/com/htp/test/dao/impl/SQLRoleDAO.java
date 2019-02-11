package com.htp.test.dao.impl;

import com.htp.test.dao.RoleDAO;
import com.htp.test.dao.connection_pool.ConnectionPool;
import com.htp.test.dao.connection_pool.ConnectionPoolException;
import com.htp.test.domain.to.Role;
import com.htp.test.exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLRoleDAO implements RoleDAO {

    private static final ConnectionPool POOL = ConnectionPool.getInstance();
    private static final String SEARCH_BY_ID = "SELECT * FROM UserBase WHERE idRole_id = ?";
    private static final String ROLE_ID = "idRole_Id";
    private static final String FIND_ALL = "SELECT * FROM UserBase";
    private static final String ROLE_NAME = "Role_Name";

    @Override
    public List<Role> findAll() throws DaoException {
        List<Role> roleList = new ArrayList<>();

        try (Connection connect = POOL.getConnection();
             PreparedStatement statement = connect.prepareStatement(FIND_ALL)) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Role role = new Role();
                role.setRoleId(set.getLong(ROLE_ID));
                role.setRoleName(set.getString(ROLE_NAME));
                roleList.add(role);
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return roleList;
    }

    @Override
    public Role findById(Long id) throws DaoException {
        try (Connection connect = POOL.getConnection();
             PreparedStatement statement = connect.prepareStatement(SEARCH_BY_ID)) {
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                Role role = new Role();
                role.setRoleId(set.getLong(ROLE_ID));
                role.setRoleName(set.getString(ROLE_NAME));
                return role;
            } else {
                return null;
            }

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }

        }


    @Override
    public boolean delete(Long id) throws DaoException {
        return false;
    }

    @Override
    public int create(Role entity) throws DaoException {
        return 0;
    }

    @Override
    public Long update(Role entity) throws DaoException {
        return null;
    }
}
