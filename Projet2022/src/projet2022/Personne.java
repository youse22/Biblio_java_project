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
public class Personne {
    protected String last_name;
    protected String first_name;
    protected String cin;
    protected String address;
    protected String phone;
    
    public Personne(String cin, String last_name, String first_name, String phone, String address){
        this.last_name = last_name;
        this.first_name = first_name;
        this.cin = cin;
        this.address = address;
        this.phone = phone;
    }
    
    //getter
    public String getLast_name(){
        return this.last_name;
    }
    
    public String getFirst_name(){
        return this.first_name;
    }
     
    public String getCin(){
        return this.cin;
    }
      
    public String getAddress(){
        return this.address;
    }
       
    public String getPhone(){
        return this.phone;
    }
        
    //setter
    public void setLast_name(String name) {
        this.last_name = name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   public void Affiche(){
       System.out.println(this.phone);
   }
        
}
