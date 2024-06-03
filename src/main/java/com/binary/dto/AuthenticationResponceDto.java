package com.binary.dto;

import lombok.Getter;

@Getter
public class AuthenticationResponceDto {

    private final String token;

    public AuthenticationResponceDto(String token) {
        this.token = token;
    }
}
