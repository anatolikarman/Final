package com.htp.test.service.impl;

import com.htp.test.dao.UserDao;
import com.htp.test.dao.factory.DaoFactory;
import com.htp.test.domain.to.User;
import com.htp.test.exceptions.DaoException;
import com.htp.test.exceptions.NoSuchEntityException;
import com.htp.test.exceptions.ServiceException;
import com.htp.test.service.UserService;
import com.htp.test.service.validator.LoginValidator;
import com.htp.test.service.validator.ValidationException;
import com.htp.test.service.validator.ValidatorInterface;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final DaoFactory factory = DaoFactory.getDaoFactory();
    private static final ValidatorInterface<User> VALIDATE = LoginValidator.getInstance();

    private UserServiceImpl(){}

    public static UserService getInstance() {
        return SingletonHolder.instance;
    }

    @Override
    public User create(User entity) throws ServiceException {
        return null;
    }



    private static class SingletonHolder {
        private static final UserServiceImpl instance = new UserServiceImpl();
    }


    @Override
    public User getUserNode(String login, String password) {
        return null;
    }

    /**
     * Method check login and password information from some user and get user object if authorization success
     * @param user object, that provides authorization operation
     * @return null if client not exists in system; user object if authorization execute correctly
     * @throws ServiceException
     */
    @Override
    public User authorization(User user) throws ServiceException {
        try {
            UserDao userDao = factory.getUserDao();

            if(VALIDATE.isValid(user)) {

        //       String password = user.getPassword();
        //       String passwordMD5 = DigestUtils.md5Hex(password);
        //       user.setPassword(passwordMD5);

                boolean check = userDao.checkUser(user.getLogin(), user.getPassword());
                if (!check) {
                    return null;
                } else {
                    return userDao.getUserNode(user.getLogin(), user.getPassword());
                }
            } else {
                throw new ValidationException("Validation Exception");
            }
        } catch (DaoException e) {
            throw new ServiceException("Service Exception", e);
        }
    }


    @Override
    public List<User> loadAll() throws ServiceException {
        List<User> listResult;
        try {
            UserDao a = factory.getUserDao();
            listResult = a.findAll();
            return listResult;
        } catch (DaoException e) {
            throw new ServiceException("Service Exception", e);
        }
    }


}

