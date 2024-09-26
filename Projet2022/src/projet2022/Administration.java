/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet2022;

/**
 *
 * @author Marie-Vonise LORDEUS
 */
public class Administration extends Personne{
    private String type;
    private boolean is_active;
    private String password;

    public Administration(String name, String first_name, String cin, String address, String phone, String type, boolean is_active){
        
        super(name, first_name, cin, address, phone);
        this.type = type;
        this.is_active = is_active;  
    }
    
    //getter
    public String getType() {
        return type;
    }

    public boolean getIs_active() {
        return is_active;
    }
    
    //setter

    public void setType(String type) {
        this.type = type;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

}
