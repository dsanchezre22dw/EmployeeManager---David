package Exercises1.ex3;

import java.io.Serial;
import java.io.Serializable;

public class Employee implements Serializable {

    private String name;
    private double salary;
    public MobilePhone mp;

    public Employee(String name, double salary, MobilePhone mp) {
        this.name = name;
        this.salary = salary;
        this.mp = mp;
    }

    public void display(){
        System.out.print("[Name: " + this.name + ", salary: " + this.salary + ", mobile phone: ");
        this.mp.display();
        System.out.println("]");
    }

    public void work(){
        salary += 10;
        this.mp.call(15);
    }

    public void work(int g, int m){
        salary += g;
        this.mp.call(m);
    }

    public String getName() {
        return this.name;
    }

    public MobilePhone getMp() {
        return this.mp;
    }

}
