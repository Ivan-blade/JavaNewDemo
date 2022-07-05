package design.typeaction.visitor;

public interface ComputerPart {
   public void accept(ComputerPartVisitor computerPartVisitor);
}