package msclients.service;

import msclients.entities.Client;
import msclients.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repo;
    @Transactional
    public Client createClient(Client client) {
        return repo.save(client);
    }

    public Optional<Client> findByCpf(String cpf) {
        return repo.findByCpf(cpf);
    }
}
