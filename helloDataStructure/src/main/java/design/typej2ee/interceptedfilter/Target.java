package design.typej2ee.interceptedfilter;

public class Target {
   public void execute(String request){
      System.out.println("Executing request: " + request);
   }
}