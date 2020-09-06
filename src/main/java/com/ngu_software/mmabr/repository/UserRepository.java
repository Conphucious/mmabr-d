package com.ngu_software.mmabr.repository;

import com.ngu_software.mmabr.entity.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> { // User and ID is String
    @Query(value = "INSERT INTO User (discordId, discordName, discordEmail) VALUES ('asd', 'asd', 'asd')", nativeQuery = true)
    public void addUser(@Param("discordId") String id, @Param("discordName") String name, @Param("discordEmail") String email);

    @Query("FROM User u WHERE " +
            "u.discordId = :#{#user.discordId} AND " +
            "u.discordName = :#{#user.discordName} AND " +
            "u.discordEmail = :#{#user.discordEmail}")
    public User findUser(User user);
}
