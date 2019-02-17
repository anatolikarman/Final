package com.htp.test.command.impl;

import com.htp.test.command.CommandException;
import com.htp.test.command.CommandInterface;
import com.htp.test.domain.to.User;
import com.htp.test.exceptions.ServiceException;
import com.htp.test.service.UserService;
import com.htp.test.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthoriseCommand implements CommandInterface {


    private static final UserService SERVICE = UserServiceImpl.getInstance();

    private static final String ACTION = "action";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";


    private  static final Logger LOGGER = Logger.getRootLogger();
    private static final String ERROR_PAGE = "/error";


    public static CommandInterface getInstance(){
        return SingletonHolder.INSTANCE;
    }




    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new AuthoriseCommand();
    }



    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, IOException {
       
        User user1 = new User();
        user1.setLogin(request.getParameter("login"));
        user1.setPassword(request.getParameter("password"));
        try {
            request.setAttribute("user",SERVICE.authorization(user1));
        } catch (ServiceException e) {
            LOGGER.error("CommandException", e);
            response.sendRedirect(request.getContextPath() + ERROR_PAGE);
            throw new CommandException();
        }
        request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);

        return "/FAP";
    }
}
