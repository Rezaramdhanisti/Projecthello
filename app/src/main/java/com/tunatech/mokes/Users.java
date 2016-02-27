package com.tunatech.mokes;

import java.util.List;

/**
 * Created by User on 17/02/2016.
 */
public class Users  {

    public List<UserItem> users;
    public String code;

    public List<UserItem> getUsers() { return users;}
    public void setUsers(List<UserItem> users) { this.users = users;}
    public Users(List<UserItem> users) { this.users = users; }


    public class UserItem {
        private int id;
        private String email;
        private String password;
        private String token_auth;
        private String name;
        private String updated_at;
        private String code;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getToken_auth() {
            return token_auth;
        }

        public void setToken_auth(String token_auth) {
            this.token_auth = token_auth;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
        
        public String getCode() { return code; }
        
        public void setCode(String code) { this.code = code;}
    }
}
