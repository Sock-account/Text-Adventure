import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
public class Window extends JFrame {
    
    // Creates the GUI for the game
    public Window(){
        //BorderLayout is what makes the screens scale: whatever sits in CENTER
        //is stretched to fill the frame instead of staying at its preferred size
        JPanel window = new JPanel(new BorderLayout());
        JPanel start = new JPanel(new GridBagLayout());

        JLabel Title = new JLabel("Sand Pit");
        Title.setFont(Title.getFont().deriveFont(Font.BOLD, 28f));

        // Sets up the logic for the start screen
        JButton sb = new JButton("Start");

        //A single GridBag column keeps the title and button centred at any window size
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        start.add(Title, gbc);
        start.add(sb, gbc);

        window.add(start, BorderLayout.CENTER);

        sb.addActionListener(q ->{
            window.remove(start);
            Chara_Creator(window);
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(window);
        this.setTitle("Sand Pit");
        this.setSize(new Dimension(600, 500));
        this.setMinimumSize(new Dimension(380, 340));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void Chara_Creator(JPanel window){
        //This should display the character creation screen
        //The name row and the create button keep their natural height at the top and
        //bottom, while stat_rows takes the space left over and splits it evenly.
        //GridLayout(0, 1) is one column with as many rows as there are stats.
        JPanel chara_creator = new JPanel(new BorderLayout());
        JPanel stat_rows = new JPanel(new GridLayout(0, 1));
        chara_creator.add(stat_rows, BorderLayout.CENTER);

        //This is the panel for the character's name
        JPanel chara_name_panel = new JPanel();
        JTextField chara_name = new JTextField(20);
        JLabel name_label = new JLabel("Name");
        chara_name_panel.add(chara_name);
        chara_name_panel.add(name_label);
        chara_creator.add(chara_name_panel, BorderLayout.NORTH);

        //The following will be the panels for the buttons and labels for the attributes

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
        stat_rows.add(strength_space);
        
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
        stat_rows.add(int_space);
        
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
        stat_rows.add(charisma_space);

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
        stat_rows.add(coordination_space);
        
        //Quirks panel
        /*JPanel quirk_panel = new JPanel();
        JLabel quirk_name = new JLabel("Quirks");
        JButton quirk_b1 = new JButton("Savant");
        JButton quirk_b2 = new JButton("Imbecile");
        JButton quirk_b3 = new JButton("Passivist");
        JButton quirk_b4 = new JButton("Socially inept");
        JButton quirk_b5 = new JButton("Sadist");
        JButton quirk_b6 = new JButton("Weird");
        quirk_panel.add(quirk_name);
        quirk_panel.add(quirk_b1);
        quirk_panel.add(quirk_b2);
        quirk_panel.add(quirk_b3);
        quirk_panel.add(quirk_b4);
        quirk_panel.add(quirk_b5);
        quirk_panel.add(quirk_b6);
        chara_creator.add(quirk_panel);*/

        //Create character button. Wrapping it in a FlowLayout panel before putting that
        //panel in SOUTH is what keeps the button at its own size - a button added to a
        //BorderLayout region directly gets stretched to fill that whole region.
        JPanel create_space = new JPanel();
        JButton create_char = new JButton("Create Character");
        create_space.add(create_char);
        chara_creator.add(create_space, BorderLayout.SOUTH);
    //TODO: Make the status buttons change the displayed numbers and once the create character button is pushed it creates a new character object

    //These variables will be assigned values and be passed to the character constructor when the create character button is pushed
    // String name;
    // int age = 0; 
    // Integer chara_strength = 0;
    // int intelligence = 0;
    // int charisma = 0;
    // int coordination = 0;
    // HashMap<String,Integer> status = new HashMap<>();
    // String[] quirks = new String[2];
            //Changes values on click

            strength_b1.addActionListener(e -> {
                if(Integer.parseInt(strength_num.getText()) > 0) {
                strength_num.setText(String.valueOf(Integer.parseInt(strength_num.getText()) - 1));
                
                }
            });
            strength_b2.addActionListener(e -> {
                if(Integer.parseInt(strength_num.getText()) < 10) {
                    strength_num.setText(String.valueOf(Integer.parseInt(strength_num.getText()) + 1));
                }
            });
            int_b1.addActionListener(e -> {
                if(Integer.parseInt(int_num.getText()) > 0) {
                    int_num.setText(String.valueOf(Integer.parseInt(int_num.getText()) - 1));
                }
            });
            int_b2.addActionListener(e -> {
                if(Integer.parseInt(int_num.getText()) < 10) {
                    int_num.setText(String.valueOf(Integer.parseInt(int_num.getText()) + 1));
                }
            });
            charisma_b1.addActionListener(e -> {
                if(Integer.parseInt(charisma_num.getText()) > 0) {
                    charisma_num.setText(String.valueOf(Integer.parseInt(charisma_num.getText()) - 1));
                }
            });
            charisma_b2.addActionListener(e -> {
                if(Integer.parseInt(charisma_num.getText()) < 10) {
                    charisma_num.setText(String.valueOf(Integer.parseInt(charisma_num.getText()) + 1));
                }
            });
            coordination_b1.addActionListener(e -> {
                if(Integer.parseInt(coordination_num.getText()) > 0) {
                    coordination_num.setText(String.valueOf(Integer.parseInt(coordination_num.getText()) - 1));
                }
            });
            coordination_b2.addActionListener(e -> {
                if(Integer.parseInt(coordination_num.getText()) < 10) {
                    coordination_num.setText(String.valueOf(Integer.parseInt(coordination_num.getText()) + 1));
                }
            });
            

            //This Button creates the player character object
            create_char.addActionListener( e -> {
            String name = chara_name.getText(); 
                int strength = Integer.parseInt(strength_num.getText()) ;
                int intelligence = Integer.parseInt(int_num.getText());
                int charisma = Integer.parseInt(charisma_num.getText());
                int coordination = Integer.parseInt(coordination_num.getText());
                Character player = createCharacter(name, strength, intelligence, charisma, coordination);
                window.remove(chara_creator);
                Quirkwin(window, player);

    });

            
        window.add(chara_creator, BorderLayout.CENTER);
        window.revalidate();
        window.repaint();
    }
    
    
    
    //This method displays the quirks window and creates and passes the hashmap for quirks to the SetQuirks method in Character
    public void Quirkwin(JPanel window, Character player) {
        JPanel quirkscreen = new JPanel(new BorderLayout());

        //Quirks panel: the heading and submit button keep their natural height at the
        //top and bottom, while the grid of quirk buttons takes all the space left over
        JPanel quirk_panel = new JPanel(new GridLayout(0, 2, 6, 6));
        JLabel quirk_name = new JLabel("Quirks", SwingConstants.CENTER);
        JButton quirk_b1 = new JButton("Savant");
        JButton quirk_b2 = new JButton("Imbecile");
        JButton quirk_b3 = new JButton("Passivist");
        JButton quirk_b4 = new JButton("Socially inept");
        JButton quirk_b5 = new JButton("Sadist");
        JButton quirk_b6 = new JButton("Weird");
        JPanel submit_space = new JPanel();
        JButton submitButton = new JButton("Submit");
        submit_space.add(submitButton);
        quirk_panel.add(quirk_b1);
        quirk_panel.add(quirk_b2);
        quirk_panel.add(quirk_b3);
        quirk_panel.add(quirk_b4);
        quirk_panel.add(quirk_b5);
        quirk_panel.add(quirk_b6);
        quirkscreen.add(quirk_name, BorderLayout.NORTH);
        quirkscreen.add(quirk_panel, BorderLayout.CENTER);
        quirkscreen.add(submit_space, BorderLayout.SOUTH);

        quirk_b1.addActionListener(e -> {
            if(!quirk_b1.getBackground().equals(Color.GREEN)) {
            quirk_b1.setBackground(Color.GREEN);
            }else if(quirk_b1.getBackground().equals(Color.GREEN)) {
            quirk_b1.setBackground(Color.LIGHT_GRAY);
            }
        });
        quirk_b2.addActionListener(e -> {
            if(!quirk_b2.getBackground().equals(Color.GREEN)) {
            quirk_b2.setBackground(Color.GREEN);
            }else if(quirk_b2.getBackground().equals(Color.GREEN)) {
            quirk_b2.setBackground(Color.LIGHT_GRAY);
            }
        });
        quirk_b3.addActionListener(e -> {
            if(!quirk_b3.getBackground().equals(Color.GREEN)) {
            quirk_b3.setBackground(Color.GREEN);
            }else if(quirk_b3.getBackground().equals(Color.GREEN)) {
            quirk_b3.setBackground(Color.LIGHT_GRAY);
            }
        });
        quirk_b4.addActionListener(e -> {
            if(!quirk_b4.getBackground().equals(Color.GREEN)) {
            quirk_b4.setBackground(Color.GREEN);
            }else if(quirk_b4.getBackground().equals(Color.GREEN)) {
            quirk_b4.setBackground(Color.LIGHT_GRAY);
            }
        });
        quirk_b5.addActionListener(e -> {
            if(!quirk_b5.getBackground().equals(Color.GREEN)) {
            quirk_b5.setBackground(Color.GREEN);
            }else if(quirk_b5.getBackground().equals(Color.GREEN)) {
            quirk_b5.setBackground(Color.LIGHT_GRAY);
            }
        });
        quirk_b6.addActionListener(e -> {
            if(!quirk_b6.getBackground().equals(Color.GREEN)) {
            quirk_b6.setBackground(Color.GREEN);
            }else if(quirk_b6.getBackground().equals(Color.GREEN)) {
            quirk_b6.setBackground(Color.LIGHT_GRAY);
            }
        });

        HashMap<Integer,Integer> quirks = new HashMap<>();
        
        submitButton.addActionListener(e -> {
            if (quirk_b1.getBackground().equals(Color.GREEN)) {
                int q1 = quirk_b1.getText().hashCode();
                quirks.put(q1, 1);
            }
            else {
                int q1 = quirk_b1.getText().hashCode();
                quirks.put(q1, 0);
            }
            if (quirk_b2.getBackground().equals(Color.GREEN)) {
                int q2 = quirk_b2.getText().hashCode();
                quirks.put(q2, 1);
            }
            else {
                int q2 = quirk_b2.getText().hashCode();
                quirks.put(q2, 0);
            }
            if (quirk_b3.getBackground().equals(Color.GREEN)) {
                int q3 = quirk_b3.getText().hashCode();
                quirks.put(q3, 1);
            }
            else {
                int q3 = quirk_b3.getText().hashCode();
                quirks.put(q3, 0);
            }
            if (quirk_b4.getBackground().equals(Color.GREEN)) {
                int q4 = quirk_b4.getText().hashCode();
                quirks.put(q4, 1);
            }
            else {
                int q4 = quirk_b4.getText().hashCode();
                quirks.put(q4, 0);
            }
            if (quirk_b5.getBackground().equals(Color.GREEN)) {
                int q5 = quirk_b5.getText().hashCode();
                quirks.put(q5, 1);
            }
            else {
                int q5 = quirk_b5.getText().hashCode();
                quirks.put(q5, 0);
            }
            if (quirk_b6.getBackground().equals(Color.GREEN)) {
                int q6 = quirk_b6.getText().hashCode();
                quirks.put(q6, 1);
            }
            else {
                int q6 = quirk_b6.getText().hashCode();
                quirks.put(q6, 0);
            }
            player.setQuirks(quirks);

            window.remove(quirkscreen);
            Game_start(player, window);
        });
        

        

        window.add(quirkscreen, BorderLayout.CENTER);
        window.revalidate();
        window.repaint();
    }
    
    //This method builds the main game screen and types out the opening text
    public static void Game_start(Character player, JPanel window){
        JPanel gamescreen = new JPanel(new BorderLayout());

        JTextArea story = new JTextArea(10, 34);
        story.setEditable(false);
        story.setLineWrap(true);
        story.setWrapStyleWord(true);
        story.setFont(new Font("Monospaced", Font.PLAIN, 14));
        story.setBackground(Color.BLACK);
        story.setForeground(Color.GREEN);
        story.setMargin(new Insets(8, 8, 8, 8));
        gamescreen.add(new JScrollPane(story), BorderLayout.CENTER);

        window.add(gamescreen, BorderLayout.CENTER);
        window.revalidate();
        window.repaint();

        String opening = "You wake to a impregnable darkness.";

        typeText(story, opening, 35);
    }

    //Reveals text one character at a time so it reads like it is being typed out.
    //Clicking the text area skips ahead to the finished message.
    public static void typeText(JTextArea area, String text, int delayMs) {
        //Held in an array so the listeners below can update the position as they run
        int[] index = {0};
        javax.swing.Timer typer = new javax.swing.Timer(delayMs, null);

        typer.addActionListener(e -> {
            area.append(String.valueOf(text.charAt(index[0])));
            index[0]++;
            if (index[0] >= text.length()) {
                typer.stop();
            }
        });

        area.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (typer.isRunning()) {
                    typer.stop();
                    area.append(text.substring(index[0]));
                    index[0] = text.length();
                }
                area.removeMouseListener(this);
            }
        });

        typer.start();
    }
    
    
    
    
    public Character createCharacter(String name, int strength, int intelligence, int charisma, int coordination) {
                Character player = new Character(name, strength, intelligence, charisma, coordination);
        return player;
            }
}
