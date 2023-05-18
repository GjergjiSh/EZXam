package com.dbproject.ezexam.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class AddProfessor {
    @NonNull
    private String Name;
    @NonNull
    private String LastName;
    @NonNull
    private String Username;
    @NonNull
    private String Password;
}
