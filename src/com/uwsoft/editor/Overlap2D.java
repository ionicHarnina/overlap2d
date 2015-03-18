package com.uwsoft.editor;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.uwsoft.editor.controlles.CustomExceptionHandler;
import com.uwsoft.editor.controlles.UIController;
import com.uwsoft.editor.gdx.Overlap2DListener;
import com.uwsoft.editor.utils.AppConfig;
import com.uwsoft.editor.utils.OSType;


public class Overlap2D {

	private static Overlap2DListener listener;

	
	public static void main(String[] argv) {
        //Get project version
        //System.out.println("Current Build Version: " + AppConfig.getInstance().version);

		//Thread.setDefaultUncaughtExceptionHandler(new CustomExceptionHandler());

		listener = new Overlap2DListener();
		if(OSType.getOS_Type() == OSType.MacOS) {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
		    System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Overlap2D");
		}

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final UIController uc = new UIController(listener);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				

				if(OSType.getOS_Type() == OSType.MacOS) {
					uc.initMacOSFrame();
				}else{
					uc.initOtherOSFrame();
				}
				//uc.initUI();
				//uc.addMainComponent();
			}
		});
	}
	
}
