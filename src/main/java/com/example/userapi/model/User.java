package com.example.userapi.model;

//public class User {
//
//    private Long id;
//    private String name;
//    private String email;
//
//    // Constructors
//    public User(){
//
//    }
//    public User(Long id, String name, String email){
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }
//
//    // Getters & Setters
//    public Long getId(){
//        return  id;
//    }
//    public void setId(Long id){
//        this.id = id;
//    }
//
//    public String getName(){
//        return name;
//    }
//    public void setName(String name){
//        this.name = name;
//    }
//
//    public String getEmail(){
//        return email;
//    }
//    public void setEmail(String email){
//        this.email = email;
//    }
//
//}



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor     // Generates a no-args constructor
@AllArgsConstructor     // Generates an all-args constructor
public class User {
    private Long id;
    private String name;
    private String email;
}
