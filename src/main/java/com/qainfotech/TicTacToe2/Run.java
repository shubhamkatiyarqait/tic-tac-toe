package com.qainfotech.TicTacToe2;

import org.openqa.selenium.WebDriver;

public class Run {
	
	static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		
		driver=Setup.chromesetup(driver);
		driver.get("https://playtictactoe.org/");
		Thread.sleep(2000);
		Play play=new Play(driver);
		play.start_game();		
	}
}
