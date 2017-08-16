package com.libertymutual.rpncalc.commands;

import java.util.Stack;

public class SwapCommand implements Undoable{

	private Stack<Double> numberStack; 
	private double firstPopped; 
	private double secondPopped; 
	
	public SwapCommand(Stack<Double> numberStack) {
		this.numberStack = numberStack;
	}
	
	public void execute() {
		firstPopped = numberStack.pop();
		secondPopped = numberStack.pop();
		numberStack.push(firstPopped);
		numberStack.push(secondPopped); 
	}
	
	
	@Override 
	public void undo() {
		numberStack.pop();
		numberStack.pop(); 
		numberStack.push(secondPopped);
		numberStack.push(firstPopped);
	}

}
