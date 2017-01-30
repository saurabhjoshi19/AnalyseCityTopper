import java.util.*;
import java.io.*;
import java.util.concurrent.*;
public class DummyDataGenerator{
public static void main(String data[]){
try{
String uom=data[0];
int size=Integer.parseInt(data[1]);
String namesFile=data[2];
String citiesFile=data[3];
String outputFile=data[4];
File output=new File(outputFile);
if(output.exists()) output.delete();
long outputFileSize=1;

ArrayList<String> names=new ArrayList<String>();
ArrayList<String> cities=new ArrayList<String>();
File nameFile=new File(namesFile);
Scanner scanner=new Scanner(nameFile).useDelimiter("\n");
String name;
while(scanner.hasNext()){
name=scanner.next();
names.add(name);
}
File cityFile=new File(citiesFile);
Scanner scanner1=new Scanner(cityFile).useDelimiter("\n");
String city;
while(scanner1.hasNext()){
city=scanner1.next();
cities.add(city);
}

if(uom.equals("b")){
outputFileSize=size;

}

if(uom.equals("gb")){
outputFileSize=1024*1024*1024*size;

}
if(uom.equals("mb")){
outputFileSize=1024*1024*size;

}
long writeFile=0;
RandomAccessFile raf=new RandomAccessFile(outputFile,"rw");
String[] classes={"I","II","III","IV","V","VII","VIII","VI"};
HashMap<Integer,Integer> rollNumberPool=new HashMap<Integer,Integer>();
while(writeFile<outputFileSize){

int schoolCode=ThreadLocalRandom.current().nextInt(1,501);
int rollNumber=1;
if(rollNumberPool.containsKey(schoolCode)==false){
rollNumberPool.put(schoolCode,rollNumber);
}
else{
rollNumber=rollNumberPool.get(schoolCode)+1;
rollNumberPool.remove(schoolCode);
rollNumberPool.put(schoolCode,rollNumber);
}
int nameIndex=ThreadLocalRandom.current().nextInt(0,names.size());
int cityIndex=ThreadLocalRandom.current().nextInt(0,cities.size());
int english=ThreadLocalRandom.current().nextInt(1,101);
int hindi=ThreadLocalRandom.current().nextInt(1,101);
int science=ThreadLocalRandom.current().nextInt(1,101);
int socialScience=ThreadLocalRandom.current().nextInt(1,101);
int classIndex=ThreadLocalRandom.current().nextInt(0,classes.length);
int math=ThreadLocalRandom.current().nextInt(1,101);
String xml="<student ";
xml=xml+"schoolCode=\""+schoolCode+"\" ";
xml=xml+"city=\""+cities.get(cityIndex)+"\" ";
xml=xml+"rollNumber=\""+rollNumber+"\" ";
xml=xml+"class=\""+classes[classIndex]+"\" ";
xml=xml+"name=\""+names.get(nameIndex)+"\" ";
xml=xml+"english=\""+english+"\" ";
xml=xml+"science=\""+science+"\" ";
xml=xml+"math=\""+math+"\" ";
xml=xml+"hindi=\""+hindi+"\" ";
xml=xml+"socialScience=\""+socialScience+"\" ";
xml=xml+" />";
xml=xml+"\r\n";
raf.writeBytes(xml);
int length=xml.length();



writeFile=writeFile+length;
}
raf.close();
System.out.println("Output file "+outputFile+" created.");
}catch(Exception e){
e.printStackTrace();
}
}
}