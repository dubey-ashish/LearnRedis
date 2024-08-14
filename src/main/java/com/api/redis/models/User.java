package com.api.redis.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

//Object which is saved has to be Serialisable otherwise it'll not be saved
public class User implements Serializable
{
    private String userId;
    private String name;
    private String phone;
    private String email;

    //No need to create getters, setters etc 'coz it'll be handled by Lombok




}
