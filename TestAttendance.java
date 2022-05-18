package cse360FinalProject;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TestAttendance {

	@Test
	public void testGetAsurite() {
		Attendance attendance = new Attendance("John", 40);
		assertEquals("John", attendance.getAsurite());
	}
	
	@Test
	public void testGetTime() {
		Attendance attendance = new Attendance("John", 40);
		assertEquals(40, attendance.getTime());
	}

}
