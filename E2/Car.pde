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
======= 補充方法 ======

建構式  (x , y , speed):
  指定車子的 x , y , speed 值
  初始化 im  g 屬性為車子圖片

*/
