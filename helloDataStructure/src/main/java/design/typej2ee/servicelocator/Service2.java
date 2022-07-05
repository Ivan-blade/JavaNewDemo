package design.typej2ee.servicelocator;

public class Service2 implements Service {
   public void execute(){
      System.out.println("Executing Service2");
   }
 
   @Override
   public String getName() {
      return "Service2";
   }
}