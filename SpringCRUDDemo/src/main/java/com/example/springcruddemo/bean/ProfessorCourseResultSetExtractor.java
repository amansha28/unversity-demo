package com.example.springcruddemo.bean;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProfessorCourseResultSetExtractor implements ResultSetExtractor<List<ProfessorCourses>> {


//    List<ProfessorCourses> resultList ;
    Set<ProfessorCourses> resultList ;
    @Override
    public List<ProfessorCourses> extractData(ResultSet rs) throws SQLException, DataAccessException {

    System.out.println("ResultSet size : "+rs.getFetchSize());
//        while(rs.next())
//        {
//            if(!resultList.isEmpty()){
//                if(resultList.contains(rs.getString("name"))){
//                    ProfessorCourses tempCourse = (ProfessorCourses) resultList.stream().filter(professorCourses -> {
//                        try {
//                            return rs.getString("name").equals(professorCourses.getName());
//                        } catch (SQLException e) {
//                            throw new RuntimeException(e);
//                        }
//                    });
//                    Set<String> tempSet = tempCourse.getCourses();
//                    tempSet.add(rs.getString("courses"));
//                    tempCourse.setCourses(tempSet);
//                    resultList.add(tempCourse);
//                }else {
//                    HashSet<String> tempSet = new HashSet<>();
//                    tempSet.add(rs.getString("courses"));
//                    ProfessorCourses courses = new ProfessorCourses(rs.getString("name"),tempSet);
//                }
//            }else {
//                HashSet<String> tempSet = new HashSet<>();
//                tempSet.add(rs.getString("courses"));
//                ProfessorCourses courses = new ProfessorCourses(rs.getString("name"),tempSet);
//            }
//        }
        return resultList.stream().collect(Collectors.toList());
    }
}
