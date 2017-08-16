package com.libertymutual.rpncalc.commands;

import java.util.Stack;

public class DivideCommand extends TwoArgumentCommand {

	
	public DivideCommand(Stack<Double> numberStack) {
		super(numberStack);		
	}
	
	@Override
	protected double doMaths() {
		return getSecondPopped() / getFirstPopped(); 	
	}
	
}
