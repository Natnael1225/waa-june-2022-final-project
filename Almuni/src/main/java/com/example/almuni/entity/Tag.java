package com.example.almuni.entity;

import lombok.Data;

import java.util.List;


@Data
//@Embeddable
public class Tag {

    private Long id;
    private List<String> titles;

}
