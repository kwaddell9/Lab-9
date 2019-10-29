package edu.cscc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Census {
    /**
     * @author Kelly Waddell
     * 10/29/2019 Census class
     */
    public static Surname[] loadCensusData(String fname) {
        /**
         * @parm fname The name of the File
         */
        int line = 0; // Keep track of lines of file we've read
        //Making a array name namelist with a length of 100
        Surname[] namelist = new Surname[100];
        File census = new File(fname);

        try {
            Scanner input = new Scanner(census);
            //ignores first line
            input.nextLine();

//For loop to print out 100 names
            for (; line < 100 && input.hasNext(); line++) {
                String c = input.nextLine();
                String CensusArray[] = c.split(",");
                int rank = 0;
                double proportion = 0;
                int count = 0;
//Try to make sure numbers format properly
                try {
                    rank = Integer.parseInt(CensusArray[1]);
                    count = Integer.parseInt(CensusArray[2]);
                    proportion = Double.parseDouble(CensusArray[3]);
                } catch (NumberFormatException e) {
                    /**
                     * @exception numberFormatException Throws if the format is incorrect (If it is a string)
                     */
                    e.printStackTrace();
                }
/**
 * @parm line is the current line of the document
 */
                namelist[line] = new Surname(CensusArray[0], rank, count, proportion);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();/**
             * @exception FileNotFoundException Throws if the file does not exist)
             */

        }
        /**
         * @return Returns the namelist after population
         */
        return namelist;
    }
}