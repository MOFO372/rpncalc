package com.libertymutual.rpncalc.commands;

import java.util.Stack;

public class AddCommand extends TwoArgumentCommand {
	
	
	public AddCommand(Stack<Double> numberStack) {
		super(numberStack);	
	}

	@Override
	protected double doMaths() {
		return getFirstPopped() + getSecondPopped(); 
	}
	
}
