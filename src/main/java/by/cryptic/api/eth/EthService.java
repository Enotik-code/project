package by.cryptic.api.eth;

import by.cryptic.config.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class EthService {

    @Autowired
    AppProperties appProperties;

    public List<String> getTransactionListByAddress(String ethAddress) {
        RestTemplate restTemplate = new RestTemplate();
        List<String> ethBlockchainTransactions = new ArrayList<>();
        Root root = getInfoFromBlockChain(ethAddress, restTemplate);
        for (EthResult results : root.result) {
            ethBlockchainTransactions.add(results.hash);
        }
        return ethBlockchainTransactions;
    }

    private Root getInfoFromBlockChain(String accountId, RestTemplate restTemplate) {
        return restTemplate.getForObject(appProperties.getEthApi() + accountId, Root.class);
    }

}
