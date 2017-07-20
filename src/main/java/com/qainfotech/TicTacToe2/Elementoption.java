package com.qainfotech.TicTacToe2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Elementoption {
	
	WebDriver driver;
	
	public Elementoption(WebDriver driver) {
		this.driver = driver;
		driver.get("Elementoption.java");
	}
	
	void click(String id) {
		driver.findElement(By.id(id)).click();
	}
	

	void senddata(String id,String msg) {
		driver.findElement(By.id(id)).sendKeys(msg);
	}

}
