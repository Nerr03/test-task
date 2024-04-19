package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetNewWalletData {
    private String network;
    private Integer user_id;
    private String address;
    private String label;
}

