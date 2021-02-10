package com.vastika.util;

public class QueryUtil {
    public static final String Save_SQL="insert into user_table(user_name,password,mobile_no,salary,enable,dob) values(?,?,?,?,?,?)";
    public static final String Update_SQL="update user_table set user_name=?,password=?,mobile_no=?,salary=?,enable=?,dob=? where id =?";
    public static final String Delete_SQL="Delete from user_table where id =?";
    public static final String List_SQL="select *from user_table";
    public static final String Get_By_Id_SQL="select * from user_table where id =?";

}
