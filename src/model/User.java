package model;

public abstract class User {
    private String name;
    private String userId;
    private String password;

    public User(String name, String userId , String password){
        this.name = name;
        this.userId = userId;
        this.password = password;
    }
    public String getName(){
        return name;
    }
    public String getUserId(){
        return userId;
    }
    public boolean CheckPassword(String inputPassword){
        return this.password.equals(inputPassword);
    }
    public abstract void showMenu();

}
