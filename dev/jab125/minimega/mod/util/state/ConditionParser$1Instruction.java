package dev.jab125.minimega.mod.util.state;

interface Instruction {
  void execute(State paramState);
  
  String srcDec();
}


/* Location:              C:\Users\timos\Downloads\minimega-6.5.32.jar!\dev\jab125\minimega\mo\\util\state\ConditionParser$1Instruction.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */