package com.example.hackathon.rewards;

import com.example.hackathon.model.MyEmi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmiRepository extends JpaRepository<MyEmi,Long> {

    MyEmi findByCustomerId(int id);
}
