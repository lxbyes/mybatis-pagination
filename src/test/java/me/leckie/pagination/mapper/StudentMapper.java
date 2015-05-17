package me.leckie.pagination.mapper;

import java.util.List;
import java.util.Map;

import me.leckie.pagination.model.Student;

import org.apache.ibatis.session.RowBounds;

/**
 * 
 * @author leckie
 * @date May 11, 2015
 */
public interface StudentMapper extends Mapper<Student> {

    public List<Student> findAll(RowBounds rowbound, Student student,
            Map<String, Object> params, int i);

}
