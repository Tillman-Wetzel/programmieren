#include <LiquidCrystal.h>

const int phSensorPin = 0;

// RS, E, D4, D5, D6, D7
LiquidCrystal lcd(8, 9, 4, 5,6, 7);

String phWert = "";
float salzgehalt = 0.0;

void setup() {
    pinMode(phSensorPin, INPUT);

    lcd.begin(16, 2);

    Serial.begin(9600);
}

void loop() {
    phWertMessen();
    printVariables();
}

void phWertMessen() {
    int raw = analogRead(phSensorPin); 
    float voltage = raw * (3.3 / 4095.0);

    phWert = String(7 + ((2.5 - voltage) / 0.18));
}

void salzgehaltMessen() {
    
}

void printVariables() {
    lcd.setCursor(0, 0);
    lcd.print("pH-Wert: " + phWert);
    Serial.println("pH-Wert: " + phWert);

    lcd.setCursor(0, 1);
    lcd.print("Salzgehalt(g/L):    " + String(salzgehalt));
    Serial.println("Salzgehalt(g/L): " + String(salzgehalt));

    delay(500);
}