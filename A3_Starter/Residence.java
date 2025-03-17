/**
 * Brock Young 
 * T00708314 
 * March 16, 2025
 */

/*
  SENG 3120 Course material
  Copyright (c) 2025
  All rights reserved.

  This document contains resources for homework assigned to students of
 SENG 3120 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to a person
  not registered in SENG 3120, constitutes Academic Misconduct, according
  to Thompsons Rivers University Policy on Academic Misconduct.

  Synopsis:
     Starter File for Assignment 3
 */

import java.util.ArrayList;
/**
 * A Residence of a hospital with a specified number of beds with consecutive labels.
 */
public class Residence
{
    /**
     * The name of this Residence.
     */
    private String name;

    /**
     * The (external) label of the first bed of the Residence.
     */
    private int minBedLabel;

    /**
     * An array to represent the beds of the Residence.  Each bed is empty (null)
     * or else has a Person in it.
     */
    private Student[] beds;

    /**
     * Initialize the Residence with the name given, and with beds those labels are
     * the consecutive integers from minBedLabel to maxBedLabel.
     * @param wName    the name of the Residence
     * @param wMinBedLabel the label of the first bed in the Residence
     * @param wMaxBedLabel the label of the last bed in the Residence
     * @precond wName != null && !wName.equals("") && wMinBedLabel >= 0 && wMaxBedLabel >= wMinBedLabel
     */
    public Residence(String wName, int wMinBedLabel, int wMaxBedLabel)
    {
        if (wName == null || wName.equals(""))
            throw new IllegalArgumentException("The name of a Residence cannot be null or empty.  "
                    + "It is " + wName);
        if (wMinBedLabel < 0 || wMaxBedLabel < wMinBedLabel)
            throw new IllegalArgumentException("The bed labels " + wMinBedLabel + " and " + wMaxBedLabel
                    + " are invalid as they cannot be negative, and must have at least one bed.");

        name = wName;
        minBedLabel = wMinBedLabel;
        beds = new Student[wMaxBedLabel - wMinBedLabel + 1];
    }

    /**
     * Return the name of this Residence.
     * @return  the name of this Residence
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the smallest label for a bed on the Residence.
     * @return  the smallest Label for a bed on the Residence
     */
    public int getMinBedLabel()
    {
        return minBedLabel;
    }

    /**
     * Return the largest label for a bed on the Residence.
     * @return  the largest label for a bed on the Residence
     */
    public int getMaxBedLabel()
    {
        return minBedLabel + beds.length - 1;
    }

    /**
     * Return the internal/array index of the bed corresponding to the external label.
     * @param bedLabel the label of a bed from the external/user perspective
     * @precond isValidLabel(bedLabel)
     * @return the internal/array index of the bed corresponding to the external label
     */
    private int externalToInternalIndex(int bedLabel)
    {
        if (! isValidLabel(bedLabel))
            throw new IllegalArgumentException("The value " + bedLabel
                    + " is not a valid label for a bed in the Residence.");

        return bedLabel - minBedLabel;
    }

    /**
     * Return the external/user label of the bed corresponding to the internal index.
     * @param arrayIndex the index of a location in the beds array
     * @precond 0 <= arrayIndex < beds.length
     * @return the external/user label of the bed corresponding to the internal index
     */
    private int internalToExternalLabel(int arrayIndex)
    {
        if (arrayIndex < 0 || arrayIndex >= beds.length)
            throw new IllegalArgumentException("The value " + arrayIndex +
                    " is not a valid index for an array of length " + beds.length + ".");

        return arrayIndex + minBedLabel;
    }

    /**
     * Is the specified bed occupied?
     * @param bedLabel  the label of the bed to be tested for being occupied
     * @precond isValidLabel(bedLabel)
     * @return  is the specified bed occupied?
     */
    public boolean isOccupied(int bedLabel)
    {
        if (! isValidLabel(bedLabel))
            throw new IllegalArgumentException("The value " + bedLabel
                    + " is not a valid label for a bed in the Residence.");

        return beds[externalToInternalIndex(bedLabel)] != null;
    }

    /**
     * Return the student in the specified bed.
     * @param bedLabel  the label of the bed that has the student to be retrieved
     * @precond isValidLabel(bedLabel) && isOccupied(bedLabel)
     * @return  the student in the specified bed
     */
    public Student getStudent(int bedLabel)
    {
        if (! isValidLabel(bedLabel))
            throw new IllegalArgumentException("The value " + bedLabel
                    + " is not a valid label for a bed in the Residence.");

        if (! isOccupied(bedLabel))
            throw new IllegalStateException("Bed " + bedLabel + " is not currently occupied"
                    + " so cannot get its student");
        return beds[externalToInternalIndex(bedLabel)];
    }

    /**
     * Assign the specified student to the specified bed.
     * @param s  the student to be assigned a bed
     * @param bedLabel  the label of the bed that the student is to be assigned
     * @precond  isValidLabel(bedLabel) && !isOccupied(bedLabel)
     */
    public void assignStudentToBed(Student s, int bedLabel)
    {
        if (! isValidLabel(bedLabel))
            throw new IllegalArgumentException("The value " + bedLabel
                    + " is not a valid label for a bed in the Residence.");

        if (isOccupied(bedLabel))
            throw new IllegalStateException("Bed " + bedLabel + " is currently occupied by "
                    + beds[externalToInternalIndex(bedLabel)]
                    + " so cannot be assigned to another student");

        beds[externalToInternalIndex(bedLabel)] = s;
    }

    /**
     * Return a String representation of the properties of the Residence.
     * @return a String representation of the properties of the Residence
     */
    public String toString()
    {
        String result = "\nResidence " + name + " with capacity " + beds.length
                + " has the following students: ";
        for (int i = 0; i < beds.length; i++)
        {
            result = result + "\nbed " + internalToExternalLabel(i) + ": ";
            if (beds[i] != null)
                result = result + beds[i].getName();
        }
        return result + "\n";
    }


    /**
     * Is bedLabel a valid external label for a bed?
     * @param bedLabel  an int to be tested to determined whether it is a valid label
     *             for a bed (from the external/user perspective)
     * @return  is bedLabel a valid external label for a bed?
     *
     * This is a helper method for testing pre-conditions students were not required to implement it
     */
    public boolean isValidLabel(int bedLabel)
    {
        return bedLabel >= minBedLabel && bedLabel <= minBedLabel + beds.length - 1;
    }


    /**
     * Display the available beds
     * @return an array list of available beds
     */
    public ArrayList<Student> availableBeds() {
        /**
         * The list of available beds that will be returned
         */
        ArrayList<Student> emptyBeds = new ArrayList<Student>();
        for (int i = 0; i < beds.length; i++) {
            if (!isOccupied(internalToExternalLabel(i))) {
                emptyBeds.add(beds[i]);
            }
        }
        return emptyBeds;
    }

    /**
     * Free a bed from the residence
     * @param bedLabel the label of the bed to be freed
     */
    public void freeBed(int bedLabel) {

        beds[externalToInternalIndex(bedLabel)] = null;

    }

    /**
     * A method to test the class.
     * @param args  not used
     */

}
