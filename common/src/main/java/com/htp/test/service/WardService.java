package com.htp.test.service;

import com.htp.test.domain.to.Ward;
import com.htp.test.exceptions.DaoException;
import com.htp.test.exceptions.ServiceException;

public interface WardService extends GenericServiceInterface<Ward, Long> {

    boolean update(Ward entity) throws DaoException, ServiceException;
    boolean checkWard(Long number) throws DaoException;
    boolean delete(Long id) throws DaoException;
    boolean findById(Long id) throws DaoException;

}
