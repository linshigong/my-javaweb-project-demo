package test.designpatten.Obsever;

import java.util.Observable;
import java.util.Observer;


/**
 * Notitied by Observabe Object,here is MessageProductor
 */
public class Subscriber implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("I got notified,the message is:" + arg.toString());
	}

}
