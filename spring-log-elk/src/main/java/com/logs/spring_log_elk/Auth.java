package com.logs.spring_log_elk;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Auth {

    private static final Logger logger = Logger.getLogger(Auth.class.getName());
    private static final Map<String, Map<String, String>> users = new HashMap<>();

    public static void saveUser(Map<String, String> userData) {
        String username = userData.get("username");
        users.put(username, userData);
    }

    public static Map<String, Map<String, String>> getUsers() {
        return users;
    }

    public static boolean authenticate(String username, String password) {
        logger.log(Level.FINE, "Tentativa de login para usuário: {0}", username);

        Map<String, String> userData = users.get(username);
        if (userData == null) {
            logger.log(Level.WARNING, "Usuário não encontrado: {0}", username);
            return false;
        }

        if (userData.get("password").equals(password)) {
            logger.log(Level.INFO, "Login bem-sucedido para usuário: {0}", username);
            return true;
        } else {
            logger.log(Level.WARNING, "Senha incorreta para usuário: {0}", username);
            return false;
        }
    }
}