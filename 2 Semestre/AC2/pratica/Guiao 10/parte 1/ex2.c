#include <detpic32.h>
// do ex 2 ao 7

#define I2C_READ 1
#define I2C_WRITE 0
#define I2C_ACK 0
#define I2C_NACK 1

#define SENS_ADDRESS  0x4D // device dependent -> usamos o registo 4D tbm ha um 48 acho que e 48
#define ADDR_WR ((SENS_ADDRESS << 1) | I2C_WRITE)
#define ADDR_RD ((SENS_ADDRESS << 1) | I2C_READ)
#define TC74_CLK_FREQ 100000 // 100 KHz
#define RTR 0 // Read temperature command

void delay(int ms)
{
    for(;ms>0;ms--)
    {
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}

// Ex 2
void i2c1_init(unsigned int clock_freq) {
  // Config baudrate generator (see introduction for details)
  I2C1BRG = (PBCLK + clock_freq)/((2*clock_freq) -1);
  // Enable I2C1 module
  I2C1CONbits.ON = 1; //Enables the I 2 C module and configures the SDAx and SCLx pins as serial port pins
}

// Ex3
void i2c1_start(void){
  // Wait until the lower 5 bits of I2CxCON are all 0 (the lower 5 bits of I2CxCON must be 0 before attempting to set the SEN bit)
  while((I2C1CON & 0x001F) !=0); // 0x001F garante que os 5 bits menos significativos do registo I2CxCON são todos 0
  // Activate Start event (I2C1CON, bit SEN)
  I2C1CONbits.SEN = 1;
  // Wait for completion of the Start event (I2C1CON, bit SEN)
  while(I2C1CONbits.SEN == 1);
}

// Ex4
void i2c1_stop(void){
  // Wait until the lower 5 bits of I2CxCON are all 0 (the lower 5 bits of I2CxCON must be 0 before attempting to set the PEN bit)
  while((I2C1CON & 0x001F)!=0);
  // Activate Stop event (I2C1CON, bit PEN)
  I2C1CONbits.PEN = 1;
  // Wait for completion of the Stop event (I2C1CON, bit PEN)
  while(I2C1CONbits.PEN == 1);
}

// Ex5
int i2c1_send(unsigned char value){
  // Copy "value" to I2C1TRN register
  I2C1TRN = value;
  // Wait while master transmission is in progress (8 bits + ACK\) (I2C1STAT, bit TRSTAT – transmit status bit)
  while(I2C1STATbits.TRSTAT == 1);
  // Return acknowledge status bit (I2C1STAT, bit ACKSTAT)
  return I2C1STATbits.ACKSTAT;
}

// Ex6
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


// Ex7
int main(void){
  int ack, temperature;
  i2c1_init(TC74_CLK_FREQ);
  while(1) {
    i2c1_start();// Send Start event
    ack = i2c1_send(ADDR_WR); // Send Address + WR (ADDR_WR); copy return value to "ack" variable
    ack += i2c1_send(RTR);// Send Command (RTR); add return value to "ack" variable
    i2c1_start(); // Send Start event (again)
    ack+=i2c1_send(ADDR_RD); // Send Address + RD (ADDR_RD); add return value to "ack" variable
    // Test "ack" variable; if "ack" != 0 then an error has occurred; send the Stop event, print an error message and exit loop
    if(ack != 0){
      i2c1_stop();
      printStr("ERRO MESSAGE\n");
      break;
    }
    temperature = i2c1_receive(I2C_NACK);// Receive a value from slave (send NACK as argument); copy received value to "temperature" variable
    i2c1_stop();// Send Stop event
    // Print "temperature" variable (syscall printInt10)
    printStr("\nTemperatura:");
    printInt10(temperature);

    delay(250);// Wait 250 ms
  }
  return 0;
}