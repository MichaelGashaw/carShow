package com.binary.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthenticationRequestDto {
    private String username;
    private String password;

    public AuthenticationRequestDto(String jwt) {
    }
}
