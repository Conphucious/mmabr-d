package com.ngu_software.mmabr.repository;

import com.ngu_software.mmabr.entity.user.User;
import com.ngu_software.mmabr.entity.user.Ip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpRepository extends CrudRepository<Ip, String> {

    @Query("FROM Ip ipdb " +
            "JOIN ipdb.userReference user " +
            "WHERE user.discordId = :#{#user.discordId} AND " +
            "ipdb.ipAddress = :#{#uip.ipAddress}")
    Ip findIp(User user, Ip uip);

}
