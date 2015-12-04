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
======= 屬性 ======
的要有 x , y , speed , img 等屬性

======= 方法 ======
建構式  : 參數(x , y )
  指定車子的 x , y 值
  初始化 speed 速度為 10
  初始化 im  g 屬性為車子圖片

建構式   : 參數(x , y , speed)
  指定車子的 x , y , speed 值
  初始化 im  g 屬性為車子圖片

reset   :
  將車子的位置移到出發點 (隱藏於螢幕左側，y 軸位置隨機)

display :
  顯示車子在畫布上

moveForward :
  車子的位置會往水平方向增加

*/