package com.checkmate_portal.chessclub.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(unique = true, nullable = false)
   private String userName;
   private String password;
   private String role;

   public User(){}
   public User(Long id,String userName,String role,String password){
   this.id=id;
   this.userName=userName;
   this.password=password;
   this.role=role;
   }

   public Long getId(){
       return this.id;
   }
   public String getUserName(){
       return this.userName;
   }
   public String getPassword(){
       return this.password;
   }
   public String getRole(){
       return this.role;
   }
    public void setId(Long id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
