package Bank.persistence.repositories;

import Bank.persistence.entities.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ContaRepository extends JpaRepository<ContaEntity, UUID> {

    Optional<ContaEntity> findByIdentificador(UUID identificador);
}

