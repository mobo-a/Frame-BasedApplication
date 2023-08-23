import javax.swing.*;
import java.awt.*;

// Mobolaji Adediran

// A skeleton JFrame class has been provided which you would need to modifiy to include the other GUI components
// and functionality specified in the assignment specification
public class ContainerFrame extends JFrame {
//this is also referenced by searching through the slides 4a and getting a background information on text fields and modifying them.
    private JTextField input_id_jJTextField;
    private JTextField color_Input_JTextField;
    private JTextField height_Width_Input_JTextField;
    private JTextField length_Input_JTextField;


    public void createComponents() {

        // At this point now we are creating the panels and the grid in which we are going to use.
        JPanel inputsPanel = new JPanel(new GridLayout(3, 6));
        ContainerPanel panel = new ContainerPanel();
        JPanel buttonsPanel = new JPanel();//REFERENCED UNIT 3 WEEK 4 SLIDE 30

        // Here we are starting to create the text fields in which needs to be used and this can be referenced through Lecture 4a SLIDE 3-7
        input_id_jJTextField = new JTextField();
        color_Input_JTextField = new JTextField();
        height_Width_Input_JTextField = new JTextField();
        length_Input_JTextField = new JTextField();

        // At this point we are now starting to create the buttons of which we need for our GUI.
        JButton CuboidButtonadd = new JButton("Add Cuboid");
        JButton CuboidsButtondisplay = new JButton("Display Cuboid data");
        JButton CuboidButtonsearch = new JButton(" Get Cuboids By ID");
        JButton CuboidsButtonsort = new JButton("Order cuboids by ID");

        // I was able to action and reference how to add action listeners by looking at Week 3 Unit 4 Slide 3
        CuboidButtonadd.addActionListener(e -> {
            // At this point we are putting through a failsafe.
            boolean add = true;
            if (getID() < 0 | getHeight_Width() == null | getColor() == null)
                add = false;
            if (add) {
                int[] dimensions = getHeight_Width();
                panel.addCuboid(getID(), dimensions[5], dimensions[6],getColor());
            } else {
                System.out.println("The cuboid can not be added.");
            }
        });
        CuboidsButtondisplay.addActionListener(e -> {
            panel.listCuboids();
        });
        CuboidButtonsearch.addActionListener(e -> {
        });// this here i tried my best but crashed but i tried to reference from unit 5. i am not sure how correct it actually is
        CuboidsButtonsort.addActionListener(e -> {
            panel.sortCuboids();
        });

        // Add labels and inputs to the input panel
        inputsPanel.add(new JLabel("ID:"));
        inputsPanel.add(input_id_jJTextField);
        inputsPanel.add(new JLabel("Colour :"));
        inputsPanel.add(color_Input_JTextField);
        inputsPanel.add(new JLabel("Height or Width :"));
        inputsPanel.add(height_Width_Input_JTextField);
        inputsPanel.add(new JLabel("Length :"));
        inputsPanel.add(length_Input_JTextField);

        // We are now adding buttons which can also be referenced in week 3 unit 4 slide 30
        buttonsPanel.add(CuboidButtonadd);
        buttonsPanel.add(CuboidsButtondisplay);
        buttonsPanel.add(CuboidButtonsearch);
        buttonsPanel.add(CuboidsButtonsort);

        // Add Panels for Inputs, Cuboids and Panels
        add(inputsPanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        // At this point we are not setting the size of our application.
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close action.

    }

    private int getID() {
        try {
            int returnVal = Integer.parseInt(input_id_jJTextField.getText().replace(" ", ""));
            if (returnVal < 100000 || returnVal > 999999) throw new Error();
            else return returnVal;
        } catch (NumberFormatException | Error ex) {
            System.out.println("> The Input is Incorrect!");
            return -1;
        }
    }
//This is the method in which is used in order to get method in which you have to call and implement many other factors.
    private Color getColor() {
        try {
            String[] rgbVals = color_Input_JTextField.getText().replace(" ", "").split(",");
            if (rgbVals.length != 3) throw new Error();
            int[] rgb = new int[]{
                    Integer.parseInt(rgbVals[0]),
                    Integer.parseInt(rgbVals[1]),
                    Integer.parseInt(rgbVals[2]),
            };
            //This is when you return The Colour
            return new Color(rgb[0], rgb[1], rgb[2]);
        } catch (NumberFormatException | Error ex) {
            System.out.println("> This Colour is not allowed");
            return null;
        }
    }

    private int[] getHeight_Width() {
        try {
            // This here is now returning the height and length as values
            return new int[]{
                    Integer.parseInt(height_Width_Input_JTextField.getText().replace(" ", "")),
                    Integer.parseInt(length_Input_JTextField.getText().replace(" ", ""))
            };
        } catch (NumberFormatException nfe) {
            System.out.println("> The height or length are not valid");
            return null;
        }
    }

    public static void main(String[] args) {

        ContainerFrame cFrame = new ContainerFrame();
        cFrame.createComponents();
    }

}
