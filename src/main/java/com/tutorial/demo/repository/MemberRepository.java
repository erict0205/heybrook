package com.tutorial.demo.repository;

import com.tutorial.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAll();

    List<Member> findByEmail(String email);
}
