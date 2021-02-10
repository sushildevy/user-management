package com.vastika.dao;

import com.vastika.model.User;
import com.vastika.util.DBUtil;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.vastika.util.QueryUtil.*;

public class UserDaoImpl implements UserDao{

    @Override
    public int saveUser(User user) {
        int saved=0;
        try(PreparedStatement ps= DBUtil.getConnection().prepareStatement(Save_SQL)) {
        ps.setString(1,user.getUsername());
        ps.setString(2,user.getPassword());
        ps.setLong(3,user.getMobileNo());
        ps.setDouble(4,user.getSalary());
        ps.setBoolean(5,user.isEnable());
        ps.setDate(6, Date.valueOf(user.getDob()));
        saved=ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } ;
        return saved;
    }

    @Override
    public int updateUser(User user) {
        int update=0;
        try(PreparedStatement ps= DBUtil.getConnection().prepareStatement(Update_SQL)) {
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setLong(3,user.getMobileNo());
            ps.setDouble(4,user.getSalary());
            ps.setBoolean(5,user.isEnable());
            ps.setDate(6, Date.valueOf(user.getDob()));
            ps.setInt(7,user.getId());
            update=ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } ;
        return update;
    }

    @Override
    public int deleteUser(int id) {
        int delete=0;
        try(PreparedStatement ps= DBUtil.getConnection().prepareStatement(Delete_SQL)) {
            ps.setInt(1,id);
            delete=ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } ;
        return delete;
    }

    @Override
    public User getUserById(int id) {
        User tmpUser =new User();
        try(PreparedStatement ps= DBUtil.getConnection().prepareStatement(Get_By_Id_SQL)) {
            ps.setInt(1, id);
            ResultSet rs =ps.executeQuery();
            if(rs.next()){

                tmpUser.setId(rs.getInt("id"));
                tmpUser.setUsername (rs.getString("user_name"));
                tmpUser.setPassword(rs.getString("password"));
                tmpUser.setEnable(rs.getBoolean("enable"));
                tmpUser.setMobileNo(rs.getLong("mobile_no"));
                tmpUser.setSalary(rs.getDouble("salary"));
                tmpUser.setDob(rs.getDate("dob").toLocalDate());

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } ;
        return tmpUser;
    }

    @Override
    public List<User> getAllUser() {
        List<User>userList=new ArrayList<>();
        try(PreparedStatement ps= DBUtil.getConnection().prepareStatement(List_SQL)) {
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                User user =new User();
                user.setId(rs.getInt("id"));
                user.setUsername (rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setEnable(rs.getBoolean("enable"));
                user.setMobileNo(rs.getLong("mobile_no"));
                user.setSalary(rs.getDouble("salary"));
                user.setDob(rs.getDate("dob").toLocalDate());
                userList.add(user);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } ;
        return userList;
    }
}
