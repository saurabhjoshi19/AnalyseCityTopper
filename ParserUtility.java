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

[root@saurabhserver local]# cat ParserUtility.java
import java.util.*;
public class ParserUtility
{
public static HashMap<String,String> getMap(String x){
String xml=x;
HashMap<String,String> map=new HashMap<String,String>();
xml=xml.substring(9,xml.length()-3);
String[] splits;
splits=xml.split("\"");
String key,value;
String y;
int i;
for(i=0;i<splits.length-1;i=i+2){
y=splits[i].trim();
key=y.substring(0,y.length()-1);
value=splits[i+1].trim();
map.put(key,value);
}
return map;
}
public static void main(String gg[]){
String z="<student schoolCode=\"99\" city=\"Groot-Bijgaarden\" rollNumber=\"1\" class=\"VI\" name=\"Walker Branch\" english=\"55\" science=\"77\" math=\"76\" hindi=\"49\" socialScience=\"11\"  />";
ParserUtility p=new ParserUtility();
HashMap<String,String> map=p.getMap(z);
for(Map.Entry<String,String> entry:map.entrySet()){
System.out.println("Key :"+entry.getKey()+"\t Value :"+entry.getValue());
}
}
}