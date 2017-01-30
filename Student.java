import java.util.*;
public class Student{
private int rollNumber;
private String name;
public void setRollNumber(int rollNumber){
this.rollNumber=rollNumber;
}
public void setName(String name){
this.name=name;
}
public int getRollNumber(){
return this.rollNumber;
}
public String getName(){
return this.name;
}
public String toString(){
return this.rollNumber+"\t"+this.name;
}
}
