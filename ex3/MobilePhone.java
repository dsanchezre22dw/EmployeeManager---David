package Exercises1.ex3;

public class MobilePhone {

    private String number;
    private double credit;

    public MobilePhone(String number, double credit){
        this.number = number;
        this.credit = credit;
    }

    public void display(){
        System.out.print("[Number: " + this.number + ", credit: " + this.credit + "]");
    }

    public void topup(int s){
        this.credit += s;
    }

    public void call(int minutes){
        this.credit -= minutes*2;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}
