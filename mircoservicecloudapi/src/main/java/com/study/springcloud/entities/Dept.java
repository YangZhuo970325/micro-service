package com.study.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable{
    private  Long      deptNo;
    private  String    dName;
    private  String    db_source;

    public Dept(String dName){
        super();
        this.dName = dName;
    }


}
