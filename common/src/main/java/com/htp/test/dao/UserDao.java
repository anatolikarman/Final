package com.htp.test.dao;


import com.htp.test.domain.to.User;
import com.htp.test.exceptions.DaoException;

public interface UserDao extends GenericDAO <User, Long> {

    User getUserNode(String login, String password) throws DaoException;

    /**
     * Method check user node in database by login and password transfers parameters
     *
     * @param login login unique parameter
     * @param password password parameter
     * @return boolean result of operation
     * @throws DaoException
     */
    boolean checkUser(String login, String password) throws DaoException;

}
