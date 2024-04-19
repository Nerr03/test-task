package block_io_api;

import helpers.CurrencyEnum;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BlockAPI {
    private final String cryptoApiKey = CurrencyEnum.LiteCoin.getCode();
    private final String getAddressEndPoint = "get_my_archived_addresses";
    private final String getAddressBalanceEndPoint = "get_address_balance";
    private final String newAddressLabelTypeEndPoint = "get_new_address";
    private final String getTransactionsEndPoint = "get_transactions";
    private final String walletLabel = "doMhkR";
    private RequestSpecification requestSpecification = given()
            .baseUri("https://block.io/api/v2/")
            .log().method()
            .log().uri()
            .log().body()
            .response()
            .log().body()
            .request();


    public Response getAllWalletsRequest(int pageNumber) {
        return requestSpecification
                .param("api_key", cryptoApiKey)
                .param("page", pageNumber)
                .get(getAddressEndPoint)
                .then()
                .log().all()
                .extract().response();
    }

    public Response getNewWalletRequest(String label) {
        return requestSpecification
                .param("api_key", cryptoApiKey)
                .param("label", label)
                .post(newAddressLabelTypeEndPoint)
                .then()
                .log().all()
                .extract().response();
    }

    public Response getTransactionHistoryRequest(String receivedOrSent) {
        return requestSpecification
                .param("api_key", cryptoApiKey)
                .param("type", receivedOrSent)
                .param("label", walletLabel)
                .get(getTransactionsEndPoint)
                .then()
                .log().all()
                .extract().response();
    }
    public Response getAddressBalanceRequest() {
        return requestSpecification
                .param("api_key", cryptoApiKey)
                .param("labels", walletLabel)
                .get(getAddressBalanceEndPoint)
                .then()
                .log().all()
                .extract().response();
    }
}
