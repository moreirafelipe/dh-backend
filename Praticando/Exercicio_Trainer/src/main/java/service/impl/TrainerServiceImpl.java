package service.impl;

import com.example.trainer.TrainerApplication;
import model.Trainer;
import org.springframework.boot.SpringApplication;
import service.TrainerService;

import java.util.Arrays;
import java.util.List;

public class TrainerServiceImpl implements TrainerService {
    @Override
    public List<Trainer> listTrainer() {
        return Arrays.asList(new Trainer("Marcos"), new Trainer("Ana"));
    }
}
