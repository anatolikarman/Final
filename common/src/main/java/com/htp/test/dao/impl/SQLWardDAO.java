package com.htp.test.dao.impl;

import com.htp.test.dao.WardDAO;
import com.htp.test.dao.connection_pool.ConnectionPool;
import com.htp.test.dao.connection_pool.ConnectionPoolException;
import com.htp.test.domain.to.Ward;
import com.htp.test.exceptions.DaoException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLWardDAO implements WardDAO {




    private static class SingletonHolder {
        private static final WardDAO instance = new SQLWardDAO();
    }

    public static WardDAO getInstance() {
        return SingletonHolder.instance;
    }

    private static final ConnectionPool POOL = ConnectionPool.getInstance();
    private static final String NUMBER = "WardNum";
    private static final String MAX_CAPACITY = "maxCapacity";
    private static final String CAPACITY = "capacity";
    private static final String PLACES_LEFT = "placesLeft";
    private static final String FIND_WARD_BY_ID = "SELECT * FROM Wards WHERE idWard = ?";
    private static final String CHECK_PLACES_LEFT = "SELECT (MAX_CAPACITY - CAPACITY)" +
            " as placesLeft " +
            "FROM wards WHERE number = ?";
    private static final String NEW_WARD =  "INSERT INTO Wards (idWard, WardNum) VALUES (?, ?)";
    private static final String LAST_INSERT_ID = "SELECT last_insert_id() as lastId";
    private static final String LAST_ID = "lastId";
    private static final String UPDATE_ROOM = "UPDATE Wards SET idWard = ?, WardNum = ?";
    private static final String DELETE_WARD = "DELETE FROM Ward WHERE idWard =?";
    private static final String WARD_ID = "idWard";
    private static final String FIND_ALL = "SELECT * FROM Wards";

    @Override
   public boolean checkWard(Long number) throws DaoException {
       try (Connection connect = POOL.getConnection();
            PreparedStatement statement = connect.prepareStatement(FIND_WARD_BY_ID)) {
           statement.setLong(1, number);
           ResultSet set = statement.executeQuery();
           return set.next();
       } catch (SQLException | ConnectionPoolException e) {
           throw new DaoException("Exception", e);
       }
   }

//  @Override
//  public String checkPlacesLeft(Long number) throws DaoException {
//      int roomsLeft = 0;
//      try (Connection connect = POOL.getConnection();
//           PreparedStatement statement = connect.prepareStatement(CHECK_PLACES_LEFT)) {
//          statement.setLong(1, number);
//          ResultSet set = statement.executeQuery();

//         if (set.getLong(PLACES_LEFT) > 0) {
//             return "There are " + set.getLong(PLACES_LEFT)+ " places left";
//         }
//         else return "No vacant places left";
//      } catch (SQLException | ConnectionPoolException e) {
//          throw new DaoException("Exception", e);
//      }
//  }


    @Override
    public List<Ward> findAll() throws DaoException {
        List<Ward> wardList = new ArrayList<>();

        try(Connection connect = POOL.getConnection();
            PreparedStatement statement = connect.prepareStatement(FIND_ALL)) {
            ResultSet set = statement.executeQuery();
            while(set.next()) {
                Ward ward = new Ward();
                ward.setWardId(set.getLong(WARD_ID));
                ward.setNumber(set.getLong(NUMBER));


                wardList.add(ward);
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return wardList;
    }

    @Override
    public Ward findById(Long id) throws DaoException {
        try (Connection connect = POOL.getConnection();
             PreparedStatement statement = connect.prepareStatement(FIND_WARD_BY_ID)) {
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                Ward ward = new Ward();
                ward.setWardId(set.getLong(WARD_ID));
                ward.setNumber(set.getLong(NUMBER));
                System.out.println("Zaebtsa");
                return ward;

            } else {
                return null;
            }

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public boolean delete(Long id) throws DaoException {
        try(Connection connect = POOL.getConnection();
            PreparedStatement statement = connect.prepareStatement(DELETE_WARD)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }



    }

    @Override
    public int create(Ward entity) throws DaoException {

            try(Connection connect = POOL.getConnection();
                PreparedStatement statement = connect.prepareStatement(NEW_WARD);
                PreparedStatement statement2 = connect.prepareStatement(LAST_INSERT_ID)) {
                statement.setLong(1, entity.getWardId());
                statement.setLong(2, entity.getNumber());
                statement.executeUpdate();


                ResultSet set = statement2.executeQuery();
                set.next();
                return set.getInt(LAST_ID);
            } catch (SQLException | ConnectionPoolException e) {
                throw new DaoException("Exception", e);
            }

    }

    @Override
    public Long update(Ward entity) throws DaoException {
        try(Connection connect = POOL.getConnection();
            PreparedStatement statement = connect.prepareStatement(UPDATE_ROOM)) {
            statement.setLong(1, entity.getWardId());
            statement.setLong(2, entity.getNumber());

            statement.executeUpdate();
            return entity.getWardId();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }
    }






