package by.mybot.payment.service;

import by.mybot.payment.bean.Operation;
import by.mybot.payment.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    public List<Operation> getAllOperations(){
        return operationRepository.findAll();
    }
}
