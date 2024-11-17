package com.test.test.service;

import com.test.test.dto.User1DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.test.repository.User1Repo;
import com.test.test.vo.User1VO;

import java.util.List;

@Service
public class User1Service {

    @Autowired
    private User1Repo repo;

//    @Autowired
//    private User1DAO dao;

    public void insertUser1(User1VO vo) {
        // MyBatis
        //dao.insertUser1(vo);

        // JPA
        repo.save(vo);

    }
    public User1VO selectUser1(String uid) {
        // MyBatis
        //User1VO user = dao.selectUser1(uid);

        // JPA
        User1VO user = repo.findById(uid).get();
        return user;
    }
    public List<User1VO> selectUser1s() {
        // MyBatis
        //List<User1VO> users = dao.selectUser1s();

        // JPA
        List<User1VO> users = repo.findAll();
        return users;
    }
    public void updateUser1(User1VO vo) {
        // MyBatis
        //dao.updateUser1(vo);

        // JPA
        repo.save(vo);
    }
    public void deleteUser1(String uid) {
        // MyBatis
        //dao.deleteUser1(uid);

        // JPA
        repo.deleteById(uid);
    }

    public User1VO selectUser1(String uid, String pass) {
        return repo.findUser1VOByUidAndPass(uid, pass);
    }

}