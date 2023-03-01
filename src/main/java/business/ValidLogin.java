package business;

import model.LoginModel;

public class ValidLogin implements SecurityServiceInterface{

    @Override
    public boolean isAuthenticated(LoginModel loginModel) {
        
        String[][] validLogins = new String[][]{
            {"test", "test"},
            {"admin", "password"}
        };
        
        boolean success = false;
        for(int i = 0; i < validLogins.length; i++)
        {
            if(loginModel.getUsername().equals(validLogins[i][0]) && loginModel.getPassword().equals(validLogins[i][1]))
            {
                success = true;
            }
        }
        if(success)
        {

            return true;
        }
        else
        {
            System.out.println("LOGIN FAILED");
            return false;
        }

    }
    


}
