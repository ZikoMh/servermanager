package com.example.server.dao.entity;

import com.example.server.dao.enumeration.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "Ip cannot be empty")
    private String ipAdresse;
    private String  name;
    private String type;
    private String memory;
    private String imageURL;
    private Status status;
}
