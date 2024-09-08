import java.util.*;
class Quiz_Generator{
    static Scanner scan=new Scanner(System.in);
    static ArrayList<String> Quizees=new ArrayList<>();
    static ArrayList<ArrayList<String>> ques_opts=new ArrayList<>();
    static ArrayList<String> addques=new ArrayList<>();
    static ArrayList<ArrayList<String>> addopts=new ArrayList<>();
    static ArrayList<Integer> crct_ans=new ArrayList<>();
    public static void main(String[] args){
        
        int flag=1;
        while(flag==1){
            System.out.println("\t\tQuiz Menu:");
            System.out.println("1.Create Quiz\n2.Add questions to the quiz\n3.Attempt Quiz\n4.Exit");
            System.out.println("Enter your choice:");
            int choice=scan.nextInt();
            switch(choice){
                case 1:
                    createquiz();
                    break;
                case 2:
                    addques();
                    break;
                case 3:
                    attempt_quiz();
                    break;
                case 4:
                    System.out.println("Successfully exited");
                    flag=0;
                    break;
                default:
                    System.out.println("Invalid choice, Try again!!");
            }
        }
    }
    
    private static void createquiz(){
        System.out.println("Enter your quiz name:");
        String q_name=scan.next();
        if(Quizees.contains(q_name)){
            System.out.println(q_name+"Already existed, Try with another name!!");
            return;
        }
        else{
            Quizees.add(q_name);
            System.out.println("Successfully added "+q_name);
        }
    }
    
    private static void addques(){
        System.out.println("The below are the available quiz names:");
        for(String str:Quizees) System.out.println("\t"+str);
        System.out.println("Enter the quiz name where you want to add questions");
        String q_name=scan.next();
        if(!Quizees.contains(q_name)){
            System.out.println(q_name+"doesnot exists, Create Quiz");
            return;
        }
        else{
            System.out.println("--Add questions--");
            scan.nextLine();
            String ques=scan.nextLine();
            addques.add(ques);
            System.out.println("Now need to add options will be marked from 1 to 4:");
            ArrayList<String> curropts=new ArrayList<>();
            for(int i=0;i<4;i++){
                String opts=scan.next();
                
                curropts.add(opts);
            }
            addopts.add(curropts);
            System.out.println("Enter the correct answer:");
            int ans=scan.nextInt();
            crct_ans.add(ans);
        }
    }
    
    
    private static void attempt_quiz(){
        int score=0;
        System.out.println("The available quizes are:");
        for(String str:Quizees) System.out.println("\t"+str);
        System.out.println("Enter the quiz name which you want to participate!!");
        String take_quiz=scan.next();
        if(!Quizees.contains(take_quiz)){
            System.out.println(take_quiz+"doesnot exists!, First create"+take_quiz);
            return;
        }
        else{
            for(int i=0;i<addques.size();i++){
                System.out.println((i+1)+")"+addques.get(i));
                ArrayList<String> curropts=addopts.get(i);
                for(int j=0;j<curropts.size();j++){
                    System.out.println((j+1)+":"+curropts.get(j));
                }
                System.out.println("Enter your answer:");
                int user_ans=scan.nextInt();
                if(user_ans==crct_ans.get(i)){
                    score++;
                    System.out.println("Correct Answer");
                }
                else{
                    System.out.println("Wrong Answer");
                    System.out.println("The correct Answer is:"+crct_ans.get(i));
                }
            }
            System.out.println("You total Score is:"+score);
            int avg=(score/addques.size())*100;
            if(avg>85 && avg<=100) System.out.println("Feedback:Outstanding");
            else if(avg>70 && avg<=85) System.out.println("Feedback:Excellent");
            else if(avg>55 && avg<=70) System.out.println("Feedback:Good");
            else System.out.println("Feedback:Better luck next time for good score.");
            System.out.println("----------------------------------");
        }
    }
    
}