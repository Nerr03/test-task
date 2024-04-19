package pojo;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllWalletData {
    private String network;
    private ArrayList<GetAllWalletAddress> addresses;
    private Integer page;
    private Boolean hasMore;
}
