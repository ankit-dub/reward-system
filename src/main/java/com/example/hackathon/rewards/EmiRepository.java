package com.example.hackathon.rewards;

import com.example.hackathon.model.MyTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmiRepository extends JpaRepository<MyTransaction,Long> {

}
