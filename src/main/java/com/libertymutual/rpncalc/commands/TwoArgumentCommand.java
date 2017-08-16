package com.libertymutual.rpncalc.commands;

import java.util.Stack;

public abstract class TwoArgumentCommand implements Undoable {
	
	//instance fields should almost always be private (always do if possible)
	private Stack<Double> numberStack; 
	private double firstPopped; 
	private double secondPopped; 

	//constructor for TwoArgumentCommand, not necessary since Java will create on own
	public TwoArgumentCommand(Stack<Double>  numberStack) {
		this.numberStack = numberStack; 
	}
	
	@Override 
	public void undo() {
		numberStack.pop(); 
		numberStack.push(secondPopped);
		numberStack.push(firstPopped); 
	}
	
	public void execute() {
		firstPopped = numberStack.pop(); 
		secondPopped = numberStack.pop(); 
		double result = doMaths(); 
		numberStack.push(result);
	}

	protected abstract double doMaths();

	protected double getFirstPopped() {
		return firstPopped;
	}

	protected double getSecondPopped() {
		return secondPopped;
	}
		
}
