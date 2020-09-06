package com.ngu_software.mmabr.service;

import com.ngu_software.mmabr.entity.user.User;
import com.ngu_software.mmabr.entity.user.Ip;
import com.ngu_software.mmabr.repository.IpRepository;
import com.ngu_software.mmabr.repository.UserRepository;
import com.ngu_software.mmabr.utils.LoggingMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    private UserRepository userRepo;
    private IpRepository ipRepo;

    @Autowired
    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Autowired
    public void setIpRepo(IpRepository ipRepo) {
        this.ipRepo = ipRepo;
    }

    public void handleTransaction(User user, Ip ip) {
        handleUser(user, ip);
        handleIp(user, ip);
        log.info(LoggingMessage.TRANSACTION_HANDLING + "{" + user.getDiscordId() + ", " + ip.getIpAddress() + "}");
    }

    public void handleUser(User user, Ip ip) {
        if (!userExists(user)) {
            saveUser(user);
        }
    }

    public void handleIp(User user, Ip ip) {
        if (!ipExists(user, ip)) {
            user.getAssociatedIpSet().add(ip);
            saveUser(user);
        }
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public void saveUserIp(Ip ip) {
        ipRepo.save(ip);
    }

    public boolean userExists(User user) {
        return findUser(user) != null;
    }

    public boolean ipExists(User user, Ip ip) {
        return findIp(user, ip) != null;
    }

    public User findUser(User user) {
        return userRepo.findUser(user);
    }

    public Ip findIp(User user, Ip ip) {
        return ipRepo.findIp(user, ip);
    }

}
