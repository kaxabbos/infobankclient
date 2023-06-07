package com.infobankclient.repo;

import com.infobankclient.model.Apps;
import com.infobankclient.model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppsRepo extends JpaRepository<Apps, Long> {
    List<Apps> findAllByOwner(Users owner);

}
