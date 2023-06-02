
package com.acsiesbitar.esbitaracsi;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "user" )
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    private String _id;
    private String name;
    private String eMail;
    private String password;
    private String phone;

    public User(String name, String eMail, String phone, String password) {
        this.name = name;
        this.eMail = eMail;
        this.phone = phone;
        this.password = password;
    }

    public void setPass(String password) {
        this.password = password;
    }

    public String getPass() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }
    public String getEMail() {return this.eMail = eMail;}
    public void setEmail(String eMail) {
        this.eMail = eMail;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}