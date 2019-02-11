package com.htp.test.dao;

import com.htp.test.domain.to.Ward;
import com.htp.test.exceptions.DaoException;

public interface WardDAO extends GenericDAO <Ward, Long> {

    boolean checkWard(Long number) throws DaoException;
}
