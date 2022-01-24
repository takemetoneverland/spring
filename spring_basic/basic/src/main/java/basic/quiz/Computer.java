package basic.quiz;

import org.springframework.beans.factory.annotation.Autowired;

public class Computer {
	
	/*
	@Autowired //자동 주입
	private Mouse mouse;
	@Autowired
	private Keyboard keyboard;
	@Autowired
	private Monitor monitor;
	*/
	
	private Mouse mouse;
	private Keyboard keyboard;
	private Monitor monitor;
	
	@Autowired	
	public Computer(Mouse mouse, Keyboard keyboard, Monitor monitor) {
		super();
		this.mouse = mouse;
		this.keyboard = keyboard;
		this.monitor = monitor;
	}

	public void computerInfo() {
		System.out.println("*** 컴퓨터의 정보 ***");
		mouse.info();
		keyboard.info();
		monitor.info();
		}
	}
