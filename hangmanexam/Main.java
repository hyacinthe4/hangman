/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmanexam;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Main {
 
   JLabel hangmanLabel;
   

    public static void main(String[] args) {

        final int WIDTH = 800;
        final int HEIGHT = 600;
        final String TITLE = "Hangman ";
        
      final String IMAGE_PATH = "img/start_screen_bg.gif";
      ImageIcon backgroundImg = new ImageIcon(Main.class.getResource(IMAGE_PATH));



        JFrame screen = new JFrame(); 
        CardLayout cardLayout = new CardLayout();
       
        screen.setSize(new Dimension(WIDTH, HEIGHT));
        screen.setTitle(TITLE);
        screen.setLocationRelativeTo(null);
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setBackground(Color.GREEN);
        JPanel container = new JPanel();
        container.setLayout(cardLayout);
        screen.add(container);
        Words words = new Words();

        StartScreenPanel startScreenPanel = new StartScreenPanel(WIDTH, HEIGHT, backgroundImg, container, cardLayout);
        MainGamePanel mainGamePanel = new MainGamePanel(WIDTH, HEIGHT, container, cardLayout, words);
        CategoryScreenPanel categoryScreenPanel = new CategoryScreenPanel(WIDTH, HEIGHT, backgroundImg, container, cardLayout, mainGamePanel, words);
        container.add(startScreenPanel, "1");
        container.add(categoryScreenPanel, "2");
        container.add(mainGamePanel, "3");
        screen.setVisible(true);
    }
}
