package Selenium.Infra;

//Login Screen Getter and Setter

public class LoginCredentials {

private String User;
private String Password;

private String Click;

    ElementConstans elementConstans = new ElementConstans();


    public String getUser() {

        this.User=elementConstans.user;


        return User;
    }

    public String setUser(String user) {
        User = user;
        return user;
    }

    public String getPassword() {

        this.Password=elementConstans.password;

        return Password;
    }

    public CharSequence setPassword(String password) {
        Password = password;
        return password;
    }

    public String getClick() {
        this.Click=elementConstans.click;
        return Click;
    }


}
