package Bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateContaRequest {

    private String cpfTitular;
    private String nomeTitular;
    private String telefoneTitular;


}
