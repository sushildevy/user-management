package com.vastika.controller;

import com.vastika.enums.OperationTypeEnum;
import com.vastika.model.User;
import com.vastika.service.UserService;
import com.vastika.service.UserServiceImpl;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserController {
    public static void main(String[] args) {
        UserService userService =new UserServiceImpl();
        String decisions ="no";
        do{
            String operation = JOptionPane.showInputDialog("Enter operations: save| update | delete | list | get");
            switch(operation){
                case "save":
                    User savedUser=getUser(OperationTypeEnum.SAVE.name());
                    int saved=userService.saveUser(savedUser);
                    if(saved >=1 ){
                        JOptionPane.showMessageDialog(null,"user info is saved in db successfully!!!");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"opps!!!error in db");

                    }
                    break;
                case "delete":
                     int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
                     int deleted=userService.deleteUser(id) ;
                     if(deleted>=1){
                         JOptionPane.showMessageDialog(null,"user info is deleted from db successfully!!!!");
                     }
                     else{
                            JOptionPane.showMessageDialog(null,"opps!!!error");
                     }



                    break;
                case "update":
                    User updatedUser=getUser(OperationTypeEnum.UPDATE.name());
                    int updated=userService.updateUser(updatedUser);
                    if(updated >=1 ){
                        JOptionPane.showMessageDialog(null,"user info is updated in db successfully!!!");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"opps!!!error in db");

                    }
                    break;
                case "list":
                    userService.getAllUser().forEach(user ->{
                        System.out.println("user id is: "+ user.getId());
                        System.out.println("user name is: "+ user.getUsername());
                        System.out.println("user password is: "+ user.getPassword());
                        System.out.println("user mobile no is: "+ user.getMobileNo());
                        System.out.println("user date of birth is: "+ user.getDob());
                        System.out.println("user salary is: "+ user.getSalary());
                        System.out.println("is user enable? "+ user.isEnable());
                        System.out.println("===============================");
                        });
                    break;
                case "get":
                    id=Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
                    User user =userService.getUserById(id);
                    System.out.println("user id is: "+ user.getId());
                    System.out.println("user name is: "+ user.getUsername());
                    System.out.println("user password is: "+ user.getPassword());
                    System.out.println("user mobile no is: "+ user.getMobileNo());
                    System.out.println("user date of birth is: "+ user.getDob());
                    System.out.println("user salary is: "+ user.getSalary());
                    System.out.println("is user enable? "+ user.isEnable());
                    System.out.println("===============================");
                    break;



            }
            decisions=JOptionPane.showInputDialog("do you want to continue? yes|no");

        }
        while(decisions.equalsIgnoreCase("yes") );
}
    public static User getUser(String type) {
        User user = new User();
        if(type.equalsIgnoreCase("update")){
            int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
            user.setId(id);
        }
        String username =JOptionPane.showInputDialog("Enter username: ");
        String password =JOptionPane.showInputDialog("Enter password: ");
        double salary=Double.parseDouble(JOptionPane.showInputDialog("Enter salary: "));
        long mobileN0=Long.parseLong(JOptionPane.showInputDialog("Enter mobile no: "));
        boolean enable=Boolean.parseBoolean(JOptionPane.showInputDialog("is user enable? "));
        String dob=JOptionPane.showInputDialog("Enter dob: format=>yyyy-MM-dd ");
        LocalDate ld=LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        user.setUsername(username);
        user.setPassword(password);
        user.setSalary(salary);
        user.setMobileNo(mobileN0);
        user.setEnable(enable);
        user.setDob(ld);

        return user;
    }
}