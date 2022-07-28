package com.patrick.savingsApp.service;

import com.patrick.savingsApp.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClientService {

        boolean save(Client client);

        Client findById(long id);

        Client deleteById(long id);

        List<Client> data();


}
