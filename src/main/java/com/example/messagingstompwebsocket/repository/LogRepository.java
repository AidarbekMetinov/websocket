package com.example.messagingstompwebsocket.repository;

import com.example.messagingstompwebsocket.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

}
