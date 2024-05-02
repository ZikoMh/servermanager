package com.example.server.dao.repository;

import com.example.server.dao.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server,Long> {
    Server findByIpAdresse(String ip);
}
