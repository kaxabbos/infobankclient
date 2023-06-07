package com.infobankclient.repo;

import com.infobankclient.model.Tertiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TertiaryRepo extends JpaRepository<Tertiary, Long> {
}
