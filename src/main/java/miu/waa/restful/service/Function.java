package miu.waa.restful.service;

public interface Function<T, R> {
    R apply(T t);
}
