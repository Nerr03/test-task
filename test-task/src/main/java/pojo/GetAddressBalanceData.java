package pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetAddressBalanceData {
    private String network;
    private String available_balance;
    private String pending_received_balance;
    private ArrayList<GetAddressUsersBalance> balances;
}

