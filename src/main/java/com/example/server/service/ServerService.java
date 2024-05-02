package com.example.server.service;

import com.example.server.dao.entity.Server;
import com.example.server.dao.enumeration.Status;
import com.example.server.dao.repository.ServerRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Collection;
@Service
@Transactional
@Slf4j
public class ServerService implements ServerManager{
    @Autowired
    ServerRepository serverRepository;
    @Override
    public Server create(Server server) {
        log.info("saving new server:{}",server.getName());
        server.setImageURL("C:/Users/user/Downloads/");
        return serverRepository.save(server);
    }


    @Override
    public Collection<Server> listOfServers(int limit) {
        log.info("fetching the list");
        return serverRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Server getServer(Long id) {
        log.info("fetching the server by id:{}",id);

        return serverRepository.findById(id).get();
    }

    @Override
    public Server updateServer(Server server) {
        log.info("updating new server:{}",server.getName());

        return serverRepository.save(server);
    }

    @Override
    public Boolean deleteServer(Long id) {
        log.info("updating new server:{}",id);
        serverRepository.deleteById(id);
        return true;
    }

    @Override
    public Server ping(String ipAdresse) throws IOException {
        log.info("pinging server:{}",ipAdresse);
        Server server = serverRepository.findByIpAdresse(ipAdresse);
        InetAddress adresse = InetAddress.getByName(ipAdresse);
        server.setStatus(adresse.isReachable(10000)? Status.SERVER_UP:Status.SERVER_DOWN);
        serverRepository.save(server);
        return server;
    }



}
