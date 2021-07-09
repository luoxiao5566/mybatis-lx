package com.thoughtworks;

import com.thoughtworks.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws IOException {
        String config = "mybatis.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        String sqlId = "com.thoughtworks.dao.StudentDao"+"."+"selectStudents";
        List<Student> students = sqlSession.selectList(sqlId);
        students.stream().forEach(student -> System.out.println(student));
        sqlSession.close();
    }
}
