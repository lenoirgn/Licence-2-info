package university;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class Curriculum{
    private String name;
    private Map<Subject, Integer> subjectCredits;

    public Curriculum(String name){
        this.name = name;
        this.subjectCredits = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public Map<Subject, Integer> getSubjectCredits(){
        return this.subjectCredits;
    }

    public  int getCoeff(Subject subject) throws IllegalStateException{
         if (!this.subjectCredits.containsKey(subject)){
            throw new IllegalStateException("Subject " + subject + " does not exist in curriculum " + this.name);
        }
        return this.subjectCredits.get(subject);
    }

    public Set<Subject> allSubjects() {
        return this.subjectCredits.keySet();
    }

    public boolean subjectExist(Subject sub){
        return this.subjectCredits.containsKey(sub);
    }

    public void addSubject(Subject sub, int coef){
        this.subjectCredits.put(sub,coef);
    }

    public void removeSubject(Subject subject) {
    this.subjectCredits.remove(subject);
    }

    public String toString(){
       String  result = this.name + " : ";
       for (Subject sub : this.subjectCredits.keySet()){
           result += sub + " (" + this.subjectCredits.get(sub) + ") ";
       }    
       return result;
    }

    /**public static void main(String[] args) {

        Curriculum curriculum = new Curriculum("Licence Informatique");

        
        curriculum.addSubject(Subject.ALR, 5);
        curriculum.addSubject(Subject.POO, 4);

        System.out.println(curriculum.toString());
    }*/


}