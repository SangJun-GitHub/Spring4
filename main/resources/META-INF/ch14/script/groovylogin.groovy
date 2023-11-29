import com.apress.isf.spring.ch14.java.service.Login;

class GroovyLoginService implements Login{
    String userName;
    String password;

    @Override
    boolean isAuthorized(String email, String pass) {
        if(userName == email && password == pass)
            return true;
        return false;
    }
}