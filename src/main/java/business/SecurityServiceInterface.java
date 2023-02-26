package business;

import model.LoginModel;

public interface SecurityServiceInterface {
    public boolean isAuthenticated(LoginModel loginModel);
}
