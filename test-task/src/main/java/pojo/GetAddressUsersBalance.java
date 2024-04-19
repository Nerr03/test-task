package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAddressUsersBalance {
    private int user_id;
    private String label;
    private String address;
    private String available_balance;
    private String pending_received_balance;
}
