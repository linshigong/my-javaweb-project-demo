package test.designpatten.Obsever;

import java.util.Observable;

/**
 * being Watched by subscriber 
 */
public class MessageProductor extends Observable {

	/**
	 * If have receive data,notify subscribers
	 */
	public void receiveDataAndNotify(String newStr){
		setChanged();
		if(true){//got data
			notifyObservers("hi ,subscribers,newData is:"+newStr);
		}
	}
	
}
