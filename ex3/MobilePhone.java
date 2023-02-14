package Exercises1.ex3;

import javax.imageio.IIOException;
import java.io.*;

public class MobilePhone implements Serializable {

    private String number;
    private double credit;
    private static final long serialVersionUID = 1L;

    public MobilePhone(String number, double credit){
        this.number = number;
        this.credit = credit;
    }

    public void writeObject(ObjectOutputStream oos){
        try {
            oos.defaultWriteObject();
            oos.writeObject(this.number);
        }catch (FileNotFoundException a){
            System.out.println("File not found");
        }catch (IOException b){
            System.out.println("Exception");
        }

    }

    public String readObject(ObjectInputStream ois){
        try {
            ois.defaultReadObject();
            this.number = (String) ois.readObject();
        }catch (FileNotFoundException a){
            System.out.println("File not found");
        }catch (IOException b){
            System.out.println("Exception");
        }catch (ClassNotFoundException c){
            System.out.println("Class not found");
        }

        return null;
    }

    public void display(){
        System.out.print("[Number: " + this.number + ", credit: " + this.credit + "]");
    }

    public void topup(int s){
        this.credit += s;
    }

    public void call(int minutes){
        if (minutes*2 <= this.credit){
            this.credit -= minutes*2;
        }else{
            System.out.println("You cannot call for that long, not enough money");
        }
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}
