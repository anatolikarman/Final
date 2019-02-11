package com.htp.test.service.impl;

import com.htp.test.dao.WardDAO;
import com.htp.test.dao.factory.DaoFactory;

import com.htp.test.domain.to.Ward;
import com.htp.test.exceptions.DaoException;
import com.htp.test.exceptions.ServiceException;
import com.htp.test.service.WardService;
import com.htp.test.service.validator.ValidationException;
import com.htp.test.service.validator.ValidatorInterface;
import com.htp.test.service.validator.WardValidator;

import java.util.List;

public class WardServiceImpl implements WardService {
    private static final DaoFactory factory = DaoFactory.getDaoFactory();

    private static class SingletonHolder {
        private static final WardService instance = new WardServiceImpl();
    }

    public static WardService getInstance() {
        return SingletonHolder.instance;
    }

    private static final ValidatorInterface<Ward> VALIDATOR = WardValidator.getInstance();


    public WardServiceImpl() {
    }

    @Override
    public boolean update(Ward entity) throws ServiceException, DaoException {

        try {
            if (VALIDATOR.isValid(entity)) {
                WardDAO wardDAO = factory.getWardDAO();
                {
                    wardDAO.update(entity);
                    return true;
                }
            } else {
                throw new ValidationException("Validation Exception");
            }
        } catch (DaoException e) {
            throw new ServiceException("Service Exception", e);
        }
    }


    @Override
    public boolean checkWard(Long number) throws DaoException {
        WardDAO wardDAO = factory.getWardDAO();
        {
            wardDAO.checkWard(number);
            return true;
        }
    }

    @Override
    public boolean delete(Long id) throws DaoException {
        WardDAO wardDAO = factory.getWardDAO();
        {
            wardDAO.delete(id);
            return true;
        }
    }

    @Override
    public boolean findById(Long id) throws DaoException {
        WardDAO wardDAO = factory.getWardDAO();
        {
            wardDAO.findById(id);
            return true;
        }
    }


    @Override
    public Ward create(Ward entity) throws ServiceException, DaoException {
        try {
            if (VALIDATOR.isValid(entity)) {
                WardDAO wardDAO = factory.getWardDAO();

                wardDAO.create(entity);
                return entity;
            } else {
                throw new ValidationException("Validation Exception");
            }

        } catch (DaoException e) {
            throw new ServiceException("Service Exception", e);
        }
    }

    @Override
    public List<Ward> loadAll() throws ServiceException {
        return null;
    }
}
