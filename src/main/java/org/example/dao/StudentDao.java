package org.example.dao;

import org.example.domain.Student;

public interface StudentDao {
    //查询一个学生
    Student selectStudentById(Integer id);
    //添加学生
    //返回值代表影响数据库的行数
    int insertStudent(Student student);
}
