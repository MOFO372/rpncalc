package com.libertymutual.rpncalc.commands;

import java.util.Stack;

public class NegateCommand extends OneArgumentCommand {
	
	public NegateCommand(Stack<Double> numberStack) {
		super(numberStack); 
	}

	protected double doMaths() { 		
		if (getValuePopped() != 0 ) {
			return getValuePopped() * (-1); 
		}
		
		else {
			return getValuePopped(); 
		}
	}	
}
