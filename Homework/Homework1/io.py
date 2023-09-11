class Fruit:
    def __init__(self, name) -> None:
        self.name = name
    
    @property
    def name(self):
        return self._name
    
    @name.setter
    def name(self, value):
        self._name = value

class Apple(Fruit):
    def __init__(self) -> None:
        super().__init__('Apple')

fruit = Fruit("Banana")
apple = Apple()
print(apple.name)