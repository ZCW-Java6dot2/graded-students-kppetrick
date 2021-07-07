package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.plaf.synth.SynthTableUI;
import java.lang.reflect.Array;

public class ClassroomTest {
    @Test
    public void classroomMaxStudentTest(){
        int expected = 25;
        Classroom newClass= new Classroom(expected);
        int actual = newClass.getStudents().length;
        Assert.assertEquals(expected,actual);

    }
}
