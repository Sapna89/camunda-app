package com.workflow.services;

import org.springframework.stereotype.Component;

/*
Using Service Task: Expression:
    trying to invoke getUserDeparment() method from BPMN
    without UserDepartmentService implementing JavaDelegate
*/
@Component
public class UserDepartmentService {
    public String getUserDeparment() {
        System.out.println("coming from User Department Service class");
        return "Accounts";
    }
}
