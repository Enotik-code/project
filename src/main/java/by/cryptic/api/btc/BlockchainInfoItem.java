package by.cryptic.api.btc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BlockchainInfoItem{
    private int locktime;
    private int size;
    private int fee;
    private String txid;
    private int weight;
    private List<VinItem> vin;
    private int version;
    private List<VoutItem> vout;
    private Status status;
}

@Data
class VinItem{
    private String scriptsig;
    private List<String> witness;
    private long sequence;
    @JsonProperty(value = "inner_redeemscript_asm")
    private String innerRedeemscriptAsm;
    @JsonProperty(value = "inner_witnessscript_asm")
    private String innerWitnessscriptAsm;
    @JsonProperty(value = "scriptsig_asm")
    private String scriptsigAsm;
    private Prevout prevout;
    @JsonProperty(value = "is_coinbase")
    private boolean isCoinbase;
    private String txid;
    private Long vout;
}

@Data
class VoutItem{
    @JsonProperty(value = "scriptpubkey_address")
    private String scriptpubkeyAddress;
    private String scriptpubkey;
    @JsonProperty(value = "scriptpubkey_asm")
    private String scriptpubkeyAsm;
    @JsonProperty(value = "scriptpubkey_type")
    private String scriptpubkeyType;
    private Long value;
}

@Data
class Status{
    @JsonProperty(value = "block_time")
    private int blockTime;
    @JsonProperty(value = "block_hash")
    private String blockHash;
    @JsonProperty(value = "block_height")
    private int blockHeight;
    private boolean confirmed;
}

@Data
class Prevout{
    @JsonProperty(value = "scriptpubkey_address")
    private String scriptpubkeyAddress;
    private String scriptpubkey;
    @JsonProperty(value = "scriptpubkey_asm")
    private String scriptpubkeyAsm;
    @JsonProperty(value = "scriptpubkey_type")
    private String scriptpubkeyType;
    private Long value;
}



