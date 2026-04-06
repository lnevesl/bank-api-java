package Bank.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class TransferirContaRequest {

    private UUID fromContaId;
    private UUID toContaId;
    private BigDecimal valor;


}
