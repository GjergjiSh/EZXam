package com.dbproject.ezexam.dto;

import com.dbproject.ezexam.configuration.Role;
import lombok.Data;
import lombok.NonNull;

@Data
public class AddUser {
    @NonNull
    private String Username;
    @NonNull
    private String Password;
    @NonNull
    private Role role;
}