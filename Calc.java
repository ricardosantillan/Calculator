import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Calc 
{	

	public static void main (String args[]) 
	{

          System.out.println("TC_ADD_001: "+testExec("add","3","5","8"));
	  System.out.println("TC_ADD_002: "+testExec("add","-4","6","2"));
	  System.out.println("TC_ADD_003: "+testExec("add","1.234","3.456","4.69"));
	  System.out.println("TC_ADD_004: "+testExec("add","1.0E10","3.0E10","4.0E10"));
	  System.out.println("TC_ADD_005: "+testExec("add","1.0E-10","3.0E-10","4.0E-10"));
	  System.out.println("TC_ADD_006: "+testExec("add","1.0000001","1.0000001","2.0000002"));
	  System.out.println("TC_ADD_007: "+testExec("add","one","two","argument."));
	  System.out.println("TC_ADD_008: "+testExec("add","1","","cli-calculator"));
	  System.out.println("TC_ADD_009: "+testExec("add","","1","cli-calculator"));
	  System.out.println("TC_ADD_010: "+testExec("add","Null","2","argument."));
	  System.out.println("TC_ADD_011: "+testExec("add","1","Undefined","argument."));
          System.out.println("");
	  System.out.println("TC_SUB_001: "+testExec("subtract","8","3","5"));
          System.out.println("TC_SUB_002: "+testExec("subtract","-3","-5","2"));
          System.out.println("TC_SUB_003: "+testExec("subtract","5.5","-2.2","7.7"));
          System.out.println("TC_SUB_004: "+testExec("subtract","5.0E6","1.0E6","4.0E10"));
          System.out.println("TC_SUB_005: "+testExec("subtract","1.0E-8","3.0E-6","-3.23E-7"));
          System.out.println("TC_SUB_007: "+testExec("subtract","one","two","argument."));
          System.out.println("TC_SUB_008: "+testExec("subtract","1","","cli-calculator"));
          System.out.println("TC_SUB_009: "+testExec("subtract","","1","cli-calculator"));
          System.out.println("TC_SUB_010: "+testExec("subtract","Null","2","argument."));
          System.out.println("TC_SUB_011: "+testExec("subtract","1","Undefined","argument."));
          System.out.println("");
	  System.out.println("TC_MUL_001: "+testExec("multiply","4","3","12"));
          System.out.println("TC_MUL_002: "+testExec("multiply","-4","5","-20"));
          System.out.println("TC_MUL_003: "+testExec("multiply","1.5","2.2","3.3"));
          System.out.println("TC_MUL_004: "+testExec("multiply","1.0E3","1.0E4","1.0E7"));
          System.out.println("TC_MUL_005: "+testExec("multiply","1.0E-4","1.0E-5","0"));
          System.out.println("TC_MUL_007: "+testExec("multiply","one","two","argument."));
          System.out.println("TC_MUL_008: "+testExec("multiply","1","","cli-calculator"));
          System.out.println("TC_MUL_009: "+testExec("multiply","","1","cli-calculator"));
          System.out.println("TC_MUL_010: "+testExec("multiply","Null","2","argument."));
          System.out.println("TC_MUL_011: "+testExec("multiply","1","Undefined","argument."));
          System.out.println("");
          System.out.println("TC_DIV_001: "+testExec("divide","10","2","5"));
          System.out.println("TC_DIV_002: "+testExec("divide","-10","2","-5"));
          System.out.println("TC_DIV_003: "+testExec("divide","7.5","3.2","2.34375"));
          System.out.println("TC_DIV_004: "+testExec("divide","1.0E8","1.0E6","100"));
          System.out.println("TC_DIV_005: "+testExec("divide","1.0E-4","1.0E-5","10"));
          System.out.println("TC_DIV_007: "+testExec("divide","one","two","argument."));
          System.out.println("TC_DIV_008: "+testExec("divide","1","","cli-calculator"));
          System.out.println("TC_DIV_009: "+testExec("divide","","1","cli-calculator"));
          System.out.println("TC_DIV_010: "+testExec("divide","Null","2","argument."));
          System.out.println("TC_DIV_011: "+testExec("divide","1","Undefined","argument."));
	  System.out.println("");
	  System.out.println("TC_ERR_001: "+testExec("divide","10","0","Cannot"));
          System.out.println("TC_ERR_002: "+testExec("add","5","3 2","Error"));
          System.out.println("TC_ERR_003: "+testExec("sqrt","1","","Error"));
	}

	private static String testExec(String op, String fOp, String sOp, String expRes)
	{
           String execResult = cmdExec("docker run --rm public.ecr.aws/l4q9w4c5/loanpro-calculator-cli "+op+" "+fOp+" "+sOp);
	   String[] systRet = execResult.split(" ");
	   //System.out.print("Inside exec: "+systRet[1]);
           return expRes.equals(systRet[1]) ? "Passed" : "Failed";
	}

	private static String cmdExec(String cmd)
	{
           String o=null;
           try
           {
    	     Process p=Runtime.getRuntime().exec(cmd);
    	     BufferedReader b=new BufferedReader(new InputStreamReader(p.getInputStream()));
    	     String r;
    	     while((r=b.readLine())!=null) {
    	        o+=r;
    	     }
           } catch(Exception e){
    	   o="Error";
           }
           return o;
        }

}
