package model;

/**
 * Created by maximize on 12/18/2016 AD.
 */

public class member {

    private   String mUsername;
    private   String mPassword;
    private   String mName;

    public String getUsername(){return mUsername;}

    public void setUsername(String usr){this.mUsername = usr;}

    public String getPassword(){return mPassword;}

    public void setPassword(String p){this.mPassword = p;}

    public String getNames() {return mName;}

    public void setNames(String n) {
        this.mName = n;
    }

}
