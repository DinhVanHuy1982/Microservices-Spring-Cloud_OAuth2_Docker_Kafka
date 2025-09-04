package huydv.jmaster.ClientRegisterService.Controller;

import huydv.jmaster.ClientRegisterService.Entity.Client;
import huydv.jmaster.ClientRegisterService.Repository.ClientRepository;
import jakarta.annotation.security.PermitAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PermitAll
public class ClientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/create-client")
    public Client createClient(@RequestBody Client client) {
        LOGGER.info("Creating client with Secret {}", client.getClientSecret());
        client.setClientSecret(new BCryptPasswordEncoder().encode(client.getClientSecret()));
        return clientRepository.save(client);
    }

    @GetMapping("/clients")
    public List<Client> findAllClients() {
        LOGGER.info("Finding all clients");
        return clientRepository.findAll();
    }

    @DeleteMapping("/delete-client")
    public void deleteClient(@RequestParam("clientId") String clientId) {
        LOGGER.info("Deleting client with id {}", clientId);
        this.clientRepository.deleteById(clientId);
    }
}
