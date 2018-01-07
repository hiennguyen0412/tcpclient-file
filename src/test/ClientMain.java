package test;

import controller.ClientControl;
import view.ClientView;

public class ClientMain {
	public static void main(String[] args) {
		ClientView view = new ClientView();
		ClientControl clientcontrol = new ClientControl(view);
	}
	
}
