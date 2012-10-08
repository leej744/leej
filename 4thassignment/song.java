import processing.core.*; 
import processing.xml.*; 

import ddf.minim.analysis.*; 
import ddf.minim.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class song extends PApplet {





PImage title;//image

Minim minim;//music library
AudioPlayer audioPlayer;
FFT fft;


float color1;//random color
int a = 0;
int b= 0;
float Xpos;
float Ypos;




public void setup()
{
  size(500, 500);
  background(255);
  title = loadImage("Untitled-2-01.png");//background image
  image(title, 0, 0, 500, 500);
  noStroke();
  minim = new Minim(this);//song
  audioPlayer = minim.loadFile("16 Various Artists - Oh! Lovely Day.mp3", 512);
  audioPlayer.loop();
  fft = new FFT(audioPlayer.bufferSize(), audioPlayer.sampleRate());


  smooth();
}

public void draw() {


  fill (random(150, 255), random(200, 255), random(200, 255));
  smooth();
  strokeWeight(0.1f);
  stroke(color1, 100, 255, 180);//stroke color changes by mouse move
  color1= dist(mouseX, mouseY, Xpos, Ypos)/2;
  frameRate(14);

  beginShape();
  for (a=0;a<400;a++) {
    float r =noise((b)*0.7f)*150*cos(a*0.7f);
    curveVertex(250+r*sin(a+b*0.8f), 250+r*cos(a+b*0.8f));//flower shape
  }
  endShape();
  b++;
}
public void stop()
{
  audioPlayer.close();
  minim.stop();
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#FFFFFF", "song" });
  }
}
