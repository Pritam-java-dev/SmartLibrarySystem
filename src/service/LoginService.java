package service;

import model.Admin;
import model.member;
import model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class LoginService {
    private Map<String, User> users = new HashMap<>();

    public LoginService() {
        loadUsersFromFile("users.txt");
    }

    private void loadUsersFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length != 4) continue;

                String userId = parts[0];
                String name = parts[1];
                String password = parts[2];
                String role = parts[3];

                User user;
                if (role.equalsIgnoreCase("Admin")) {
                    user = new Admin(name, userId, password);
                } else {
                    user = new member(name, userId, password);
                }

                users.put(userId, user);
            }
        } catch (Exception e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }

    public User login(String userId, String password) {
        User user = users.get(userId);
        if (user != null && user.CheckPassword(password)) {
            return user;
        }
        return null;
    }
}
