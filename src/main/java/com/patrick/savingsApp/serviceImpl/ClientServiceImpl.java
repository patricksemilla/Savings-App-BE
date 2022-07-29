package com.patrick.savingsApp.serviceImpl;


import com.patrick.savingsApp.Repo.ClientRepo;
import com.patrick.savingsApp.model.Client;
import com.patrick.savingsApp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    private final ClientRepo repo;

    @Autowired
    public ClientServiceImpl(ClientRepo repo) {
        this.repo = repo;
    }

    @Override
    public Client save(Client client) {
    return repo.save(client);
    }

    @Override
    public Client findById(long id) {
        Optional<Client> clientOptional = repo.findById(id);

        return clientOptional.orElse(null);
    }
    @Override
    public Client deleteById(long id) {
        Client client = findById(id);

        if(client == null) return null;

        repo.deleteById(id);

        return client;
    }

    @Override
    public List<Client> data() {
        return repo.findAll();
    }

    public List<Client> findAllClient() {
        return repo.findAll();
    }


}
