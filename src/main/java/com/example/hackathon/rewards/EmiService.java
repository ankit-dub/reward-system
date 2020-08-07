package com.example.hackathon.rewards;

import com.example.hackathon.model.MyTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmiService {
    @Autowired
    private EmiRepository emiRepository;

    public MyTransaction save(MyTransaction myTransaction){
        return emiRepository.save(myTransaction);
    }

    public List<MyTransaction> getTransactionAll(int id){
        return emiRepository.findAllByCustomerId(id);
    }
}
