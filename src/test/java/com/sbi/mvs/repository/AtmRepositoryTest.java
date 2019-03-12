package com.sbi.mvs.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AtmRepositoryTest {

    @Autowired
    private AtmRepository atmRepository;

    @Test
    public void testOne()
    {
        atmRepository.findAll();
    }
}