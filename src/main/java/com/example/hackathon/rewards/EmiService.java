package com.example.hackathon.rewards;

import com.example.hackathon.model.MyEmi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmiService {
    @Autowired
    private EmiRepository emiRepository;

    public MyEmi save(MyEmi myEmi){
        return emiRepository.save(myEmi);
    }

    public MyEmi getEmi(int id){
        return emiRepository.findByCustomerId(id);
    }
}
