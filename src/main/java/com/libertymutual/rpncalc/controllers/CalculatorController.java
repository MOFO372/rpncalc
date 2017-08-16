package com.libertymutual.rpncalc.controllers;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libertymutual.rpncalc.commands.AddCommand;
import com.libertymutual.rpncalc.commands.ClearCommand;
import com.libertymutual.rpncalc.commands.DivideCommand;
import com.libertymutual.rpncalc.commands.MultiplyCommand;
import com.libertymutual.rpncalc.commands.NegateCommand;
import com.libertymutual.rpncalc.commands.PushCommand;
import com.libertymutual.rpncalc.commands.ReciprocalCommand;
import com.libertymutual.rpncalc.commands.SquareRootCommand;
import com.libertymutual.rpncalc.commands.SubtractCommand;
import com.libertymutual.rpncalc.commands.SwapCommand;
import com.libertymutual.rpncalc.commands.Undoable;


@Controller
@RequestMapping("/calculator")
public class CalculatorController {

	Stack<Double> numberStack;
	Stack<Undoable> commandHistory; 
	
	
	//CONTROLLER DECLARATION
	public CalculatorController() {
		numberStack = new Stack<Double>();
		commandHistory = new Stack<Undoable>(); 
	}
	
	//VALUE ENTERING - PUSH AND TEXT BOX
	@PostMapping("/values") 
	public String pushValueOntoStack(double enteredValue) { 
		PushCommand command = new PushCommand(enteredValue, numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}
	
	//CLEAR
	@PostMapping("/operation/clear")
	public String clearValues() {
		ClearCommand command = new ClearCommand(numberStack);
		command.execute(); 
		commandHistory.push(command); 
		return "redirect:/calculator"; 
	}
	
	//UNDO
	@PostMapping("/operation/undo")
	public String undoTheLastCommand() { 
		if (commandHistory.size() > 0) {
			Undoable command = commandHistory.pop();
			command.undo(); 
		}
		return "redirect:/calculator";
	}
	
	//ADD
	@PostMapping("/operation/add")
	public String addTheTopStackNumbers() {
		AddCommand command = new AddCommand(numberStack); 
		command.execute(); 
		commandHistory.push(command);
		return "redirect:/calculator"; 
	}
	
	//SUBTRACT
	@PostMapping("/operation/subtract")
	public String subtractTopStackCumbers() {
		SubtractCommand command = new SubtractCommand(numberStack);
		command.execute(); 
		commandHistory.push(command);
		return "redirect:/calculator"; 
	}
	
	//NEGATE
	@PostMapping("/operation/negate")
	public String negateTopStackNumber() {
		NegateCommand command = new NegateCommand(numberStack); 
		command.execute(); 
		commandHistory.push(command);
		return "redirect:/calculator"; 
		
		}
	
	//MULTIPLY
	@PostMapping("/operation/multiply")
	public String multiplyTopStackNumbers() {
		MultiplyCommand command = new MultiplyCommand(numberStack); 
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}
	
	//SWAP
	@PostMapping("/operation/swap")
	public String swapTopStackNumbers() {
		SwapCommand command = new SwapCommand(numberStack);
		command.execute(); 
		commandHistory.push(command); 
		return "redirect:/calculator";
	}
	//DIVIDE
	@PostMapping("/operation/divide")
	public String divideyTopStackNumbers() {
		DivideCommand command = new DivideCommand(numberStack); 
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator"; 
	}
	
	//RECIPROCAL
	@PostMapping("/operation/reciprocal")
	public String reciprocateTopStackNumber() {
		ReciprocalCommand command = new ReciprocalCommand(numberStack); 
		command.execute(); 
		commandHistory.push(command);
		return "redirect:/calculator"; 
	}
	
	//SQUARE ROOT
	@PostMapping("/operation/squareroot")
	public String squareRootTopStackNumber() {
		SquareRootCommand command = new SquareRootCommand(numberStack); 
		command.execute(); 
		commandHistory.push(command);
		return "redirect:/calculator"; 
	}
	
	//BUTTON SHOWING
	@GetMapping("")	
	public String showDefaultPage(Model model) {
		model.addAttribute("stack", numberStack);
		model.addAttribute("canShowBinaryOperator", numberStack.size() > 1);
		model.addAttribute("canShowUnaryOperator", numberStack.size() > 0); 
		model.addAttribute("undoSize", commandHistory.size()); 
		return "calculator/default"; 
	}
 }







