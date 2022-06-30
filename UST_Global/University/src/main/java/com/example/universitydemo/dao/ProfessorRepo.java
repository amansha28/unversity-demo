package com.example.universitydemo.dao;

import com.example.universitydemo.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepo extends JpaRepository<Professor, Integer> {
}
