public class WeightedGrades
{
	public static void main(String[] args)
	{
   
   
   
   
   
      
      
      double calcTestScale = .80;
      double calcHomeworkScale = .20;
      double apcsTestScale = .60;
      double apcsHomeworkScale = .40;
      //class percentage scales
      
		double calcTestGrade = 1.00;
		double calcHomeworkGrade = .25;
      //double calcFinalGrade = .85;
      //calc grades
      
      double apcsTestGrade = 1.00;
      double apcsHomeworkGrade = .25;
		//double apcsFinalGrade = .70;
      //apcs grades
      
      char calcLetterGrade = 'B';
      char apcsLetterGrade = 'C';
      //final letter grades
      
      //-------------------------------
      //Calc scale
		System.out.println("Calculus\nScale: " + calcTestScale*100 + "% Test, " + calcHomeworkScale*100 + "% Homework");
      System.out.println();
		//Calculus Grades
		System.out.println("Student's Test Percent: " + calcTestGrade*100 + "%");
      System.out.println();
		System.out.println("Student's Homework Percent: " + calcHomeworkGrade*100 + "%");
      System.out.println();
      //calc final grade
      double calcTestFinal = calcTestScale*calcTestGrade;//new variable
      double calcHomeworkFinal = calcHomeworkScale*calcHomeworkGrade;//new variable
      double calcFinalGrade = calcTestFinal + calcHomeworkFinal;
      System.out.println("Final Percent: " + calcFinalGrade*100 + "%");
      System.out.println();
      System.out.println("Grade: " + calcLetterGrade);
      System.out.println("---------------------------------------");
      //calc scale
      System.out.println("AP Computer Science\nScale: " + apcsTestScale*100 + "% Test, " + apcsHomeworkScale*100 + "% Homework");
      System.out.println();
      //AP Computer Science Grades
		System.out.println("Student's Test Percent: " + apcsTestGrade*100 + "%");
      System.out.println();
		System.out.println("Student's Homework Percent: " + apcsHomeworkGrade*100 + "%");
		System.out.println();
      //apcs final grade
      double apcsTestFinal = apcsTestScale*apcsTestGrade;//new variable
      double apcsHomeworkFinal = apcsHomeworkScale*apcsHomeworkGrade;//new variable
      double apcsFinalGrade = apcsTestFinal + apcsHomeworkFinal;
      System.out.println("Final Percent: " + apcsFinalGrade*100 + "%");
      System.out.println();
      System.out.println("Grade: " + apcsLetterGrade + "-");
      
      
      
      
	}
	
	
}	
	
	
	







