package com.ngu_software.mmabr.service;

import com.ngu_software.mmabr.entity.user.User;
import com.ngu_software.mmabr.entity.user.Ip;

public interface IUserService {
    public void handleTransaction(User user, Ip ip);
    public void handleUser(User user, Ip ip);
    public void handleIp(User user, Ip ip);

    public void saveUser(User user);
    public void saveUserIp(Ip ip);

    public boolean userExists(User user);
    public boolean ipExists(User user, Ip ip);

    public User findUser(User user); // fetches from DB
    public Ip findIp(User user, Ip ip);


}
