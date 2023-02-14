package Exercises1.ex3;

import java.io.*;
import java.util.List;

public class EmployeesManager {

    private String filename;

    public EmployeesManager(String filename){
        this.filename = filename;
    }

    public void saveEmployees(List<Employee> emps){

        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/Exercises1/ex3/files/" + this.filename));
            for (Employee elem:emps){
                oos.writeObject(elem);
            }
            oos.write(null);
        }catch (FileNotFoundException a){
            System.out.println("File not found");
        }catch (IOException b){
            System.out.println("Exception");
        }

        try{
            if (oos != null){
                oos.close();
            }
        }catch (IOException e){
            System.out.println("IOException");
        }
    }

    public void displayEmployees(){

        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("src/Exercises1/ex3/files/" + this.filename));
            Employee emp = (Employee)ois.readObject();
            while (emp != null){
                emp.display();
                emp = (Employee)ois.readObject();
            }
        }catch (FileNotFoundException a){
            System.out.println("File not found");
        }catch (IOException b){
            System.out.println("Exception");
        }catch (ClassNotFoundException c){
            System.out.println("Class not found");
        }

        try{
            if (ois != null){
                ois.close();
            }
        }catch (IOException e){
            System.out.println("IOException");
        }
    }

    public Employee searchEmployee(String empname){

        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("src/Exercises1/ex3/files/" + this.filename));
            Employee emp = (Employee)ois.readObject();
            while (emp != null){
                if (emp.getName().equalsIgnoreCase(empname)){
                    return emp;
                }
                emp = (Employee)ois.readObject();
            }
        }catch (FileNotFoundException a){
            System.out.println("File not found");
        }catch (IOException b){
            System.out.println("Exception");
        }catch (ClassNotFoundException c){
            System.out.println("Class not found");
        }

        try{
            if (ois != null){
                ois.close();
            }
        }catch (IOException e){
            System.out.println("IOException");
        }

        return null;
    }

    public void generateMobilesFile(String filename){

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/Exercises1/ex3/files/" + filename));
            ois = new ObjectInputStream(new FileInputStream("src/Exercises1/ex3/files/" + this.filename));
            Employee emp = (Employee)ois.readObject();
            while (emp != null){
                emp.getMp().setCredit(0);
                oos.writeObject(emp.getMp());

                emp = (Employee)ois.readObject();
            }
        }catch (FileNotFoundException a){
            System.out.println("File not found");
        }catch (IOException b){
            System.out.println("Exception");
        }catch (ClassNotFoundException c){
            System.out.println("Class not found");
        }

        try{
            if (oos != null){
                oos.close();
            }

            if (ois != null){
                ois.close();
            }
        }catch (IOException e){
            System.out.println("IOException");
        }
    }

    public void workEveryone(){
        ObjectInputStream ois = null;
        List<Employee> emps




        try {
            ois = new ObjectInputStream(new FileInputStream("src/Exercises1/ex3/files/" + this.filename));
            Employee emp = (Employee)ois.readObject();
            while (emp != null){
                emp.work();
                emp = (Employee)ois.readObject();
            }
        }catch (FileNotFoundException a){
            System.out.println("File not found");
        }catch (IOException b){
            System.out.println("Exception");
        }catch (ClassNotFoundException c){
            System.out.println("Class not found");
        }

        try{
            if (ois != null){
                ois.close();
            }
        }catch (IOException e){
            System.out.println("IOException");
        }
    }

    public static void main(String[] args) {

        EmployeesManager em1 = new EmployeesManager("employees.data")





    }





}
