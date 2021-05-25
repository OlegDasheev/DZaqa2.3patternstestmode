package ru.netology.Data;

public class RegistrationDto {
    private String login;
    private String password;
    private String active;

    public RegistrationDto(String login, String password, String active) {
       this.login = login;
       this.password = password;
       this.active = active;
    }

    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
    public String getActive(){
        return active;
    }
}
