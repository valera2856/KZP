class Ship:
    """
    Клас Ship представляє базовий корабель.
    """

    def __init__(self, name, tonnage, armor_type):
        """
        Ініціалізує корабель.

        :param name: Назва корабля.
        :param tonnage: Водотоннажність (у тоннах).
        :param armor_type: Тип броні.
        """
        self.name = name
        self.tonnage = tonnage
        self.armor_type = armor_type
        self.is_engine_on = False
        self.is_moving = False
        self.current_course = "невідомий"
        self.damage_level = 0  # Від 0 (без ушкоджень) до 100 (критичні ушкодження)

    def start_engine(self):
        """
        Увімкнення двигуна.
        """
        self.is_engine_on = True
        print(f"Двигун корабля {self.name} увімкнено.")

    def stop_engine(self):
        """
        Вимкнення двигуна.
        """
        self.is_engine_on = False
        print(f"Двигун корабля {self.name} вимкнено.")

    def set_course(self, course):
        """
        Встановлює курс корабля.

        :param course: Новий курс.
        """
        self.current_course = course
        print(f"Курс корабля {self.name} встановлено на {course}.")

    def move(self):
        """
        Починає рух корабля, якщо двигун увімкнено.
        """
        if self.is_engine_on:
            self.is_moving = True
            print(f"Корабель {self.name} рухається за курсом {self.current_course}.")
        else:
            print("Неможливо почати рух: двигун вимкнено.")

    def stop(self):
        """
        Зупиняє рух корабля.
        """
        if self.is_moving:
            self.is_moving = False
            print(f"Корабель {self.name} зупинено.")
        else:
            print("Корабель вже стоїть на місці.")

    def repair(self):
        """
        Ремонтує корабель, відновлюючи його стан.
        """
        self.damage_level = 0
        print(f"Корабель {self.name} відремонтовано.")

    def take_damage(self, damage):
        """
        Завдає ушкодження корабля.

        :param damage: Рівень ушкоджень (від 1 до 100).
        """
        self.damage_level = min(100, self.damage_level + damage)
        print(f"Корабель {self.name} отримав ушкодження: {damage}%. Поточний рівень ушкоджень: {self.damage_level}%.")

    def get_status(self):
        """
        Повертає статус корабля.
        """
        engine_status = "увімкнений" if self.is_engine_on else "вимкнений"
        return f"Корабель {self.name}, тоннаж: {self.tonnage}, броня: {self.armor_type}, двигун: {engine_status}, ушкодження: {self.damage_level}%."

