package com.infobankclient.repo;

import com.infobankclient.model.Primarys;
import com.infobankclient.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepo extends JpaRepository<Reviews, Long> {
}
