/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session7_Baitap;

/**
 *
 * @author June
 */
public class SMS {

    String message;

    public SMS() {
    }

    public SMS(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sendSMS(String message) {
        this.message = message;
    }
}
