package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * GKislin
 * 15.09.2015.
 */

@Repository
public class InMemoryMealRepositoryImpl implements MealRepository {
    private Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.MEALS.forEach(this::save);
    }

    @Override
    public Meal save(Meal meal) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
        }
        repository.put(meal.getId(), meal);
        return meal;
    }

    @Override
    public void delete(int id, int userID) {

        Meal meal = repository.get(id);
        if (meal.getUserId() == userID) repository.remove(id);

    }

    @Override
    public Meal get(int id, int userID) {

        Meal meal = repository.get(id);
        return meal.getUserId() == userID ? repository.get(id): null;

    }

    @Override
    public List<Meal> getAll(int userID) {
        return repository.values().stream()
                .filter(meal -> meal.getUserId() == userID)
                .sorted((o1, o2) -> o1.getDateTime().isBefore(o2.getDateTime()) ? 1 : -1)
                .collect(Collectors.toList());
    }
}


