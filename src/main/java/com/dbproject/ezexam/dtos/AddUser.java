package com.dbproject.ezexam.dtos;

import com.dbproject.ezexam.config.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class AddUser {
    private String Username;
    private String Password;
    private Role role;
}