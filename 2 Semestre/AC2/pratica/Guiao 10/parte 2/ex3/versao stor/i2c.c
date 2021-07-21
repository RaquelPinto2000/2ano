#include <detpic32.h>
#include "i2c.h"


//I2C1 module initilization function
void i2c1_init(unsigned int clock_freq) {
  // Config baudrate generator (see introduction for details)
  I2C1BRG = (PBCLK + clock_freq)/((2*clock_freq) -1);
  // Enable I2C1 module
  I2C1CONbits.ON = 1; //Enables the I 2 C module and configures the SDAx and SCLx pins as serial port pins
}

//I2C1 module start event function
void i2c1_start(void){
  // Wait until the lower 5 bits of I2CxCON are all 0 (the lower 5 bits of I2CxCON must be 0 before attempting to set the SEN bit)
  while((I2C1CON & 0x001F) !=0); // 0x001F garante que os 5 bits menos significativos do registo I2CxCON são todos 0
  // Activate Start event (I2C1CON, bit SEN)
  I2C1CONbits.SEN = 1;
  // Wait for completion of the Start event (I2C1CON, bit SEN)
  while(I2C1CONbits.SEN == 1);
}

//I2C1 module stop event function
void i2c1_stop(void){
  // Wait until the lower 5 bits of I2CxCON are all 0 (the lower 5 bits of I2CxCON must be 0 before attempting to set the PEN bit)
  while((I2C1CON & 0x001F)!=0);
  // Activate Stop event (I2C1CON, bit PEN)
  I2C1CONbits.PEN = 1;
  // Wait for completion of the Stop event (I2C1CON, bit PEN)
  while(I2C1CONbits.PEN == 1);
}

//I2C1 module byte send function
int i2c1_send(unsigned char value){
  // Copy "value" to I2C1TRN register
  I2C1TRN = value;
  // Wait while master transmission is in progress (8 bits + ACK\) (I2C1STAT, bit TRSTAT – transmit status bit)
  while(I2C1STATbits.TRSTAT == 1);
  // Return acknowledge status bit (I2C1STAT, bit ACKSTAT)
  return I2C1STATbits.ACKSTAT;
}

//I2C1 module byte receive function
char i2c1_receive(char ack_bit){
  while((I2C1CON & 0x001F)!=0);  // Wait util the lower 5 bits of I2C1CON are all 0 (the lower 5 bits of I2C1CON must be 0 before attempting to set the RCEN bit)
  I2C1CONbits.RCEN =1;           // Activate RCEN bit (receive enable bit, I2C1CON register)
  while(I2C1CONbits.RCEN == 0);  // Wait while byte not received (I2C1STAT, bit RBF – receive buffer full status bit)
  // Send ACK / NACK bit. For that:
  if(ack_bit!=1 && ack_bit!=0){ // atribuir um valor se ele nem for 1 nem 0
    ack_bit = 0;
  }
  I2C1CONbits.ACKDT = ack_bit;//1. Copy "ack_bit" to I2C1CON, bit ACKDT (be sure "ack_bit" value is only 0 or 1)
  while((I2C1CON & 0x001F)!=0);//2. Wait until the lower 5 bits of I2C1CON are all 0 (the lower 5 bits of I2C1CON must be 0 before attempting to set the ACKEN bit.
  I2C1CONbits.ACKEN = 1;// 3. Start Acknowledge sequence (I2C1CON register, bit ACKEN=1)
  while(I2C1CONbits.ACKEN ==1);// Wait for completion of Acknowledge sequence (I2C1CON, bit ACKEN)
  return I2C1RCV;// Return received value (I2C1RCV)
}
