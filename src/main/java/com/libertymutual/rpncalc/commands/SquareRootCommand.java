package com.libertymutual.rpncalc.commands;

import java.util.Stack;

public class SquareRootCommand extends OneArgumentCommand{

	public SquareRootCommand(Stack<Double> numberStack) {
		super(numberStack);
	}
	
	@Override
	protected double doMaths() {
		return Math.sqrt(getValuePopped()); 
	}
}
