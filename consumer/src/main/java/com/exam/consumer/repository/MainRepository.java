package com.exam.consumer.repository;

import com.exam.consumer.model.MainModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepository extends JpaRepository<MainModel, Integer> {
}
