package com.tutorial.demo.repository;

import com.tutorial.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {

    List<Member> findAll();

    List<Member> findByEmail(String email);

    @Query(value = "select * from member " +
            "where email_ = ?1 and password_ = ?2", nativeQuery = true)
    List<Member> findCheckMemberAccount(String email, String password);

}
