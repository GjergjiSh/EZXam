package com.dbproject.ezexam.dtos;

import lombok.Data;
import lombok.NonNull;

@Data
public class AddProfessor {
    private String Name;
    private String LastName;
    private String Username;
    private String Password;
}
