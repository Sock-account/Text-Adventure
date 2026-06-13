import javax.swing.*;
import java.awt.*;
public class Window extends JFrame {
    
    //TODO:Figure out how to change the elements in the window dynamically 
    @SuppressWarnings("deprecation")
    // Creates the GUI for the game
    public Window(){
        JPanel window = new JPanel();
        JPanel start = new JPanel();
        Frame Game = new JFrame();
        
        JLabel Title = new JLabel("The Game of Life");

        start.add(Title);
        window.add(start);
        Game.add(window);

        // Sets up the logic for the start screen
        JPanel start_button_space = new JPanel();
        JButton sb = new JButton();
        JLabel l1 = new JLabel("Start");
        sb.add(l1);
        start_button_space.add(sb);
        start.add(start_button_space);
        sb.addActionListener(q ->{
            start.remove(start_button_space);
            start.remove(Title);
            repaint();
            Chara_Creator(window);
        });




        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(window);
        Game.setLayout(new FlowLayout());
        Game.pack();
        this.setSize(new Dimension(500,500));
        this.setVisible(true);
        this.setTitle("Text Adventure");
    }

    public void Chara_Creator(JPanel window){
        //This should display the character creation screen
        JPanel chara_creator = new JPanel();
        
        //This is the panel for the character's name
        JPanel chara_name_panel = new JPanel();
        JTextField chara_name = new JTextField(20);
        JLabel name_label = new JLabel("Name");
        chara_name_panel.add(chara_name);
        chara_name_panel.add(name_label);
        chara_creator.add(chara_name_panel);
        
        //This is the panel for the character's age
        JPanel age_space = new JPanel();
        JTextField age_box = new JTextField(2);
        JLabel age_label = new JLabel("Age");
        age_space.add(age_box);
        age_space.add(age_label);
        chara_creator.add(age_space);

        
        //The following will be the panels for the buttons 
        // and labels for the attributes

        // Strength panel
        JPanel strength_space = new JPanel();
        JLabel strength_label = new JLabel("Strength");
        JLabel strength_num = new JLabel("0");
        JButton strength_b1 = new JButton("<");
        JButton strength_b2 = new JButton(">");
        strength_space.add(strength_label);
        strength_space.add(strength_b1);
        strength_space.add(strength_num);
        strength_space.add(strength_b2);
        chara_creator.add(strength_space);
        
        // Intelligence panel
        JPanel int_space = new JPanel();
        JLabel int_label = new JLabel("Intelligence");
        JLabel int_num = new JLabel("0");
        JButton int_b1 = new JButton("<");
        JButton int_b2 = new JButton(">");
        int_space.add(int_label);
        int_space.add(int_b1);
        int_space.add(int_num);
        int_space.add(int_b2);
        chara_creator.add(int_space);
        
        //Charisma panel
        JPanel charisma_space = new JPanel();
        JLabel charisma_label = new JLabel("Charisma");
        JLabel charisma_num = new JLabel("0");
        JButton charisma_b1 = new JButton("<");
        JButton charisma_b2 = new JButton(">");
        charisma_space.add(charisma_label);
        charisma_space.add(charisma_b1);
        charisma_space.add(charisma_num);
        charisma_space.add(charisma_b2);
        chara_creator.add(charisma_space);

        //Coordination panel
        JPanel coordination_space = new JPanel();
        JLabel coordination_label = new JLabel("Coordination");
        JLabel coordination_num = new JLabel("0");
        JButton coordination_b1 = new JButton("<");
        JButton coordination_b2 = new JButton(">");
        coordination_space.add(coordination_label);
        coordination_space.add(coordination_b1);
        coordination_space.add(coordination_num);
        coordination_space.add(coordination_b2);
        chara_creator.add(coordination_space);
        
        //Quirks panel
        JPanel quirk_panel = new JPanel();
        JLabel quirk_name = new JLabel("Quirks");
        JButton quirk_b1 = new JButton("");
        JButton quirk_b2 = new JButton("");
        JButton quirk_b3 = new JButton("");
        JButton quirk_b4 = new JButton("");
        JButton quirk_b5 = new JButton("");
        JButton quirk_b6 = new JButton("");
        quirk_panel.add(quirk_name);
        quirk_panel.add(quirk_b1);
        quirk_panel.add(quirk_b2);
        quirk_panel.add(quirk_b3);
        quirk_panel.add(quirk_b4);
        quirk_panel.add(quirk_b5);
        quirk_panel.add(quirk_b6);
        chara_creator.add(quirk_panel);
        window.add(chara_creator);
        window.revalidate();
        window.repaint();

        chara_creator.setLayout(new GridLayout(6, 3));
    }
}
