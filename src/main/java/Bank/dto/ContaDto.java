package Bank.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContaDto {

    private UUID id;
    private String nomeTitular;
    private String cpfTitular;
    private BigDecimal saldo;
}
