package com.patrick.savingsApp.resource;

import com.patrick.savingsApp.Response;
import com.patrick.savingsApp.model.Client;
import com.patrick.savingsApp.serviceImpl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.LocalTime.now;
import static net.bytebuddy.ClassFileVersion.of;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping( "/client")
public class ClientResource {

    private final ClientServiceImpl clientService;

    @Autowired
    public ClientResource(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveClient(@RequestBody Client client){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("clients", clientService.save(client)))
                        .message("Client Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
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
