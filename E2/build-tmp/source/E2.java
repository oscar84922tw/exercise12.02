import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class E2 extends PApplet {

Car car[] = new Car[10] ;

public void setup (){
  
  
  // \u5275\u5efa car \u7269\u4ef6
  for(int i = 0;i<10;i++){
  car[i] = new Car (-100,100+50*i,floor(random(3, 5))) ;
  }
}

public void draw () {
  background(255);
  
  for(int i = 0;i<10;i++){
  // \u628a\u8eca\u5b50\u756b\u51fa\u4f86
  car[i].display();
  
  // \u8eca\u5b50\u5f80\u524d\u8dd1
  car[i].moveForward();
  if (car[i].x > width ) car[i].reset(); 
  }
  
  
}


/*
  \u8acb\u628aE1 \u7684\u7df4\u7fd2\u8cbc\u904e\u4f86\uff0c\u4e26\u4f7f\u7528\u9663\u5217\u88dd 10 \u500b Car\uff0c
  \u8eca\u5b50\u7684 y \u8ef8\u4f4d\u7f6e\u9593\u9694\u70ba 50 \uff0c\u901f\u5ea6\u70ba 3.0 ~ 5.0 \u7684\u96a8\u6a5f\u6578\u5b57
*/
class Car{
  int speed;
  int x;
  int y;
  PImage car;
  public Car (int x , int y) {
    this.x = x;
    this.y = y;
    this.speed = 10;
    car = loadImage("car.png");
  }
  public Car (int x,int y,int speed){
    this.x = x;
    this.y = y;
    this.speed = speed ;
    car = loadImage("car.png");
  }

  public void reset(){
    this.x = -50000;
    this.y = floor(random(0, 500));
  }

  public void display(){
    image(car, x, y);
  }

  public void moveForward(){
    x+=speed;
  }
}

/*
Car
======= \u88dc\u5145\u65b9\u6cd5 ======

\u5efa\u69cb\u5f0f  (x , y , speed):
  \u6307\u5b9a\u8eca\u5b50\u7684 x , y , speed \u503c
  \u521d\u59cb\u5316 im  g \u5c6c\u6027\u70ba\u8eca\u5b50\u5716\u7247

*/
/* @pjs preload=
"car.png"; */
  public void settings() {  size(500,500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "E2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
