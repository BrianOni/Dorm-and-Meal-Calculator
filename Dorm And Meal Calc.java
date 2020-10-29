package dorm.and.meal.plan.calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DormandMealCalculator extends JFrame
 {
    private JLabel label;
    private JPanel dormPanel;
    private JPanel selectedDormPanel;
    private JComboBox dormBox;
    private JTextField sectedDorm;
    private JPanel mealPanel;
    private JPanel selectedMealPanel;
    private JComboBox mealBox;
    private JTextField selectedMeal;
    private JPanel totalPanel;
    private JTextField total;
   
    //creates the info that will be displayed in the combo box
    private String[] dorm =
        {
                "Allen Hall $" + 1500,
                "Pike Hall $" + 1600,
                "Farthing Hall $" + 1200,
                "University Suites $" + 1800
        };
   
    //dorm rates
    double[] drate =
        {
                1500, 1600, 1200, 1800
        };
    //puts the meal plans in the combo box
    private String[] meal =
        {
            "7 Meals Per Week $" + 560,
            "14 Meal Per Week $" + 1095,
            "Unlimited Meals $" + 1500
        };
   
    // meal plan rates
    double[] mrate =
        {
                560, 1095, 1500
        };
   
    // creates a constructor method
    public DormandMealCalculator()
    {
        //sets the title
        setTitle("Dorm and Meal Plan Calculator");
       
        //sets the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        //creates a layout
        setLayout(new GridLayout(3,2));
       
        //builds the panel
        buildDormPanel();
        buildMealPanel();
        buildTotalPanel();
       
        //adds the panels
        add(dormPanel);
        add(mealPanel);
        add(total);
       
        //displays the window
        pack();
        setVisible(true);
    }
   
    //adds comboBox
    private void buildDormPanel()
    {
        //creates a panel to hold combo box
        dormPanel = new JPanel();
       
        //creates a combo box
        dormBox = new JComboBox(dorm);
       
        // creates a listener
        dormBox.addActionListener(new ComboBoxListener());
        dormPanel.add(dormBox);
    }
   
    //adds a combo box for meals
    private void buildMealPanel()
    {
        //creates a combo box
        label = new JLabel("Select a Meal Plan");
        mealPanel = new JPanel();
       
        //creates a combo box
        mealBox = new JComboBox(meal);
   
        //creates a listener
        mealBox.addActionListener(new ComboBoxListener());
       
        //adds a combo box
        mealPanel.add(mealBox);
    }

   //adds a read only text feild
    private void buildSelectedDormPanel()
    {
        //holds componets
        selectedDormPanel = new JPanel();
       
        //creates a label
        label = new JLabel("Your Dormitory is: ");
       
        //creates a text field
        sectedDorm = new JTextField(20);
        sectedDorm.setEditable(false);
       
        //adds a lable and a text field
        selectedDormPanel.add(label);
        selectedDormPanel.add(sectedDorm);
    }
   
    //adds a read only text field
    private void buildSectedMealPanel()
    {
        //creates components
        selectedMealPanel = new JPanel();
       
        //creates a label
        label = new JLabel("Your Meal Plan is: ");
       
        //creates a readonly text field
        selectedMeal = new JTextField(20);
        selectedMeal.setEditable(false);
       
        //adds a label and text field
        selectedMealPanel.add(label);
        selectedMealPanel.add(selectedMeal);
    }
   
    private void buildTotalPanel()
    {
        //creates a combo box
        totalPanel = new JPanel();
       
        //creates a label
        label = new JLabel("Your total charges for the semester is: ");
       
        //creates a read only text field
        total = new JTextField(15);
        total.setEditable(false);
        totalPanel.add(label);
        totalPanel.add(total);
    }
   
    //creates a class that handles events
    private class ComboBoxListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int dorm;
            int meal;
            double totall;
           
            //gets the dorm selected
            String selection1 = (String) dormBox.getSelectedItem();
            dorm = dormBox.getSelectedIndex();
           
            //gets the selected meal plan
            String selection2 = (String) mealBox.getSelectedItem();
            meal = mealBox.getSelectedIndex();
           
            //add selections
            totall = drate[dorm] + mrate[meal];
            total.setText("$" + totall);
        }
        }

   public static void main(String[] args)
    {
        DormandMealCalculator dmc = new DormandMealCalculator();
    }
 }
