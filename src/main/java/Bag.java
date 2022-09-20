/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {
    /*
     * TODO: Create the following private instance variables
     *       - a String named color
     *       - an int named numberOfContents
     *       - an int named capacity
     *       - an array of Strings named contents
     */

    /**
     * the color of the bag.
     */
    private String color;
    /**
     * the number of contents in the bag.
     */
    private int numberOfContents;
    /**
     * the capacity of the bag.
     */
    private int capacity;
    /**
     * the contents in the bag.
     */
    private String[] contents;




    /*
     * TODO: Create a constructor that takes two arguments:
     *       - a String representing the Bag's colour
     *       - an int representing the Bag's capacity
     *
     * The other attributes (private instance variables) should
     * be empty (e.g. numberOfContents is 0 and an empty String array for
     * its contents.)
     */

    /**
     * Initializes a bag with the color and capacity.
     *
     * @param bagColor    the color of the bag
     * @param bagCapacity the capacity of the bag
     */
    public Bag(String bagColor, int bagCapacity) {
        this.color = bagColor;
        this.capacity = bagCapacity;
        this.numberOfContents = 0;
        this.contents = new String[bagCapacity];
    }



    /*
     * TODO: Create a variety of 'getter' functions.
     *       These should be named:
     *           - getColor
     *           - getNumberOfContents
     *           - getCapacity
     */

    /**
     * Return the color of the bag.
     *
     * @return the color of the bag.
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Return the number of contents in the bag.
     *
     * @return the number of contents in the bag.
     */
    public int getNumberOfContents() {
        return this.numberOfContents;
    }

    /**
     * Return the capacity of the bag.
     *
     * @return the capacity of the bag.
     */
    public int getCapacity() {
        return this.capacity;
    }



    /*
     * TODO: Create a setter function called setColor which sets the
     *       color of this bag to the given color.
     */

    /**
     * Sets the color of the bag
     *
     * @param bagColor the color of the bag
     */
    public void setColor(String bagColor) {
        this.color = bagColor;
    }





    /*
     * TODO: Create a method called addItem that takes in a String
     *       representing an item in the Bag.
     *       The item is added into the Bag if the number of items
     *       in the bag is < the capacity of the Bag.
     *       Remember to modify numberOfContents accordingly.
     *
     *       This method should return true if the item was added
     *       and false otherwise.
     */

    /**
     * Add an item to the bag if the number of items in the bag is < the capacity of the Bag.
     *
     * @param item the item to be added
     * @return true if the item is added successfully and false otherwise
     */
    public boolean addItem(String item) {
        if (this.numberOfContents >= this.capacity) {
            return false;
        } else {
            this.contents[this.numberOfContents] = item;
            this.numberOfContents++;
            return true;
        }
    }


    /**
     * TODO: Create a method called popItem that returns a String.
     *       The string should be the last item added to this Bag
     *       and the item should be removed from this Bag.
     *       Remember to modify numberOfContents accordingly.
     * <p>
     * If there are no items in this Bag, return null.
     *
     * @return the last item added
     */
    public String popItem() {
        if (this.numberOfContents == 0) {
            return null;
        } else {
            String item = this.contents[this.numberOfContents - 1];
            this.contents[this.numberOfContents - 1] = null;
            this.numberOfContents--;
            return item;
        }
    }


    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        // TODO: Implement this method.
        this.capacity += n;
        String[] newContents = new String[this.capacity];
        for (int i = 0; i < this.numberOfContents; i++) {
            newContents[i] = this.contents[i];
            this.contents = newContents;
        }

    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}