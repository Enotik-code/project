package by.cryptic.repository;

import by.cryptic.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Currency findByName(String name);
    Currency findByCode(String code);

    @Query("select c from Currency c where c.name like %?1%")
    List<Currency> findByNameLike(String name);

    @Query("select c from Currency c where c.code like %?1%")
    List<Currency> findByCodeLike(String code);

    @Query("select c from Currency c where c.name like %?1% or c.code like %?1%")
    List<Currency> findByNameOrCodeLike(String name);

    @Transactional
    @Query("delete from Currency c where c.name like %?1% or c.code like %?1%")
    void deleteByCode(String code);

    @Transactional
    @Query("update Currency c set c.name = ?1 where c.code = ?2")
    void updateNameByCode(String name, String code);

    @Transactional
    @Query("update Currency c set c.code = ?1 where c.name = ?2")
    void updateCodeByName(String code, String name);



}
