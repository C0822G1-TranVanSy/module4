package com.codegym.exam3.repository;

import com.codegym.exam3.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMemberRepository extends JpaRepository<Member,Integer> {
}
