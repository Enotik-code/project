package by.cryptic.service;

import by.cryptic.entities.Wallet;
import by.cryptic.repository.WalletRepository;
import com.google.common.hash.Hashing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

@Service
@Slf4j
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public void createWallet(Wallet wallet) {
        walletRepository.save(wallet);
        log.info("Wallet created");
    }

    public List<Wallet> getWallets(String sign) {
        return walletRepository.findAllBySign(sign);
    }

    public String generateAddress(String userLogin){
        Supplier<String> apiKey = () -> {
            StringBuilder token = new StringBuilder();
            long currentTimeInMilisecond = Instant.now().toEpochMilli();
            return token.append(currentTimeInMilisecond).append("-")
                    .append(UUID.randomUUID()).toString();
        };

        return Hashing.sha256()
                .hashString(apiKey.get() + userLogin, StandardCharsets.UTF_8)
                .toString();

    }

    public List<Wallet> getAllWallets(){
        return walletRepository.findAll();
    }
}
