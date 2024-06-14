package it.unicam.progettoids2324.Services.Abstractions;

import it.unicam.progettoids2324.entities.User;

import java.util.Set;

public interface UserServiceInterface {

    void createUser(String email, String password);

    /**
     * Return the details of all user in the repository
     *@return the details of all user in the repository
     */
    Set<User> getUsers();

    /**
     * Return user from Id
     * @param id
     * @return user from the Id
     * @throws IllegalArgumentException if the user doesn't exist
     */
    User getUserById(long id);

    /**
     * Delete the user in the repository by the Id
     * @param id
     */
    void deleteUser(long id);

    void updateRole(long userId, long toUpdateUserId, String role);
}
