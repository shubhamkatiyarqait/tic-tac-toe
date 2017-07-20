package com.qainfotech.TicTacToe2;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Play {

	WebDriver driver;
	public static final int COMP = 2;
	public static final int HUMAN = 1;
	int arr[][] = new int[3][3];

	public Play(WebDriver driver) {
		this.driver = driver;
	}

	void start_game() throws InterruptedException {
		// driver.findElement(By.cssSelector("div.square.top.left")).click();
		Thread.sleep(2000);
		Boolean appear = false;
		while (!appear) {
			inspect_human();
			Thread.sleep(500);
			inspect_comp();
			System.out.println(Arrays.deepToString(arr));
			try {
				move();
				Thread.sleep(500);
				try {
					if (driver.findElement(By.xpath("//span[@class='score appear']")).isDisplayed()) {
						System.out.println("game ended in tie");
						appear = true;
					}
				} catch (Exception e) {
				}
			} catch (Exception e) {
				appear = true;
			}
		}

		System.out.println("END OF THE GAME");
	}

	void inspect_comp() {
		List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='o']"));
		for (WebElement element : list1) {
			WebElement parent = element.findElement(By.xpath(".."));
			String par = parent.getAttribute("class");
			// System.out.println(par);
			set_arr(par, COMP);
		}
	}

	void inspect_human() {
		List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='x']"));
		for (WebElement element : list1) {
			WebElement parent = element.findElement(By.xpath(".."));
			String par = parent.getAttribute("class");
			// System.out.println(par);
			set_arr(par, HUMAN);
		}
	}

	void set_arr(String parent, int value) {
		if (parent.equals("square top left")) {
			arr[0][0] = value;
		} else if (parent.equals("square top")) {
			arr[0][1] = value;
		} else if (parent.equals("square top right")) {
			arr[0][2] = value;
		} else if (parent.equals("square left")) {
			arr[1][0] = value;
		} else if (parent.equals("square")) {
			arr[1][1] = value;
		} else if (parent.equals("square right")) {
			arr[1][2] = value;
		} else if (parent.equals("square bottom left")) {
			arr[2][0] = value;
		} else if (parent.equals("square bottom")) {
			arr[2][1] = value;
		} else if (parent.equals("square bottom right")) {
			arr[2][2] = value;
		}
	}

	void move() {
		int i = (int) (Math.random() * 3);
		int j = (int) (Math.random() * 3);
		;
		while (arr[i][j] != 0) {
			i = (int) (Math.random() * 3);
			j = (int) (Math.random() * 3);
		}
		click_random(i, j);
	}

	private void click_random(int i, int j) {
		StringBuffer str = new StringBuffer("square");
		if (i == 0) {
			str.append(" top");
		} else if (i == 2) {
			str.append(" bottom");
		}

		if (j == 0) {
			str.append(" left");
		} else if (j == 2) {
			str.append(" right");
		}
		System.out.println("found: " + str);
		driver.findElement(By.xpath("//div[@class='" + str + "']")).click();
	}
}
