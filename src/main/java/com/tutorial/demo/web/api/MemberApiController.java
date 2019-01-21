package com.tutorial.demo.web.api;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.tutorial.demo.domain.Member;
import com.tutorial.demo.model.MemberAccount;
import com.tutorial.demo.repository.MemberApiRepository;
import com.tutorial.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/memberApi")
public class MemberApiController {
    @Autowired
    private MemberAccount memberAccount;

    @Autowired
    private MemberApiRepository memberApiRepository;

    @RequestMapping("/memberTest")
    public MemberAccount memberTest() {
        MemberAccount memberAccount = new MemberAccount();
        memberAccount.setAddress("南投縣");
        memberAccount.setCellphone("0987987987");
        memberAccount.setEmail("test@gmail.com");
        memberAccount.setId(1);
        memberAccount.setPassword("98787");
        return memberAccount;
    }

    // *******

    @RequestMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public Optional<Member> read(@ModelAttribute("message") String msg, Model model, @PathVariable Long id) {
        Map map = new HashMap();
        String email = map.get("EMAIL").toString();
        if (email == null) throw new NullPointerException(email);
        System.err.println(email);

        Optional<Member> result = memberApiRepository.findById(id);
        return memberApiRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Member memberaccount) {
        memberApiRepository.save(memberaccount);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Member memberaccount) {
        memberApiRepository.save(memberaccount);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        memberApiRepository.deleteById(id);

    }

    // ************

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Page is not exsit")
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> notFound() {
        System.err.println("進入NullPointerException例外處理");
        return new ResponseEntity<Object>(
                "NOT FOUND THE DATA", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
