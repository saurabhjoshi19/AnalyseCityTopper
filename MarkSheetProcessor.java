import java.util.*;
public class MarkSheetProcessor{
public enum RESULT{PASS,FAIL,SUPPLEMENTARY};
public static RESULT getResult(int english,int hindi,int math,int science,int socialScience){
int x=0;
if(english<33) x++;
if(hindi<33) x++;
if(math<33) x++;
if(science<33) x++;
if(socialScience<33) x++;
if(x==1) return RESULT.SUPPLEMENTARY;
if(x==0) return RESULT.PASS;
return RESULT.FAIL;
}
public static float getPercentage(int english,int hindi,int math,int science,int socialScience){
float percentage=Math.round((english+hindi+math+science+socialScience)/5);
return percentage;
}
public static void main(String data[]){
int english=Integer.parseInt(data[0]);
int hindi=Integer.parseInt(data[1]);
int math=Integer.parseInt(data[2]);
int science=Integer.parseInt(data[3]);
int socialScience=Integer.parseInt(data[4]);
System.out.println(MarkSheetProcessor.getPercentage(english,hindi,math,science,socialScience));

}
}