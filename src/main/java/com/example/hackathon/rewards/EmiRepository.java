package com.example.hackathon.rewards;

import com.example.hackathon.model.MyTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmiRepository extends JpaRepository<MyTransaction,Long> {

    List<MyTransaction> findAllByCustomerId(int id);
}
