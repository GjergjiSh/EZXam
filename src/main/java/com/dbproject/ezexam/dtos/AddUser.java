package com.dbproject.ezexam.dtos;

import com.dbproject.ezexam.config.Role;
import io.swagger.annotations.ApiModelProperty;
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