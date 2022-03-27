Association
- Relationship between one or more   classes



Example 
 class : student, Program

 one program has many registered students
 Every student enrolled in one program
 One program has at most 40 studennts
 - Imran enrolled in BBA
 - Atif enrolled in BBA
 - Jawad enrolled in BS

 Mutiplicity : one to many


class student{
public Student (){}
public Student (String n){name=n;}
public String getName(){return name;}
public void setName(String n){name=n;}
private String name;
}

class Program{
public Program(){ a=new Student[40]; no=-1;}
public void enroll(Student p){
     a[++no]=p;
}
publoic void printAllStudents(){
   for (int i=0;i<=no;i++)
       System.out.println(a[no].getName());

}
private int no;
private Student a[];
private String title;
}

class Test{
public static void main(String o[]){
Student s1=new Student("Imran");
Student s2=new Student("atif");
Student s3=new Student("jawad");
Program p1=new Program ("BBA");
Program p2=new Program ("BS");
p1.enroll(s1);
p1.enroll(s2);
p2.enroll(s3);
p1.printAllStudents();
p2.printAllStudents();

}
}


...................................................

e.g Student Belongs to specific Faculty
One faculty has many students
(See UML Diagram on Board)

class Student {
String name;
Student () {name=null; }
Student (String n) {name=n; }
void setName(String n) {name=n;}
String getName() { return name;}
}
Class Faculty{
Student student[];
int size;
Faculty (int s){size=0;
         student=new Student[s];}
void belongsTo(Student p){
    student[size]=p;
    size++;
}
void print(){
   for (int i=0;i<size;i++)
      System.out.println(student[i].getName());
}
}
class Test{
public static void main (String a[]){
Faculty FIT= new Faculty(5);
Faculty FMS= new Faculty(5);
Student s1=new Student("Hamza");
FMS.belongsTo(s1);
Student s2=new Student("Kamil");
FIT.belongsTo(s2);
Student s3=new Student("Shoaib");
FMS.belongsTo(s3);
System.out.println("FIT students");
FIT.print();
System.out.println("FMS students");
FMS.print();
}
}
....................................
Practice 2
  Classes : Student, Course

   Student Register courses
one student resgister max 5 courses
one Course has max 50 registed students
  -  - Association   (binary)
  - Cardinality many to many
  - design an extra class (association class) i.e register
(see UML Diagram on board)
 -hamza, ahmed and jawad (student objects)
 - DSA and algo (Course Objects)
 - Hamza register DSA
 - Ahmed register DSA
 - jawad register Algo



class Student {
private String name;
public Student () {name=null; }
public Student (String n) {name=n; }
public void setName(String n) {name=n;}
public String getName() { return name;}
}
class Course {
private String title;
public Course  () {title=null; }
public Course  (String n) {title=n; }
public void setTitle(String n) {title=n;}
public String getTitle() { return title;}
}

class Registeration{
Student s;
Course  c;
void register(Student s,Course c ) {
            this.s=s;
            this.c=c;
}
void print(){
 System.out.println(s.getName());
 System.out.println(c.getTitle());
}
}

class Test{
public static void main (String a[]){
Registration r[]=new Registration[10];
//size of registration array depends on number of registrations
Student s1= new Student("Hamza");
Student s2= new Student("Ahmed");
Student s3= new Student("Jawad");
Course  c1 = new Course ("DSA");
Course  c2 = new Course ("Algo");
r[0].register(s1,c1);
r[1].register(s2,c1);
r[2].register(s3,c2);
// print no. of students in DSA
for (int i=0;i<3;i++)
  if(r[i].c.getTitle().equals("DSA"))
      System.out.println(r[i].s.getName());
//print title of courses registered by hamza

for (int i=0;i<3;i++)
  if(r[i].s.getName().equals("Hamza"))
      System.out.println(r[i].c.getTitle());

}
}
...........................................................................
                    Assignment

Classes : Student(name), Course(title), Semeter(title)
   one student can register specific course in specific semester
   
one student resgister max 5 courses in one semester
one Course has max 50 registerd students one semester
  - Association  ternary
  - Cardinality many to many
  - design an extra class (association class) i.e register
(see UML Diagram on board)
 
 -hamza, ahmed and jawad (student objects)
 - DSA and algo (Course Objects)
 - Spring15, Summer15 (Semester Objects)
 - Hamza register DSA in Spring15 and got F grade
 - Ahmed register DSA in Spring15 and got A grade
 - jawad register Algo in Spring15 and got B grade
 -  Hamza reregister DSA in Summer15 and got B grade

Hint :
 class Registeration{
private Student s;
private Course  c;
private Semester  sem;
void register(Student s,Course c, Semester sem) {
            this.s=s;
            this.c=c;
            this.sem=sem;
}
void setGrade() {......}
void print(){
 System.out.println(s.getName());
 System.out.println(c.getTitle());
}
}

class Test{
public static void main (String a[]){
Registration r[]=new Registration[10];
//size of registration array depends on number of registrations
Student s1= new Student("Hamza");
Student s2= new Student("Ahmed");
Student s3= new Student("Jawad");
Course  c1 = new Course ("DSA");
Course  c2 = new Course ("Algo");
Semester sem1= new Semester("Spring15");
Semester sem2= new Semester("Summer15");
r[0].register(s1,c1,sem1);
r[1].register(s2,c1,sem1);
r[2].register(s3,c2,sem1);
r[0].setGrade(s1,c1,sem1,"F");
r[3].register(s1,c1,sem2);
// print no. of students in DSA
for (int i=0;i<3;i++)
  if(r[i].c.getTitle().equals("DSA"))
      System.out.println(r[i].s.getName());
//print title of courses registered by hamza

for (int i=0;i<3;i++)
  if(r[i].s.getName().equals("Hamza"))
      System.out.println(r[i].c.getTitle());
//print Hamza Transcript
  
}
}
...................................................................
Example  Unary Relationship (class associates itself)

 one course has many prereqs

 - AdvProg, DSA,oop,prog1 (Course Objects)
 - No prereq for Prog1
 - OOP prereq prog1
 - DSA prereq (OOP)
 - AdvProg (DSA and Prog1)


  (See UML Diagram on board)


class Course {
private String title;
 Course a[];
private int used;
public Course  () {title=null; }
public Course  (String n) {title=n;
   a=new Course[3];used=-1}
public void setTitle(String n) {title=n;}
public int getUsed(){retrurn used;}
public String getTitle() { return title;}
public void prereq(Course p){ a[++used]=p;}
}

class Test{
public static void main (String a[]){
Course c1=new Course("Prog1");
Course c2=new Course("oop");
Course c3=new Course("DSA");
Course c4=new Course("AdvProg");
c2.prereq(c1);
c2.prereq(c2);
c4.prereq(c1);
c4.prereq(c2);
//print rereq of AdvProg

for (int i=0;i<c4.getUsed();i++)
  System.out.println(c4.a[i]);
}
}


