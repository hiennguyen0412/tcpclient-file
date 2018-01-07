package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.ArrayList;

import model.DataModel;
import model.SinhVien;
import view.ClientView;

public class ClientControl<E> {
	private ClientView view;
	/* Luong vao ra voi Socket */
	private ObjectOutputStream out;
	private ObjectInputStream in;

	public ClientControl(ClientView view) {

		this.view = view;
		try {
			SinhVien sv = null;
			Socket socket = new Socket("localhost", 1234);
			out = new ObjectOutputStream(socket.getOutputStream());
			
			in = new ObjectInputStream(socket.getInputStream());
			while (true) {
				int choice = view.selectMenu();
				switch (choice) {
				case 1: 
					sv = view.nhapSV();
					DataModel model = new DataModel("add", sv);
					out.writeObject(model);
					out.flush();
					break;
				
				case 2: 
					DataModel model1 = new DataModel("view");
					out.writeObject(model1);
					out.flush();
					break;

				case 3: 
					SinhVien sv0 = view.search();
					SinhVien sv1= view.nhapSV();
					sv1.setMaSV(sv0.getMaSV());
					DataModel model2 = new DataModel("edit",sv1);
					out.writeObject(model2);
					out.flush();
					break;
				
				case 4:
					SinhVien sv3 = view.search();
					DataModel model3 = new DataModel("delete",sv3);
					out.writeObject(model3);
					out.flush();
					break;
					
				case 5:
					DataModel model4 = new DataModel("save");
					out.writeObject(model4);
					out.flush();
					break;
					
				case 0:
					System.exit(1);
					break;
				
				}//end switch
				/**
				 * show result
				 */
				Object o = in.readObject();
				if(o instanceof ArrayList<?>) {
					ArrayList<SinhVien> listSV = (ArrayList<SinhVien>) o;
					view.showListSV(listSV);
				}
				if(o instanceof Boolean) {
					if(o.equals(true)) {
						view.showMess("OK");
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		

	}

}
