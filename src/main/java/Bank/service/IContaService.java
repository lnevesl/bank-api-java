package Bank.service;

import Bank.dto.ContaDto;
import Bank.dto.CreateContaRequest;
import Bank.dto.TransferirContaRequest;

import java.math.BigDecimal;
import java.util.UUID;

public interface IContaService {

    void createConta(CreateContaRequest createContaRequest);

    void depositar(UUID contaId, ContaDto amount);

    void sacar(UUID contaId, BigDecimal amount);

    void transferir(TransferirContaRequest transferirContaRequest);

    ContaDto getContaService(UUID identificador);


}
