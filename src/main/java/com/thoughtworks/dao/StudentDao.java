package com.thoughtworks.dao;

import com.thoughtworks.domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudents();
}
