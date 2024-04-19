import helpers.RandomNameGenerator;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import pojo.GetAllWallet;
import pojo.GetAllWalletData;
import pojo.GetNewWallet;

import static helpers.AssertHelper.asserStatusCodeAndContentType;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class GenerateNewAddressTests extends BaseApiTest {
    @Test
    public void generateNewAddressTest() {
        Response getAllWalletsResponse = blockAPI.getAllWalletsRequest(1);
        GetAllWalletData getAllWalletData = getAllWalletsResponse.as(GetAllWallet.class).getData();
        String newAddressLabel = RandomNameGenerator.generateRandomName();
        Response getNewWalletsResponse = blockAPI.getNewWalletRequest(newAddressLabel);
        asserStatusCodeAndContentType(getNewWalletsResponse, HttpStatus.SC_OK, ContentType.JSON);
        GetNewWallet newWallet = getNewWalletsResponse.as(GetNewWallet.class);
        assertEquals(newWallet.getData().getLabel(), newAddressLabel, "Address label" );
        Response getAllWalletsResponseAfterCreate = blockAPI.getAllWalletsRequest(1);
        GetAllWalletData getAllWalletDataAfterCreate = getAllWalletsResponseAfterCreate.as(GetAllWallet.class).getData();
        assertEquals(getAllWalletDataAfterCreate.getAddresses().size(),
                getAllWalletData.getAddresses().size()+1, "Wallet list size");
    }
}
