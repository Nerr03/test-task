import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.GetAddressBalance;
import pojo.GetAllTransactions;
import pojo.GetAllTransactionsTx;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TransactionChangeTest extends BaseApiTest {

    @Test
    public void transactionChangeAmountTest() {
        double balanceBefore = getAddressBalance();

        int numberOfTransactionsBefore = getNumberOfTransactions();

        Optional<Double> changeAmountOptional = getLatestTransactionChangeAmount();
        Assert.assertTrue(changeAmountOptional.isPresent(), "No transaction found");

        int numberOfTransactionsAfter = getNumberOfTransactions();

        double changeAmount = changeAmountOptional.get();

        double balanceAfter = getAddressBalance();

        Assert.assertEquals(numberOfTransactionsBefore + 1, numberOfTransactionsAfter);
        Assert.assertEquals(balanceBefore + changeAmount, balanceAfter);
    }

    private double getAddressBalance() {
        Response getAddressBalanceResponse = blockAPI.getAddressBalanceRequest();
        return Double.parseDouble(getAddressBalanceResponse.as(GetAddressBalance.class)
                .getData().getAvailable_balance());
    }

    private int getNumberOfTransactions() {
        Response getTransactionHistoryResponse = blockAPI.getTransactionHistoryRequest("received");
        return getTransactionHistoryResponse.as(GetAllTransactions.class)
                .getData().getTxs().size();
    }

    private Optional<Double> getLatestTransactionChangeAmount() {
        Response getTransactionResponse = blockAPI.getTransactionHistoryRequest("received");
        List<GetAllTransactionsTx> allTransactions = getTransactionResponse.as(GetAllTransactions.class)
                .getData().getTxs();

        Optional<GetAllTransactionsTx> latestTransactionOptional = allTransactions.stream()
                .max(Comparator.comparingLong(GetAllTransactionsTx::getTime));

        return latestTransactionOptional.map(transaction -> transaction.getAmounts_received().get(0).getAmount());
    }
}