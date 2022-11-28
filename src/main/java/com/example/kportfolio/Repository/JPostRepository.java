package com.example.kportfolio.Repository;

import com.example.kportfolio.model.JPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPostRepository extends JpaRepository<JPost,Long> {
    JPostRepository findByPost(String post);

    void deleteById(Long id);
}
