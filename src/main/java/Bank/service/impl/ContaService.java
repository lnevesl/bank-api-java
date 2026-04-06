package Bank.service.impl;


import Bank.dto.ContaDto;
import Bank.dto.CreateContaRequest;
import Bank.dto.TransferirContaRequest;
import Bank.persistence.entities.ContaEntity;
import Bank.persistence.repositories.ContaRepository;
import Bank.service.IContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContaService implements IContaService {

    private final ContaRepository contaRepository;

    @Override
    public void createConta(CreateContaRequest createContaRequest) {

        ContaEntity conta = new ContaEntity();

        conta.setNomeTitular(createContaRequest.getNomeTitular());
        conta.setCpfTitular(createContaRequest.getCpfTitular());
        conta.setTelefoneTitular(createContaRequest.getTelefoneTitular());
        conta.setAtivo(true);
        conta.setSaldo(BigDecimal.ZERO);

        // UUID gerado automaticamente
        conta.setIdentificador(UUID.randomUUID());

        contaRepository.save(conta);
    }

    @Override
    public void depositar(UUID contaId, ContaDto contaDto) {

        ContaEntity conta = contaRepository.findById(getContaId(contaId))
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        if (contaDto.getSaldo() == null || contaDto.getSaldo().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Valor de depósito inválido");
        }

        conta.setSaldo(conta.getSaldo().add(contaDto.getSaldo()));

        contaRepository.save(conta);
    }

    private static UUID getContaId(UUID contaId) {
        return contaId;
    }

    @Override
    public void sacar(UUID contaId, BigDecimal valor) {

        ContaEntity conta = contaRepository.findById(contaId)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        if (conta.getSaldo().compareTo(valor) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        conta.setSaldo(conta.getSaldo().subtract(valor));

        contaRepository.save(conta);
    }

    @Override
    public void transferir(TransferirContaRequest transferirContaRequest) {

        ContaEntity from = contaRepository
                .findByIdentificador(transferirContaRequest.getFromContaId())
                .orElseThrow(() -> new RuntimeException("Conta origem não encontrada"));

        ContaEntity to = contaRepository
                .findByIdentificador(transferirContaRequest.getToContaId())
                .orElseThrow(() -> new RuntimeException("Conta destino não encontrada"));

        if (from.getSaldo().compareTo(transferirContaRequest.getValor()) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        from.setSaldo(from.getSaldo().subtract(transferirContaRequest.getValor()));
        to.setSaldo(to.getSaldo().add(transferirContaRequest.getValor()));

        contaRepository.save(from);
        contaRepository.save(to);
    }

    @Override
    public ContaDto getContaService(UUID identificador) {

        ContaEntity contaEntity = contaRepository.findByIdentificador(identificador)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        ContaDto contaDto = new ContaDto();
        contaDto.setId(contaEntity.getIdentificador());
        contaDto.setNomeTitular(contaEntity.getNomeTitular());
        contaDto.setCpfTitular(contaEntity.getCpfTitular());
        contaDto.setSaldo(contaEntity.getSaldo());

        return contaDto;
    }

}