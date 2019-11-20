package com.m.sofiane.mynews;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * created by Sofiane M. 2019-11-20
 */
public class TestSection {

    @Test
    public void changeSectionFormat() {
        String section;
        String subsection;
        String junction;
        String sectionandsubsection;


        section = "Sports";
        junction = " > ";
        subsection = "Podracer";
        sectionandsubsection = section + junction + subsection;
        assertEquals("Sports > Podracer", sectionandsubsection);
    }
}
