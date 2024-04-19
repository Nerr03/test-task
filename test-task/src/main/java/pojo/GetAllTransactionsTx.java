package pojo;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllTransactionsTx {

    private String txid;
    private boolean from_green_address;
    private long time;
    private int confirmations;
    private ArrayList<GetAllTransactionsAmountsReceived> amounts_received;
    private ArrayList<String> senders;
    private double confidence;
    private Object propagated_by_nodes;

}
