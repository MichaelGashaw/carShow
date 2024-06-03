package com.binary.controller;

import com.binary.config.JwtUtil;
import com.binary.config.MemberDetailsService;
import com.binary.dto.AuthenticationRequestDto;
import com.binary.dto.AuthenticationResponceDto;
import com.binary.entity.Member;
import com.binary.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    @Autowired
    private MemberServiceImpl memberService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MemberDetailsService memberDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<Object> registerMember(@RequestBody Member member) {
        return new ResponseEntity<>(memberService.createMember(member), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<Object> CreateMemberAuthToken(@RequestBody AuthenticationRequestDto authenticationRequestDto) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequestDto.getUsername(), authenticationRequestDto.getPassword())
            );

        }catch (Exception e) {
            throw new Exception("Invalid username or password", e);
        }
        final UserDetails userDetails = memberDetailsService.loadUserByUsername(authenticationRequestDto.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return new ResponseEntity<>(new AuthenticationResponceDto(jwt), HttpStatus.ACCEPTED);
    }

}
