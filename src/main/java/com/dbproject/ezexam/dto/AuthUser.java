package com.dbproject.ezexam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class AuthUser {
    private String Username;
    private String Password;
}
