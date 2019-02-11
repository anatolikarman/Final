package com.htp.test.command;

import com.htp.test.command.impl.ViewAllUsersCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandHelper {

        private static final String ATTRIBUTE_COMMAND = "command";
        private static final String DASH = "-";
        private static final String UNDERSCORE = "_";

        private final Map<CommandName, CommandInterface> commands = new HashMap<>();

        public CommandHelper() {
            commands.put(CommandName.FIND_ALL, ViewAllUsersCommand.getInstance());

        }


        public CommandInterface getCommand(HttpServletRequest request) {
            String commandName = request.getParameter(ATTRIBUTE_COMMAND);
            if(commandName != null) {
                CommandName name = CommandName.valueOf(commandName.toUpperCase().replace(DASH, UNDERSCORE));
                return commands.get(name);
            } else {
                return null;
            }
        }


        private enum CommandName {
            FIND_ALL,
        }



}
