package me.leckie.pagination.mapper;

/**
 * 
 * @author leckie
 * @date May 11, 2015
 */
public interface Mapper<T> {

    public void save(T t);

    public void update(T t);

    public void delete(Long id);

    public T findOne(Long id);
}
