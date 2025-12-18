from Frigate import Frigate

if __name__ == "__main__":
    # Створюємо фрегат
    frigate = Frigate("Гордість океану", 5000, "Титанова броня", 20)

    # Виводимо початковий статус фрегата
    print("\n1. Початковий статус:")
    print(frigate.get_status())

    # Увімкнення двигуна
    print("\n2. Увімкнення двигуна:")
    frigate.start_engine()

    # Підготовка до бою
    print("\n3. Підготовка до бою:")
    frigate.prepare_for_battle()

    # Вогонь по цілі
    print("\n4. Атака цілі:")
    frigate.fire_cannon("ворожий корабель")

    # Використання радара
    print("\n5. Використання радара:")
    frigate.scan_area()

    # Захист
    print("\n6. Активація системи захисту:")
    frigate.activate_shield()

    # Переміщення
    print("\n7. Переміщення фрегата:")
    frigate.set_course("південний захід")
    frigate.move()

    # Ремонт
    print("\n8. Виконання ремонту:")
    frigate.repair()

    # Вимкнення двигуна
    print("\n9. Вимкнення двигуна:")
    frigate.stop_engine()

    print("\n10. Фінальний стан:")
    print(frigate.get_status())