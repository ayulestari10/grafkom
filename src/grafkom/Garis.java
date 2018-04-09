/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafkom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author Ayu Lestari
 */
public class Garis extends JComponent {
    
    private static class Titik {
        
        final int x;
        final int y;
        
        public Titik(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }
    
    private List<Titik> titik = new ArrayList<>();
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        for (Titik t : titik) {
            g.drawLine(t.x, t.y, t.x, t.y);
        }
    }
    
    private void addPoint(Titik t) {
        titik.add(t);
    }
    
    private void draw() {
        repaint(); // call paintComponent method via this method
    }
    
    public static void BruteForce(){
        JFrame frame = new JFrame();
        Garis garis = new Garis();
        garis.setPreferredSize(new Dimension(1000, 1000));
        frame.getContentPane().add(garis, BorderLayout.CENTER);
        
        Scanner in = new Scanner(System.in);
        
        System.out.print("Masukkan x1 : ");
        int x1 = in.nextInt();
        System.out.print("Masukkan y1 : ");
        int y1 = in.nextInt();
        System.out.print("Masukkan x2 : ");
        int x2 = in.nextInt();
        System.out.print("Masukkan y2 : ");
        int y2 = in.nextInt();
        
//        int x1 = 400;
//        int y1 = 300;
//        int x2 = 700;
//        int y2 = 800;
        int y,x = 0;

        if(x1 == x2){
            for(int i = 0; i < y2; i++){
                y = y1+i;
                garis.addPoint(new Titik(x1, y));
            }
        }
        
        if(y1 == y2){
            for(int i = 0; i < x2; i++){
                x = x1+i;
                garis.addPoint(new Titik(x,y1));
            }
        }
        
        if(x2 > x1 && y2 != y1){
            float m = (float)(y2-y1)/(float)(x2-x1);
            float t;
            
            int N = x2 - x1 + 1;
            x = x1;
            
            if(m < 1){
                for(int i = 0; i < N; i++){
                    t = m *(x-x1) + y1;

                    y = java.lang.Math.round(t);

                    x = x+1;
                    garis.addPoint(new Titik(x, y));
                    System.out.println(x + "," + y);
                }
                //System.out.println("m = "+m);
            }
            else {
                
                float m_baru = (float)(x2-x1)/(float)(y2-y1);
                for(int i = 0; i < N; i++){
                    t = m_baru *(x-x1) + y1;

                    y = java.lang.Math.round(t);

                    x = x+1;
                    garis.addPoint(new Titik(x, y));
                    System.out.println(x + "," + y );
                }
                //System.out.println("m_baru = "+m_baru);
            }
        }
        
        garis.draw();

        // set frame size to preferred size
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void DDA(){
        JFrame frame = new JFrame();
        Garis garis = new Garis();
        garis.setPreferredSize(new Dimension(1000, 1000));
        frame.getContentPane().add(garis, BorderLayout.CENTER);
        
        Scanner in = new Scanner(System.in);
        
        System.out.print("Masukkan x1 : ");
        int x1 = in.nextInt();
        System.out.print("Masukkan y1 : ");
        int y1 = in.nextInt();
        System.out.print("Masukkan x2 : ");
        int x2 = in.nextInt();
        System.out.print("Masukkan y2 : ");
        int y2 = in.nextInt();
        
//        int x1 = 2;
//        int y1 = 1;
//        int x2 = 8;
//        int y2 = 5;
        float y = 0,x = 0;
        int dy = y2-y1;
        int dx = x2-x1;
        int N;
        
        if(dy > dx){
            N = dy;
        }
        else {
            N = dx;
        }
        
        float x_inc = (float)dx/N;
        float y_inc = (float)dy/N;
        
        System.out.println("dx    = " + dx);
        System.out.println("dy    = " + dy);
        System.out.println("N     = " + N);
        System.out.println("x inc = " + x_inc);
        System.out.println("y inc = " + y_inc);
        
        x = x1; y = y1;
        int roundX, roundY;
        garis.addPoint(new Titik(x1,y1));
        System.out.println("("+x1+","+y1+")");
        
        for(int i = 0; i < N; i++){
           x = x + x_inc;
           y = y + y_inc;
           
           roundX = java.lang.Math.round(x);
           roundY = java.lang.Math.round(y);
           
           System.out.println("("+roundX+","+roundY+")");
           
           garis.addPoint(new Titik(roundX, roundY));
        }
        
        
        garis.draw();

        // set frame size to preferred size
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void bressenham(){
        JFrame frame = new JFrame();
        Garis garis = new Garis();
        garis.setPreferredSize(new Dimension(1000, 1000));
        frame.getContentPane().add(garis, BorderLayout.CENTER);
        
        Scanner in = new Scanner(System.in);
        
        System.out.print("Masukkan x0 : ");
        int x1 = in.nextInt();
        System.out.print("Masukkan y0 : ");
        int y1 = in.nextInt();
        System.out.print("Masukkan x1 : ");
        int x2 = in.nextInt();
        System.out.print("Masukkan y1 : ");
        int y2 = in.nextInt();
        
//        int x1 = 2;
//        int y1 = 1;
//        int x2 = 8;
//        int y2 = 5;
        int y = 0, x = 0;
        
        x = x1;
        y = y1;
        int akhirX = x2;
        int akhirY = y2;
        
        if(x1 > x2){
            x = x2;
            y = y2;
            akhirX = x1;
            akhirY = y1;
        }
        
        System.out.println("(x0,y0) = ("+x+","+y+")");
        System.out.println("(xakhir, yakhir) = ("+akhirX+","+akhirY+")");
        garis.addPoint(new Titik(x, y));
        
        int dy = Math.abs(y2-y1);
        int dx = Math.abs(x2-x1);
        
        System.out.println("dx = " + dx);
        System.out.println("dy = " + dy);
        
        int twody   = (2*dy);
        int twodydx = (2*dy) - (2*dx);
        
        int P = (2*dy) - dx; // dlama
        
        System.out.println("P = " + P);
        
        while ( x != akhirX || y != akhirY ) {
            
            x++;
            if ( P < 0 ) {
                P += twody;
            } else if ( P >= 0 ) {
                y++;
                P += twodydx;
            }
            
            System.out.println("("+x+","+y+")");
            garis.addPoint(new Titik(x, y));
        }

        garis.draw();

        // set frame size to preferred size
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void ellips(){
        JFrame frame = new JFrame();
        Garis garis = new Garis();
        garis.setPreferredSize(new Dimension(1000, 1000));
        frame.getContentPane().add(garis, BorderLayout.CENTER);
        
        // kuadran 1 (x,y)
        int rx = 8;
        int ry = 6;
        
        int P;
        int x = 0;
        int y = ry;
        float RoundP;
        // region 1
        RoundP = (float)(( ry*ry ) - ((rx*rx) * ry) + (0.25 * (rx*rx)));
        
        P = java.lang.Math.round(RoundP);
        System.out.println("P0 setelah Round : "+P);
        
        while (2*ry*ry*x < 2*rx*rx*y){
            if(P < 0){
                x += 1;
                P =  P + (2* (ry*ry) * x) + (ry*ry);
                System.out.println("P : "+P);
            }
            else {
                x += 1;
                y -= 1;
                P = P + (2* (ry*ry) * x)  - (2* (rx*rx) * y) + (ry*ry);
                System.out.println("P : "+P);
            }
            
            System.out.println("("+x+","+y+")");
            garis.addPoint(new Titik(x, y));
        }
         System.out.println("(xter,yter):("+x+","+y+")");   
        
        // region 2
        
        int P2;
        int xk = x;
        int yk = y;
        float RoundP2;
        
        RoundP2 = (float)( (( ry*ry )*(xk+0.5)*(xk+0.5)) + ((rx*rx)*(yk-1)*(yk-1)) - ((rx*rx) * (ry*ry)));
        P2 = java.lang.Math.round(RoundP2);
        System.out.println("P2 setelah Round : "+P2);
        
        while (yk != 0){
            if(P2 < 0){
                xk += 1;
                yk -= 1;
                P2 = P2 + (2* (ry*ry) * xk) - (2* (rx*rx) * yk) + (rx*rx);                
                System.out.println("P2 : "+P2);
            }
            else {
                yk -= 1;
                P2 =  P2 - (2* (rx*rx) * yk) + (rx*rx);
                System.out.println("P2 : "+P2);
            }
            
            System.out.println("("+xk+","+yk+")");
            garis.addPoint(new Titik(xk, yk));
        }
        
        
        
        
        
        
        garis.draw();

        // set frame size to preferred size
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void menu(int pilih){
        
        switch(pilih){
            case 1:
                BruteForce();
                break;
            case 2:
                DDA();
                break;
            case 3:
                bressenham();
                break;
            default:
                System.out.println("Pilihan tidak ada!");
        }
    }
    
    public static void main(String[] args) {
          ellips();
//        Scanner in = new Scanner(System.in);
//        
//        System.out.println("Pilih metode yang diinginkan : \n 1. Brute Force \n 2. DDA \n 3. Bressenham");
//        System.out.print("\nMasukkan : ");
//        
//        int pilihan;
//        pilihan = in.nextInt();
//        
//        menu(pilihan);
       
    }
    
}
