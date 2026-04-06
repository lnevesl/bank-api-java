package Bank.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "contas")

public class ContaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    // UUID externo (não expõe o ID do banco)
    @Column(nullable = false, unique = true, updatable = false)
    private UUID identificador;

    @Column(nullable = false)
    private String nomeTitular;

    @Column(nullable = false, unique = true)
    private String cpfTitular;

    @Column
    private String telefoneTitular;

    @Column(nullable = false)
    private BigDecimal saldo = BigDecimal.ZERO;

    @Column(nullable = false)
    private Boolean ativo;
}