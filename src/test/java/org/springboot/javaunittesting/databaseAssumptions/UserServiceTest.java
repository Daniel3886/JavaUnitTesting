package org.springboot.javaunittesting.databaseAssumptions;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserDAO dao;
    private UserService service;

    public void shouldAddUser() {
        // to prevent assuming the db doesnt have any users
        int nbOfUsers = dao.getNbOfUsers();
        User user = new User();
        service.save(user);

        // allows us to assert that the user was added regardless of the db state during the process
        assertEquals(nbOfUsers + 1, dao.getNbOfUsers());
    }
}