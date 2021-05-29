package by.mybot.payment.service;

import by.mybot.payment.bean.Operation;
import by.mybot.payment.bean.OperationEnum;
import by.mybot.payment.repository.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationService {

    private OperationRepository operationRepository;

    public List<Operation> getAllOperations(){
        return operationRepository.findAllOperation();
    }
}
