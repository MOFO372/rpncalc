package com.libertymutual.rpncalc.commands;

import java.util.Stack;

public class ReciprocalCommand extends OneArgumentCommand {

	public ReciprocalCommand(Stack<Double> numberStack) {
		super(numberStack); 
	}
	
	@Override
	protected double doMaths() {
		return Math.pow(getValuePopped(),  -1); 
	}
}
