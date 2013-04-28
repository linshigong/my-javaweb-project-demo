package test.random;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseJtester;

public class RandomUtilsTest extends BaseJtester{

	@Test
	public void testRandomInt(){
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		System.out.println(list.get(RandomUtils.nextInt(list.size())));
		
		Assert.assertTrue(true);
	}
	
}
