import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class RoPaSgame {

    private static final int DISPOSE_ON_CLOSE = 0;
    static int humanWon; // use for statistic
    static int win=0;
    static int total=0;
    static int tie=0;
    static String userName;
    static JTextArea b6;
    static JTextField b7;
    static JButton quitFrame;
    static Container panelAns, panel;
    static JFrame frameAns, frame;
    public static void main(String[] args){ // main
        gamePanel();// launch main game
        introductionPanel(); // launch instruction
    }

    private static void introductionPanel(){ // give the instruction to the game
        String text="RoPaS Game is a strategic game played between\ntwo people. The choices are rock, paper or scissors\ngesture with the hand. Paper covers rock, rock\ncrushes scissors,scissors cuts paper.";
        JOptionPane.showMessageDialog(null,text, "Introduction", 0, new ImageIcon(System.getProperty("user.dir")+"/image/5.jpg"));
    }

    private static void gamePanel(){ // the main game panel

        frame = new JFrame("RoPaS Game");  //the main frame of the game


        panel = frame.getContentPane();  // creating a container panel, so we can place buttons where we pleased
        panel.setLayout(null);

        String[] iconString= new String[3]; // creating icon string name so we can place the directory in with little effort
        int[] boundInt= new int[3]; // same idea

        for(int i=0; i<=2; i++){ // creating the conditions
            iconString[i]=System.getProperty("user.dir")+"/image/"+i+".jpg";
            boundInt[i]=60+110*i;
        }

        JButton b1 = new JButton (" ", new ImageIcon(iconString[0]));
        b1.setBackground(Color.white);
        b1.setBounds(10,boundInt[0],150,100);


        JButton b2 = new JButton (" ", new ImageIcon(iconString[1]));
        b2.setBackground(Color.white);
        b2.setBounds(10,boundInt[1],150,100);

        JButton b3 = new JButton (" ", new ImageIcon(iconString[2]));
        b3.setBackground(Color.white);
        b3.setBounds(10,boundInt[2],150,100);//creating three buttons

        JLabel l1 = new JLabel(new ImageIcon(System.getProperty("user.dir")+"/image/3.jpg"));
        l1.setBounds(0, 0, 400, 50);
        panel.add(l1);//creating a question button

        JButton b4 = new JButton("Cheat");
        b4.setBackground(Color.DARK_GRAY);
        b4.setForeground(Color.WHITE);
        b4.setBounds(210, 350, 80, 30); //create a code button, this button will give you an automatic win

        JButton b5 = new JButton("Quit"); //quit
        b5.setBackground(Color.DARK_GRAY);
        b5.setForeground(Color.WHITE);
        b5.setBounds(300, 350, 80, 30);

        b6 = new JTextArea ();
        b6.setBounds(210,100, 170, 240);




        JScrollPane mySchroll = new JScrollPane(b6, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(mySchroll);

        Random ran = new Random();
        int ranName = ran.nextInt(99999);

        b7 = new JTextField("Guest " + ranName);
        b7.setBounds(260,60, 120, 25);

        JLabel name = new JLabel("Name: ");
        name.setBounds(210,60, 120, 25);



        //place button on panel
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(name);

        b1.addActionListener( //next three button will listen for which play pick and calculate the win in computeWinner

                new ActionListener() {
                    public void actionPerformed( ActionEvent event ) {
                        computeWinner(1);
                    }});

        b2.addActionListener(

                new ActionListener() {
                    public void actionPerformed( ActionEvent event ) {
                        computeWinner(2);
                    }});

        b3.addActionListener(

                new ActionListener() {
                    public void actionPerformed( ActionEvent event ) {
                        computeWinner(3);
                    }});

        b4.addActionListener(

                new ActionListener() {//cheat button, hit the guy and get a win
                    public void actionPerformed( ActionEvent event ) {
                        win=win+1;
                        total=total+1;

                        JOptionPane.showMessageDialog(null,"You WIN again :)"+"\nWin/Loss rate: " + win+"/"+total+"\nTie: "+tie,"Cheater do prosper", 0, new ImageIcon(System.getProperty("user.dir")+"/image/4.jpg"));

                    }});


        b5.addActionListener( //quit the game and show three beat up guys

                new ActionListener() {
                    public void actionPerformed( ActionEvent event ) {
                        String text=" Joke:\n Ok, so in rock, paper, scissors \n I get howscissors beats paper and \n rock beats scissors butI don't get\n how paper beats rock is it supposed \n to magically wrap around rocks?\n why doesn't it do that to scissors?\n actually forget scissors why doesn't\n it do that to people? Paper should\n  be able to suffocate us when we take\n notes and use daily contact with it\n if so we should be living in fear\n with our contact to it but we're not\n know why paper can't hurt us\n I always pick rock when I play\n when someone picks paper and says\n they beat me...I punch them in the face\n 'Oh, I'm sorry. I thought paper would\n protect you.' loser. \n\n Thank You for using RoPaS Game\n See you soon";
                        JOptionPane.showMessageDialog(null,text, "Thank You, Goof Bye", 0, new ImageIcon(System.getProperty("user.dir")+"/image/6.gif"));
                        System.exit(0);
                    }
                });


        frame.setSize(400, 420);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set frame size and the game begins!
    }

    public static void computeWinner(int x){ // computing the winner
        int computerChoice=computerRandomChoice();
        int humanChoice=x;
        String text,text1="";
        String winningCombination= ""+Math.min(computerChoice, humanChoice)+Math.max(computerChoice, humanChoice);

        switch(Integer.parseInt(winningCombination)){

        case 12:
            text = "Paper wins";
            if(humanChoice==2) humanWon=1;
            break;
        case 13:
            text = "Rock wins";
            if(humanChoice==1) humanWon=1;
            break;
        case 23:
            text = "Scissors wins";
            if(humanChoice==3) humanWon=1;
            break;
        default: text="DRAW";
        humanWon=2;
        tie=tie+1;
        }

        if(humanWon==1){
            text1="Human wins: ";
            humanWon=0;
            win=win+1;
            total=total+1;
        }else if(humanWon==2){
            text1="";
            humanWon=0;
        }else{
            text1="Computer wins: ";
            total=total+1;
        }


        frameAns = new JFrame("RoPaS Game");
        Point MainLoc = frame.getLocation();
        frameAns.setLocation(410 + (int)MainLoc.getX(), 0 + (int)MainLoc.getY());
        panelAns = frameAns.getContentPane();
        panelAns.setLayout(null);

        JLabel l0 = new JLabel(text1+text);
        b6.append(b7.getText() + "\n" +text1+text+"\n\n");
        l0.setBounds(10, 10, 300, 15);
        panelAns.add(l0);

        JLabel l01 = new JLabel("________________________________________________");
        l01.setBounds(0, 10, 350, 25);
        panelAns.add(l01);
        //show the result in a new splash screen

        JLabel l1 = new JLabel("| USER |");
        l1.setBounds(60, 35, 150, 35);
        panelAns.add(l1);

        JLabel l2 = new JLabel("| COMPUTER |");
        l2.setBounds(165, 35, 150, 35);
        panelAns.add(l2);

        JLabel l3 = new JLabel(new ImageIcon(System.getProperty("user.dir")+"/image/"+(humanChoice-1)+".jpg"));
        l3.setBounds(0, 70, 170, 80);
        panelAns.add(l3);

        JLabel l4 = new JLabel(new ImageIcon(System.getProperty("user.dir")+"/image/"+(computerChoice-1)+".jpg"));
        l4.setBounds(115, 70,170, 80);
        panelAns.add(l4);

        JLabel l015 = new JLabel("________________________________________________");
        l015.setBounds(0, 10, 350, 280);
        panelAns.add(l015);

        JLabel l5 = new JLabel("Win/Loss rate: " + win+"/"+total);
        l5.setBounds(5, 25, 150, 290);
        panelAns.add(l5);

        JLabel l6 = new JLabel("Tie: "+tie);
        l6.setBounds(5, 30, 125, 310);
        panelAns.add(l6);



        quitFrame = new JButton("Quit"); //quit
        quitFrame.setBackground(Color.DARK_GRAY);
        quitFrame.setForeground(Color.WHITE);
        quitFrame.setBounds(210, 165, 80,30);

        panelAns.add(quitFrame);

        quitFrame.addActionListener( //quit the game and show three beat up guys

                new ActionListener() {
                    public void actionPerformed( ActionEvent event ) {
                        frameAns.setVisible(false);
                    }
                });

        frameAns.setSize(300, 230);
        frameAns.getContentPane().setBackground(Color.LIGHT_GRAY);
        frameAns.setVisible(true);
        frameAns.setResizable(false);
        frameAns.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }

    public static int computerRandomChoice(){// creating a random choice of rock paper or scissors by the computer
        int result=(int)(Math.random()*3)+1;
        return result;
    }
}
