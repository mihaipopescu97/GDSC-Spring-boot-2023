package com.example.gdscspringboot2023.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FirstService {

    public void t1() {
        log.info("First log");
    }
}
