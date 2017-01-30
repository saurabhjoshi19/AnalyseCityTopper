public class StudentCountPassCountRecord{
long passCount=0;
long studentCount=0;
public void setStudentCount(long studentCount){
this.studentCount=studentCount;
}
public long getStudentCount(){
return this.studentCount;
}
public void setPassCount(long passCount){
this.passCount=passCount;
}
public long getPassCount(){
return this.passCount;
}
public String toString(){
return getStudentCount()+"\t"+getPassCount();
}
}