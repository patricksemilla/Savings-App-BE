package com.patrick.savingsApp.resource;

import com.patrick.savingsApp.model.Client;
import com.patrick.savingsApp.serviceImpl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping( "/client")

public class ClientResource {

    private final ClientServiceImpl clientService;

    @Autowired
    public ClientResource(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }


    @GetMapping
    public ResponseEntity<List<Client>> getAllClient() {
        List<Client> client = clientService.findAllClient();
        HashMap<String, List<Client>> parasayoto = new HashMap<>();

        parasayoto.put("data", client);
        System.out.println(client.size());
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
}
