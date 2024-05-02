package com.example.server.service;

import com.example.server.dao.entity.Server;

import java.io.IOException;
import java.util.Collection;

public interface ServerManager {
    Server create(Server server);
    Collection<Server> listOfServers(int limit);
    Server getServer(Long id);
    Server updateServer(Server server);
    Boolean deleteServer(Long id);
    Server ping(String ipAdresse) throws IOException;
}
