package org.restAssured.pojo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
