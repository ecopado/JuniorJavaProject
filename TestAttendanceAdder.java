package cse360FinalProject;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class TestAttendanceAdder {

	@Test
	public void testLoadAttendance() {
		
	// making list we expect loadAttendance to return
        List<Attendance> expectedList = new ArrayList<Attendance>();
        // initialising list
        expectedList.add(new Attendance("John", 65));
        expectedList.add(new Attendance("Sam", 30));
        expectedList.add(new Attendance("Sopia", 50));
        expectedList.add(new Attendance("David", 35));
        expectedList.add(new Attendance("Javiergs", 75));   
        // coverting list to array
        Attendance[] expectedArray = new Attendance[expectedList.size()];
        expectedList.toArray(expectedArray);
        
        // coverting list to array
        List<Attendance> actualList = AttendanceAdder.loadAttendance("attendanceFileTest.csv");
        Attendance[] actualArray = new Attendance[actualList.size()];
        actualList.toArray(actualArray);
        
        assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));

	}

}
