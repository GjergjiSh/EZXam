package com.dbproject.ezexam.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class AddProfessor {
    private String Name;
    private String LastName;
    private String Username;
    private String Password;
}
