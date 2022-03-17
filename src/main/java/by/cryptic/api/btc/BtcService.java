package by.cryptic.api.btc;

import by.cryptic.config.AppProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BtcService {

    @Autowired
    AppProperties appProperties;

    public List<String> getTransactionListByAddress(String address){
        RestTemplate restTemplate = new RestTemplate();
        return getInfoFromBlockChain(address, restTemplate);
    }


    private List<String> getInfoFromBlockChain(String accountId, RestTemplate restTemplate){
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity( appProperties.getBtcApi() +  accountId + "/txs", Object[].class);
        Object[] objects = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();

        List<BlockchainInfoItem> blockchainInfoItems = Arrays.stream(Objects.requireNonNull(objects))
                .map(object -> mapper.convertValue(object, BlockchainInfoItem.class))
                .collect(Collectors.toList());
        return blockchainInfoItems.stream().map(BlockchainInfoItem::getTxid).collect(Collectors.toList());
    }
}
