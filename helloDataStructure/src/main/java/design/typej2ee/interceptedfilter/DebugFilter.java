package design.typej2ee.interceptedfilter;

public class DebugFilter implements Filter {
   public void execute(String request){
      System.out.println("request log: " + request);
   }
}