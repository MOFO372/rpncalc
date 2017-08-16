package com.libertymutual.rpncalc.commands;

import java.util.Stack;

public abstract class OneArgumentCommand implements Undoable {

	private Stack<Double> numberStack; 
	private double valuePopped; 
	
	public OneArgumentCommand(Stack<Double> numberStack) {
		this.numberStack = numberStack; 
	}
	
	@Override
	public void undo() {
		numberStack.pop(); 
		numberStack.push(valuePopped); 
	}
	
	public void execute() {
		valuePopped = numberStack.pop(); 
		double result = doMaths();
		numberStack.push(result); 
	}
	
	protected abstract double doMaths(); 
	
	protected double getValuePopped() {
		return valuePopped; 
	}
}
