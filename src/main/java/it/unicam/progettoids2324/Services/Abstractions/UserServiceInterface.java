package it.unicam.progettoids2324.Services.Abstractions;

import it.unicam.progettoids2324.entities.User;

import java.util.Set;

public interface UserServiceInterface {

    /** Add a user to the repository
     * @param user the user to add
     * @throws IllegalArgumentException if the user is alredy in the repository
     */
    void createUser(User user);

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
    User getUser(long id);

    /**
     * Delete the user in the repository by the Id
     * @param id
     */
    void deleteUser(long id);
}
