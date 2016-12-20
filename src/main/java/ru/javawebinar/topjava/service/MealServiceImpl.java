package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.repository.mock.InMemoryMealRepositoryImpl;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;


/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class MealServiceImpl implements MealService {

    private MealRepository repository = new InMemoryMealRepositoryImpl();

    @Override
    public Meal save(Meal meal) {
        return repository.save(meal);
    }

    @Override
    public void delete(int id, int userID) throws NotFoundException {
        repository.delete(id, userID);
    }

    @Override
    public Meal get(int id, int userID) throws NotFoundException {
        return repository.get(id, userID);
    }

    @Override
    public List<Meal> getAll(int userID) {

        return repository.getAll(userID);

    }

    @Override
    public void update(Meal meal) {
        repository.save(meal);
    }

}
