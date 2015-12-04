Car car ;

void setup (){
  size(500,500);
  
  // 創建 car 物件
  car = new Car (-100,100) ;
  
}

void draw () {
  background(255);
  
  // 把車子畫出來
  car.display();
  
  // 車子往前跑
  car.moveForward();
  
  // 如果車子超過邊界了，就要回到原點。
  if (car.x > width ) car.reset();  
  
}

