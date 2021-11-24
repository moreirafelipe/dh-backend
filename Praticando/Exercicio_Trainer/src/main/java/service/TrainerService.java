package service;

import model.Trainer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TrainerService {

    List<Trainer> listTrainer();
}
