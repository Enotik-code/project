package by.cryptic.api.eth;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class EthResult {
    public String blockNumber;
    public String timeStamp;
    public String hash;
    public String nonce;
    public String blockHash;
    public String transactionIndex;
    public String from;
    @JsonProperty("to")
    public String myto;
    public String value;
    public String gas;
    public String gasPrice;
    public String isError;
    public String txreceipt_status;
    public String input;
    public String contractAddress;
    public String cumulativeGasUsed;
    public String gasUsed;
    public String confirmations;
}

class Root{
    public String status;
    public String message;
    public ArrayList<EthResult> result;
}


