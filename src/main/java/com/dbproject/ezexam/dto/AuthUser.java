package com.dbproject.ezexam.dto;

import com.dbproject.ezexam.configuration.Role;
import lombok.Data;
import lombok.NonNull;

@Data
public class AuthUser {
    @NonNull
    private String Username;
    @NonNull
    private String Password;
}
