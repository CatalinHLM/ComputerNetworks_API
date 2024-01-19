package com.example.api.repository;

import com.example.api.model.Log;
import com.example.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LogRepository extends JpaRepository<Log,Long> {

    // Search logs by email
    List<Log> findByUser(User user);

    // Search logs by time greater than a given date
    List<Log> findByTimeGreaterThanOrderByTimeDesc(long timestamp);

    // Search logs by email and time greater than a given date
    List<Log> findByUserAndTimeGreaterThanOrderByTimeDesc(User user, long timestamp);

}
