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

public class E1 extends PApplet {

Car car ;

public void setup (){
  
  
  // \u5275\u5efa car \u7269\u4ef6
  car = new Car (-100,100) ;
  
}

public void draw () {
  background(255);
  
  // \u628a\u8eca\u5b50\u756b\u51fa\u4f86
  car.display();
  
  // \u8eca\u5b50\u5f80\u524d\u8dd1
  car.moveForward();
  
  // \u5982\u679c\u8eca\u5b50\u8d85\u904e\u908a\u754c\u4e86\uff0c\u5c31\u8981\u56de\u5230\u539f\u9ede\u3002
  if (car.x > width ) car.reset();  
  
}

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
    x++;
  }
}

/*
Car
======= \u5c6c\u6027 ======
\u7684\u8981\u6709 x , y , speed , img \u7b49\u5c6c\u6027

======= \u65b9\u6cd5 ======
\u5efa\u69cb\u5f0f  : \u53c3\u6578(x , y )
  \u6307\u5b9a\u8eca\u5b50\u7684 x , y \u503c
  \u521d\u59cb\u5316 speed \u901f\u5ea6\u70ba 10
  \u521d\u59cb\u5316 im  g \u5c6c\u6027\u70ba\u8eca\u5b50\u5716\u7247

\u5efa\u69cb\u5f0f   : \u53c3\u6578(x , y , speed)
  \u6307\u5b9a\u8eca\u5b50\u7684 x , y , speed \u503c
  \u521d\u59cb\u5316 im  g \u5c6c\u6027\u70ba\u8eca\u5b50\u5716\u7247

reset   :
  \u5c07\u8eca\u5b50\u7684\u4f4d\u7f6e\u79fb\u5230\u51fa\u767c\u9ede (\u96b1\u85cf\u65bc\u87a2\u5e55\u5de6\u5074\uff0cy \u8ef8\u4f4d\u7f6e\u96a8\u6a5f)

display :
  \u986f\u793a\u8eca\u5b50\u5728\u756b\u5e03\u4e0a

moveForward :
  \u8eca\u5b50\u7684\u4f4d\u7f6e\u6703\u5f80\u6c34\u5e73\u65b9\u5411\u589e\u52a0

*/
/* @pjs preload=
"car.png"; */
  public void settings() {  size(500,500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "E1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
