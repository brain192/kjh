package com.test.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.test.vo.User1VO;

public interface User1Repo extends JpaRepository<User1VO, String> {
    public User1VO findUser1VOByUidAndPass(String uid, String pass);
}
