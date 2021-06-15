package org.perscholas.keyproject;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Door> doors = new ArrayList<>(100);
		
		for (int i = 0; i < 10; i++)
			doors.add(new Door(null));
		
		for (int i = 0; i < 90; i++) {
			KeyShape[] shapes = {KeyShape.Square, KeyShape.Circular, KeyShape.Oval, KeyShape.TrapezoidDown};
			doors.add(new Door(new Key(shapes[(int)(Math.random()*shapes.length)])));
		}
		
		for (Door d : doors) {
			System.out.println(d.getKey());
		}
	}

}
