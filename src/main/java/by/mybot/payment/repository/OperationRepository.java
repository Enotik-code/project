package by.mybot.payment.repository;

import by.mybot.consts.SqlQuery;
import by.mybot.payment.bean.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OperationRepository{

    @Transactional
    @Query(value = SqlQuery.GET_ALL_OPERATIONS)
    List<Operation> findAllOperation();

    Operation getOperationById(Long operationId);
}
