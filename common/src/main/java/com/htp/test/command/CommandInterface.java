package com.htp.test.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** Interface provide method for dealing with HttpServletRequest and HttpServletResponse
        */
public interface CommandInterface {
  /**
          *
          * Method performs some logic to process the request and determines
     * which page will be a transition after completion method
     *
             * @param request HttpServletRequest
   * @param response HttpServletResponse
   * @return the path to go to a specific page
   * @throws CommandException
   */


    String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, IOException;


    /**
     * Method determines by request of which command is needed and returns the command object
     *
     * @param request HttpServletRequest
     * @return command object if command exists in map, else return null
     */

}