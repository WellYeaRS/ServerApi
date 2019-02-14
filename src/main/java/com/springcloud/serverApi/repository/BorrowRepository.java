package com.springcloud.serverApi.repository;

import com.springcloud.serverApi.entity.Borrow;
import com.springcloud.serverApi.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow,Long>{
    Page<Borrow> findAll(Specification<Borrow> spec, Pageable pageable);
}
