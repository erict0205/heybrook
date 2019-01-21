package com.tutorial.demo.repository;

import com.tutorial.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberApiRepository extends JpaRepository<Member, Long> {

}
