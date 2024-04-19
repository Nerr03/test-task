package helpers;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CurrencyEnum {
    LiteCoin("Litecoin (TESTNET!)", "f150-0dbf-2cf1-b72c"),
    BitCoin("Bitcoin (TESTNET!)", "38b7-a086-8631-61f0"),
    DogeCoin("Dogecoin (TESTNET!)", "37c2-6568-be27-49f7");
    private String name;
    private String code;

    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }


}
