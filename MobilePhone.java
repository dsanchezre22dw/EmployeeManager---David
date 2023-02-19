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

    private void writeObject(ObjectOutputStream oos) throws IOException{
        oos.defaultWriteObject();
        oos.writeObject(this.number);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{
        ois.defaultReadObject();
        this.number = (String) ois.readObject();
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

    public double getCredit() {
        return this.credit;
    }
}
