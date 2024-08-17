package com.ohgiraffers.Login;

import java.util.ArrayList;
import java.util.Objects;

public class Login {

    private final ArrayList<User> users = new ArrayList<>();

    public Login() {
        users.add(new User("hyun", "1234"));
        users.add(new User("whoo", "5678"));
        users.add(new User("seok", "1234"));
    }


    public boolean validLogin(String userid, String password) {
        for (User user : users) {
            if (user.getUsername().equals(userid) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }



    public class User {
        private String userid;
        private String password;

        public User(String username, String password) {
            this.userid = username;
            this.password = password;
        }

        public String getUsername() {
            return userid;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userid='" + userid + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(userid, user.userid) && Objects.equals(password, user.password);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userid, password);
        }
    }
}

