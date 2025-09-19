package demo;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(demo.Listenerimpclass.class)

public class DemoScriptTest extends BaseClass {
	@Test
	public void test1Test() {
		System.out.println("test1");
	}
	@Test
	public void test2Test() {
		System.out.println("test2");
	}

}
