package com.kocfinans.kocfinans.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersModel {

    private String password;

    private String userName;

    private int active;
}
