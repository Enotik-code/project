package by.cryptic.repository;

import by.cryptic.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {
    Card findByCardNumber(String cardNumber);
}
