package huydv.jmaster.ClientRegisterService.Repository;

import huydv.jmaster.ClientRegisterService.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findClientById(String id);
    void deleteClientById(String id);
}
