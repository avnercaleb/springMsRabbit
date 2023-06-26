package msclients.controller;

import msclients.entities.Client;
import msclients.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.net.URI;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService service;
    @PostMapping
    public ResponseEntity createClient(@RequestBody Client client, UriComponentsBuilder uriBuilder) {
        Client c = service.createClient(client);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(c.getCpf())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Client> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(service.findByCpf(cpf)
                .orElseThrow(() -> new EntityNotFoundException()));
    }
}
