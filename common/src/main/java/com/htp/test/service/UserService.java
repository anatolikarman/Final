package com.htp.test.service;

import com.htp.test.domain.to.User;
import com.htp.test.exceptions.NoSuchEntityException;
import com.htp.test.exceptions.ServiceException;

public interface UserService extends GenericServiceInterface <User, Long>{
 //   User loadById(Long userId) throws ServiceException, NoSuchEntityException, ServiceException;

    User getUserNode(String login, String password);
    /**
     * Method provides operation for login user
     *
     * @param user object, that provides authorization operation
     * @return {@link User} - login record
     * @throws ServiceException
     */
    User authorization(User user) throws ServiceException;
}
