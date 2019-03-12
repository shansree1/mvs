package com.sbi.mvs.repository;

import com.sbi.mvs.entity.ATM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmRepository extends JpaRepository<ATM,Long> {



}
