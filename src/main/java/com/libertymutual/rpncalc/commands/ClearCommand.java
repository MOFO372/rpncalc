package com.libertymutual.rpncalc.commands;

import java.util.Stack;

public class ClearCommand implements Undoable {

	private Stack<Double> numberStack; 
	private Stack<Double> memory; 
	
	public ClearCommand(Stack<Double> numberStack) {
		this.numberStack = numberStack; 
		memory = new Stack<Double>(); 
	}
	
	public void execute() {
		int numberOfNumbers = numberStack.size();
		for (int i = 0; i < numberOfNumbers; i += 1) {
			Double value = numberStack.pop(); 
			memory.push(value);
			
			//the above could also be written as:
			//memory.push(numberStack.pop()); 
		}
	}
	
	@Override
	public void undo() {
		int numberOfNumbersInMemory = memory.size(); 
		for (int i = 0; i < numberOfNumbersInMemory; i += 1) {
			Double value = memory.pop(); 
			numberStack.push(value); 
		}
	}
	
	

}
