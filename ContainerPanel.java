import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// ContainerPanel class for CE203 Assignment to use and modify if needed
//Mobolaji Adediran

public class ContainerPanel extends JPanel {

    CuboidContainer cuboid; // Cuboid container object instance
    private final ArrayList<CuboidContainer> cuboidContainers = new ArrayList<>();//GENERICS FROM UNIT 4B WAS REFERENCED HERE
    private final Set<Integer> usedIDs = new HashSet<>();


    public boolean addCuboid(int id, int cWidthHeight, int cLength, Color c) {
        if (usedIDs.contains(id)) {
            System.out.println("The Cuboid " + id + " is already present and a new one wasn't added.");
            return false;
        }
// HERE WE ARE ADDING THE ASPECTS OF THE CUBOID AND PRINTING A MESSAGE WHEN THIS OCCURS
        cuboidContainers.add(new CuboidContainer(id, cWidthHeight, cLength, c));
        usedIDs.add(id);
        System.out.println("The cuboid was added: " + id);


        return true;
    }
    //Here we are calling in the cuboid based on ID and are stating if not there we return null.
    public CuboidContainer getCuboid(int id) {
        if (usedIDs.contains(id)) {
            for (CuboidContainer cuboid : cuboidContainers) {
                if (cuboid.getID() == id)//If it is the correct ID return the cuboid
                    return cuboid;
            }
        }
        //Return nothing
        return null;
    }

    public void listCuboids() {
        // Arranging the Cuboids
        System.out.print("Cuboid IDs: (");

        for (CuboidContainer c : cuboidContainers) {
            System.out.print(c.getID() + ", ");
        }
        System.out.println(")");
    }

    public void sortCuboids() {
        // This is correction and putting the cuboid list in order.
        Collections.sort(cuboidContainers);
        System.out.println("Cuboids are in place:");
        System.out.println(cuboidContainers);
    }



    @Override
    protected void paintComponent(Graphics g) {
        // I decided to add this part after getting reference unit 3 week 4
        super.paintComponent(g);
        if (cuboid != null)
            cuboid.drawCuboid(g);
    }
}
