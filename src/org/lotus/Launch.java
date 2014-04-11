package org.lotus;

import java.awt.Frame;
import java.awt.EventQueue;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

import static java.lang.System.out;

public class Launch {

    public static void main(String[] args) {
		// create thread for this work(optional but recommended)
		EventQueue.invokeLater(new UiBuilder());
    }
}

class UiBuilder implements Runnable {

    @Override
    public void run() {
        Frame f = new Frame("My AWT Frame"); //set title
		f.addMouseMotionListener(new MouseMotionHandler()); // add mouse motion observer/handler
        f.setSize(300, 200);
        f.setLocationRelativeTo(null); //put in center of screen
		f.setVisible(true); //show to the user
    }
	// inner class
	class MouseMotionHandler implements MouseMotionListener {

		@Override
		public void mouseMoved(MouseEvent event) {
			printMouseEventInfo(event);
		}

		@Override
		public void mouseDragged(MouseEvent event) {
			printMouseEventInfo(event);
		}
	}

	private void printMouseEventInfo(MouseEvent event) {
		String action = "dragged";
		if (MouseEvent.MOUSE_MOVED == event.getID()) {
			action = "moved";
		}
		out.println("--------------------------------------------------");
		out.printf("Mouse %s location on frame%n", action);
		out.printf("x = %s%n", event.getX());
		out.printf("y = %s%n", event.getY());
	}
}