from Ship import Ship


class Frigate(Ship):
    """
    Клас Frigate розширює функціональність базового класу Ship,
    додаючи бойові можливості.
    """

    def __init__(self, name, tonnage, armor_type, cannon_count):
        """
        Ініціалізує фрегат.

        :param name: Назва фрегата.
        :param tonnage: Водотоннажність (у тоннах).
        :param armor_type: Тип броні.
        :param cannon_count: Кількість гармат.
        """
        super().__init__(name, tonnage, armor_type)
        self.cannon_count = cannon_count
        self.shield_activated = False

    def fire_cannon(self, target):
        """
        Стріляє з гармат по цілі.

        :param target: Назва цілі.
        """
        if self.cannon_count > 0:
            print(f"Фрегат {self.name} стріляє з {self.cannon_count} гармат по цілі: {target}.")
        else:
            print(f"Фрегат {self.name} не має гармат для атаки.")

    def prepare_for_battle(self):
        """
        Готує фрегат до бою.
        """
        self.shield_activated = True
        print(f"Фрегат {self.name} готовий до бою: щит активовано.")

    def activate_shield(self):
        """
        Активує щит.
        """
        self.shield_activated = True
        print(f"Щит фрегата {self.name} активовано.")

    def deactivate_shield(self):
        """
        Вимикає щит.
        """
        self.shield_activated = False
        print(f"Щит фрегата {self.name} вимкнено.")

    def scan_area(self):
        """
        Виконує сканування навколишньої зони.
        """
        print(f"Фрегат {self.name} сканує навколишню зону: ворогів не виявлено.")

    def get_status(self):
        """
        Повертає статус фрегата.
        """
        basic_status = super().get_status()
        shield_status = "активовано" if self.shield_activated else "вимкнено"
        return f"{basic_status} Щит: {shield_status}, гармати: {self.cannon_count}."
