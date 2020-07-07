package edu.csuft.Bruno.desgin;

import java.util.Observable;
import java.util.Observer;

/**
 * command line inteface
 * @author Bruno
 *
 */
public class CLIView implements Observer {

	// 被可观测的对象进行回调--callback
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("cliView" + arg);
		dispaly(arg);
	}
	public void dispaly(Object arg) {
		System.out.println("cliView显示更新" + arg);
	}

}
