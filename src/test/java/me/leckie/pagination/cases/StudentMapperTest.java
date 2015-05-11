package me.leckie.pagination.cases;

import java.util.Date;

import javax.annotation.Resource;

import me.leckie.pagination.UnitTestBase;
import me.leckie.pagination.mapper.StudentMapper;
import me.leckie.pagination.model.Student;

import org.junit.Test;

/**
 * 
 * @author leckie
 * @date May 11, 2015
 */
public class StudentMapperTest extends UnitTestBase {

    @Resource
    private StudentMapper studentMapper;

    @Test
    public void save() {
        Student s = new Student();
        s.setName("Vickie");
        s.setGender(2);
        s.setBirthday(new Date());

        studentMapper.save(s);

        System.out.println(s);
    }

    @Test
    public void testPagination() {
        System.out.println(studentMapper.findOne(1L));
    }
}
