package com.htp.test.dao.impl;


import com.htp.test.dao.UserDao;
import com.htp.test.dao.connection_pool.ConnectionPool;
import com.htp.test.dao.connection_pool.ConnectionPoolException;

import com.htp.test.domain.to.User;
import com.htp.test.exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLUserDao implements UserDao {




    private static class SingletonHolder {
        private static final UserDao instance = new SQLUserDao();
    }

    public static UserDao getInstance() {
        return SingletonHolder.instance;
    }

    private static final String USER_ID = "idUser";
    private static final String LOGIN = "Login";
    private static final String PASSWORD = "Password";
    private static final String NAME = "Name";
    private static final String SURNAME = "Surname";
    private static final String REGISTRATION_DATE = "Registration_Date";
    private static final String USER_ROLE = "UserBase_Role_Id";
    private static final ConnectionPool POOL = ConnectionPool.getInstance();
    private static final String NEW_USER = "INSERT INTO User (idUser, Login, Password, Name, Surname, Registration_Date, UserBase_Role_Id) " +
            "VALUES (?, ?, ?, ?, ?, ?, ? )";
    private static final String DELETE_USER = "";
    private static final String SELECT_BY_ID = "SELECT * FROM autorization WHERE idUser = ?";
    private static final String SELECT_BY_LOGIN_PASSWORD = "SELECT * FROM  User WHERE Login = ? AND Password = ?";
    private static final String LAST_INSERT_ID = "SELECT last_insert_id() as lastId";
    private static final String LAST_ID = "lastId";
    private static final String FIND_ALL = "SELECT * FROM User";


  //  @Override
  //  public int create(User entity) throws DaoException { try (Connection connect = POOL.getConnection();
  //         PreparedStatement statement = connect.prepareStatement(NEW_USER);
  //         PreparedStatement statement2 = connect.prepareStatement(LAST_INSERT_ID)) {
  //        statement.setLong(1, entity.getUserId());
  //        statement.setString(2, entity.getLogin());
  //        statement.setString(3, entity.getLogin());
  //        statement.setString(4, entity.getPassword());
  //        statement.setString(5, entity.getName());
  //        statement.setString(6, entity.getSurname());
  //        statement.setString(7, entity.getRegistrationDate());
//
  //        statement.executeUpdate();
  //        statement2.executeUpdate();
//
  //        ResultSet set = statement2.executeQuery();
  //        set.next();
  //        return set.getInt(LAST_ID);
  //    } catch (SQLException | ConnectionPoolException e) {
  //        throw new DaoException("Exception", e);
  //    }return Integer.parseInt(null);
  //  }


    @Override
    public User getUserNode(String login, String password) throws DaoException {
        try (Connection connect = POOL.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_LOGIN_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                User user = new User();
                user.setUserId(set.getLong(USER_ID));
                user.setLogin(set.getString(LOGIN));
                user.setPassword(set.getString(PASSWORD));
                user.setRoleId(set.getString(USER_ROLE));
                user.setRegistrationDate(set.getString(REGISTRATION_DATE));
                user.setName(set.getString(NAME));
                user.setSurname(set.getString(SURNAME));
                return user;
            } else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }


    @Override
    public User findById(Long id) throws DaoException {
        try (Connection connect = POOL.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_ID)) {
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                User user = new User();
                user.setUserId(set.getLong(USER_ID));
                user.setLogin(set.getString(LOGIN));
                user.setPassword(set.getString(PASSWORD));
                user.setRoleId(set.getString(USER_ROLE));
                user.setRegistrationDate(set.getString(REGISTRATION_DATE));
                user.setName(set.getString(NAME));
                user.setSurname(set.getString(SURNAME));
                return user;
            } else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public boolean checkUser(String login, String password) throws DaoException {
        try (Connection connect = POOL.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_LOGIN_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet set = statement.executeQuery();
            return set.next();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public boolean delete(Long id) throws DaoException {
        return false;
    }

    @Override
    public int create(User entity) throws DaoException {
        return 0;
    }


    @Override
    public Long update(User entity) throws DaoException {
        return null;
    }


    @Override
    public List<User> findAll() throws DaoException {
        List<User> userList = new ArrayList<>();

        try(Connection connect = POOL.getConnection();
            PreparedStatement statement = connect.prepareStatement(FIND_ALL)) {
            ResultSet set = statement.executeQuery();
            while(set.next()) {
                User user = new User();
                user.setUserId(set.getLong(USER_ID));
                user.setLogin(set.getString(LOGIN));
                user.setPassword(set.getString(PASSWORD));
                user.setRoleId(set.getString(USER_ROLE));
                user.setRegistrationDate(set.getString(REGISTRATION_DATE));
                user.setName(set.getString(NAME));
                user.setSurname(set.getString(SURNAME));
                userList.add(user);

            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }

        return userList;
    }

}
