package com.dbproject.ezexam.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAuthedProfessor {
    private String Id;
    private String Name;
    private String LastName;
}
