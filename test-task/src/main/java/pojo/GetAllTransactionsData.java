package pojo;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllTransactionsData {
    private String network;
    private ArrayList<GetAllTransactionsTx> txs;
}
