class Car:
    'Car class'
    
    def __init__(self,manufacturer,model,make,transmission,color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " is moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped")

obj1 = Car('Totyota', "Corolla", "2015", "Manual", "White")
obj2 = Car('Mercedes', "C Class", "2018", "Automatic", "Black")
obj3 = Car('Ferari', "458 Italia", "2019", "Automatic", "Red")

obj1.accelerate()
obj1.stop()

obj2.accelerate()
obj2.stop()

obj3.accelerate()
obj3.stop()

