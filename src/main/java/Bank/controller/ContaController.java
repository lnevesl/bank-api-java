package Bank.controller;


import Bank.dto.ContaDto;
import Bank.dto.CreateContaRequest;
import Bank.dto.TransferirContaRequest;
import Bank.service.IContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ContaController {

    private final IContaService iContaService;

    @PostMapping(path = "/conta")
    public String createConta(@RequestBody CreateContaRequest createContaRequest) {
        if (createContaRequest.getNomeTitular() == null) {
            return "O Campo Nome do Titular é obrigatório!";
        }
        if (createContaRequest.getCpfTitular() == null) {
            return "O Campo CPF do Titular é obrigatório!";
        }
        iContaService.createConta(createContaRequest);
        return "Conta Cadastrada com Sucesso!";

    }

    @PostMapping("/depositar/{id}")
    public String depositar(
            @PathVariable UUID id,
            @RequestBody ContaDto contaDto
    ) {

        iContaService.depositar(id, contaDto);
        return "Deposito efetuado com sucesso!";
    }

    @PostMapping("/{id}/sacar")
    public String sacar(@PathVariable UUID id,
                        @RequestBody BigDecimal valor) {
        iContaService.sacar(id, valor);
        return "Saque efetuado com sucesso!";
    }

    @PostMapping("/transferencia")
    public String transferir(@RequestBody TransferirContaRequest transferirContaRequest) {
        iContaService.transferir(transferirContaRequest);
        return "Transferência efetuada com sucesso!";
    }

    @GetMapping("/{uuid}")
    public ContaDto getConta(@PathVariable UUID uuid) {
        return iContaService.getContaService(uuid);
    }
}
