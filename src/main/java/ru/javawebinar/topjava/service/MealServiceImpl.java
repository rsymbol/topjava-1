package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.repository.mock.InMemoryMealRepositoryImpl;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;
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
    public void delete(int id) throws NotFoundException {
        repository.delete(id);
    }

    @Override
    public Meal get(int id) throws NotFoundException {

        long s = getAll().stream()
                .filter(meal -> meal.getId()==id)
                .count();

        if (s==0) {
            throw new NotFoundException("ID not found");
        } else {
            return repository.get(id);
        }
    }

    @Override
    public List<Meal> getAll() {

        return repository.getAll().stream()
                .filter(meal -> meal.getUserId()== AuthorizedUser.id())
                .collect(Collectors.toList());

    }

    @Override
    public void update(Meal meal) {
        repository.save(meal);
    }

}
