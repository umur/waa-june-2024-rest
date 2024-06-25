package miu.waa.restful.repository;

import lombok.RequiredArgsConstructor;
import miu.waa.restful.service.Predicate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public abstract class DefaultRepository<T> {
    protected final List<T> repo = new ArrayList<>();

    public T create(T item) {
        this.repo.add(item);
        return item;
    }

    public List<T> getMany() {
        return repo;
    }

    public List<T> getMany(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : repo) {
            if (predicate.test(t)) result.add(t);
        }
        return result;
    }

    public T getOne(Predicate<T> predicate) {
        for (T t : repo) {
            if (predicate.test(t)) return t;
        }
        return null;
    }

    public void update(Predicate<T> predicate, T t) {
        T item = getOne(predicate);
        if (item == null) throw new RuntimeException("Entry not found!");
        int index = repo.indexOf(item);
        repo.set(index, t);
    }

    public void delete(Predicate<T> predicate) {
        T item = getOne(predicate);
        if (item == null) throw new RuntimeException("Entry not found!");
        repo.remove(item);
    }
}
