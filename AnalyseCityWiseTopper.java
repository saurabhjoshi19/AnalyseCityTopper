import java.io.*;
import java.util.*;
public class AnalyseCityWiseTopper{
public static void main(String data[]){
try{
long start=System.nanoTime();
String xml;
String inputFileName=data[0];
String outputFileName=data[1];
File inputFile=new File(inputFileName);
File outputFile=new File(outputFileName);
RandomAccessFile raf=new RandomAccessFile(inputFile,"r");
long inputFileSize=inputFile.length();
HashMap<String,String> map=new HashMap<String,String>();
HashMap<String,StudentCountPassCountRecord> finalMap=new HashMap<String,StudentCountPassCountRecord>();
String city;
int english,math,hindi,science,socialScience;
while(raf.getFilePointer()<inputFileSize){
xml=raf.readLine();
map=ParserUtility.getMap(xml);
english=Integer.parseInt(map.get("english"));
hindi=Integer.parseInt(map.get("hindi"));
math=Integer.parseInt(map.get("math"));
science=Integer.parseInt(map.get("science"));
socialScience=Integer.parseInt(map.get("socialScience"));
city=map.get("city");
StudentCountPassCountRecord value=new StudentCountPassCountRecord();
MarkSheetProcessor.RESULT result=MarkSheetProcessor.getResult(english,hindi,math,science,socialScience);
raf.close();
}catch(Exception e){
e.printStackTrace();
}

}