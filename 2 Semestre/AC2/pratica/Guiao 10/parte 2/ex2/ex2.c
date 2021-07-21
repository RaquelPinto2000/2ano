#include <detpic32.h>
#include "i2c.h"

void delay(int ms)
{
    for(;ms>0;ms--)
    {
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

int getTemperature(int *temperature){
  int ack;
  i2c1_start();// Send Start event
  ack = i2c1_send(ADDR_WR); // Send Address + WR (ADDR_WR); copy return value to "ack" variable
  ack += i2c1_send(RTR);// Send Command (RTR); add return value to "ack" variable
  i2c1_start(); // Send Start event (again)
  ack+=i2c1_send(ADDR_RD); // Send Address + RD (ADDR_RD); add return value to "ack" variable
  // Test "ack" variable; if "ack" != 0 then an error has occurred; send the Stop event, print an error message and exit loop
  if(ack != 0){
    i2c1_stop();
    printStr("ERRO MESSAGE\n");
    return 0;
  }
  
  *temperature = i2c1_receive(I2C_NACK);// Receive a value from slave (send NACK as argument); copy received value to "temperature" variable
  i2c1_stop();// Send Stop event

  return ack;
}

int main(void){
  int temperature;
  i2c1_init(TC74_CLK_FREQ);
  while(1){
    getTemperature(&temperature);
    printStr("\nTemperatura:");
    printInt10(temperature);
    delay(250);// Wait 250 ms
  }
}
