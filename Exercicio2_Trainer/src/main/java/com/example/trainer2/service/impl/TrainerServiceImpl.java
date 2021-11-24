package com.example.trainer2.service.impl;

import com.example.trainer2.model.Trainer;
import org.springframework.stereotype.Service;
import com.example.trainer2.service.TrainerService;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Override
    public List<Trainer> listTrainer() {
        return Arrays.asList(new Trainer("Marcos"), new Trainer("Ana"));
    }
}
