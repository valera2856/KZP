def createMatrix(size, symbol):
    matrix = []

    for i in range(size):
        row = []
        for j in range(size):
            row.append(symbol)
        matrix.append(row)

    return matrix


def printMatrix(matrix, file_name):
    print("Результат матриці:")

    with open(file_name, "w", encoding="utf-8") as file:
        for row in matrix:
            for elem in row:
                print(elem, end=" ")
                file.write(elem + " ")
            print()
            file.write("\n")


if __name__ == "__main__":
    size = int(input("Введіть розмір матриці: "))
    symbol = input("Введіть символ заповнювач: ")

    if size <= 0:
        print("Помилка: розмір має бути додатнім числом")
    elif len(symbol) != 1:
        print("Помилка: введіть ОДИН символ")
    else:
        matrix = createMatrix(size, symbol)
        printMatrix(matrix, "matrix_output.txt")
