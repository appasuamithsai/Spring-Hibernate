package com.amith.librarymanagementsystem.dao;

import com.amith.librarymanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Book,Integer> {
}
