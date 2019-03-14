package com.sbi.mvs.repository;

import com.sbi.mvs.entity.ATM;
import com.sbi.mvs.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtmRepository extends JpaRepository<ATM,String> {

    List<ATM> findByOwnerBranch(Branch branch);

    List<ATM> findByCashLinkBranch(Branch branch);

}
