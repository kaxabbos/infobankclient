package com.infobankclient.repo;

import com.infobankclient.model.Secondary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondaryRepo extends JpaRepository<Secondary, Long> {
}
