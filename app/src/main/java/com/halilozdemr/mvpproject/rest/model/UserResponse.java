package com.halilozdemr.mvpproject.rest.model;

public class UserResponse {
    //{"error":{"status":false},"data":{"name":"hsbs","surname":"gsg","userId":"hhs"}}

    private User data;

    public User getData() {
        return data;
    }

    public class User {
        private String name;
        private String surname;
        private String userId;

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getUserId() {
            return userId;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", userId='" + userId + '\'' +
                    '}';
        }
    }


}
