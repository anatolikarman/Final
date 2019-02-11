package com.htp.test;


import com.htp.test.dao.connection_pool.ConnectionPool;
import com.htp.test.dao.connection_pool.ConnectionPoolException;
import com.htp.test.dao.factory.DaoFactory;

import com.htp.test.dao.impl.SQLUserDao;
import com.htp.test.dao.impl.SQLWardDAO;
import com.htp.test.domain.to.User;
import com.htp.test.exceptions.DaoException;

public class Main {

    private static final DaoFactory factory = DaoFactory.getDaoFactory();

    public static void main(String[] args) throws DaoException {
        try {
            ConnectionPool.getInstance().init();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }


        SQLUserDao a = new SQLUserDao();

        for(User object: a.findAll()){
            System.out.println(object);
        }
    }
}
