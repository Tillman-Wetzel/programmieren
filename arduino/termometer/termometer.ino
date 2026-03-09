int termometerPin = 8;

int temperatur;

void setup() {
  pinMode(termometerPin, INPUT); 

  Serial.begin(38400);

  pinMode(7, OUTPUT);
  digitalWrite(7, HIGH);

  pinMode(5, INPUT);
}

void loop() {
  if ()

  temperatur = analogRead(termometerPin);
  Serial.println("Temparatur: " + String(temperatur) + "°C");
  delay(1000);
}