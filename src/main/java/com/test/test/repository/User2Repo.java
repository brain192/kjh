package com.test.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.test.vo.User2VO;

public interface User2Repo extends JpaRepository<User2VO, String> {
    public User2VO findUser2VOByUidAndPass(String uid, String pass);
}
