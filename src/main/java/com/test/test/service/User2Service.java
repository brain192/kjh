package com.test.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.test.repository.User2Repo;
import com.test.test.vo.User2VO;

@Service
public class User2Service {

    @Autowired
    private User2Repo  repo;

    public User2VO   selectUser2(String uid, String pass) {
        return repo.findUser2VOByUidAndPass(uid, pass);
    }

}
